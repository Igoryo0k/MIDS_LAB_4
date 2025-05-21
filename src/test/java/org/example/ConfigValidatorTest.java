package org.example;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConfigValidatorTest {

    @Test
    void testValidConfig() {
        Schema schema = new Schema(Map.of(
                "host", "string",
                "port", "int",
                "enabled", "boolean"
        ));

        Map<String, Object> config = Map.of(
                "host", "localhost",
                "port", 8080,
                "enabled", true
        );

        assertTrue(ConfigValidator.validate(config, schema));
    }

    @Test
    void testMissingField() {
        Schema schema = new Schema(Map.of("name", "string"));
        Map<String, Object> config = Map.of();

        assertFalse(ConfigValidator.validate(config, schema));
    }

    @Test
    void testWrongType() {
        Schema schema = new Schema(Map.of("port", "int"));
        Map<String, Object> config = Map.of("port", "notAnInt");

        assertFalse(ConfigValidator.validate(config, schema));
    }
}