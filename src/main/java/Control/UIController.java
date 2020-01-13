package Control;

import Entity.Player;
import Test.ReadFieldDescription;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class UIController {

    /**
     * This is our board game with fields.
     */


    /**
     * #########################################################################
     * THIS CLASS HAVE BEEN MERGED WITH "MatadorGUI.java"
     * Content below is from MatadorGUI.java
     */
    protected GUI gui;
    protected GUI_Field[] guiFields;
    protected GUI_Player[] players;
    protected GUI_Car[] cars;

    public void MatadorGUI(GUI gui) {
        this.gui = gui;
        this.guiFields= gui.getFields();
    }

    public void startInfo(Player[] p) {
        players = new GUI_Player[p.length];
        cars = new GUI_Car[p.length];
        for (int i = 0; i < p.length; i++) {
            cars[i] = new GUI_Car(p[i].getColor(), null, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
            players[i] = new GUI_Player(p[i].getName(), p[i].getMoney(), cars[i]);
            gui.addPlayer(players[i]);
        }

        for (GUI_Player player : players){
            guiFields[0].setCar(player, true);
        }

    }

    /**
     * THIS CLASS HAVE BEEN MERGED WITH "MatadorGUI.java"
     * Content above is from MatadorGUI.java
     * #########################################################################
     */
    public int getPlayerNumber() {
        String playerNumbTemp = gui.getUserSelection("Vælg antal spillere", "2","3","4","5","6");
        int setPlayerAmount = Integer.parseInt(playerNumbTemp);
        return setPlayerAmount;
    }

    public String[] getPlayerNames(int amountOfPlayers) {
        String[] playerNames = new String[amountOfPlayers];
        for (int i = 0; i < amountOfPlayers; i++) {
            playerNames[i] = gui.getUserString("Indtast navn på spiller " + (i+1) + ": ");
        }
        return playerNames;
    }

    public void addPlayers(String [] playerNames, int balance,GUI_Car[] car){
        for (int i = 0; i < playerNames.length; i++) {

            players[i] = new GUI_Player(playerNames[i], balance, car[i]);
            gui.addPlayer(players[i]);
            gui.getFields()[0].setCar(players[i], true);
        }
    }

    public GUI_Car[] setCar(int playernumb, String[] playerNames){
        GUI_Car[] cars = new GUI_Car[playernumb];
        for (int i = 0; i < playernumb; i++) {

            String car = gui.getUserButtonPressed(playerNames[i] + " Vælg farve til bil: ", "Rød", "Grøn", "Blå", "Gul", "Sort", "Hvid");

            if (car.equals("Rød")) {
                cars[i] = new GUI_Car(Color.red, Color.red, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
            } else if (car.equals("Blå")) {
                cars[i] = new GUI_Car(Color.blue, Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.DOTTED);
            } else if (car.equals("Grøn")) {
                cars[i] = new GUI_Car(Color.green, Color.green, GUI_Car.Type.CAR, GUI_Car.Pattern.DOTTED);
            } else if (car.equals("Gul")) {
                cars[i] = new GUI_Car(Color.yellow, Color.yellow, GUI_Car.Type.CAR, GUI_Car.Pattern.DOTTED);
            } else if (car.equals("Sort")) {
                cars[i] = new GUI_Car(Color.black, Color.black, GUI_Car.Type.CAR, GUI_Car.Pattern.DOTTED);
            } else if (car.equals("Hvid")) {
                cars[i] = new GUI_Car(Color.WHITE, Color.white, GUI_Car.Type.CAR, GUI_Car.Pattern.DOTTED);
            }
        }
        return cars;
    }

    public void showDice(int val){
        gui.setDie(val);
    }

    public void showMessage(String message){
        gui.showMessage(message);
    }

    public static GUI_Field[] makeFields() {
        /**
         * We made a read Field Description. So when you click on a field while you play, you can see the description for that field.
         */
        String gameLanguage = "da";
        ReadFieldDescription fieldDesDA = new ReadFieldDescription();
        fieldDesDA.ReadFieldDescription(gameLanguage);
        GUI_Field[] fields = new GUI_Field[40];
        int line = 0;
        int i = 0;
        int var2 = i + 1;
        /**
         * all our MatadorGUI fields, as you see them on the screen while playing.
         */
        fields[i] = new GUI_Start("Start", "Modtag: 4000", "Modtag 4000,-\nnår de passerer start", new Color(204, 68, 60), Color.BLACK);
        fields[var2++] = new GUI_Street("Rødovrevej", "Pris:  1.200", fieldDesDA.getFieldDescription(line), "Leje:  50", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Street("Hvidovrevej", "Pris:  1.200", fieldDesDA.getFieldDescription(line+1), "Leje:  50", new Color(75, 155, 225), Color.BLACK);
        fields[var2++] = new GUI_Tax("Betal\nindkomst-\nskat", "10% el. 4.000", "Betal indkomstskat\n10% eller kr. 4.000,-", Color.GRAY, Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "Øresund", "Pris:  4.000", fieldDesDA.getFieldDescription(line+2), "Leje:  500", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Roskildevej", "Pris:  2.000", fieldDesDA.getFieldDescription(line+3), "Leje:  100", new Color(255, 150, 167), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Street("Valby\nLanggade", "Pris:  2.000", fieldDesDA.getFieldDescription(line+4), "Leje:  100", new Color(255, 150, 167), Color.BLACK);
        fields[var2++] = new GUI_Street("Allégade", "Pris:  2400", fieldDesDA.getFieldDescription(line+5), "Leje:  150", new Color(255, 150, 167), Color.BLACK);
        fields[var2++] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK);
        fields[var2++] = new GUI_Street("Frederiks-\nberg Allé", "Pris:  2.800", fieldDesDA.getFieldDescription(line+6), "Leje:  200", new Color(131, 204, 88), Color.BLACK);
        fields[var2++] = new GUI_Brewery("default", "Tuborg", "Pris:  3.000", fieldDesDA.getFieldDescription(line+7), "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[var2++] = new GUI_Street("Bülowsvej", "Pris:  2.800", fieldDesDA.getFieldDescription(line+8), "Leje:  200", new Color(131, 204, 88), Color.BLACK);
        fields[var2++] = new GUI_Street("Gammel Kongevej", "Pris:  3.200", fieldDesDA.getFieldDescription(line+9), "Leje:  2500", new Color(131, 204, 88), Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "Kalun./Århus", "Pris:  4.000", fieldDesDA.getFieldDescription(line+2), "Leje:  500", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Bernstorffsvej", "Pris:  3.600", fieldDesDA.getFieldDescription(line+10), "Leje:  300", new Color(108, 108, 108), Color.WHITE);
        fields[var2++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Street("Hellerupvej", "Pris:  3.600", fieldDesDA.getFieldDescription(line+11), "Leje:  300", new Color(108, 108, 108), Color.WHITE);
        fields[var2++] = new GUI_Street("Strandvejen", "Pris:  4.000", fieldDesDA.getFieldDescription(line+12), "Leje:  350", new Color(108, 108, 108), Color.WHITE);
        fields[var2++] = new GUI_Refuge("default", "Helle", "Parkering", "Ta' en pause", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Trianglen", "Pris:  4.400", fieldDesDA.getFieldDescription(line+13), "Leje:  350", new Color(247, 82, 80), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Street("Østerbro-\ngade", "Pris:  4.400", fieldDesDA.getFieldDescription(line+14), "Leje:  350", new Color(247, 82, 80), Color.BLACK);
        fields[var2++] = new GUI_Street("Grønningen", "Pris:  4.800", fieldDesDA.getFieldDescription(line+15), "Leje:  400", new Color(247, 82, 80), Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "Seaways", "Pris:  4.000", fieldDesDA.getFieldDescription(line+2), "Leje:  500", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Bredgade", "Pris:  5.200", fieldDesDA.getFieldDescription(line+16), "Leje:  450", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Street("Kgs. Nytorv", "Pris:  5.200", fieldDesDA.getFieldDescription(line+17), "Leje:  450", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Brewery("default", "Carlsberg", "Pris:  3.000", fieldDesDA.getFieldDescription(line+7), "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[var2++] = new GUI_Street("Østergade", "Pris:  5.600", fieldDesDA.getFieldDescription(line+18), "Leje:  500", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Jail("default", "Gå i fængsel", "Gå i fængsel", "De fængsles\nSlå to ens for at komme ud", new Color(125, 125, 125), Color.BLACK);
        fields[var2++] = new GUI_Street("Amagertorv", "Pris:  6.000", fieldDesDA.getFieldDescription(line+19), "Leje:  550", new Color(255, 205, 87), Color.BLACK);
        fields[var2++] = new GUI_Street("Vimmel-\nskaftet", "Pris:  6.000", fieldDesDA.getFieldDescription(line+20), "Leje:  550", new Color(255, 205, 87), Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Street("Nygade", "Pris:  6.400", fieldDesDA.getFieldDescription(line+21), "Leje:  600", new Color(255, 205, 87), Color.BLACK);
        fields[var2++] = new GUI_Shipping("default", "Hals./knuds.", "Pris:  4.000", fieldDesDA.getFieldDescription(line+2), "Leje:  75", Color.WHITE, Color.BLACK);
        fields[var2++] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        fields[var2++] = new GUI_Street("Frederiks-\nberggade", "Pris:  7.000", fieldDesDA.getFieldDescription(line+22), "Leje:  700", new Color(150, 104, 141), Color.WHITE);
        fields[var2++] = new GUI_Tax("Ekstra-\nordinær\nstatsskat", "Betal 2.000", "Betal ekstraordinær\nstatsskat: kr. 1.000,-", Color.GRAY, Color.BLACK);
        fields[var2++] = new GUI_Street("Rådhuspladsen", "Pris:  8000", fieldDesDA.getFieldDescription(line+23), "Leje:  150", new Color(150, 104, 141), Color.WHITE);
        return fields;
    }
}
