package org.example;

// ================= ConfigValidator.java =================
import java.util.Map;

public class ConfigValidator {
    public static boolean validate(Map<String, Object> config, Schema schema) {
        for (Map.Entry<String, String> field : schema.getFields().entrySet()) {
            String key = field.getKey();
            String expectedType = field.getValue();

            if (!config.containsKey(key)) {
                System.out.println("Missing required field: " + key);
                return false;
            }

            Object value = config.get(key);

            switch (expectedType) {
                case "string":
                    if (!(value instanceof String)) {
                        System.out.println("Field '" + key + "' should be a string.");
                        return false;
                    }
                    break;
                case "int":
                    if (!(value instanceof Integer)) {
                        System.out.println("Field '" + key + "' should be an integer.");
                        return false;
                    }
                    break;
                case "boolean":
                    if (!(value instanceof Boolean)) {
                        System.out.println("Field '" + key + "' should be a boolean.");
                        return false;
                    }
                    break;
                default:
                    System.out.println("Unknown expected type: " + expectedType);
                    return false;
            }
        }
        return true;
    }
}
