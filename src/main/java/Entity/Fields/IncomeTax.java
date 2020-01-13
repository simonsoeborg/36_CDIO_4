package Entity.Fields;

public class IncomeTax extends Field {

    private int payCash;
    private double payPercentage;

    public IncomeTax(String fieldName, int payCash, double payPercentage) {
        super(fieldName);
        this.payCash = payCash;
        this.payPercentage = payPercentage;
    }
}
