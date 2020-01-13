package Control;

import Entity.DiceCup;
import Entity.FieldCreator;
import Entity.Player;
import gui_main.GUI;

import java.awt.*;

public class GameController {

    protected GUI gui = new GUI(UIController.makeFields(), Color.white);
    protected BoardController bC;
    protected DiceCup dC;
    protected LogicController lC;
    /**
     * @param p  : The player who's turn it is.
     * @param fl : Our fieldList.
     *           The method is changing the players FieldIndex, and therefore its location.
     */
    public void movePlayer(Player p, FieldCreator fl) {
        dC.roll();
        int previous = p.getFieldIndex();
        p.setFieldIndex((p.getFieldIndex() + dC.faceValues()) % fl.getSize());
        int actual = p.getFieldIndex();

        // todo Add value er endnu ikke relevant i forhold til vores test.
        if (actual < previous)
            p.addMoney(4000);
    }

    public String checkFieldType(int fieldIndex){

        String felt = "";

        switch (fieldIndex){
            // Dette er ejendomsfelter
            case 1: case 3: case 6: case 8: case 9: case 11: case 13: case 14: case 16: case 18: case 19:
            case 21: case 23: case 24: case 26: case 27: case 29: case 31: case 32: case 34: case 37: case 39:
                felt = "Street";
                break;
            // Prøv lykken felter
            case 2: case 7: case 17: case 22: case 33: case 36:
                felt = "Chance";
                break;
            // færge felter
            case 5: case 15: case 25: case 35:
                felt = "Ferry";
                break;
            // brygerier
            case 12: case 28:
                felt = "Brewery";
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
                felt = "Jail";
                break;
        }
        return felt;
    }

    public void decideLogik(String fieldtype){

        switch (fieldtype){
            case "Street": //Evt underpakke med logik til ejendomsfelter;
                break;
            case "Chance": // logik chance felter;
                break;
            case "Ferry": // logik til færger;
                break;
            case "Brewery": // logik til bryggerier;
                break;
            case "Income tax": //logik til indkomstskat;
                break;
            case "Extraordinary state tax": //logik til ekstra.....skat;
                break;
            case "Default": // intet logik da der ikke sker noget på disse felter;
                break;
            case "Jail": // fængselslogik;
                break;
        }
    }
}
