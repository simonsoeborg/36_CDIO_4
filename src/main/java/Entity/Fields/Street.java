package Entity.Fields;

public class Street extends Ownable {

    private int housePrice;

    private int oneHouse, twoHouse, threeHouse, fourHouse, hotel;

    private int numberOfHouses;

    public Street(String fieldName, int propertyPrice, int propertyRent, int propertyPledgePrice, int housePrice, int oneHouse, int twoHouse, int threeHouse, int fourHouse, int hotel) {
        super(fieldName, propertyPrice, propertyRent, propertyPledgePrice);
        this.housePrice = housePrice;
        this.oneHouse = oneHouse;
        this.twoHouse = twoHouse;
        this.threeHouse = threeHouse;
        this.fourHouse = fourHouse;
        this.hotel = hotel;
        this.numberOfHouses = 0;
    }

    public int getNumberOfHouses() {
        return numberOfHouses;
    }

    public void setNumberOfHouses(int numberOfHouses) {
        this.numberOfHouses = numberOfHouses;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public int getOneHouse() {
        return oneHouse;
    }

    public int getTwoHouse() {
        return twoHouse;
    }

    public int getThreeHouse() {
        return threeHouse;
    }

    public int getFourHouse() {
        return fourHouse;
    }

    public int getHotel() {
        return hotel;
    }
}
