package Logic;

import Control.GameController;
import Entity.DiceCup;
import Entity.GameBoard;
import Entity.Player;

public class PlayerMove {

    private static final PlayerMove INSTANCE = new PlayerMove();

    private DiceCup dc =  DiceCup.getINSTANCE();

    GameBoard gameBoard = GameBoard.getInstance();

    /**
     * @param p  : The player whose turn it is.
     * @param gb : Our fieldList.
     *           The method is changing the players FieldIndex, and therefore its location.
     */
    public void movePlayer(Player p, GameBoard gb) {
        int previous = p.getFieldIndex();
        p.setFieldIndex((p.getFieldIndex() + dc.faceValues()) % gb.getSize());
        int actual = p.getFieldIndex();

        // todo Add value er endnu ikke relevant iforhold til vores test.
        if (actual < previous)
            p.addMoney(4000);
    }

    public void movePlayerChanceCard(Player p, int toFieldNumber) {

        int previous = p.getFieldIndex();
        p.setFieldIndex(toFieldNumber);
        int actual = p.getFieldIndex();

        if (actual < previous)
            p.addMoney(4000);
    }

    public static PlayerMove getInstance() {
        return INSTANCE;
    }

}
