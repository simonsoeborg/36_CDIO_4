package Entity.Fields;

import java.awt.*;

public class Brewery extends Ownable {
    /**
     * BreweryRentFactor is the factor which must be multipled with amount of brewerys and facevalue (in logic)
     */
    private int BreweryRentFactor = 100;

    public Brewery(String fieldName, int propertyPrice, int propertyRent, int propertyPledgePrice) {
        super(fieldName, propertyPrice, propertyRent, propertyPledgePrice);
    }
}
