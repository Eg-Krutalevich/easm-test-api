package ru.easm.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {

    static ObjectMapper mapper = new ObjectMapper();

    public static <T> String writeObjectAsString(T cls) {
        String value = null;
        mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        try {
            value = mapper.writeValueAsString(cls);
        } catch (Exception e) {
            e.getCause();
        }
        return value;
    }
}