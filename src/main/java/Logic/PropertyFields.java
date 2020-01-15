package Logic;

import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.GameBoard;
import Entity.Player;
import Entity.PlayerList;

public class PropertyFields {


    /**
     * Method to determine whether or not a field is owned.
     */
    private static GameBoard gb = GameBoard.getInstance();
    private PropertyRent pr = new PropertyRent(gb);
    private static PlayerList pl = PlayerList.getInstance();
    private Field[] fields = gb.getFields();
    private Player[] p = pl.getPlayers();


    public String checkFieldOwnerStreet(int fieldIndex, Player p){

        if (((Ownable)fields[fieldIndex]).getOwnerID()==0){
            return "Buy";
        }
        else if (((Ownable)fields[fieldIndex]).getOwnerID()==p.getId()){
            return "Yours";
        }
        else {
            int owner = whoseProberty(p.getFieldIndex());
            pr.payRent(owner, p, pl.getPlayers(), fields );
            return "Theirs";
        }
    }


    public String checkFieldOwnerFerry(int fieldIndex, Player p){

        if (((Ownable)fields[fieldIndex]).getOwnerID()==0){
            return "Buy";
        }
        else if (((Ownable)fields[fieldIndex]).getOwnerID()==p.getId()){
            return "Yours";
        }
        else {
            int owner = whoseProberty(p.getFieldIndex());
            pr.payRent(owner, p, pl.getPlayers(), fields );
            return "Theirs";
        }
    }


    public String checkFieldOwnerBrewery(int fieldIndex, Player p){

        if (((Ownable)fields[fieldIndex]).getOwnerID()==0){
            return "Buy";
        }
        else if (((Ownable)fields[fieldIndex]).getOwnerID()==p.getId()){
            return "Yours";
        }
        else {
            int owner = whoseProberty(p.getFieldIndex());
            pr.payRent(owner, p, pl.getPlayers(), fields );
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
