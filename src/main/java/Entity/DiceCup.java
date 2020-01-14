package Entity;

/**
 * This class is a dice cup. We use our die class to make two dice for our game.
 */
public class DiceCup {

    private static final DiceCup INSTANCE = new DiceCup();
    private int die1 = 0;
    private int die2 = 0;

    /* Terningekastet defineres. */
    public void roll() {
        Die die1 = new Die();
        Die die2 = new Die();

        this.die1 = die1.getFaceValue();
        this.die2 = die2.getFaceValue();
    }

    /**
     * show the value of two dice.
     */
    public int faceValues(){
        int sum = this.die1+this.die2;
        return sum;

    }

    /**
     * it checks if you roll two of the same eyes.
     */
    // tjekker om der bliver slået 2 ens
    public boolean isFaceValueSame(){
        boolean check;

       if (die1 == die2){
           check = true;
       }
       else{
           check = false;
       }

       return check;
    }

    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    public static DiceCup getINSTANCE(){
        return  INSTANCE;
    }


}

