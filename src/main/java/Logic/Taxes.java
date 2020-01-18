package Logic;

import Entity.Fields.Field;
import Entity.Fields.IncomeTax;
import Entity.Fields.Ownable;
import Entity.Fields.StateTax;
import Entity.GameBoard;
import Entity.Player;

/**
 * There are two fields on the board with taxes (income tax and state tax).
 * @author David, Kristoffer
 * @version 1.0.0
 */
public class Taxes {

    private GameBoard gb = GameBoard.getInstance();
    private IncomeTax it;
    private StateTax st;

    public Taxes() {
          it = ((IncomeTax) gb.getFields()[4]);
          st = ((StateTax) gb.getFields()[38]);
    }

    /**
     * The option of paying a total amount (set in the param of the contructor)
     * @param p - Player who is paying
     */
    public void incomeTaxCash(Player p){
        p.addMoney(-(it.getPayCash()));
    }

    /**
     * The option of paying a roundnumber percentage of all the values the player has got (money, properties)
     * @param p - Player who is paying
     */
    public void incomeTaxPercentage(Player p){

        int totalPropertyValue = 0;

        // går igennem alle felter og tjekker først om feltet er af typen Ownable og derefter om feltets ID stemmer
        // overens med spillerens. Gør det dette, hentes feltets værdi og lægges til variablen totalpropertyvalue.
        for (Field ownedField: gb.getFields()) {

            if (ownedField instanceof Ownable)
                if (p.getId() == ((Ownable) ownedField).getOwnerID())
                    totalPropertyValue += ((Ownable)ownedField).getPropertyPrice();

        }

        // totalpropertyvalue lægges til spillerens pengebeholding og der udregnes ud fra summen, en værdi der afhænger
        // af procentsatsen der blev sat. til sidst trækkes denne værdi fra spillerens pengebeholdning.
        p.addMoney(-((p.getMoney()+totalPropertyValue)/it.getPayPercentage()));
    }

    public void stateTax(Player p){
        p.addMoney(-(st.getTax()));
    }

}
