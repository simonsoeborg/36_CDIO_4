package Entity.Fields;

public class Ferry extends Ownable {
    /**
     * ferryRentFactor is the factor which the rent is multiple with for each owend ferry.
     */
    public Ferry(String fieldName, int propertyPrice, int propertyRent, int propertyPledgePrice) {
        super(fieldName, propertyPrice, propertyRent, propertyPledgePrice);
    }
}

