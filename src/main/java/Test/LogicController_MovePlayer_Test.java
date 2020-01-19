package Test;

import Entity.DiceCup;
import Entity.GameBoard;
import Entity.Player;
import Logic.PlayerMove;

import static org.junit.Assert.*;

/**
 * Test the moveablility af the player
 * @author Simon F. David
 * @version 1.0.0
 */
public class LogicController_MovePlayer_Test {

    private int testRuns = 1000;
    PlayerMove pm = new PlayerMove();
    Player p = new Player(null, null, 1);
    GameBoard gb = GameBoard.getInstance();
    DiceCup dc = DiceCup.getINSTANCE();
    int beforeMoving, afterMoving;

    @org.junit.Test
    public void movePlayer() {
        //Checks that the players initial position is the "Start"-field
        assertEquals(gb.getFieldName(p.getFieldIndex()),"Start");

        //Moves the player and checks that the players position, and that it remains within the boundaries of the board
        for (int i = 0; i < testRuns; i++){
            dc.roll();
            beforeMoving = p.getFieldIndex();
            pm.movePlayer(p, gb);
            afterMoving = (beforeMoving + dc.faceValues()) % gb.getSize();
            assertEquals(afterMoving, p.getFieldIndex());
            assertNotEquals(beforeMoving, p.getFieldIndex());
        }
    }
}