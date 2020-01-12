package Test;

import Entity.DiceCup;
import Entity.FieldCreator;
import Entity.Player;

import java.awt.*;

import static org.junit.Assert.*;

public class LogicController_MovePlayer_Test {

    @org.junit.Test
    public void movePlayer() {

        Player p = new Player("Karsten", Color.black);
        FieldCreator fl = new FieldCreator();
        DiceCup d = new DiceCup();

        //Checks that the players initial position is the "Start"-field
        assertEquals(fl.getFieldName(0),"Start");

        //Moves the player and checks that the players position is different from the previous
        d.roll();
        int previous = p.getFieldIndex();
        p.setFieldIndex((p.getFieldIndex()+d.faceValues())%fl.getSize());
        int actual = p.getFieldIndex();

      //  assertEquals(p.getFieldIndex(),);





    }
}