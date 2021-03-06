package Entity.Fields;

public abstract class Ownable extends Field {
    private int propertyPrice, propertyRent, propertyPledgePrice, ownerID;
    /**
     * @param fieldName name on the field
     * @param propertyPrice the price for the field
     * @param propertyRent the rent a player has to pay on the field
     * @param propertyPledgePrice When you need money you can pledge your field and get some money back
     */
    public Ownable(String fieldName, int propertyPrice, int propertyRent, int propertyPledgePrice){
        super(fieldName);
        this.propertyPrice = propertyPrice;
        this.propertyRent = propertyRent;
        this.propertyPledgePrice = propertyPledgePrice;
        this.ownerID = 0;
    }

    public int getPropertyPrice() {

        return propertyPrice;
    }

    public int getPropertyRent() {
        return propertyRent;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

}
