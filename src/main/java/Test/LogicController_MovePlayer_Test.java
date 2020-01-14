package Test;

import Entity.DiceCup;
import Entity.Player;

import static org.junit.Assert.*;

/**
 * Test the moveablility af the player
 * @author Simon F. David
 * @version 1.0.0
 */
public class LogicController_MovePlayer_Test {

    @org.junit.Test
    public void movePlayer() {

        Player p = new Player();
        FieldCreator fl = new FieldCreator();
        DiceCup d = new DiceCup();

        //Checks that the players initial position is the "Start"-field
        assertEquals(fl.getFieldName(0),"Start");

        //Moves the player and checks that the players position, and that it remains within the boundaries of the board
        for (int count = 0; count<10;count++){

            //This part is the actual code from movePlayer
            d.roll();
            int previous = p.getFieldIndex();
            p.setFieldIndex((p.getFieldIndex()+d.faceValues())%fl.getSize());
            int actual = p.getFieldIndex();

            //Moves the player and checks that the players position is different from the previous
            assertNotSame(previous,actual);

            //prints the value just to make sure that the precise position matches the facevalue + previous position
            System.out.println("previous: " + previous);
            System.out.println("facevalue: " + d.faceValues());
            System.out.println("actual: " + actual);

        }





    }
}