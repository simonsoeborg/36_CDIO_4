package Entity;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    private String name;
    private Color color;
    private int money;
    private int fieldIndex;
    private int id;
    private boolean bankruptcy;
    private boolean inJail;
    private boolean freeOutOfJail;
    private boolean buying;
    private boolean isAbleToBuyHouses;
    private int roundsInJail;

    public Player(String name, Color color, int id) {

        this.name = name;
        this.color = color;
        this.id = id;
        money=30000;
        fieldIndex = 0;
        bankruptcy = false;
        inJail = false;
        freeOutOfJail = false;
        buying = false;
        isAbleToBuyHouses = false;
        roundsInJail = 0;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMoney() {

        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int diff) {
        if (money + diff >= 0) {
            money = money + diff;
        } else {
            setBankruptcy(true);
            money = money + diff;
        }
    }

    public boolean getBankruptcy() {return bankruptcy;}

    public void setBankruptcy(boolean bankruptcy) { this.bankruptcy = bankruptcy; }

    public int getFieldIndex() { return fieldIndex; }

    public void setFieldIndex(int fieldIndex) { this.fieldIndex = fieldIndex; }

    public boolean IsInJail(){return inJail;}

    public void setInJail(boolean inJail) { this.inJail = inJail; }

    public boolean getFreeOutOfJail() { return freeOutOfJail; }

    public void setFreeOutOfJail(boolean freeOutOfJail) { this.freeOutOfJail = freeOutOfJail; }

    public boolean getBuying() {return buying; }

    public void setBuying(boolean buying) { this.buying = buying; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAbleToBuyHouses() {
        return isAbleToBuyHouses;
    }

    public void setAbleToBuyHouses(boolean ableToBuyHouses) {
        isAbleToBuyHouses = ableToBuyHouses;
    }

    public int getRoundsInJail() {
        return roundsInJail;
    }

    public void setRoundsInJail(int roundsInJail) {
        this.roundsInJail = roundsInJail;
    }

    @Override
    public String toString() { return name; }

}

