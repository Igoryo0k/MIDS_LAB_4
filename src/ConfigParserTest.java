package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConfigParserTest {

    @Test
    void testParseValidConfig() throws IOException {
        String json = """
            {
              "host": "localhost",
              "port": 8080,
              "enabled": true
            }
            """;

        Map<String, Object> config = ConfigParser.parse(json);
        assertEquals("localhost", config.get("host"));
        assertEquals(8080, config.get("port"));
        assertEquals(true, config.get("enabled"));
    }

    @Test
    void testParseInvalidJson() {
        String json = "not a valid json";

        assertThrows(IOException.class, () -> ConfigParser.parse(json));
    }
}
