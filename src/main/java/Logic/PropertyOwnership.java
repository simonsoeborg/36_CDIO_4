package Logic;

import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.GameBoard;
import Entity.Player;

import java.awt.*;

/**
 *  Property ownership handles all aspects of ownership of fields.
 * @author David, Kristoffer
 * @version 1.0.0
 */

public class PropertyOwnership {

    /**
     * Buyfield withdraw the price for the field from the players account and set him as the owner
     * @param - p the current player
     */
        public void buyField(Player p, Field[] fl){

        p.addMoney(-(((Ownable)fl[p.getFieldIndex()]).getPropertyPrice()));
        ((Ownable)fl[p.getFieldIndex()]).setOwnerID(p.getId());
        }
}
