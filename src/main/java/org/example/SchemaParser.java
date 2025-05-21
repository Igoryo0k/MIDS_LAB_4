package org.example;

// ================= SchemaParser.java =================


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class SchemaParser {
    public static Schema parse(File jsonContent) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> fields = mapper.readValue(jsonContent, new TypeReference<>() {});
        return new Schema(fields);
    }
}
