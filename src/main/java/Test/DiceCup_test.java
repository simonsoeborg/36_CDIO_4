package Test;

import Entity.DiceCup;

/**
 * This test checks, first that our dice function and if you roll two of the same.
 */
public class DiceCup_test {

    public static void main(String[] args) {
        DiceCup dc = new DiceCup();
        for (int i = 0; i <10; i++) {


            dc.roll();
            /**
             * checks if the value is the same of both the dice
             */
            if (dc.isFaceValueSame()){
                System.out.println(dc.faceValues()+ " is same");
            } else {
                // hvis det ikke er det samme printer den ud normalt
                System.out.println(dc.faceValues());
            }
        }
    }
}
