package Entity;

/**
 * This class is a dice cup which create two die objects and roll them.
 * @author Kristoffer
 * @version 1.0.0
 */
public class DiceCup {

    private static final DiceCup INSTANCE = new DiceCup();
    private int die1 = 0;
    private int die2 = 0;
    private int i = 0;


    /**
     * Creates two die objects and roll them by assigning the random values of each die to the intance variables die1 and die2
     */
    public void roll() {
        Die die1 = new Die();
        Die die2 = new Die();

        this.die1 = die1.getFaceValue();
        this.die2 = die2.getFaceValue();

    }


    /**
     * Adds the value of the two facevalues
     * @return - The sum of the facevalues
     */
    public int faceValues(){
        int sum = this.die1+this.die2;
        return sum;
    }

    /**
     * Checks both facevalues to see weather their values are equal
     * @return - Boolean true if the facevalues are equal or boolean false if they're not
     */
    public boolean isFaceValueSame(){

       boolean check = false;

       if (die1 == die2)
           check = true;

       return check;
    }

    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    //todo --- Den der har lavet den statiske metode getIntance, må gerne lige beskrive den
    /**
     * ?????????????????????
     * @return
     */
    public static DiceCup getINSTANCE(){
        return  INSTANCE;
    }

}

