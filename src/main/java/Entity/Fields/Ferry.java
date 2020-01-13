package Entity.Fields;

import java.awt.*;
public class Ferry extends Ownable {

    /**
     * ferryRentFactor is the factor which the rent is multiple with for each owend ferry.
     */
    private int ferryRentFactor = 2;

    public Ferry(String fieldName, int propertyPrice, int propertyRent, int propertyPledgePrice) {
        super(fieldName, propertyPrice, propertyRent, propertyPledgePrice);
    }
}

