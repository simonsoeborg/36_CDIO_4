import boundary.BoardCreator;
import boundary.MatadorGUI;
import control.GameController;
import gui_main.GUI;

import java.awt.*;

public class MatadorSpil {
    public static void main(String[] args) {
        GameController con = new GameController();
        con.playGame();
    }
}
