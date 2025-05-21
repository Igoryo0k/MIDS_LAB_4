package org.example;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConfigValidatorTest {

    @Test
    void testValidConfig() {
        Map<String, String> schemaMap = Map.of(
            "name", "string",
            "age", "int",
            "active", "boolean"
        );
        Map<String, Object> config = Map.of(
            "name", "Alice",
            "age", 30,
            "active", true
        );

        Schema schema = new Schema(schemaMap);
        assertTrue(ConfigValidator.validate(config, schema));
    }

    @Test
    void testMissingField() {
        Map<String, String> schemaMap = Map.of("username", "string", "age", "int");
        Map<String, Object> config = Map.of("username", "Bob");

        Schema schema = new Schema(schemaMap);
        assertFalse(ConfigValidator.validate(config, schema));
    }

    @Test
    void testWrongTypeStringInsteadOfInt() {
        Map<String, String> schemaMap = Map.of("age", "int");
        Map<String, Object> config = Map.of("age", "twenty");

        Schema schema = new Schema(schemaMap);
        assertFalse(ConfigValidator.validate(config, schema));
    }

    @Test
    void testWrongTypeBooleanInsteadOfString() {
        Map<String, String> schemaMap = Map.of("nickname", "string");
        Map<String, Object> config = Map.of("nickname", true);

        Schema schema = new Schema(schemaMap);
        assertFalse(ConfigValidator.validate(config, schema));
    }

    @Test
    void testUnknownTypeInSchema() {
        Map<String, String> schemaMap = Map.of("data", "float"); 
        Map<String, Object> config = Map.of("data", 3.14);

        Schema schema = new Schema(schemaMap);
        assertFalse(ConfigValidator.validate(config, schema));
    }
}
