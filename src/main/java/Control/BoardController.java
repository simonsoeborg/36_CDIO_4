package Control;

import Entity.FieldCreator;
import Entity.Player;

public class BoardController {
    FieldCreator FC = new FieldCreator();
    private int fieldLength = FC.getSize();
    //todo MovePlayer skal testes.

    public BoardController() {

    }

    /**
     * @param p : The player who's turn it is.
     *  The method is changing the players FieldIndex, and therefore its location.
     */

    public void movePlayer(Player p, int faceValues) {

        int previous = p.getFieldIndex();
        p.setFieldIndex( (p.getFieldIndex() + faceValues) % fieldLength );
        int actual = p.getFieldIndex();

        // todo Add value er endnu ikke relevant i forhold til vores test.
        if (actual < previous) {
            p.setMoney(p.getMoney() + 4000);
        }

    }
}
