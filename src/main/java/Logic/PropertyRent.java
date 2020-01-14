package Logic;

import Entity.Fields.Ownable;
import Entity.Player;

/**
 * handles everthing with rent
 * @author David, Kristoffer
 * @version 1.0.0
 */
public class PropertyRent {

    /**
     * payRent transfer the money from the player to the owner.
     * @param owner - the owner of the field
     * @param p - the player who
     * @param propertyField
     */
    public void payRent(Player owner, Player p, Ownable propertyField){
        p.addMoney(-(propertyField.getPropertyRent()));
        owner.addMoney(propertyField.getPropertyRent());
    }
}
