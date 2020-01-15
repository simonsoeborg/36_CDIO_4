package Logic;

import Entity.FileReader;

import java.util.Random;

public class ChanceCardLogic {
    private int case6Count = 1;
    private int case12Count = 1;
    private int case13Count = 1;
    private int case17Count = 1;
    private int case24Count = 1;
    private int case26Count = 1;
    private int case28Count = 1;
    private int case35Count = 1;
    private int case36Count = 1;
    FileReader reader = new FileReader();

    public String drawChanceCard() {
        // Variables
        Random rand = new Random();
        int MAX = 36;
        int n = rand.nextInt(MAX + 1);
        String newChanceCard;
        int fileNumber = 5;
        
        switch (n) {
            case 6:
                if (case6Count < 2) {
                    // If case 6 has been drawn more than 2 times, then draw new card.
                    newChanceCard = reader.read(fileNumber, 6);
                    case6Count++;
                } else {
                    // Draw new card
                    newChanceCard = reader.read(fileNumber, rand.nextInt(MAX +1));
                }
                break;
            case 12:
                if (case12Count < 2) {
                    newChanceCard = reader.read(fileNumber, 12);
                    case12Count++;
                } else {
                    // Draw new card
                    newChanceCard = reader.read(fileNumber, rand.nextInt(MAX +1));
                }
                break;
            case 13:
                if (case13Count < 3) {
                    newChanceCard = reader.read(fileNumber, 13);
                    case13Count++;
                } else {
                    // Draw new card
                    newChanceCard = reader.read(fileNumber, rand.nextInt(MAX +1));
                }
                break;
            case 17:
                if (case17Count < 2) {
                    newChanceCard = reader.read(fileNumber, 17);
                    case17Count++;
                } else {
                    // Draw new card
                    newChanceCard = reader.read(fileNumber, rand.nextInt(MAX +1));
                }
                break;
            case 24:
                if (case24Count < 2) {
                    newChanceCard = reader.read(fileNumber, 24);
                    case24Count++;
                } else {
                    // Draw new card
                    newChanceCard = reader.read(fileNumber, rand.nextInt(MAX +1));
                }
                break;
            case 26:
                if (case26Count < 2) {
                    newChanceCard = reader.read(fileNumber, 26);
                    case26Count++;
                } else {
                    // Draw new card
                    newChanceCard = reader.read(fileNumber, rand.nextInt(MAX +1));
                }
                break;
            case 28:
                if (case28Count < 2) {
                    newChanceCard = reader.read(fileNumber, 28);
                    case28Count++;
                } else {
                    // Draw new card
                    newChanceCard = reader.read(fileNumber, rand.nextInt(MAX +1));
                }
                break;
            case 35:
                if (case35Count < 2) {
                    newChanceCard = reader.read(fileNumber, 35);
                    case35Count++;
                } else {
                    // Draw new card
                    newChanceCard = reader.read(fileNumber, rand.nextInt(MAX +1));
                }
                break;
            case 36:
                if (case36Count < 2) {
                    newChanceCard = reader.read(fileNumber, 36);
                    case36Count++;
                } else {
                    // Draw new card
                    newChanceCard = reader.read(fileNumber, rand.nextInt(MAX +1));
                }
                break;
            default:
                newChanceCard = reader.read(fileNumber, rand.nextInt(MAX +1));
        }
        return newChanceCard;
    }
}
