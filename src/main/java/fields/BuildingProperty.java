package fields;

import java.awt.*;

public class BuildingProperty extends Ownable {

    private int housePrice;

    public BuildingProperty(String fieldName, int propertyPrice, int propertyRent, int propertyPledgePrice, int ownerID, Color propertyColor, int housePrice) {
        super(fieldName, propertyPrice, propertyRent, propertyPledgePrice, ownerID, propertyColor);
        this.housePrice = housePrice;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }
}
