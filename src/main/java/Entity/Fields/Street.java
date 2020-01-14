package Entity.Fields;

import java.awt.*;

public class Street extends Ownable {

    private int housePrice;
    private Color color;

    public Street(String fieldName, int propertyPrice, int propertyRent, int propertyPledgePrice, int housePrice, Color color) {
        super(fieldName, propertyPrice, propertyRent, propertyPledgePrice);
        this.housePrice = housePrice;
    }

    public Color getColorolor() {
        return color;
    }

    public void setColor(Color colorlor) {
        this.color = color;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }
}
