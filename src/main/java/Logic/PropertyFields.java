package Logic;

import Control.MainController;
import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.Fields.Street;
import Entity.GameBoard;
import Entity.Player;
import Entity.PlayerList;

public class PropertyFields {
    /**
     * Method to determine whether or not a field is owned.
     */
    private static GameBoard gb = GameBoard.getInstance();
    private static PlayerList pl = PlayerList.getInstance();
    private Field[] fields = gb.getFields();
    private Player[] p = pl.getPlayers();

    public String CheckFieldOwner(int fieldIndex, int turn){

        if (((Ownable)fields[fieldIndex]).getOwnerID()==0){
            return "Not owned";
        }
        else if (((Ownable)fields[fieldIndex]).getOwnerID()==p[turn].getId()){
            return "Your Property";
        }
        else {
            return "Owned by another";
        }
    }
    /**
     * This is a method  is design only as an extention to the "else" statement: Owned by another,
     * to determine who you need to pay. SCRUB
     */

    public int whoseProberty(int fieldIndex){
        int ownerID = ((Ownable)fields[fieldIndex]).getOwnerID();
        return ownerID;
    }

}
