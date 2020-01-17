import Control.MainController;
import Entity.GameBoard;
import Entity.PlayerList;
import Logic.Action;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws Exception {

        MainController mc = new MainController();

        mc.playGame();

    }
}
