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
    private static PlayerList pl = PlayerList.getInstance();
    private Field[] fields = gb.getFields();
    private Player[] p = pl.getPlayers();
    /**
     * Method to determine whether or not a field is owned.
     * @param fieldIndex
     * @param p
     * @return
     */
    public String checkFieldOwner(int fieldIndex, Player p){

        if (((Ownable)fields[fieldIndex]).getOwnerID()==0){
            return "Buy";
        }
        else if (((Ownable)fields[fieldIndex]).getOwnerID()==p.getId()){
            return "Yours";
        }
        else {
            int owner = whoseProberty(p.getFieldIndex());
            return "Theirs";
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
