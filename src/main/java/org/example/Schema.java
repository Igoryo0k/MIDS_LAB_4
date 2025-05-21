package configlib;

import java.util.Map;

public class Schema {
    private Map<String, Char[]> fields;

    public Schema(Map<String, Char[]> fields) {
        this.fields = fields;
    }

    public Map<String, Char[]> getFields() {
        return fields;
    }
}
