package Entity;

import java.awt.*;

/**
 *  This a player class with attributes to identify what a player has to play the game
 * @author
 * @version 1.0.0
 */

public class Player {
    private String name;
    private Color color;
    private int money;
    private int fieldIndex;
    private int id;
    private boolean bankruptcy;
    private boolean inJail;
    private int roundsInJail;
    private int doublesInARow;
    private int blue = 0, pink = 0, green = 0, grey = 0, red = 0, yellow = 0, purple = 0, white = 0;
    /**
     *
     * @param name - the person who's going to play the game, as the possibility to set a name on the current player
     * @param color - every player has a color on their car, But also the colorBoard for their field
     * @param id - When a player is created, the get a ID. The ID is used to show which things a player owns
     */
    public Player(String name, Color color, int id) {

        this.name = name;
        this.color = color;
        this.id = id;
        money=30000;
        fieldIndex = 0;
        bankruptcy = false;
        inJail = false;
        roundsInJail = 0;
        doublesInARow = 0;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public int getMoney() {

        return money;
    }

    // their start money is set to 30.000
    public void addMoney(int diff) {
        if (money + diff >= 0) {
            money = money + diff;
        } else {
            setBankruptcy(true);
            money = 0;
        }
    }

    public boolean getBankruptcy() {return bankruptcy;}

    public void setBankruptcy(boolean bankruptcy) { this.bankruptcy = bankruptcy; }

    public int getFieldIndex() { return fieldIndex; }

    public void setFieldIndex(int fieldIndex) { this.fieldIndex = fieldIndex; }

    public boolean isInJail(){return inJail;}

    public void setInJail(boolean inJail) { this.inJail = inJail; }

    public int getId() {
        return id;
    }

    public int getRoundsInJail() {
        return roundsInJail;
    }

    public void setRoundsInJail(int roundsInJail) {
        this.roundsInJail = roundsInJail;
    }

    public void addRoundInJail() {
        this.roundsInJail++;
    }

    public int getDoublesInARow() {
        return doublesInARow;
    }

    public void setDoublesInARow(int doublesInARow) {
        this.doublesInARow = doublesInARow;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getPink() {
        return pink;
    }

    public void setPink(int pink) {
        this.pink = pink;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getGrey() {
        return grey;
    }

    public void setGrey(int grey) {
        this.grey = grey;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getYellow() {
        return yellow;
    }

    public void setYellow(int yellow) {
        this.yellow = yellow;
    }

    public int getPurple() {
        return purple;
    }

    public void setPurple(int purple) {
        this.purple = purple;
    }

    public int getWhite() {
        return white;
    }

    public void setWhite(int white) {
        this.white = white;
    }

    // antal felter i farver en spiller ejer
    public void Altf4() {
        setBlue(0);
        setRed(0);
        setPink(0);
        setGrey(0);
        setGreen(0);
        setYellow(0);
        setWhite(0);
        setPurple(0);
    }

    @Override
    public String toString() { return name; }

}

