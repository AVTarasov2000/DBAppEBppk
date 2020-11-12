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
    public Object convert(Object dto) {
        if (!dto.getClass().isAnnotationPresent(DTODAO.class)) {
            throw new AnnotationTypeMismatchException(null, "no DTO annotation");
        }
        Object obj = dto.getClass().getAnnotation(DTODAO.class).targetClass().getDeclaredConstructor().newInstance();
        for (Field field :
                dto.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(One.class)) {
                field.set(obj, convert(field.get(dto)));
            } else if (field.isAnnotationPresent(Many.class)) {
                ((Set) field.get(obj)).add(convert(field.get(dto)));
            } else {
                obj.getClass().getField(field.getName()).set(obj, field.get(dto));
            }
        }
        return obj;
    }
}