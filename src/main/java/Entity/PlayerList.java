package Entity;

import java.awt.*;
import java.util.Optional;

public class PlayerList {

    private static final PlayerList INSTANCE = new PlayerList();
    private Player[] players;
    private int playerNumber;
    private Color[] colorList = {Color.RED , Color.YELLOW, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.CYAN};
//    public String [] playerNames = {"Bo i folkswagen","Lis i Up", "Jens i goCar", "Brian i BMW","Britta Jensen", "Olga på cykel"};

    public PlayerList() {}

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

    public void givePlayerNames(String[] playerNames) {
        for (int i = 0; i < playerNumber ; i++) {
            players[i].setName(playerNames[i]);
        }
    }

    public Player getPlayer(int index) {
        return players[index];
    }

    public void setPlayerNull(int index){


    }



    public static PlayerList getInstance() {
        return INSTANCE;
    }

}
