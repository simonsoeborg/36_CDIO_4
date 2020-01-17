package Logic;

import Entity.FileReader;
import Entity.Player;
import Entity.PlayerList;

import java.util.Arrays;
import java.util.Random;

public class ChanceCardLogic {
    private String newChanceCard;
    private String updateChanceCard;
    FileReader reader = new FileReader();
    private int pay;
    private int fileNumber = 5;


    PlayerList pl = PlayerList.getInstance();
    PlayerMove PM = PlayerMove.getInstance();

    Random rand = new Random(36);

    private int[] nArr = {1,2,3,4,5,6,6,7,8,9,10,
            11,12,12,13,13,13,14,15,16,17,17,18,19,
            20,21,22,23,24,24,25,26,27,28,29,
            30,31,32};

    private int[] payArr = {1,2,3,4,5,6,7,8,9,10,11};

    private int[] receiveArr = {12,13,14,15,16,17,18,19,20,21,22};

    private int[] moveArr = {23,24,25,26,27,28,29,30,31,32};



    public boolean contains(int key, int[] arr) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public int getRandomNumber() {
        return nArr[rand.nextInt(nArr.length)];
    }

    public String payChanceCard(Player p, int number) {
        // Player has to pay for something.
        if (number == 4) {
            pay = 300;
            updateChanceCard = reader.read(fileNumber, number);
            p.setMoney(p.getMoney() - pay);
        } else if (number == 3 || number == 7 || number == 9) {
            pay = 1000;
            updateChanceCard = reader.read(fileNumber, number);
            p.setMoney(p.getMoney() - pay);
        } else if (number == 5 || number == 8 || number == 10) {
            pay = 200;
            updateChanceCard = reader.read(fileNumber, number);
            p.setMoney(p.getMoney() - pay);
        } else if (number == 11) {
            pay = 2000;
            updateChanceCard = reader.read(fileNumber, number);
            p.setMoney(p.getMoney() - pay);
        }
        return updateChanceCard;
    }

    public String receiveMoneyChanceCard(Player p, int number) {
        // Player will receive money from something.
        if (number == 13 || number == 15 || number == 16 || number == 17 || number == 18) {
            pay = 1000;
            updateChanceCard = reader.read(fileNumber,number);
            p.addMoney(pay);
        }
        if (number == 12 || number == 21 || number == 22) {
            pay = 500;
            updateChanceCard = reader.read(fileNumber,number);
            p.addMoney(pay);
        }
        // Get 200 kr from each player in the game.
        if (number == 20) {
            updateChanceCard = reader.read(fileNumber,number);
            int amountOfPlayers = pl.getPlayers().length;
            pay = 200 * amountOfPlayers;
            p.addMoney(pay);
        }
        if (number == 19) {
            pay = 200;
            updateChanceCard = reader.read(fileNumber,number);
            p.addMoney(pay);
        }
        if (number == 14) {
            pay = 3000;
            updateChanceCard = reader.read(fileNumber,number);
            p.addMoney(pay);
        }
        return updateChanceCard;
    }

    public String movePlayerChanceCard(Player p, int number) {
        // Player will move to some fields.
        switch (number) {
            case 23:
                // Move player to "Start" field. Start field has Index 0
                p.setFieldIndex(0); // Will player get 4000 ?
                updateChanceCard = reader.read(fileNumber,number);
                break;
            case 24:
                // Move player to 3 fields forward
                p.setFieldIndex(p.getFieldIndex()+3);
                updateChanceCard = reader.read(fileNumber,number);
                break;
            case 25:
                // Move player to 3 fields backwards
                p.setFieldIndex(p.getFieldIndex()-3);
                updateChanceCard = reader.read(fileNumber,number);
                break;
            case 26:
                // Move player to fieldIndex 29
                PM.movePlayerChanceCard(p, 38+1);
                updateChanceCard = reader.read(fileNumber,number);
                break;
            case 27:
                // Tag med Mols-Linien \nflyt brikken frem og hvis De passerer START indkassér da 4000 kroner.
                PM.movePlayerChanceCard(p, 16+1);
                updateChanceCard = reader.read(fileNumber,number);
                break;
            case 28:
                // Tag til grønningen
                PM.movePlayerChanceCard(p, 25+1);
                updateChanceCard = reader.read(fileNumber,number);
                break;
            case 29:
                // Tag til Vimmelskaftet
                PM.movePlayerChanceCard(p, 33+1);
                updateChanceCard = reader.read(fileNumber,number);
                break;
            case 30:
                // Tag til Strandvejen
                PM.movePlayerChanceCard(p, 20+1);
                updateChanceCard = reader.read(fileNumber,number);
                break;
            case 31:
                // Tag til Rådhuspladsen
                PM.movePlayerChanceCard(p, 40+1);
                updateChanceCard = reader.read(fileNumber,number);
                break;
            case 32:
                // Move player to Prison, will not receive 4k to pass over Start
                p.setInJail(true);
                p.setFieldIndex(10);
                updateChanceCard = reader.read(fileNumber,number);
                break;
        }
        return updateChanceCard;
    }

    public String drawChanceCard(Player p) {
        int n = getRandomNumber();
        System.out.println("Random Number: " + n);

        if (contains(n, payArr)) {
            newChanceCard = payChanceCard(p, n);

        } else if(contains(n, receiveArr)) {
            newChanceCard = receiveMoneyChanceCard(p, n);

        } else if(contains(n, moveArr)) {
            newChanceCard = movePlayerChanceCard(p, n);
        }
        return newChanceCard;
    }
}
