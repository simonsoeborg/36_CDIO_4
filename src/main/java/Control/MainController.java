package Control;

import Entity.GUISetup;
import Entity.PlayerList;

public class MainController {

    private int playerNumber;

    private PlayerList pl = PlayerList.getInstance();

    public void playGame() {

        GUISetup gui = GUISetup.getInstance();

        playerNumber = gui.askForPlayers();

        pl.addPlayers(playerNumber);



    }





}
