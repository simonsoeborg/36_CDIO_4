package Control;

import Entity.DiceCup;
import Entity.Player;

import java.awt.*;

public class PlayerController {

    private Player[] players;
    private int playersNum;
    private Color[] colorList = {Color.BLACK, Color.YELLOW, Color.BLUE, Color.GREEN, Color.RED, Color.MAGENTA};
    public String [] playerNames = {"Bo i folkswagen","Lis i Up", "Jens i goCar", "Brian i BMW","Britta Jensen", "Olga på cykel"};

    public PlayerController(int playersNum) {
        this.playersNum = playersNum;
        players = new Player[playersNum];
        for (int i = 0;i < playersNum;i++) {
            players[i] = new Player(null, colorList[i]);
        }
    }

    public int getPlayersNum() {
        return playersNum;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getPlayer(int i){ return players[i]; }

    public Color getColor(int i){
        return colorList[i];
    }

    public Color[] getColorList() {
        return colorList;
    }

}
