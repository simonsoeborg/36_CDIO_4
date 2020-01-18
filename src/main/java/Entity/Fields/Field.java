package Entity.Fields;

import java.awt.*;

public class Field {

    private String fieldName;


    public Field(String fieldName) {
        this.fieldName = fieldName;
    }


    public String getFieldName() {
        return fieldName;
    }


    public boolean isOwnable() { return false; }
}
