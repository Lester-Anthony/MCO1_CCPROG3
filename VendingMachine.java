import java.util.ArrayList;

public class VendingMachine {
    private String name;
    private ArrayList<Item> itemList;
    private ArrayList<MoneyDenomination> balance;
    private ArrayList<Item> dispensedItemsList;

    public VendingMachine(String name) {
        this.name = name;
        this.itemList = new ArrayList<>();
        this.balance = new ArrayList<>();
    }

    // General Features

    public boolean addItem(String name, float price, float calories, int initStock) {
        if(Item.itemCount < Constants.MAX_ITEMS) {
            Item item = new Item(name, price, calories, initStock);
            itemList.add(item);
            return true;
        }
        else
            return false;
    }

    public void addMoneyDenomination(MoneyDenomination denomination) {
        this.balance.add(denomination);
    }
    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public ArrayList<MoneyDenomination> getBalance() {
        return balance;
    }

    public void setBalance(ArrayList<MoneyDenomination> balance) {
        this.balance = balance;
    }

    // Vending Features

    public void receivePayment(float payment) {
        // Implementation
    }

    public boolean dispenseItem(int itemIndex, int quantity) {
        // Checks if item's stock is over 0
        if((itemList.get(itemIndex)).getStock() > 0) {
            // Decrements item's stock by 1
            (itemList.get(itemIndex)).setStock((itemList.get(itemIndex)).getStock()-1);

            // // Adds item to list of dispensed items
            // dispensedItemsList.add(itemList.get(itemIndex));
            return true;
        }
        else
            return false;

    }

    public void produceChange(float cost) {
        // Implementation
    }

    // Maintenance Features

    public void stockItem(int itemIndex, int stock) {
        // Adds stock to the item's current stock
        (itemList.get(itemIndex)).setStock((itemList.get(itemIndex)).getStock() + stock);
    }

    public void setItemPrice(int itemIndex, float price) {
        // Sets new price of item
        (itemList.get(itemIndex)).setPrice(price);
    }

    public void collectEarnings() {
        // Implementation
    }

    public void replenishMoney(int denominationIndex, int quantity) {
        // Implementation
    }

    public void transactionSummary() {
        // Implementation
    }
}
