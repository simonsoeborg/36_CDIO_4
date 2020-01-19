package Test;

import Entity.DiceCup;

import static org.junit.jupiter.api.Assertions.*;

class DiceCupTest {

    private int testRuns = 1000;
    private DiceCup dc = new DiceCup();

    // Tester om metoden roll() slår begge terninger inden for intervallet 1 - 6.
    @org.junit.jupiter.api.Test
    void roll() {
        for (int i = 0; i < testRuns; i++) {
            dc.roll();
            assertEquals(3.5, dc.getDie1(), 2.5);
            assertEquals(3.5, dc.getDie2(), 2.5);
        }
    }

    // Tester om metoden faceValues() returnere den samlede værdi af de to terninger.
    @org.junit.jupiter.api.Test
    void faceValues() {
        for (int i = 0; i < testRuns; i++) {
            dc.roll();
            assertEquals(dc.getDie1() + dc.getDie2(), dc.faceValues());
        }
    }

    // Tester om metoden isFaceValueSame() returnere true, når terningerne har samme værdi, og false når de ikke har samme værdi.
    @org.junit.jupiter.api.Test
    void isFaceValueSame() {
        for (int i = 0; i < testRuns; i++) {
            dc.roll();
            if (dc.getDie1() == dc.getDie2())
                assertTrue(dc.isFaceValueSame());
            else
                assertFalse(dc.isFaceValueSame());
        }
    }
}