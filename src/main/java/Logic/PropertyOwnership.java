package Logic;

import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.Fields.Street;
import Entity.FileReader;
import Entity.GameBoard;
import Entity.Player;

import java.awt.*;

/**
 *  Property ownership handles all aspects of ownership of fields.
 * @author David, Kristoffer
 * @version 1.0.0
 */

public class PropertyOwnership {


    private FileReader reader = new FileReader();
    int blue = 0, pink = 0, green = 0, grey = 0, red = 0, yellow = 0, purple = 0, white = 0;

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
     *
     * @param fields
     * @param p
     */
    public void buildableSets(Field[] fields, Player p) {
        propertySetCounter(fields, p);

        if (blue == 2) {
            // retuner de blå felter til guien
        }
        if (purple == 2) {
            // retuner de lilla felter til guien
        }
        if (pink == 3) {
            // retuner de pink felter til guien
        }
        if (green == 3) {
            // retuner grøn felter til guien
        }
        if (grey == 3) {
            // retuner de grå felter til guien
        }
        if (red == 3) {
            // retuner de red felter til guien
        }
        if (yellow == 3) {
            // retuner de gul felter til guien
        }
        if (white == 3) {
            // retuner de hvid felter til guien
        }
    }

    //blue og purple har hver især to felter - Resten har tre felter

    /**
     * Builds a house on a owned field, and redrawm money from the players account.
     * @param field - one of the owners field
     * @param p - the owners turn
     */
    public void houseBuilder(Street field, Player p) {
        if (field.getNumberOfHouses() <= 5) {
            p.addMoney(-(field.getHousePrice()));
            field.setNumberOfHouses(field.getNumberOfHouses() + 1);

        }
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

    public void propertySetCounter(Field[] fields, Player p) {
        blue = 0; pink = 0; green = 0; grey = 0; red = 0; yellow = 0; purple = 0; white = 0;
        int index = 0;

        for (Field field : fields) {
            if (field instanceof Street) {
                if (p.getId() == ((Street) field).getOwnerID()) {
                    switch (reader.read(4, index)) {
                        case "1":
                            blue++;
                            break;
                        case "2":
                            pink++;
                            break;
                        case "3":
                            green++;
                            break;
                        case "4":
                            grey++;
                            break;
                        case "5":
                            red++;
                            break;
                        case "6":
                            yellow++;
                            break;
                        case "7":
                            purple++;
                            break;
                        case "8":
                            white++;
                        default:
                            ;
                            break;
                    }
                }
            }

            index++;
        }
    }


    public void canBuildHouse(Field[] fields, Player p) {
        propertySetCounter(fields, p);
        if (blue == 2 || purple == 2|| pink == 3|| green == 3|| grey == 3|| red == 3|| yellow == 3|| white == 3)
            p.setAbleToBuyHouses(true);
        else
            p.setAbleToBuyHouses(false);
    }
}



