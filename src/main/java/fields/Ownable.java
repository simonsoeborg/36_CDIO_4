package fields;

import java.awt.*;

public class Ownable extends Field {

    private int propertyPrice, propertyRent, propertyPledgePrice, ownerID;
    private Color propertyColor;

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
