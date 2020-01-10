package control;

import boundary.BoardCreator;
import boundary.MatadorGUI;
import entity.PlayerList;
import gui_main.GUI;

import java.awt.*;

public class GameController {

    public void playGame(){

        GUI gui = new GUI(BoardCreator.makeFields(), Color.white);

        MatadorGUI mat = new MatadorGUI(gui);

        PlayerList pl = new PlayerList(6);

        //Uses test names
        for (int i = 0; i < pl.getPlayersNum(); i++) {
            pl.getPlayer(i).setName(pl.playerNames[i]);
        }

        mat.startInfo(pl.getPlayers());

    }
}
