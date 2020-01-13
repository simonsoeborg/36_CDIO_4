package Control;

import Entity.DiceCup;
import Entity.FieldCreator;
import Entity.Fields.Field;
import Entity.Fields.Ownable;
import Entity.Player;


public class LogicController {

    DiceCup d = new DiceCup();


    /**
     * @param p  : The player who's turn it is.
     * @param fl : Our fieldList.
     *           The method is changing the players FieldIndex, and therefore its location.
     */
    public void movePlayer(Player p, FieldCreator fl) {
        d.roll();
        int previous = p.getFieldIndex();
        p.setFieldIndex((p.getFieldIndex() + d.faceValues()) % fl.getSize());
        int actual = p.getFieldIndex();

        // todo Add value er endnu ikke relevant iforhold til vores test.
        if (actual < previous)
            p.addMoney(4000);
    }

    public Field checkFieldType(int fieldIndex){

        switch (fieldIndex){
            // Dette er ejendomsfelter
            case 1: case 3: case 6: case 8: case 9: case 11: case 13: case 14: case 16: case 18: case 19:
            case 21: case 23: case 24: case 26: case 27: case 29: case 31: case 32: case 34: case 37: case 39: kjslafjalfk;
            break;

            // Prøv lykken felter
            case 2: case 7: case 17: case 22: case 33: case 36: jfajfjalj;
            break;

            // færge felter
            case 5: case 15: case 25: case 35: khfakfhkh;
            break;

            // brygerier
            case 12: case 28: hafkfhkash;
            break;

            //Indkomstskat
            case 4: jlajfljadslj;
            break;

            //Statsskat
            case 38: fjaljfladjs;
            break;

            //start, parkering og besøg i fængsel felter
            case 0: case 10: case 20: kjahfkjhfk;
            break;

            // gå i fængsel
            case 30: ljfalfj;
            break;


        }


    }



}
