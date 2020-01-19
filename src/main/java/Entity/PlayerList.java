package Entity;

import java.awt.*;

/**
 * Creates an array of type Player which contains references to the players
 * @author
 * @version 1.0.0
 */
public class PlayerList {

    private static final PlayerList INSTANCE = new PlayerList();
    private Player[] players;
    private int playerNumber;
    private Color[] colorList = {Color.RED , Color.YELLOW, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.CYAN};

    /**
     *Adds a specified number of players to the players array
     * @param playerNumber - The number of players to add
     */
    public void addPlayers(int playerNumber) {
        this.playerNumber = playerNumber;
        players = new Player[this.playerNumber];
        for (int i = 0;i < this.playerNumber;i++) {
            players[i] = new Player(null, colorList[i], i+1);
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    /**
     * Sets all the player names according to names contained in an array
     * @param playerNames - a String type array containing names
     */
    public void givePlayerNames(String[] playerNames) {
        for (int i = 0; i < playerNumber ; i++) {
            players[i].setName(playerNames[i]);
        }
    }

    public Player getPlayer(int index) {
        return players[index];
    }

    public static PlayerList getInstance() {
        return INSTANCE;
    }

}
