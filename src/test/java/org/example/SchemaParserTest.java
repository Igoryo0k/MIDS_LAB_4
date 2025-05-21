package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SchemaParserTest {

    @Test
    void testParseValidSchema() throws IOException {
        String json = """
            {
              "host": "string",
              "port": "int",
              "enabled": "boolean"
            }
            """;

        Schema schema = SchemaParser.parse(json);
        assertNotNull(schema);
        assertEquals("string", schema.getFields().get("host"));
        assertEquals("int", schema.getFields().get("port"));
        assertEquals("boolean", schema.getFields().get("enabled"));
    }

    @Test
    void testParseInvalidJson() {
        String json = "invalid json";

        assertThrows(IOException.class, () -> SchemaParser.parse(json));
    }
}
