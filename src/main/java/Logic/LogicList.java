package Logic;
import Entity.Player;


public class LogicList {

    private PropertyFields pf = new PropertyFields();
    /**
     *
     * @param fieldIndex Hole array of fields on the board
     * @param p - player
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
                felt = pf.checkFieldOwner(fieldIndex,p);
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
}
