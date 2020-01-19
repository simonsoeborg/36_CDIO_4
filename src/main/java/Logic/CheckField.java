package Logic;

import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.GameBoard;
import Entity.Player;

/**
 * @author
 * @version 1.0.0
 */
public class CheckField {

    private static GameBoard gb = GameBoard.getInstance();
    private Field[] fields = gb.getFields();

    /**
     * This method checks which type of field the player has landed on.
     * @param fieldIndex - The filed the player has landed on.
     * @param p - The current player
     * @return What kind of field the player have landed on
     */
    public String checkFieldType(int fieldIndex, Player p){
        String felt = "";
        switch (fieldIndex){
            // Dette er ejendomsfelter
            case 1: case 3: case 6: case 8: case 9: case 11: case 13: case 14: case 16: case 18: case 19:
            case 21: case 23: case 24: case 26: case 27: case 29: case 31: case 32: case 34: case 37: case 39:

                // brygerier
            case 12: case 28:

                // færge felter
            case 5: case 15: case 25: case 35:
                felt = checkFieldOwner(fieldIndex,p);
                break;

            // Prøv lykken felter
            case 2: case 7: case 17: case 22: case 33: case 36:
                felt = "Chance";
                break;

            //Indkomstskat
            case 4:
                felt = "Income tax";
                break;

            //Statsskat
            case 38:
                felt = "Extraordinary state tax";
                break;

            //start, parkering og besøg i fængsel felter
            case 0: case 10: case 20:
                felt = "Default";
                break;

            // gå i fængsel
            case 30:
                p.setInJail(true);
                felt = "Jail";
                break;
        }
        return felt;
    }

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
