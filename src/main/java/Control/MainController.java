package Control;

import Entity.Player;
import gui_main.GUI;

import java.awt.*;

public class MainController {
    protected GameController game;
    protected UIController UI;
    protected int amountOfPlayers;
    protected String[] playerNames;

    public void initGame() {
        UI.MatadorGUI(game.gui);
        playGame();
    }

    public void playGame() {
        boolean gameOver = false;
        PlayerController pl = new PlayerController();
        GUI gui = new GUI();
        UIController gC = new UIController();

        // Ask for amount of players:
        amountOfPlayers = UI.getPlayerNumber();
        // Call method to ask for player names
        playerNames = UI.getPlayerNames(amountOfPlayers);

        // Insert players in to PlayerController
        PlayerController pC = new PlayerController();
        pC.setPlayers(playerNames);
        UI.addPlayers(playerNames, pC.getStartbalance(), UI.setCar(amountOfPlayers, playerNames));

        // Setup should be complete.
        // Start game logic
        UI.showMessage("Start spil");
        while (!gameOver) {
            for(int i = 0; i < amountOfPlayers; i++) {
                UI.showMessage(playerNames[i] + ", Press enter to roll the dice!");
                //todo Mangler turn logic game.turn(player.getPlayers()[i]);

                //todo Mangler turn logic game.turn(player.getPlayers()[i]);
                UI.showDice(game.dC.faceValues());

            }
        }
    }
}
