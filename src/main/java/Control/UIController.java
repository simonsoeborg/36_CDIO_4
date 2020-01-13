package Control;

import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class UIController {

    private GUI gui;

    private String[] Fields= new String[40];
    private GUI_Player[] Player;
    private GUI_Field[] guiFields = new GUI_Field[40];

    public GUI_Field[] createFields() {

        return guiFields;
    }

    public String displayChance(String fieldText) {

        return "";
    }

    public int getPlayerNumber() {
        return 0;
    }

    public int getPlayerNames(int PlayerNumber) {
        return 0;
    }

    public GUI_Car[] setCar(int playerNumber, String[] playerNames){
        GUI_Car[] cars = new GUI_Car[playerNumber];

        for(int i = 0; i < playerNumber; i++) {
            String car = gui.getUserButtonPressed(playerNames[i] + "Vælg farve på bil:", "Rød", "Grøn", "Blå", "Gul", "Sort", "Hvid");
            if(car.equals("Rød")) {
                cars[i] = new GUI_Car(Color.RED, Color.RED, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
            } else if(car.equals("Grøn")) {
                cars[i] = new GUI_Car(Color.GREEN, Color.GREEN, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
            } else if(car.equals("Blå")) {
                cars[i] = new GUI_Car(Color.BLUE, Color.BLUE, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
            } else if(car.equals("Gul")) {
                cars[i] = new GUI_Car(Color.YELLOW, Color.YELLOW, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
            } else if(car.equals("Sort")) {
                cars[i] = new GUI_Car(Color.BLACK, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
            } else if(car.equals("Hvid")) {
                cars[i] = new GUI_Car(Color.WHITE, Color.WHITE, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
            }
        }
        return cars;
    }

    public void addPlayers(String[] playerNames, int balance, GUI_Car[] car) {
        for (int i = 0; i < playerNames.length; i++) {

            Player[i] = new GUI_Player(playerNames[i], balance, car[i]);
            gui.addPlayer(Player[i]);
            gui.getFields()[0].setCar(Player[i], true);
        }
    }

    public void movePlayer(int playerIndex) {

    }

    public void updateBalance(int playerIndex, int balance) {
        Player[playerIndex].setBalance(balance);
    }

    public void updateOwner(int playerIndex, int location) {

    }

    public void winner(int winner) {
        displayChance("Tilykke " + Player[winner].getName() + "!! Du vandt spillet med " + Player[winner].getBalance() + " penge");
    }

    public void showDice(int val1, int val2){
        gui.setDice(val1, val2);
    }

    public void showMessage(String message){
        gui.showMessage(message);
    }

    public int askForPlayers(String msg) {
        int playerNum = gui.getUserInteger(msg,3,6);
        return playerNum;
    }

}
