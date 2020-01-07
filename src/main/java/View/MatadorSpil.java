package view;

import gui_fields.GUI_Board;
import gui_fields.GUI_Field;
import gui_main.GUI;

import java.awt.*;

public class MatadorSpil {
    public static void main(String[] args) {
        GUI gui = new GUI(BoardCreator.makeFields(), Color.LIGHT_GRAY);
    }
}
