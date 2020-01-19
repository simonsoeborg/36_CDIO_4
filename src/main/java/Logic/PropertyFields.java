package Logic;

import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.GameBoard;
import Entity.Player;
import Entity.PlayerList;
/**
 * @author
 * @version 1.0.0
 */
public class PropertyFields {

    private static GameBoard gb = GameBoard.getInstance();
    private Field[] fields = gb.getFields();

    /**
     * Method to determine whether or not a field is owned and if the field is owned by you or not.
     * @param fieldIndex - The field where the player has landed.
     * @param p - The player whose turn it is.
     * @return - Returns a string which indicates the ownership status of the ownable field.
     */
    public String checkFieldOwner(int fieldIndex, Player p){

        if (((Ownable)fields[fieldIndex]).getOwnerID()==0){
            return "Buy";
        }
        else if (((Ownable)fields[fieldIndex]).getOwnerID()==p.getId()){
            return "Yours";
        }
        else {
            return "Theirs";
        }
    }
    /**
     * This is a method is designed only as an extention to the "else" statement: Owned by another,
     * to determine who you need to pay rent to.
     */
    public int whoseProperty(int fieldIndex){
        return ((Ownable)fields[fieldIndex]).getOwnerID();
    }

}
