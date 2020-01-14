package Entity;

import java.awt.*;

public class Player {
    private String playerName;
    private int money;
    private int fieldIndex;
    private boolean bankruptcy;
    private boolean inPrison;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String Name) {
        playerName = Name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int amount) {
        money = amount;
    }

    public boolean setBankrupt(int playerNumber) {
        return bankruptcy;
    }

    public boolean isPlayerInPrison(int playerNumber) {
        return inPrison;
    }
}
