package Entity;

/**
 * The class show makes a die with a value 1-6 and able to show the number.
 */
public class Die {
    private final int MAX = 6;
    private int faceValue;

    /**
    /* Value from 1-6
     * We say +1 infront of (math.random() * MAX) because else it would be from 0-5.
     * */
    public Die() { this.faceValue = (int) (Math.random() * MAX) + 1;
    }

    /**
     * get the value.
     */
    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }
}
