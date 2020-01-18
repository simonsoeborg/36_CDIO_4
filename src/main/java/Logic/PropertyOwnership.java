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
 * Property ownership handles all aspects of ownership of fields. This includes buying Ownable fields and building
 * on Street type fields
 * @author David, Kristoffer
 * @version 1.0.0
 */

public class PropertyOwnership {

    private FileReader reader = new FileReader();
    private GameBoard gb = GameBoard.getInstance();
    private Field[] fl = gb.getFields();

    // det er en to demintionel array, hvor du kan se hvilken farver der høre sammen.
    private int[][] streetSets =  {{1,3},{6,8,9},{11,13,14},{16,18,19},{21,23,24},{26,27,29},{31,32,34},{37,39}};
    /**
     * Checks which of the fields within a specific set ( decided by color ) has the most houses.
     * This ensures that buildings are placed evenly
     * @param set - A specific set of fields the player owns
     * @return - The index of the field that should be build on
     */
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
     * Checks weather a player owns sets. one set is all fields of the same color
     * @param fields - Field type array
     * @param p - The player
     * @return - Boolean true if the player owns any of the sets or false if he don't
     */
    public boolean canBuildHouse(Field[] fields, Player p) {
        propertySetCounter(fields, p);
        if (p.getBlue() == 2 || p.getPurple() == 2|| p.getPink() == 3|| p.getGreen() == 3|| p.getGrey() == 3|| p.getRed() == 3|| p.getYellow() == 3|| p.getWhite() == 3)
            return true;
        else
            return false;
    }
    // her tjekker vi om vi kan spilleren kan bygge på feltet ( har alle felter)
    /**
     * Goes through all fields on the gameboard and counts variables corresponding to diffrent field colors whenever it meets
     * one the specified player owns.
     * @param fields - Field type array
     * @param p - The player
     */
    public void propertySetCounter(Field[] fields, Player p) {

        // nulstiller alle int varablerne med farvenane hos spilleren ( de er arrtributter i Player klassen )
        // vi gør dette da vi gerne vil have en baseline når vi gennemløber felterne i fieldsarrayet. Så sikre vi os
        // at deres værdi altid er inden for de intavaller vi har defineret ( f.eks. blue = 2, er et set ---red = 3 er et andet set)
        p.Altf4();

        //Sørger for at FileReader starter på første linje i Textdokumentet SameColoredFieldsInfo.txt
        int line = 1;

        // foreach gennemløber alle elementer i fields arrayet
        for (Field field : fields) {

            // Tjekker først om feltet er en intans af Street klassen ( altså at det er af denne type), ellers køres
            // der videre til næste element i arrayet
            if (field instanceof Street) {

                // Tjekker om spillerens id er det samme som det pågældende felts, hvis ikke køres der videre i arrayet
                if (p.getId() == ((Street) field).getOwnerID()) {

                    //Læser en linje (som matcher det pågældende index i arrayet vi gennemløber) og tjekker havd der står
                    // alt efter havd der står bliver spillerens arttributter ( int med farvenavne) plusset med 1
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
            // sørger for at filereaderen læser fra næste linje ved næste gennemløb
            line++;
        }
    }
}



