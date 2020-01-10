package entity;

import java.awt.*;

public class Player {
    private String name;
    private Color color;
    private int money;
    private int fieldIndex;
    private boolean bankruptcy;
    private boolean inJail;
    private boolean freeOutOfJail;
    private boolean buying;

    public Player(String name, Color color) {
        //todo "Husk at argumentere for at vi har money, som en parameter."
        this.color = color;
        money=0;
        fieldIndex = 0;
        bankruptcy =false;
        inJail =false;
        freeOutOfJail=false;
        buying=false;
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

    public boolean isBankruptcy() {return bankruptcy;}

    public void setBankruptcy(boolean bankruptcy) { this.bankruptcy = bankruptcy; }

    public int getFieldIndex() { return fieldIndex; }

    public void setFieldIndex(int fieldIndex) { this.fieldIndex = fieldIndex; }

    public boolean isInJail(){return inJail;}

    public void setInJail(boolean inJail) { this.inJail = inJail; }

    public boolean isFreeOutOfJail() { return freeOutOfJail; }

    public void setFreeOutOfJail(boolean freeOutOfJail) { this.freeOutOfJail = freeOutOfJail; }

    public boolean isBuying() { return buying; }

    public void setBuying(boolean buying) { this.buying = buying; }

    @Override
    public String toString() { return name; }

}
