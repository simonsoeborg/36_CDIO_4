package Test;

import Control.LogicController;
import Entity.DiceCup;
import Entity.FieldCreator;
import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.Player;

import java.awt.*;

public class TrytobuyField {

    public static void main(String[] args) {

        // test om CheckFieldType retunerer den korrekte string
        Player p = new Player("karsten", Color.blue);
        FieldCreator fl = new FieldCreator();
        LogicController test = new LogicController();

        p.addMoney(3000);
        p.setFieldIndex(2);
        System.out.println(test.checkFieldType(p.getFieldIndex()));



    }



}
