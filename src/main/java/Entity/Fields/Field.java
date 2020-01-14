package Entity.Fields;

import java.awt.*;

public class Field {

    private String fieldName;

    private Color color;

    public Field(String fieldName,Color color) {
        this.fieldName = fieldName;
        this.color = color;
    }


    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
