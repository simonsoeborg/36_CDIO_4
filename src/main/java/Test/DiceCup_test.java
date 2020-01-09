package Test;

import entity.DiceCup;

public class DiceCup_test {

    public static void main(String[] args) {
        DiceCup dc = new DiceCup();
        for (int i = 0; i <10; i++) {


            dc.roll();
            // tjekker om de 2 terninger er alig hinanden
            if (dc.isFaceValueSame()){
                System.out.println(dc.faceValues()+ " is same");
            } else {
                // hvis det ikke er det samme printer den ud normalt
                System.out.println(dc.faceValues());
            }
        }
    }
}
