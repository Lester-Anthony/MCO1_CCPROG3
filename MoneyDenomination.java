/**
 * Represents a money denomination with a specific denomination, value, and quantity.
 */
public class MoneyDenomination {
    private float value;
    private int quantity;

    /**
     * Constructs a MoneyDenomination object with the specified denomination, value, and quantity.
     *
     * @param denomination the denomination of the money
     * @param value        the value of the money
     * @param quantity     the quantity of the money
     */
    public MoneyDenomination(float value, int quantity) {
        this.value = value;
        this.quantity = quantity;
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
