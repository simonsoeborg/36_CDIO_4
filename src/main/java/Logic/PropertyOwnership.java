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

    /**
     * Buyfield withdraw the price for the field from the players account and set him as the owner
     * @param - p the current player
     */
        public void buyField(Player p, Field[] fl){

        p.addMoney(-(((Ownable)fl[p.getFieldIndex()]).getPropertyPrice()));
        ((Ownable)fl[p.getFieldIndex()]).setOwnerID(p.getId());
        }

        public void buildHouse(Field[] fields, Player p, FileReader reader){
            int blue=0, pink=0, green=0, grey=0, red=0, yellow=0, purple=0;
            int index = 0;

            for (Field field: fields) {
                if (field instanceof Street){
                    if (p.getId()==((Street) field).getOwnerID()){
                        switch (reader.read(4,index)){
                            case "1": blue++;
                            break;
                            case "2": pink++;
                            break;
                            case "3": green++;
                            break;
                            case "4": grey++;
                            break;
                            case "5": red++;
                            break;
                            case "6": yellow++;
                            break;
                            case "7": purple++;
                            break;
                            default: ;
                            break;
                        }
                    }
                }

                index++;
            }

            if (blue==2||purple==2||pink==3||green==3||grey==3||red==3||yellow==3){
              //Send besked til GUI om at knappen 'byg hus' skal oprettes
            }
            else //Send besked at han ikke kan købe
        }
    //blue og purple har hver især to felter - Resten har tre felter

    public void houseBuilder(Street field){
            switch (field)
    }
}

