package Control;

import Boundary.MatadorGUI;
import Entity.DiceCup;
import gui_main.GUI;

import java.awt.*;

public class GameController {

    public void playGame(){

        GUI gui = new GUI(GUIController.makeFields(), Color.white);
        MatadorGUI mat = new MatadorGUI(gui);
        PlayerController pl = new PlayerController(6);
        GUIController bc = new GUIController();
        BoardController BC = new BoardController();
        DiceCup dC = new DiceCup();
        LogicController Lc = new LogicController();
        //Uses test names
        for (int i = 0; i < pl.getPlayersNum(); i++) {
            pl.getPlayer(i).setName(pl.playerNames[i]);
        }
    }
}
