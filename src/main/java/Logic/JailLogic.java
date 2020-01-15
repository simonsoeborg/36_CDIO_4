package Logic;


import Entity.DiceCup;
import Entity.Player;

/**
 * EqualDies handles the logic regrading rolls with same facevalues
 * @author Kristoffer, Freja, David
 * @version 1.0.0
 */
public class JailLogic {

    private int counter = 0;


    /**
     * checkNumDoubles is responsible for making sure the rule regarding 3 equal facevalue rolls are followed accordingly
     * @param p The player who's rolling the dies
     * @return Boolean value which is true if the player is set in jail
     */

    public boolean checkInJail (Player p){

        boolean pInJail = false;
        if (p.getInJail())
            pInJail = true;

        return pInJail;
    }

    public boolean checkNumDoubles(Player p, boolean check){

        boolean jail = false;

        if(check)
            counter++;

        if(counter > 2){
            p.setInJail(true);
            jail = true;

        }

    return jail;

    }

    // spilleren har valgt om han vil betale eller roll med terningerne
    public boolean getOutJail (Player p, int choice, Boolean check){

        // til at der skal vise noget tekst at de er fri fra fængsel
        boolean outOfJailSignal = false;

        switch (choice) {
            case 1: {
                p.addMoney(-1000);
                p.setInJail(false);
                outOfJailSignal = true;
            }
            break;
            case 2: case 3:
                p.setInJail(false);
                outOfJailSignal = true;
            break;
        }
        return outOfJailSignal;
    }
}
