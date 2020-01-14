package Logic;

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
     * @param propertyField - a field that you can own. Which the player have landed on.
     * @return - the players color
     */
        public Color buyField(Player p, Ownable propertyField){

        p.addMoney(-(propertyField.getPropertyPrice()));
        propertyField.setOwnerID(p.getId());
        return p.getColor();
        }
}
