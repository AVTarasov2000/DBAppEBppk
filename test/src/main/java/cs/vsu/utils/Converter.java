package cs.vsu.utils;

import org.springframework.stereotype.Component;

@Component
public interface Converter {
    public Object convert(Object dto);
}
