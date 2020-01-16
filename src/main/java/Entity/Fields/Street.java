package Entity.Fields;

import java.awt.*;

public class Street extends Ownable {

    private int housePrice;

    private int oneHouse, twoHouse, threeHouse, fourHouse, hotel;

    public Street(String fieldName, int propertyPrice, int propertyRent, int propertyPledgePrice, int housePrice, int oneHouse, int twoHouse, int threeHouse, int fourHouse, int hotel) {
        super(fieldName, propertyPrice, propertyRent, propertyPledgePrice);
        this.housePrice = housePrice;
        this.oneHouse = oneHouse;
        this.twoHouse = twoHouse;
        this.threeHouse = threeHouse;
        this.fourHouse = fourHouse;
        this.hotel = hotel;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

    public int getOneHouse() {
        return oneHouse;
    }

    public void setOneHouse(int oneHouse) {
        this.oneHouse = oneHouse;
    }

    public int getTwoHouse() {
        return twoHouse;
    }

    public void setTwoHouse(int twoHouse) {
        this.twoHouse = twoHouse;
    }

    public int getThreeHouse() {
        return threeHouse;
    }

    public void setThreeHouse(int threeHouse) {
        this.threeHouse = threeHouse;
    }

    public int getFourHouse() {
        return fourHouse;
    }

    public void setFourHouse(int fourHouse) {
        this.fourHouse = fourHouse;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }
}
