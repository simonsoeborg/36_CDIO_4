package Entity.Fields;

import java.awt.*;

public class Brewery extends Ownable {
    public Brewery(String fieldName, int propertyPrice, int propertyRent, int propertyPledgePrice, int ownerID, Color propertyColor) {
        super(fieldName, propertyPrice, propertyRent, propertyPledgePrice, ownerID, propertyColor);
    }
}
