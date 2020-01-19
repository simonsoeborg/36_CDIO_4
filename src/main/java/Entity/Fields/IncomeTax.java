package Entity.Fields;

public class IncomeTax extends Field {
    private int payCash;
    private int payPercentage;

    public IncomeTax(String fieldName, int payCash, int payPercentage) {
        super(fieldName);
        this.payCash = payCash;
        this.payPercentage = payPercentage;
    }

    public int getPayCash() {
        return payCash;
    }

    public int getPayPercentage() {
        return payPercentage;
    }
}
