package Entity;

/**
 * This class is a dice cup. We use our die class to make two dice for our game.
 */
public class DiceCup {

    private static final DiceCup INSTANCE = new DiceCup();
    private int die1 = 0;
    private int die2 = 0;

    private int i = 0;


    /* Terningekastet defineres. */
    public void roll() {
        Die die1 = new Die();
        Die die2 = new Die();

        this.die1 = die1.getFaceValue();
        this.die2 = die2.getFaceValue();

    }


    public void testRoll() {
        int[][] test = {{1,4,1,3,4,6,4,2,1,3,4,5,4,2,3,4},
                        {2,4,1,2,1,3,3,5,4,1,2,4,5,4,6,3}};

        setDie1(test[0][i]);
        setDie2(test[1][i]);
        i = (i + 1) %test[0].length;

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

    public void setDie1(int die1) {
        this.die1 = die1;
    }

    public void setDie2(int die2) {
        this.die2 = die2;
    }
}

