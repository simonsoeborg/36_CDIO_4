package Logic;

import Control.GameController;
import Entity.DiceCup;
import Entity.GameBoard;
import Entity.Player;

public class PlayerMove {

    private DiceCup dc =  DiceCup.getINSTANCE();

    /**
     * @param p  : The player whose turn it is.
     * @param gb : Our fieldList.
     *           The method is changing the players FieldIndex, and therefore its location.
     */
    public void movePlayer(Player p, GameBoard gb) {
        GameController GC = new GameController();
        int previous = p.getFieldIndex();
        p.setFieldIndex((p.getFieldIndex() + dc.faceValues()) % gb.getSize());
        int actual = p.getFieldIndex();

        // todo Add value er endnu ikke relevant iforhold til vores test.
        if (actual < previous)
            p.addMoney(4000);
    }

}
