package boundary;

import entity.Player;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class MatadorGUI {

    private GUI gui;
    private GUI_Field[] guiFields;
    private GUI_Player[] players;
    private GUI_Car[] cars;

    public MatadorGUI(GUI gui) {
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
}