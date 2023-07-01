/**
 * Represents a money denomination with a specific denomination, value, and quantity.
 */
public class MoneyDenomination {
    private String name;
    private float value;
    private int quantity;

    // CONSTRUCTOR

    /**
     * Constructs a MoneyDenomination object with the specified denomination, value, and quantity.
     *
     * @param name         the name of the money
     * @param denomination the denomination of the money
     * @param value        the value of the money
     * @param quantity     the quantity of the money
     */
    public MoneyDenomination(String name, float value, int quantity) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }

    // GETTERS

    /**
     * Returns the the name of the money.
     * 
     * @return the name of the money
     */
    public String getName() {
        return name;
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

    // SETTER

    /**
     * Sets the quantity of the money.
     *
     * @param quantity the new quantity of the money
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}