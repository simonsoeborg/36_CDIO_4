package entity;

public class Die {
    private final int MAX = 6;
    private int faceValue;

    /* Værdien af terningerne skal være et tal fra 1 til 6.
     * Vi siger +1 af (math.random() * MAX) som ellers vil være fra 0-5 */
    public Die() {
        this.faceValue = (int) (Math.random() * MAX) + 1;
    }

    /* Terningekastet defineres. dvs. hvis man skriver d1.roll svarer det til terning 1 kastes.
    Koden skal retunere en værdi fra kastet 1 til 6 */
    public int roll() {
        this.faceValue = (int) (Math.random() * MAX) + 1;
        return faceValue;
    }
}
