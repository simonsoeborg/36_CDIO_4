package entity;

public class DiceCup {

    private int die1 = 0;
    private int die2 = 0;

    /* Terningekastet defineres. */
    public void roll() {
        Die die1 = new Die();
        Die die2 = new Die();

        this.die1 = die1.getFaceValue();
        this.die2 = die2.getFaceValue();
    }

    public int faceValues(){
        int sum = this.die1+this.die2;
        return sum;

    }
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
}