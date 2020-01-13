package Entity.Fields;

import java.awt.*;

public class Street extends Ownable {

    private int housePrice;

    public Street(String fieldName, int propertyPrice, int propertyRent, int propertyPledgePrice, int ownerID, Color propertyColor, int housePrice) {
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
