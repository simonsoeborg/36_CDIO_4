package Test;

import Entity.PlayerList;
import Logic.ChanceCardLogic;

import java.util.Random;

public class ChanceCardTest {
    public static void main(String[] args) {
        PlayerList pl = PlayerList.getInstance();
        ChanceCardLogic cl = new ChanceCardLogic();
        pl.addPlayers(2);
        pl.getPlayer(0);

        //Testing drawChanceCard
//        System.out.println("##### Testing drawChanceCard: #####");
//        for(int i = 1; i <= 32; i++) {
//            System.out.println("\n" + i);
//            System.out.println("Current Field: " + pl.getPlayer(0).getFieldIndex());
//            System.out.println("Player current currency: " + pl.getPlayer(0).getMoney());
//            String testString = cl.drawChanceCard(pl.getPlayer(0));
//            System.out.println("Chancecard: " + testString);
//            System.out.println("Player new currency: " + pl.getPlayer(0).getMoney());
//            System.out.println("new Field: " + pl.getPlayer(0).getFieldIndex());
//        }
    }
}
