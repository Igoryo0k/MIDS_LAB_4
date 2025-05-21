package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class ConfigParser {
    public static Map<String, Object> parse(String jsonContent) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, Map.class);
    }
}
