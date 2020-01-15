package Entity.Fields;

import Entity.Player;

public class IncomeTax extends Field {

    private int payCash;
    private int payPercentage;

    public IncomeTax(String fieldName, int payCash, int payPercentage) {
        super(fieldName);
        this.payCash = payCash;
        this.payPercentage = payPercentage;
    }

    /**
     * The option of paying a total amount (set in the param of the contructor)
     * @param p - Player who is paying
     */
    public void option4000(Player p){
        p.addMoney(-payCash);
    }

    /**
     * The option of paying a roundnumber percentage of all the values the player has got (money, properties)
     * @param p - Player who is paying
     * @param field - an array consistent of type Field
     */
    public void optionPercent(Player p, Field[] field){

        int totalPropertyValue = 0;

        // går igennem alle felter og tjekker først om feltet er af typen Ownable og derefter om feltets ID stemmer
        // overens med spillerens. Gør det dette, hentes feltets værdi og lægges til variablen totalpropertyvalue.
        for (Field ownedField: field) {

            if (ownedField instanceof Ownable)
                if(p.getId() == ((Ownable) ownedField).getOwnerID())
                totalPropertyValue += ((Ownable)ownedField).getPropertyPrice();

        }

        // totalpropertyvalue lægges til spillerens pengebeholding og der udregnes ud fra summen, en værdi der afhænger
        // af procentsatsen der blev sat. til sidst trækkes denne værdi fra spillerens pengebeholdning.
        p.addMoney(-((p.getMoney()+totalPropertyValue)/payPercentage));
    }

}
