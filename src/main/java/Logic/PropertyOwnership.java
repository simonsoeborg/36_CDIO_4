package Logic;

import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.Fields.Street;
import Entity.FileReader;
import Entity.GameBoard;
import Entity.Player;
import Entity.PlayerList;

import java.awt.*;

/**
 *  Property ownership handles all aspects of ownership of fields.
 * @author David, Kristoffer
 * @version 1.0.0
 */

public class PropertyOwnership {

    private FileReader reader = new FileReader();
    private GameBoard gb = GameBoard.getInstance();
    private Field[] fl = gb.getFields();

// det er en to demintionel array, hvor du kan se hvilken farver der høre sammen.
    private int[][] streetSets =  {{1,3},{6,8,9},{11,13,14},{16,18,19},{21,23,24},{26,27,29},{31,32,34},{37,39}};

    public int whereToBuild(int set) {
        int fieldIndex = 0;
        int houses = 0;
        int fewest = 5;
        // Dette tjekker hvilken af setsene (oven over) hvor der kan bygges.
        for (int i = 0; i < streetSets[set].length; i++) {
            houses = ((Street)fl[streetSets[set][i]]).getNumberOfHouses();
            if (fewest > houses)
                fewest = houses;
        }
        // Her sætter den på det sidste felt i array og bygge den "modsatte vej" fra den dyreste til de billigeste
        for (int i = streetSets[set].length - 1 ; i >= 0 ; i--) {
            if (fewest == ((Street)fl[streetSets[set][i]]).getNumberOfHouses()) {
                fieldIndex = streetSets[set][i];
                break;
            }
        }

        return fieldIndex;
    }

    /**
     * Buyfield withdraw the price for the field from the players account and set him as the owner
     *
     * @param - p the current player
     */
    public void buyField(Player p, Field[] fl) {

        p.addMoney(-(((Ownable) fl[p.getFieldIndex()]).getPropertyPrice()));
        ((Ownable) fl[p.getFieldIndex()]).setOwnerID(p.getId());
    }

    /**
     * Builds a house on a owned field, and redrawm money from the players account.
     * @param field - one of the owners field
     * @param p - the owners turn
     */
    public String houseBuilder(Street field, Player p) {
        if (field.getNumberOfHouses() < 5) {
            p.addMoney(-(field.getHousePrice()));
            field.setNumberOfHouses(field.getNumberOfHouses() + 1);
            if (field.getNumberOfHouses() == 5)
                return "Hotel";
            else
                return "Hus";

        }
        return "Full";
    }

    /**
     * sells/removes a house on a owned field
     * @param field - one of the owners field
     * @param p - the owners turn
     */
    public void houseSeller (Street field, Player p){
            if (field.getNumberOfHouses() > 0) {
                p.addMoney(field.getHousePrice()/2);
                field.setNumberOfHouses(field.getNumberOfHouses() - 1);
            }
    }

    // Den tjekker de ejer felene og sætter det til true, at de kan bygge.
    public boolean canBuildHouse(Field[] fields, Player p) {
        propertySetCounter(fields, p);
        if (p.getBlue() == 2 || p.getPurple() == 2|| p.getPink() == 3|| p.getGreen() == 3|| p.getGrey() == 3|| p.getRed() == 3|| p.getYellow() == 3|| p.getWhite() == 3)
            return true;
        else
            return false;
    }

    // her tjekker vi om vi kan spilleren kan bygge på feltet ( har alle felter)
    public void propertySetCounter(Field[] fields, Player p) {

        p.Altf4();

        int line = 1;

        for (Field field : fields) {
            if (field instanceof Street) {
                if (p.getId() == ((Street) field).getOwnerID()) {
                    switch (reader.read(4, line)) {
                        case "1":
                            p.setBlue(p.getBlue()+1);
                            break;
                        case "2":
                            p.setPink(p.getPink()+1);
                            break;
                        case "3":
                            p.setGreen(p.getGreen()+1);
                            break;
                        case "4":
                            p.setGrey(p.getGrey()+1);
                            break;
                        case "5":
                            p.setRed(p.getRed()+1);
                            break;
                        case "6":
                            p.setWhite(p.getWhite()+1);
                            break;
                        case "7":
                            p.setYellow(p.getYellow()+1);
                            break;
                        case "8":
                            p.setPurple(p.getPurple()+1);
                            break;
                        default:
                            break;
                    }
                }
            }
            line++;
        }
    }
}



