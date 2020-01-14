package Control;

import Entity.GUISetup;
import Entity.Player;
import Entity.PlayerList;

public class MainController {

    private int playerNumber;

    private PlayerList pl = PlayerList.getInstance();

    public void playGame() {

        GUISetup gui = GUISetup.getInstance();

        playerNumber = gui.askForPlayers();

        pl.addPlayers(playerNumber);

        pl.givePlayerNames(gui.getPlayerNames(playerNumber));

        gui.addPlayers(pl.getPlayers());

        while (true) {




        }



    }





}
