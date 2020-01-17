package Test;

import Entity.GameBoard;
import Entity.Player;

public class TrytobuyField {

    public static void main(String[] args) {

        // test om CheckFieldType retunerer den korrekte string
        Player p = new Player(null, null,1);
        GameBoard fl = new GameBoard();
       // LogicController test = new LogicController();

        p.addMoney(3000);
        p.setFieldIndex(2);
     //   System.out.println(test.checkFieldType(p.getFieldIndex()));

    }



}
