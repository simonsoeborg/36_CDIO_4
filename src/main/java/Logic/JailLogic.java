package Logic;


import Entity.Player;
/**
 *
 * @author Kristoffer, Freja, David
 * @version 1.0.0
 */
public class JailLogic {
    /**
     * checkNumDoubles is responsible for making sure the rule regarding 3 equal facevalue rolls are followed accordingly
     * 3 equal rolls after another results in jail-time
     * @param p The player who's rolling the dies
     * @param check - Boolean value from the Dicecup-class, which is returned true when a players roll has equal facevalues
     * @return Boolean value which is true if the player is set in jail and false if not
     */
    public boolean checkNumDoubles(Player p, boolean check){
        if (check)
            //adds one to the players attribute doublesInARow
            p.setDoublesInARow(p.getDoublesInARow()+1);
        else
            p.setDoublesInARow(0);

        //Checks wheater doublesInARow is bigger than 2. if so the player is set in jail and doublesInARow is set to 0
        if(p.getDoublesInARow() > 2){
            p.setInJail(true);
            p.setDoublesInARow(0);
            return true;
        }
        return false;
    }

    /**
     * Withdraws money form the specified player and sets him free from jail
     * @param p - The player whom is in jail
     */
    public void payOutOfJail(Player p) {
        p.addMoney(-1000);
        p.setInJail(false);
        //Nulstiler roundsInJail, så det ikke påvirker noget, hvis en spiller skulle komme i fængsel en anden gang
        p.setRoundsInJail(0);
    }
}
