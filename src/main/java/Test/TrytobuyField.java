package Test;

import Entity.Player;

public class TrytobuyField {

    public static void main(String[] args) {

        // test om CheckFieldType retunerer den korrekte string
        Player p = new Player();
        FieldCreator fl = new FieldCreator();
        LogicController test = new LogicController();

        p.addMoney(3000);
        p.setFieldIndex(2);
        System.out.println(test.checkFieldType(p.getFieldIndex()));



    }



}
