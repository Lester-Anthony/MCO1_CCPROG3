/**
 * The Item class represents a product with its name, price, calories, and stock information.
 * It provides methods to access and modify the properties of an item.
 */
public class Item {
    private String name;
    private float price;
    private int calories;
    private int stock;
    static int itemCount = 0;

    /**
     * Constructs an Item object with the specified name, price, calories, and initial stock quantity.
     *
     * @param name          the name of the item
     * @param price         the price of the item
     * @param calories      the calories of the item
     * @param initStock     the initial stock quantity of the item
     */
    public Item(String name, float price, int calories, int initStock) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.stock = initStock;
    }

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
     * Sets the price of the item.
     *
     * @param price the new price of the item
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Returns the calories of the item.
     *
     * @return the calories of the item
     */
    public int getCalories() {
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

    /**
     * Sets the stock quantity of the item.
     *
     * @param amount the new stock quantity of the item
     */
    public void setStock(int amount) {
        this.stock = amount;
    }
}