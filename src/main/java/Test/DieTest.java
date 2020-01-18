package Test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DieTest {
   /* final int faces = 6;

    @Test
    public void roll() {
        // Testen viser at vores terning kun slår værdier der matcher med antal sider på terningen.
        Dice d1 = new Dice(faces);
        for (int i = 0; i < 1000000; i++) {
            d1.roll();
            assertEquals(faces / 2.0 + 0.5, d1.getFaceValue(), faces / 2.0 - 0.5);
        }
    }

    @org.junit.Test
    public void rollStatistics() {
        // Testen viser at vores ternings facevalue, matcher med almindelig sandsylighed.
        Dice dice1 = new Die(faces);
        int occurrences = 100000;
        float[] arr = new float[faces];
        int t;
        for (int i = 0; i < occurrences; i++) {
            dice1.roll();
            t = dice1.getFaceValue() - 1;
            arr[t] = arr[t] + 1;
        }
        for (int i = 0; i < faces; i++) {
            assertEquals(16.67, arr[i] / occurrences * 100, 4);
        }
    }

    */
}
