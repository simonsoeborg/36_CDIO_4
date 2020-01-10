package entity;


import fields.Field;

public class FieldList {
    private Field[] fields = new Field[40];

    public FieldList() {
        fields[0] = new Field ("Start");
        fields[1] = new Field ("Rødovrevej");
        fields[2] = new Field ("Prøv lykken");
        fields[3] = new Field ("Hvidovrevej");
        fields[4] = new Field ("Indkomstskat");
        fields[5] = new Field ("Øresund");
        fields[6] = new Field ("Roskildevej");
        fields[7] = new Field ("Prøv lykken");
        fields[8] = new Field ("Vallby Langade");
        fields[9] = new Field ("Allégade");
        fields[10] = new Field ("Fængsel");
        fields[11] = new Field ("Frederiksberg Allé");
}
