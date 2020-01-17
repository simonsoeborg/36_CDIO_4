package Logic;

import Entity.Fields.Field;
import Entity.FileReader;
import Entity.Player;
import Entity.PlayerList;

import java.util.Arrays;
import java.util.Random;

public class ChanceCardLogic {
    private String newChanceCard;
    FileReader reader = new FileReader();

    PlayerList pl = PlayerList.getInstance();
    PlayerMove PM = PlayerMove.getInstance();

    Random rand = new Random();

    private int[] nArr = {1,2,3,4,5,6,6,7,8,9,10,
            11,12,12,13,13,13,14,15,16,17,17,18,19,
            20,21,22,23,24,24,25,26,27,28,29,
            30,31,32,33,34,35,35,36,36};

    private int[] payArr = {1,2,3,4,5,6,7,8,9,10,11};

    private int[] receiveArr = {12,13,14,15,16,17,18,19,20,21,22};

    private int[] moveArr = {23,24,25,26,27,28,29,30,31,32,33,34};



    public boolean contains(int[] arr, int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public int getRandomNumber() {
        return nArr[rand.nextInt(nArr.length)];
    }

    public String drawChanceCard(Player p, Field[] fl) {
        // Variables
        int pay;
        int fileNumber = 5;
        // int MAX = nArr.length;
        int n = getRandomNumber();


        if (contains(payArr, n)) {
//            Player has to pay for something.
            if (n == 4) {
                pay = 300;
                newChanceCard = reader.read(fileNumber,n);
                p.setMoney(p.getMoney() - pay);
            }

            if (n == 3 || n == 7 || n == 9) {
                pay = 1000;
                newChanceCard = reader.read(fileNumber,n);
                p.setMoney(p.getMoney() - pay);
            }

            if (n == 5 || n == 8 || n == 10) {
                pay = 200;
                newChanceCard = reader.read(fileNumber,n);
                p.setMoney(p.getMoney() - pay);
            }

        }

        if(contains(receiveArr, n)) {
            // Player will receive money from something.
            if (n == 13 || n == 15 || n == 16 || n == 17 || n == 18) {
                pay = 1000;
                newChanceCard = reader.read(fileNumber,n);
                p.addMoney(pay);
            }
            if (n == 12 || n == 21 || n == 22) {
                pay = 500;
                newChanceCard = reader.read(fileNumber,n);
                p.addMoney(pay);
            }
            // Get 200 kr from each player in the game.
            if (n == 20) {
                newChanceCard = reader.read(fileNumber,n);
                int amountOfPlayers = pl.getPlayers().length;
                pay = 200 * amountOfPlayers;
                p.addMoney(pay);
            }
            if (n == 19) {
                pay = 200;
                newChanceCard = reader.read(fileNumber,n);
                p.addMoney(pay);
            }
            if (n == 14) {
                pay = 3000;
                newChanceCard = reader.read(fileNumber,n);
                p.addMoney(pay);
            }
        }

        if(contains(moveArr, n)) {
            // Player will move to some fields.
            switch (n) {
                case 23:
                    // Move player to "Start" field. Start field has Index 0
                    p.setFieldIndex(0); // Will player get 4000 ?
                    newChanceCard = reader.read(fileNumber,n);
                    break;
                case 24:
                    // Move player to 3 fields forward
                    p.setFieldIndex(p.getFieldIndex()+3);
                    newChanceCard = reader.read(fileNumber,n);
                    break;
                case 25:
                    // Move player to 3 fields backwards
                    p.setFieldIndex(p.getFieldIndex()-3);
                    newChanceCard = reader.read(fileNumber,n);
                    break;
                case 26:
                    // Move player to fieldIndex 29
                    PM.movePlayerChanceCard(p, 38+1);
                    newChanceCard = reader.read(fileNumber,n);
                    break;
                case 27:
                    // Tag med Mols-Linien \nflyt brikken frem og hvis De passerer START indkassér da 4000 kroner.
                    PM.movePlayerChanceCard(p, 16+1);
                    newChanceCard = reader.read(fileNumber,n);
                    break;
                case 28:
                    // Tag til grønningen
                    PM.movePlayerChanceCard(p, 25+1);
                    newChanceCard = reader.read(fileNumber,n);
                    break;
                case 29:
                    // Tag til Vimmelskaftet
                    PM.movePlayerChanceCard(p, 33+1);
                    newChanceCard = reader.read(fileNumber,n);
                    break;
                case 30:
                    // Tag til Strandvejen
                    PM.movePlayerChanceCard(p, 20+1);
                    newChanceCard = reader.read(fileNumber,n);
                    break;
                case 31:
                    // Tag til Rådhuspladsen
                    PM.movePlayerChanceCard(p, 40+1);
                    newChanceCard = reader.read(fileNumber,n);
                    break;
                case 32:
                    // Move player to Prison, will not receive 4k to pass over Start
                    p.setInJail(true);
                    p.setFieldIndex(10);
                    newChanceCard = reader.read(fileNumber,n);
                    break;
            }
        }
        return newChanceCard;
    }
}
