package com.yoga.movie_reservation.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@UtilityClass
@Slf4j
public class JsonUtil {

    public static <T> Object getObjectFromJsonString(String json, Class<T> des) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return  mapper.readValue(json, des);
        } catch (JsonProcessingException e) {
            log.error("Exception occurred while parsing. Exception : {}", e.getMessage());
            return null;
        }
    }

    public static String getJsonStringFromObject(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Exception occurred while parsing. Exception : {}", e.getMessage());
            return null;
        }
    }

    public static <T> List<T> getListFromJsonStr(String json, Class<T> desc) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, desc);
            return mapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            log.error("Exception occurred while parsing. Exception : {}", e.getMessage());
            return null;
        }
    }
}
