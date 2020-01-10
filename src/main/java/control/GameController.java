package control;

import boundary.BoardCreator;
import boundary.MatadorGUI;
import gui_main.GUI;

import java.awt.*;

public class GameController {

    public void playGame(){
        GUI gui = new GUI(BoardCreator.makeFields(), Color.white);

        // MatadorGUI matGUI = new MatadorGUI(gui);
    }
}
