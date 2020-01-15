package Logic;


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
     * @param player The player who's rolling the dies
     * @param check The boolean returnvalue from the Dicecup-class
     * @return Boolean value which is true if the player is set in jail
     */
    public boolean checkNumDoubles(Player player, boolean check){

        boolean jail = false;

        if(check)
            counter++;

        if(counter > 2){
            player.setFieldIndex(10);
            jail = true;

        }

    return jail;

    }

}
