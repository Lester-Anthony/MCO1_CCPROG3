/**
 * Represents a money denomination with a specific denomination, value, and quantity.
 */
public class MoneyDenomination {
    private String denomination;
    private float value;
    private int quantity;

    /**
     * Constructs a MoneyDenomination object with the specified denomination, value, and quantity.
     *
     * @param denomination the denomination of the money
     * @param value        the value of the money
     * @param quantity     the quantity of the money
     */
    public MoneyDenomination(String denomination, float value, int quantity) {
        this.denomination = denomination;
        this.value = value;
        this.quantity = quantity;
    }

    /**
     * Returns the denomination of the money.
     *
     * @return the denomination of the money
     */
    public String getDenomination() {
        return denomination;
    }

    /**
     * Returns the value of the money.
     *
     * @return the value of the money
     */
    public float getValue() {
        return value;
    }

    /**
     * Returns the quantity of the money.
     *
     * @return the quantity of the money
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the money.
     *
     * @param quantity the new quantity of the money
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
