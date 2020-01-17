package Boundary;

import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.FileReader;
import Entity.GameBoard;
import Entity.Player;
import Logic.Action;
import Logic.ChanceCardLogic;
import gui_fields.*;
import gui_main.GUI;

import javax.swing.*;
import java.awt.*;

public class GUISetup {

    private static final GUISetup INSTANCE = new GUISetup();
    private FileReader reader = new FileReader();
    private GameBoard fl = GameBoard.getInstance();
    private ChanceCardLogic cl = ChanceCardLogic.getInstance();


    private GUI gui;
    private String[] playerNames;
    private GUI_Player[] players;
    private GUI_Field[] guiFields = makeFields();
    private GUI_Car[] cars;

    public GUISetup(){
        gui = new GUI(guiFields, Color.WHITE);
    }

    public String displayChance(String fieldText) {
        return "";
    }

    private void displayChanceCard() {
        gui.setChanceCard(reader.read(5, cl.getRandom()));
    }

    public void addPlayers(Player[] p) {
        players = new GUI_Player[p.length];
        cars = new GUI_Car[p.length];
        for (int i=0; i<p.length;i++){
            cars[i] = new GUI_Car(p[i].getColor(), null, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
            players[i] = new GUI_Player(p[i].getName(),p[i].getMoney(), cars[i]);
            gui.addPlayer(players[i]);
        }

        // sæt alle biler på start
        for (GUI_Player player : players){
            guiFields[0].setCar(player, true);
        }
    }


    /**
     * Updates the board (balance, car placements, ownerships).
     * @param pl Takes a list of players.
     * @param fl Takes a list of fields.
     */
    public void showGameStatus(Player[] pl, Field[] fl) {
        for (int i = 0; i < guiFields.length; i++) {
            if (guiFields[i] != null) {
                guiFields[i].removeAllCars();
                updateOwner(i, pl, fl);
            }
        }
        for (int j = 0; j < pl.length; j++) {
            movePlayer(j, pl);
            updateBalance(j, pl);
        }
    }

    private void movePlayer(int i, Player[] pl) {
        if (!pl[i].getBankruptcy())
            guiFields[pl[i].getFieldIndex()].setCar(players[i], true);
        for (int j = 0; j < pl.length; j++) {
            if (pl[j].getBankruptcy()) {
                guiFields[pl[j].getFieldIndex()].setCar(players[i], false);
            }
        }
    }

    private void updateBalance(int i, Player[] pl) {
        players[i].setBalance(pl[i].getMoney());
    }

    private void updateOwner(int i, Player[] pl, Field[] fl) {
        if (fl[i] instanceof Ownable) {
            int owner = ((Ownable) fl[i]).getOwnerID();
            if (owner != 0) {
                ((GUI_Ownable) guiFields[i]).setBorder(pl[owner - 1].getColor());
            } else {
                ((GUI_Ownable) guiFields[i]).setBorder(Color.BLACK);
            }

        }
    }

    public void winner(int winner) {
        gui.showMessage("Tillykke " + players[winner].getName() + "!!! \nDu vandt spillet og er en ægte MATADOR.");
    }

    public void showDice(int val1, int val2){
        gui.setDice(val1, val2);
    }

    public void showMessage(String message){
        gui.showMessage(message);
    }

    public int askForPlayers() {
        String s = gui.getUserButtonPressed("Vælg antal spillere", "3", "4", "5", "6");
        return Integer.parseInt(s);
    }

    public String[] getPlayerNames(int playerNumber) {
        playerNames = new String[playerNumber];
        for (int i = 0; i < playerNumber; i=i) {
            playerNames[i++] = gui.getUserString("Tilføj spiller " + i + "'s navn");
        }
        return playerNames;
    }

    public String action(String name, int fieldIndex, String action) {
        String choice = "";
        switch (action) {

            case "Buy":
                choice = gui.getUserButtonPressed(name + reader.read(3,2) + " " +
                        reader.read(1, fieldIndex + 1) + reader.read(3,3), "Køb", "Køb ikke");
                break;

            case "Yours":
                choice = gui.getUserButtonPressed(name + reader.read(3,2) + " " +
                        reader.read(1, fieldIndex + 1) + reader.read(3,4), "Ok");
                break;

            case "Theirs":
                choice = gui.getUserButtonPressed(name + reader.read(3,2) + " " +
                        reader.read(1, fieldIndex + 1) + reader.read(3,5), "Betal");
                break;

            case "Default":
                choice = gui.getUserButtonPressed(name +  reader.read(3,2) + " " +
                        reader.read(1, fieldIndex + 1) + reader.read(3, 11), "Ok");
                break;

//----------------------------------------------Chance----------------------------------------------------------------//

            case "Chance":
                choice = gui.getUserButtonPressed(name + reader.read(3,2) + " " +
                        reader.read(1, fieldIndex + 1), "Træk kort");
                break;

            case "Pay":
                displayChanceCard();
                choice = gui.getUserButtonPressed("", "Betal penge");
                break;

            case "Receive":
                displayChanceCard();
                choice = gui.getUserButtonPressed("", "Modtag penge");
                break;

            case "Move":
                displayChanceCard();
                choice = gui.getUserButtonPressed("", "Ryk");
                break;

//------------------------------------------------Tax-----------------------------------------------------------------//

            case "Income tax":
                choice = gui.getUserButtonPressed(name +  reader.read(3,2) + " " +
                        reader.read(1, fieldIndex + 1) + reader.read(3,7), "Betal 10%", "Betal 4000kr.-");
                break;

            case "Extraordinary state tax":
                choice = gui.getUserButtonPressed(name +  reader.read(3,2) + " " +
                        reader.read(1, fieldIndex + 1) + reader.read(3,9),  "Betal 2000kr.-");
                break;



//----------------------------------------------JAIL------------------------------------------------------------------//

            case "Jail":
                choice = gui.getUserButtonPressed(name +  reader.read(3,2) + " " +
                        reader.read(1, fieldIndex + 1) + reader.read(3, 8), "Ryk i fængsel");
                break;

            case "InJail":
                choice = gui.getUserButtonPressed(name + reader.read(3, 6), "Betal 1.000kr.-", "Prøv at slå par");
                break;

            case "NotFree":
                choice = gui.getUserButtonPressed(name + reader.read(3, 12), "Ok");
                break;

            case "Free":
                choice = gui.getUserButtonPressed(name + reader.read(3,14), "Rul");
                break;

            case "ThreeRoundsInJail":
                choice = gui.getUserButtonPressed(name + reader.read(3, 13), "Betal");
                break;

            case "3Doubles":
                choice = gui.getUserButtonPressed(name + reader.read(3, 15), "Ryk i fængsel");
                break;

//----------------------------------------------House-----------------------------------------------------------------//

            case "House":
                choice = gui.getUserButtonPressed(reader.read(3, 16), "Byg Hus", "Slut tur");
                break;

            case "HouseRollAgain":
                choice = gui.getUserButtonPressed(reader.read(3, 17), "Byg Hus", "Rul");
                break;

            case "BuildHouse":
                choice = gui.getUserSelection(reader.read(3, 18), "Blå", "Pink", "Grøn", "Grå", "Rød", "Hvid", "Gul", "Lilla");
                break;

            case "NotAllSets":
                choice = gui.getUserButtonPressed(reader.read(3, 20), "Ok");
                break;

//----------------------------------------------Bankruptcy------------------------------------------------------------//

            case "Bankrupt":
                choice = gui.getUserButtonPressed(name + reader.read(3, 19), "Slut tur");
                break;

            case "IsBankrupt":
                choice = "Slut tur";
                break;

//----------------------------------------------Roll------------------------------------------------------------------//

            case "RollAgain":
                choice = gui.getUserButtonPressed(name + reader.read(3,10), "Rul");
                break;

            case "Roll":
            default:
                choice = gui.getUserButtonPressed(name + reader.read(3,1), "Rul");
                break;
        }

        return choice;
    }






    public static GUISetup getInstance() {
        return INSTANCE;
    }

    /**
     * This is our board game with fields.
     */

    public static GUI_Field[] makeFields() {
        /**
         * We made a read Field Description. So when you click on a field while you play, you can see the description for that field.
         */

        FileReader fieldDesDA = new FileReader();
        GUI_Field[] fields = new GUI_Field[40];
        int line = 1;
        int i = 0;
        int var2 = i + 1;
        /**
         * all our MatadorGUI fields, as you see them on the screen while playing.
         */
        fields[i] = new GUI_Start("Start", "Modtag: 4000", "Modtag 4000,-\nnår de passerer start", new Color(204, 68, 60), Color.BLACK);
        fields[var2++] = new GUI_Street("Rødovrevej", "Pris:  1.200", fieldDesDA.read(2,line), "Leje:  50", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Street("Hvidovrevej", "Pris:  1.200", fieldDesDA.read(2,line+1), "Leje:  50", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Tax("Betal\nindkomst-\nskat", "10% el. 4.000", "Betal indkomstskat\n10% eller kr. 4.000,-", Color.GRAY, Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "Øresund", "Pris:  4.000", fieldDesDA.read(2,line+2), "Leje:  500", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Roskildevej", "Pris:  2.000", fieldDesDA.read(2,line+3), "Leje:  100", new Color(255, 150, 167), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Street("Valby\nLanggade", "Pris:  2.000", fieldDesDA.read(2,line+4), "Leje:  100", new Color(255, 150, 167), Color.BLACK);
        fields[var2++] = new GUI_Street("Allégade", "Pris:  2400", fieldDesDA.read(2,line+5), "Leje:  150", new Color(255, 150, 167), Color.BLACK);
        fields[var2++] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK);
        fields[var2++] = new GUI_Street("Frederiks-\nberg Allé", "Pris:  2.800", fieldDesDA.read(2,line+6), "Leje:  200", new Color(131, 204, 88), Color.BLACK);
        fields[var2++] = new GUI_Brewery("default", "Tuborg", "Pris:  3.000", fieldDesDA.read(2,line+7), "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[var2++] = new GUI_Street("Bülowsvej", "Pris:  2.800", fieldDesDA.read(2,line+8), "Leje:  200", new Color(131, 204, 88), Color.BLACK);
        fields[var2++] = new GUI_Street("Gammel Kongevej", "Pris:  3.200", fieldDesDA.read(2,line+9), "Leje:  2500", new Color(131, 204, 88), Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "Kalun./Århus", "Pris:  4.000", fieldDesDA.read(2,line+2), "Leje:  500", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Bernstorffsvej", "Pris:  3.600", fieldDesDA.read(2,line+10), "Leje:  300", new Color(108, 108, 108), Color.WHITE);
        fields[var2++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Street("Hellerupvej", "Pris:  3.600", fieldDesDA.read(2,line+11), "Leje:  300", new Color(108, 108, 108), Color.WHITE);
        fields[var2++] = new GUI_Street("Strandvejen", "Pris:  4.000", fieldDesDA.read(2,line+12), "Leje:  350", new Color(108, 108, 108), Color.WHITE);
        fields[var2++] = new GUI_Refuge("default", "Helle", "Parkering", "Ta' en pause", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Trianglen", "Pris:  4.400", fieldDesDA.read(2,line+13), "Leje:  350", new Color(247, 82, 80), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Street("Østerbro-\ngade", "Pris:  4.400", fieldDesDA.read(2,line+14), "Leje:  350", new Color(247, 82, 80), Color.BLACK);
        fields[var2++] = new GUI_Street("Grønningen", "Pris:  4.800", fieldDesDA.read(2,line+15), "Leje:  400", new Color(247, 82, 80), Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "Seaways", "Pris:  4.000", fieldDesDA.read(2,line+2), "Leje:  500", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Bredgade", "Pris:  5.200", fieldDesDA.read(2,line+16), "Leje:  450", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Kgs. Nytorv", "Pris:  5.200", fieldDesDA.read(2,line+17), "Leje:  450", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Brewery("default", "Carlsberg", "Pris:  3.000", fieldDesDA.read(2,line+7), "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[var2++] = new GUI_Street("Østergade", "Pris:  5.600", fieldDesDA.read(2,line+18), "Leje:  500", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Jail("default", "Gå i fængsel", "Gå i fængsel", "De fængsles\nSlå to ens for at komme ud", new Color(125, 125, 125), Color.BLACK);
        fields[var2++] = new GUI_Street("Amagertorv", "Pris:  6.000", fieldDesDA.read(2,line+19), "Leje:  550", new Color(255, 205, 87), Color.BLACK);
        fields[var2++] = new GUI_Street("Vimmel-\nskaftet", "Pris:  6.000", fieldDesDA.read(2,line+20), "Leje:  550", new Color(255, 205, 87), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Street("Nygade", "Pris:  6.400", fieldDesDA.read(2,line+21), "Leje:  600", new Color(255, 205, 87), Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "Hals./knuds.", "Pris:  4.000", fieldDesDA.read(2,line+2), "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Street("Frederiks-\nberggade", "Pris:  7.000", fieldDesDA.read(2,line+22), "Leje:  700", new Color(150, 104, 141), Color.WHITE);
        fields[var2++] = new GUI_Tax("Ekstra-\nordinær\nstatsskat", "Betal 2.000", "Betal ekstraordinær\nstatsskat: kr. 1.000,-", Color.GRAY, Color.BLACK);
        fields[var2++] = new GUI_Street("Rådhuspladsen", "Pris:  8000", fieldDesDA.read(2,line+23), "Leje:  150", new Color(150, 104, 141), Color.WHITE);
        return fields;
    }
}
