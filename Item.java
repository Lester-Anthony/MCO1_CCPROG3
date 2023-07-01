/**
 * The Item class represents a product with its name, price, calories, and stock information.
 * It provides methods to access and modify the properties of an item.
 */
public class Item {
    private String name;
    private float price;
    private float calories;
    private int stock;
    static int itemCount = 0;

    // CONSTRUCTOR

    /**
     * Constructs an Item object with the specified name, price, calories, and initial stock quantity.
     *
     * @param name          the name of the item
     * @param price         the price of the item
     * @param calories      the calories of the item
     * @param initStock     the initial stock quantity of the item
     */
    public Item(String name, float price, float calories, int initStock) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.stock = initStock;
    }

    // GETTERS

    /**
     * Returns the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the item.
     *
     * @return the price of the item
     */
    public float getPrice() {
        return price;
    }

    /**
     * Returns the calories of the item.
     *
     * @return the calories of the item
     */
    public float getCalories() {
        return calories;
    }

    /**
     * Returns the current stock quantity of the item.
     *
     * @return the current stock quantity of the item
     */
    public int getStock() {
        return stock;
    }

    // SETTERS

    /**
     * Sets the price of the item.
     *
     * @param price the new price of the item
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Sets the stock quantity of the item.
     *
     * @param stock the new stock quantity of the item
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
