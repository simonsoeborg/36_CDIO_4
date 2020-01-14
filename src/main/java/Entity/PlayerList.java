package Entity;

import java.awt.*;

public class PlayerList {
    private static final PlayerList INSTANCE = new PlayerList(6);

    private Player[] players;
    private int playerNumber;
    private Color[] colorList = {Color.BLACK, Color.YELLOW, Color.BLUE, Color.GREEN, Color.RED, Color.MAGENTA};
    public String [] playerNames = {"Bo i folkswagen","Lis i Up", "Jens i goCar", "Brian i BMW","Britta Jensen", "Olga på cykel"};

    public PlayerList(int playersNum) {
        this.playerNumber = playersNum;
        players = new Player[playersNum];
        for (int i = 0;i < playersNum;i++) {
            players[i] = new Player(null, colorList[i], i+1);
        }
    }

    public static PlayerList getINSTANCE(){
        return INSTANCE;
    }

}
