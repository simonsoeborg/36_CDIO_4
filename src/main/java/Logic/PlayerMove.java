package Logic;

import Entity.DiceCup;
import Entity.GameBoard;
import Entity.Player;

public class PlayerMove {

    private static final PlayerMove INSTANCE = new PlayerMove();

    private DiceCup dc =  DiceCup.getINSTANCE();

    /**
     * @param p  : The player whose turn it is.
     * @param gb : Our fieldList.
     *           The method is changing the players FieldIndex, and therefore its location.
     */
    public void movePlayer(Player p, GameBoard gb) {
        int previous = p.getFieldIndex();
        p.setFieldIndex((p.getFieldIndex() + dc.faceValues()) % gb.getSize());
        int actual = p.getFieldIndex();

        if (actual < previous)
            p.addMoney(4000);
    }

    /**
     *
     * @param p - the player
     * @param toFieldNumber - Amount of fields the player has to move after have drawn a chanceCard there moves the player
     */
    public void movePlayerChanceCard(Player p, int toFieldNumber) {

        int previous = p.getFieldIndex();
        p.setFieldIndex(toFieldNumber);
        int actual = p.getFieldIndex();

        // hvis de passere start får de så start beløbet.
        if (actual < previous)
            p.addMoney(4000);
    }

    public static PlayerMove getInstance() {
        return INSTANCE;
    }

}
