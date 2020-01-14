package Control;

import Entity.GUISetup;
import Entity.PlayerList;

public class MainController {

    private int playerNumber;

    private static final PlayerList plINSTANCE = new PlayerList();

    public void playGame() {

        GUISetup gui = GUISetup.getInstance();

        playerNumber = gui.askForPlayers();

        plINSTANCE.addPlayers(playerNumber);



    }




    public static PlayerList getPlInstance() {
        return plINSTANCE;
    }

}
