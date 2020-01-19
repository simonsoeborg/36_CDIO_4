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
public class MovePlayerTest {

    private int testRuns = 1000;
    private PlayerMove pm = new PlayerMove();
    private Player p = new Player(null, null, 1);
    private GameBoard gb = GameBoard.getInstance();
    private DiceCup dc = DiceCup.getINSTANCE();

    @org.junit.Test
    public void movePlayer() {
        // Checks that the players initial position is the "Start"-field
        assertEquals(gb.getFieldName(p.getFieldIndex()),"Start");

        // Moves the player and checks that the players position, and that it remains within the boundaries of the board
        // and if the balance goes up by 4000 if the player passes START.
        for (int i = 0; i < testRuns; i++){
            dc.roll();
            int beforeMoving = p.getFieldIndex();
            int balanceBeforeMoving = p.getMoney();
            pm.movePlayer(p, gb);
            int afterMoving = (beforeMoving + dc.faceValues()) % gb.getSize();
            assertEquals(afterMoving, p.getFieldIndex());
            assertNotEquals(beforeMoving, p.getFieldIndex());
            if (beforeMoving > afterMoving)
                assertEquals(balanceBeforeMoving + 4000, p.getMoney());
            else
                assertEquals(balanceBeforeMoving, p.getMoney());
        }
    }
}