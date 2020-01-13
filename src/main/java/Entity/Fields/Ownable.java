package Entity.Fields;

import Control.PlayerController;
import Entity.FieldCreator;
import Entity.Player;

import java.awt.*;

public class Ownable extends Field {

    private int propertyPrice, propertyRent, propertyPledgePrice, ownerID;
    private Color propertyColor;
    private boolean owned = false;

    /**
     *
     * @param fieldName name on the field
     * @param propertyPrice the price for the field
     * @param propertyRent the rent a player has to pay on the field
     * @param propertyPledgePrice When you need money you can pledge your field and get some money back
     * @param ownerID so we can se who has the field
     * @param propertyColor the colorboard around the field
     */
    public Ownable(String fieldName, int propertyPrice, int propertyRent, int propertyPledgePrice, int ownerID, Color propertyColor) {
        super(fieldName);
        this.propertyPrice = propertyPrice;
        this.propertyRent = propertyRent;
        this.propertyPledgePrice = propertyPledgePrice;
        this.ownerID = ownerID;
        this.propertyColor = propertyColor;
    }


    public int getPropertyPrice() {

        return propertyPrice;
    }

    public void setPropertyPrice(int propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public int getPropertyRent() {
        return propertyRent;
    }

    public void setPropertyRent(int propertyRent) {
        this.propertyRent = propertyRent;
    }

    public int getPropertyPledgePrice() {
        return propertyPledgePrice;
    }

    public void setPropertyPledgePrice(int propertyPledgePrice) {
        this.propertyPledgePrice = propertyPledgePrice;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public Color getPropertyColor() {
        return propertyColor;
    }

    public void setPropertyColor(Color propertyColor) {
        this.propertyColor = propertyColor;
    }
}
