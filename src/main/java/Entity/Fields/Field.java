package Entity.Fields;

import java.awt.*;

public class Field {

    private String fieldName;

//todo Der skal inføres en standard farve på alle "Fields", som udelukkende skal bruges til "PropertyRent".

    public Field(String fieldName) {
        this.fieldName = fieldName;
    }


    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public boolean isOwnable() { return false; }
}
