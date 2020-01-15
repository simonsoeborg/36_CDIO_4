package Logic;

import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.Fields.Street;
import Entity.GameBoard;
import Entity.Player;

/**
 * handles everthing with rent
 * @author David, Kristoffer
 * @version 1.0.0
 */
public class PropertyRent {

    private GameBoard gameBoard;

    public PropertyRent(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }
    /**
     * payRent transfer the money from the player to the owner.
     * first it checks all the fields on the gameboard to see if the owner owns all fields of same color
     * Which result in double rent
     * @param owner - the owner of the field
     * @param p - the player who
     * @param propertyField
     */
    public void payRent(Player owner, Player p, Street propertyField){

        // vi bruger en foreach til at gennemløbe alle elementer i fieldArry
        // hvis et felt har samme farve som propertyField sættes count 1 op
        int count = 0;
        int rentDouble = 1;
        for (Field field:gameBoard.getFields()){

            /// TODO: 14-01-2020 tilføj GUIField farverne

            //if ( det ene felt farve == andetfeltes farve)

            if (propertyField.getColorolor() ==)


            count++;
        }

        count -= 1;

        // her tjekker vi om navnet for propertyField er en af de felter hvor der kun er 2 af samme farve
        // hvis ikke skal der være 3.
        switch (propertyField.getFieldName()){

            case "Rødovrevej": case "Hvidovrevej":
            case "Frederiks- \\nberggade": case"Rådhuspladsen":
                if (count == 2) rentDouble = 2;
            break;
            default: if (count == 3) rentDouble = 2;
            break;
        }

        p.addMoney(-(propertyField.getPropertyRent()*rentDouble));
        owner.addMoney(propertyField.getPropertyRent()*rentDouble);
    }
}
