package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class ConfigLibTest {

    @Test
    void testMainValidConfig() throws IOException {
        Path tempDir = Files.createTempDirectory("configlibtest");

        String schema = """
            {
              "host": "string",
              "port": "int",
              "enabled": "boolean"
            }
            """;

        String config = """
            {
              "host": "localhost",
              "port": 8080,
              "enabled": true
            }
            """;

        Files.writeString(tempDir.resolve("schema.json"), schema);
        Files.writeString(tempDir.resolve("config.json"), config);

        Path original = Path.of("").toAbsolutePath();
        System.setProperty("user.dir", tempDir.toString());

        ConfigLib.main(new String[]{});

        System.setProperty("user.dir", original.toString());
    }

    @Test
    void testMainFileNotFound() {
        ConfigLib.main(new String[]{});  // no files present
        // It should trigger the IOException path
    }
}
