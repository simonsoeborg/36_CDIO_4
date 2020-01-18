package Entity.Fields;

public class Brewery extends Ownable {
    /**
     * BreweryRent is multipled with the amount of brewerys and facevalue (in logic)
     */
    public Brewery(String fieldName, int propertyPrice, int propertyRent, int propertyPledgePrice) {
        super(fieldName, propertyPrice, propertyRent, propertyPledgePrice);
    }
}
