package Control;

import Entity.DiceCup;
import Entity.FieldCreator;
import Entity.Player;


public class LogicController {

    DiceCup d = new DiceCup();

    //todo MovePlayer skal testes.

    /**
     * @param p : The player who's turn it is.
     * @param fl : Our fieldList.
     *  The method is changing the players FieldIndex, and therefore its location.
     */
    public void movePlayer( Player p, FieldCreator fl) {
        d.roll();
        int previous = p.getFieldIndex();
        p.setFieldIndex((p.getFieldIndex()+d.faceValues())%fl.getSize());
        int actual = p.getFieldIndex();

        // todo Add value er endnu ikke relevant iforhold til vores test.
        if (actual<previous)
            p.addMoney(4000);
    }
}
