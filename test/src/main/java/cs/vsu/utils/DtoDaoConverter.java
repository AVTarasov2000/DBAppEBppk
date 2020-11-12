package cs.vsu.utils;

import cs.vsu.annotations.DAO;
import cs.vsu.annotations.DTO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Field;

@Component
public class DtoDaoConverter {

    @SneakyThrows
    public Object fromDTOtoDAO(Object dto){
        if(!dto.getClass().isAnnotationPresent(DTO.class)){
            throw new AnnotationTypeMismatchException(null,"no DTO annotation");
        }
        Object obj = dto.getClass().getAnnotation(DTO.class).targetClass().getDeclaredConstructor().newInstance();
        for (Field field:
            dto.getClass().getDeclaredFields()){
            obj.getClass().getField(field.getName()).set(obj,field.get(dto));
        }
        return obj;
    }

    @SneakyThrows
    public Object fromDAOtoDTO(Object dao){
        if(!dao.getClass().isAnnotationPresent(DAO.class)){
            throw new AnnotationTypeMismatchException(null,"no DTO annotation");
        }
        Object obj = dao.getClass().getAnnotation(DTO.class).targetClass().getDeclaredConstructor().newInstance();
        for (Field field:
                dao.getClass().getDeclaredFields()){
            obj.getClass().getField(field.getName()).set(obj,field.get(dao));
        }
        return obj;
    }


}
