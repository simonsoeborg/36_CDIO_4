package Test;

import Entity.DiceCup;
import Entity.FieldCreator;
import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.Player;

import java.awt.*;

public class TrytobuyField {

    public static void main(String[] args) {

        Player p = new Player("karsten", Color.blue);

        FieldCreator fl = new FieldCreator();

        p.addMoney(3000);

        p.setFieldIndex(2);

        System.out.println(fl.getFieldName(2));



    }


    // vi går op i logic controlleren
public static boolean checkOwnField (Ownable field) {

    if (field.getOwned()){

      return true;

    } else {

        return false;
    }
}
}