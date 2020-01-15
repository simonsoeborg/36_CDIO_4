package Entity.Fields;

public class StateTax extends Field {

    private int tax;

    public StateTax(String fieldName, int tax) {
        super(fieldName);
        this.tax = tax;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }
}
