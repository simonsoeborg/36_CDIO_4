package Control;

import Boundary.MatadorGUI;
import gui_main.GUI;

import java.awt.*;

public class GameController {

    public void playGame(){

        GUI gui = new GUI(BoardController.makeFields(), Color.white);

        MatadorGUI mat = new MatadorGUI(gui);

        PlayerController pl = new PlayerController(6);

        //Uses test names
        for (int i = 0; i < pl.getPlayersNum(); i++) {
            pl.getPlayer(i).setName(pl.playerNames[i]);
        }

        mat.startInfo(pl.getPlayers());

    }
}
