package Logic;

import Entity.DiceCup;
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
    private DiceCup dc = DiceCup.getINSTANCE();

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
    public void payRentStreet(int ownerID, Player p, Player[] pl, Field[] fl) {

        int rentDouble = 1;
        int count = countProperties(ownerID, p, fl);
        int houses = ((Street) fl[p.getFieldIndex()]).getNumberOfHouses();

        // her tjekker vi om navnet for propertyField er en af de felter hvor der kun er 2 af samme farve
        // hvis ikke skal der være 3.
        if (houses == 0) {
            switch (fl[p.getFieldIndex()].getFieldName()) {

                case "Rødovrevej":
                case "Hvidovrevej":
                case "Frederiksberggade":
                case "Rådhuspladsen":
                    if (count == 2) rentDouble = 2;
                    break;
                default:
                    if (count == 3) rentDouble = 2;
                    break;
            }

            p.addMoney(-(((Ownable) fl[p.getFieldIndex()]).getPropertyRent() * rentDouble));
            pl[ownerID - 1].addMoney(((Ownable) fl[p.getFieldIndex()]).getPropertyRent() * rentDouble);

        } else {
            switch (houses) {
                case 1:
                    p.addMoney(-(((Street) fl[p.getFieldIndex()]).getOneHouse()));
                    pl[ownerID - 1].addMoney(((Street) fl[p.getFieldIndex()]).getOneHouse());
                    break;
                case 2:
                    p.addMoney(-(((Street) fl[p.getFieldIndex()]).getTwoHouse()));
                    pl[ownerID - 1].addMoney(((Street) fl[p.getFieldIndex()]).getTwoHouse());
                    break;
                case 3:
                    p.addMoney(-(((Street) fl[p.getFieldIndex()]).getThreeHouse()));
                    pl[ownerID - 1].addMoney(((Street) fl[p.getFieldIndex()]).getThreeHouse());
                    break;
                case 4:
                    p.addMoney(-(((Street) fl[p.getFieldIndex()]).getFourHouse()));
                    pl[ownerID - 1].addMoney(((Street) fl[p.getFieldIndex()]).getFourHouse());
                    break;
                case 5:
                    p.addMoney(-(((Street) fl[p.getFieldIndex()]).getHotel()));
                    pl[ownerID - 1].addMoney(((Street) fl[p.getFieldIndex()]).getHotel());
                    break;

            }
        }
    }

    public void payRentFerry(int ownerID, Player p, Player[] pl, Field[] fl){

        int rentDouble = 1;
        int count = countProperties(ownerID, p, fl);

        // her tjekker vi om navnet for propertyField er en af de felter hvor der kun er 2 af samme farve
        // hvis ikke skal der være 3.
        switch (count){
            case 1: rentDouble = 1;
            break;
            case 2: rentDouble = 2;
            break;
            case 3: rentDouble = 4;
            break;
            case 4: rentDouble = 8;
            break;
        }

        p.addMoney(-(((Ownable)fl[p.getFieldIndex()]).getPropertyRent()*rentDouble));
        pl[ownerID-1].addMoney(((Ownable)fl[p.getFieldIndex()]).getPropertyRent()*rentDouble);
    }


    public void payRentBrewery(int ownerID, Player p, Player[] pl, Field[] fl){

        int rentDouble = 1;
        int count = countProperties(ownerID, p, fl);

        // her tjekker vi om navnet for propertyField er en af de felter hvor der kun er 2 af samme farve
        // hvis ikke skal der være 3.
        switch (count){
            case 1: rentDouble = 1;
                break;
            case 2: rentDouble = 2;
                break;
        }

        p.addMoney(-(((Ownable)fl[p.getFieldIndex()]).getPropertyRent()*rentDouble*dc.faceValues()));
        pl[ownerID-1].addMoney(((Ownable)fl[p.getFieldIndex()]).getPropertyRent()*rentDouble*dc.faceValues());
    }


    private int countProperties(int ownerID, Player p, Field[] fl) {

        // vi bruger et for-loop til at gennemløbe alle elementer i feltlisten
        // hvis et felt har samme farve som propertyField sættes count 1 op
        int count = 0;
        int actualColor = Integer.parseInt(reader.read(4, p.getFieldIndex()+1));
        int sameColor;
        for (int i = 0; i < fl.length; i++) {
            sameColor = Integer.parseInt(reader.read(4, i + 1));
            if (actualColor == sameColor && fl[i] instanceof Ownable)
                if (ownerID == ((Ownable)fl[i]).getOwnerID())
                    count++;
        }

        return count;
    }





}



