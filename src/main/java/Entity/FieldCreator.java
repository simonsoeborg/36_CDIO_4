package Entity;

import Entity.Fields.Field;

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
        fields[0] = new Field("1");
        fields[1] = new Field("2");
        fields[2] = new Field("3");
        fields[3] = new Field("4");
        fields[4] = new Field("5");
        fields[5] = new Field("6");
        fields[6] = new Field("7");
        fields[7] = new Field("8");
        fields[8] = new Field("9");
        fields[9] = new Field("10");
        fields[10] = new Field("11");
        fields[11] = new Field("12");
        fields[12] = new Field("13");
        fields[13] = new Field("14");
        fields[14] = new Field("15");
        fields[15] = new Field("16");
        fields[16] = new Field("17");
        fields[17] = new Field("18");
        fields[18] = new Field("19");
        fields[19] = new Field("20");
        fields[20] = new Field("21");
        fields[21] = new Field("22");
        fields[22] = new Field("23");
        fields[23] = new Field("24");
        fields[24] = new Field("25");
        fields[25] = new Field("26");
        fields[26] = new Field("27");
        fields[27] = new Field("28");
        fields[28] = new Field("29");
        fields[29] = new Field("30");
        fields[30] = new Field("31");
        fields[31] = new Field("32");
        fields[32] = new Field("33");
        fields[33] = new Field("34");
        fields[34] = new Field("35");
        fields[35] = new Field("36");
        fields[36] = new Field("37");
        fields[37] = new Field("38");
        fields[38] = new Field("39");
        fields[39] = new Field("40");
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




