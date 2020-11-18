package cs.vsu.utils;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.annotations.One;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Field;
import java.util.Set;

@Component
public class DtoDaoConverter implements Converter{

    @SneakyThrows
    public Object convert(Object input) {
        if (input==null)
            return null;
        if (!input.getClass().isAnnotationPresent(DTODAO.class)) {
            throw new AnnotationTypeMismatchException(null, "no DTO annotation");
        }
        Object obj = input.getClass().getAnnotation(DTODAO.class).targetClass().getDeclaredConstructor().newInstance();
        for (Field field :
                input.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(One.class)) {
                Field targetField = obj.getClass().getDeclaredField(field.getName());
                targetField.setAccessible(true);
                targetField.set(obj, convert(field.get(input)));
            } else if (field.isAnnotationPresent(Many.class)) {
                Field targetField = obj.getClass().getDeclaredField(field.getName());
                targetField.setAccessible(true);
                for (Object o : ((Set) field.get(input))) {
                    ((Set) targetField.get(obj)).add(convert(o));
                }
            } else {
                Field targetField = obj.getClass().getDeclaredField(field.getName());
                targetField.setAccessible(true);
                targetField.set(obj, field.get(input));
            }
        }
        return obj;
    }
}