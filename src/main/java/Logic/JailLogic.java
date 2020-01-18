package Logic;


import Entity.Player;

/**
 * EqualDies handles the logic regrading rolls with same facevalues
 * @author Kristoffer, Freja, David
 * @version 1.0.0
 */
public class JailLogic {

    /**
     * checkNumDoubles is responsible for making sure the rule regarding 3 equal facevalue rolls are followed accordingly
     * @param p The player who's rolling the dies
     * @return Boolean value which is true if the player is set in jail
     */

// hvis de slår double for at komme ud.
    public boolean checkNumDoubles(Player p, boolean check){
        if (check)
            p.setDoublesInARow(p.getDoublesInARow()+1);
        else
            p.setDoublesInARow(0);
        if(p.getDoublesInARow() > 2){
            p.setInJail(true);
            p.setDoublesInARow(0);
            return true;
        }
        return false;
    }

    // hvis spilleren betaler for at komme ud, så bliver deres rounds in jail sat til 0, så det ikke pårvirker det en anden gang
    public void payOutOfJail(Player p) {
        p.addMoney(-1000);
        p.setInJail(false);
        p.setRoundsInJail(0);
    }
}
