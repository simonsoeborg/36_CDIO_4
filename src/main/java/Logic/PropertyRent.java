package Logic;

import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.Fields.Street;
import Entity.FileReader;
import Entity.GameBoard;
import Entity.Player;
/**
 * handles everthing with rent
 * @author David, Kristoffer
 * @version 1.0.0
 */
public class PropertyRent {

    private GameBoard gameBoard;
    private FileReader reader = new FileReader();

    public PropertyRent(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }
    /**
     * payRent transfer the money from the player to the owner.
     * first it checks all the fields on the gameboard to see if the owner owns all fields of same color
     * Which result in double rent
     * @param ownerID - the ownerID of the player who owns the field
     * @param p - the current player
     * @param pl - the player list
     * @param fl - the field list
     */
    public void payRent(int ownerID, Player p, Player[] pl, Field[] fl){

        // vi bruger et for-loop til at gennemløbe alle elementer i feltlisten
        // hvis et felt har samme farve som propertyField sættes count 1 op
        int count = 0;
        int rentDouble = 1;
        int actualColor = Integer.parseInt(reader.read(4, p.getFieldIndex()));
        int sameColor;
        for (int i = 1; i < fl.length+1; i++) {
            sameColor = Integer.parseInt(reader.read(4, i));
            if (actualColor == sameColor && fl[i] instanceof Ownable)
                if (ownerID == ((Ownable)fl[i]).getOwnerID())
                    count++;
        }

        // her tjekker vi om navnet for propertyField er en af de felter hvor der kun er 2 af samme farve
        // hvis ikke skal der være 3.
        switch (fl[p.getFieldIndex()].getFieldName()){

            case "Rødovrevej": case "Hvidovrevej":
            case "Frederiksberggade": case"Rådhuspladsen":
                if (count == 2) rentDouble = 2;
            break;
            default: if (count == 3) rentDouble = 2;
            break;
        }

        p.addMoney(-(((Street)fl[p.getFieldIndex()]).getPropertyRent()*rentDouble));
        pl[ownerID-1].addMoney(((Street)fl[p.getFieldIndex()]).getPropertyRent()*rentDouble);
    }
}
