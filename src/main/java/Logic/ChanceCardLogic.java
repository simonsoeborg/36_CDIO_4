package Logic;

import Entity.Player;
import Entity.PlayerList;
import java.util.Arrays;

/**
 *  The logic behind the chanceCards
 * @author Simon Søborg
 * @version 1.0.0
 */

public class ChanceCardLogic {
    private int pay;
    private int random;

    private static final ChanceCardLogic INSTANCE = new ChanceCardLogic();

    PlayerList pl = PlayerList.getInstance();
    PlayerMove PM = PlayerMove.getInstance();

    private int[] payArr = {1,2,3,4,5,6,7,8,9,10,11};

    private int[] receiveArr = {12,13,14,15,16,17,18,19,20,21,22};

    private int[] moveArr = {23,24,25,26,27,28,29,30,31,32};

    /**
     * contains method is used to search an integer array for a specific integer match.
     * the array can be of any size and the key can be any integer. If the key is within the array of integers
     * the method will return a boolean.
     * @param key is the key which we want to check if the array contains
     * @param arr is the array
     * @return returns true or false. If the key is in the array the statement is true. If not it is false.
     */
    public boolean contains(int key, int[] arr) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public void getRandomNumber() {
        random = (int)(Math.random() * 30) + 3;
    }

    /**
     * payChanceCard is a method used for all the chance cards that will make the player, whom have landed on the "Prøv lykken" field,
     * to pay something to the game bank.
     * @param p is to make sure that it will be the current player who will lose money
     * @param number is the random generated integer that will determine how much the player will have to pay.
     */
    public void payChanceCard(Player p, int number) {
        // Player has to pay for something.
        if (number == 4) {
            pay = 300;
            p.addMoney(-pay);
        } else if (number == 3 || number == 7 || number == 9) {
            pay = 1000;
            p.addMoney(-pay);
        } else if (number == 5 || number == 8 || number == 10) {
            pay = 200;
            p.addMoney(-pay);
        } else if (number == 11) {
            pay = 2000;
            p.addMoney(-pay);
        } else if (number == 6) {
            pay = 3000;
            p.addMoney(-pay);
        }
    }

    /**
     * receiveMoneyChanceCard is a method used for all the chance cards that will make the player, whom have landed on the "Prøv lykken" field,
     * to receive something from the game bank or other players.
     * @param p is to make sure that it will be the current player who will get money
     * @param number is the random generated integer that will determine how much the player will have to receive.
     */

    public void receiveMoneyChanceCard(Player p, int number) {
        // Player will receive money from something.
        if (number == 13 || number == 15 || number == 16 || number == 17 || number == 18) {
            pay = 1000;
            p.addMoney(pay);
        }
        if (number == 21 || number == 22) {
            pay = 500;
            p.addMoney(pay * pl.getPlayers().length);
            for (Player player : pl.getPlayers()) {
                player.addMoney(-pay);
            }
        }
        if (number == 12) {
            pay = 500;
            p.addMoney(pay);
        }
        // Get 200 kr from each player in the game.
        if (number == 20) {

            pay = 200;
            p.addMoney(pay * pl.getPlayers().length);
            for (Player player : pl.getPlayers()) {
                player.addMoney(-pay);
            }
        }
        if (number == 19) {
            pay = 200;
            p.addMoney(pay);
        }
        if (number == 14) {
            pay = 3000;
            p.addMoney(pay);
        }
    }

    /**
     * moveChanceCard is a method that will make the current player move to a new field.
     * @param p is to make sure that it will be the current player who will be moved
     * @param number is the random generated integer that will determine which chance card.
     */

    public void moveChanceCard(Player p, int number) {
        // Player will move to some fields.
        switch (number) {
            case 23:
                // Move player to "Start" field. Start field has Index 0
                PM.movePlayerChanceCard(p, 0);
                break;
            case 24:
                // Move player to 3 fields forward
                PM.movePlayerChanceCard(p, p.getFieldIndex() + 3);
                break;
            case 25:
                // Move player to 3 fields backwards
                p.setFieldIndex(p.getFieldIndex()-3);
                break;
            case 26:
                // Move player to fieldIndex 11
                PM.movePlayerChanceCard(p, 11);
                break;
            case 27:
                // Tag med Kalun./Århus \nflyt brikken frem og hvis De passerer START indkassér da 4000 kroner.
                PM.movePlayerChanceCard(p, 15);
                break;
            case 28:
                // Tag til grønningen
                PM.movePlayerChanceCard(p, 24);
                break;
            case 29:
                // Tag til Vimmelskaftet
                PM.movePlayerChanceCard(p, 32);
                break;
            case 30:
                // Tag til Strandvejen
                PM.movePlayerChanceCard(p, 19);
                break;
            case 31:
                // Tag til Rådhuspladsen
                PM.movePlayerChanceCard(p, 39);
                break;
            case 32:
                // Move player to Prison, will not receive 4k to pass over Start
                p.setInJail(true);
                p.setFieldIndex(10);
                break;
        }
    }

    /**
     * getRandom returns the integer that was random generated.
     */
    public int getRandom() {
        return random;
    }

    /**
     * drawChanceCard is the method used when a player lands on a "Prøv lykken" field.
     * @param p determines which player who shall draw a card.
     */
    public void drawChanceCard(Player p) {
        int n = getRandom();

        if (contains(n, payArr)) {
            payChanceCard(p, n);

        } else if(contains(n, receiveArr)) {
            receiveMoneyChanceCard(p, n);

        } else if(contains(n, moveArr)) {
            moveChanceCard(p, n);
        }
    }

    public static ChanceCardLogic getInstance() {
        return INSTANCE;
    }

}
