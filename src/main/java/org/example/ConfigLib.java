package org.example;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


public class ConfigLib {
    public static void main(String[] args) {
        try {
            // Load schema
            String schemaContent = Files.readString(Paths.get("schema.json"));
            Schema schema = SchemaParser.parse(schemaContent);

            // Load config
            String configContent = Files.readString(Paths.get("config.json"));
            Map<String, Object> configData = ConfigParser.parse(configContent);

            // Validate config against schema
            boolean valid = ConfigValidator.validate(configData, schema);

            if (valid) {
                System.out.println("Configuration is valid!");
            } else {
                System.out.println("Configuration is invalid.");
            }
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }
}