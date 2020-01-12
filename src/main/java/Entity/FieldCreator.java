package Entity;

import Entity.Fields.Field;
import Test.FileReader;

/**
 * This class makes our field array, with all the logial properties that the individual field contains.
 */

public class FieldCreator {

    //String gameLanguage = "da";
    //ReadFieldDescription fieldNamesDA = new ReadFieldDescription();
    //fieldNamesDA.ReadFieldDescription(gameLanguage);

    private int fieldNum;

    //todo Vi skal have opdateret "fieldNames", således at også disse navne bliver hentet fra et seperat dokument.
    //todo Vi skal senere infører de passende felter og deres attributer til Fiellisten.

    private Field[] fields = new Field[40];

    public FieldCreator() {

        FileReader reader = new FileReader(
                "C:\\Users\\david\\IdeaProjects\\36_CDIO_4\\src\\Textfiles\\FieldDescription_da.txt",
                "C:\\Users\\david\\IdeaProjects\\36_CDIO_4\\src\\Textfiles\\FieldDescription_en.txt",
                "C:\\Users\\david\\IdeaProjects\\36_CDIO_4\\src\\Textfiles\\FieldName_da");


        fields[0] = new Field(reader.read(3,1));
        fields[1] = new Field(reader.read(3,2));
        fields[2] = new Field(reader.read(3,3));
        fields[3] = new Field(reader.read(3,4));
        fields[4] = new Field(reader.read(3,5));
        fields[5] = new Field(reader.read(3,6));
        fields[6] = new Field(reader.read(3,7));
        fields[7] = new Field(reader.read(3,8));
        fields[8] = new Field(reader.read(3,9));
        fields[9] = new Field(reader.read(3,10));
        fields[10] = new Field(reader.read(3,11));
        fields[11] = new Field(reader.read(3,12));
        fields[12] = new Field(reader.read(3,13));
        fields[13] = new Field(reader.read(3,14));
        fields[14] = new Field(reader.read(3,15));
        fields[15] = new Field(reader.read(3,16));
        fields[16] = new Field(reader.read(3,17));
        fields[17] = new Field(reader.read(3,18));
        fields[18] = new Field(reader.read(3,19));
        fields[19] = new Field(reader.read(3,20));
        fields[20] = new Field(reader.read(3,21));
        fields[21] = new Field(reader.read(3,22));
        fields[22] = new Field(reader.read(3,23));
        fields[23] = new Field(reader.read(3,24));
        fields[24] = new Field(reader.read(3,25));
        fields[25] = new Field(reader.read(3,26));
        fields[26] = new Field(reader.read(3,27));
        fields[27] = new Field(reader.read(3,28));
        fields[28] = new Field(reader.read(3,29));
        fields[29] = new Field(reader.read(3,30));
        fields[30] = new Field(reader.read(3,31));
        fields[31] = new Field(reader.read(3,32));
        fields[32] = new Field(reader.read(3,33));
        fields[33] = new Field(reader.read(3,34));
        fields[34] = new Field(reader.read(3,35));
        fields[35] = new Field(reader.read(3,36));
        fields[36] = new Field(reader.read(3,37));
        fields[37] = new Field(reader.read(3,38));
        fields[38] = new Field(reader.read(3,39));
        fields[39] = new Field(reader.read(3,40));
    }

    public int getSize(){
        return fields.length;
    }

    public int getField() {
        return fieldNum;
    }

    public void setField(int newField) {
        fieldNum = newField;
    }
}




