package Logic;

import Entity.DiceCup;
import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.Fields.Street;
import Entity.FileReader;
import Entity.GameBoard;
import Entity.Player;
/**
 * Handles the different variations of rent depending on the type of field
 * @author David, Kristoffer
 * @version 1.0.0
 */
public class PropertyRent {
    private FileReader reader = new FileReader();
    private DiceCup dc = DiceCup.getINSTANCE();
    /**
     * payRent transfer the money from the player to the owner.
     * first it checks all the fields on the gameboard to see if the owner owns all fields of same color
     * Which results in double rent
     * @param ownerID - the ownerID of the player who owns the field
     * @param p - the current player
     * @param pl - an array containing elements of Player type (playerlist)
     * @param fl - an array containing elements of Field type (fieldlist)
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
            // kodestykket under tjekker nu, hvor mange huse der er op feltet og betale det beløb.
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

    /**
     * Chooses the correct rent a player needs to pay when landing on a Ferry field. The rent is doubled for every
     * Ferry field the owner owns and then withdrawn from the players balance and added to the owners balance
     * @param ownerID - The ownerID of the player who owns the ferry-field
     * @param p - the player whom stands on the field
     * @param pl - an array containing elements of Player type (playerlist)
     * @param fl - an array containing elements of Field type (fieldlist)
     */
    public void payRentFerry(int ownerID, Player p, Player[] pl, Field[] fl){
        // faktoren som den oprindelige leje skal ganges med.
        int rentDouble = 1;

        // her bliver antallet af færge felter talt og sat lig count
        int count = countProperties(ownerID, p, fl);

        //Tjekker værdien af count og sætter rentdouble lig en passene faktor.
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
        // Lejen bliver ganget med den passende faktor og trækkes først fra Player p og lægges derefter til
        // den spiller, vis ownerID matcher feltets
        p.addMoney(-(((Ownable)fl[p.getFieldIndex()]).getPropertyRent()*rentDouble));
        pl[ownerID-1].addMoney(((Ownable)fl[p.getFieldIndex()]).getPropertyRent()*rentDouble);
    }

    /**
     *  Chooses the correct rent a player needs to pay when landing on a brewery-field. The rent is doubled for every
     *  brewery-field the owner owns and then withdrawn from the players balance and added to the owners balance
     * @param ownerID - The ownerID of the player who owns the brewery-field
     * @param p - the player whom stands on the field
     * @param pl - an array containing elements of Player type (playerlist)
     * @param fl - an array containing elements of Field type (fieldlist)
     */
    public void payRentBrewery(int ownerID, Player p, Player[] pl, Field[] fl){
        // faktoren som den oprindelige leje skal ganges med.
        int rentDouble = 1;
        // her bliver antallet af bryggeri-felter talt og sat lig count
        int count = countProperties(ownerID, p, fl);

        //Tjekker værdien af count og sætter rentdouble lig en passene faktor
        switch (count){
            case 1: rentDouble = 1;
                break;
            case 2: rentDouble = 2;
                break;
        }
        // Lejen bliver ganget med den passende faktor og trækkes først fra Player p og lægges derefter til
        // den spiller, vis ownerID matcher feltets
        p.addMoney(-(((Ownable)fl[p.getFieldIndex()]).getPropertyRent()*rentDouble*dc.faceValues()));
        pl[ownerID-1].addMoney(((Ownable)fl[p.getFieldIndex()]).getPropertyRent()*rentDouble*dc.faceValues());
    }


    /**
     * Checks all elements of an array containing Field type elements to see which ones match the same color and ownerID
     * of the field the player has landed on.
     * @param ownerID - The ownerID of the player who owns the field
     * @param p - the player whom stands on the field
     * @param fl - an array containing elements of Field type (fieldlist)
     * @return - The number of matches
     */
    private int countProperties(int ownerID, Player p, Field[] fl) {

        // vi bruger et for-loop til at gennemløbe alle elementer i feltlisten
        // hvis et felt har samme farve som feltet spillern står på, sættes count 1 op
        int count = 0;
        // bruger parse int, da det FileReaderen læser fra dokumentet SameColoredFieldsInfo.txt er en string
        // Der indholder en integer-representation, som vi gerne konvaterer til en int type. Denne gemmes som actual color
        // linjen der bliver læst er det samme nummer som indekset af feltet spilleren står på
        int actualColor = Integer.parseInt(reader.read(4, p.getFieldIndex()+1));
        int sameColor;
        for (int i = 0; i < fl.length; i++) {

            // bruger parse int, da det FileReaderen læser fra dokumentet SameColoredFieldsInfo.txt er en string
            // Der indholder en integer-representation, som vi gerne konvaterer til en int type. Denne gemmes som sameColor
            // Linjen som læses, er det samme nummer som værdien af i (nummeret af hvilken iteration vi er i)
            sameColor = Integer.parseInt(reader.read(4, i + 1));

            // tjekker om actual color er den samme som samecolor  og  at feltet af indeks (i) er en instans af Ownable-klassen
            if (actualColor == sameColor && fl[i] instanceof Ownable)

                //Tjekker om ownerID er det samme som feltets. hvis det er det samme tælles count en op
                if (ownerID == ((Ownable)fl[i]).getOwnerID())
                    count++;
        }

        return count;
    }

}



