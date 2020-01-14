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

    Player p;
    Ownable propertyField;

    /**
     * @param - p the current player
     * @param propertyField - a field that you can own. Which the player have landed on.
     */
    public PropertyOwnership(Player p, Ownable propertyField) {
        this.p = p;
        this.propertyField = propertyField;
    }

    /**
     * Buyfield withdraw the price for the field from the players account and set him as the owner
     * @return - the players color
     */
        public Color buyField(){

        p.addMoney(-(propertyField.getPropertyPrice()));
        propertyField.setOwnerID(p.getId());
        return p.getColor();
        }
}
