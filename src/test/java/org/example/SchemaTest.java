package org.example;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SchemaTest {

    @Test
    void testSchemaFields() {
        Map<String, String> fields = Map.of(
            "name", "string",
            "age", "int"
        );

        Schema schema = new Schema(fields);
        assertEquals(2, schema.getFields().size());
        assertEquals("string", schema.getFields().get("name"));
        assertEquals("int", schema.getFields().get("age"));
    }
}
