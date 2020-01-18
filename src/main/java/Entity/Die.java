package Entity;

/**
 * The class makes a die with possible facevalues between 1-6.
 * @author Kristoffer
 * @version 1.0.0
 */
public class Die {

    private final int MAX = 6;
    // We say +1 infront of (math.random() * MAX) because else it would be from 0-5.
    private int faceValue = (int) (Math.random() * MAX) + 1;


    public int getFaceValue() {
        return faceValue;
    }

}
