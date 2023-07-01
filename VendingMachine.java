import java.util.*;

/**
 * The VendingMachine class represents a vending machine that holds various items
 * and accepts money denominations for transactions. It keeps track of the machine's
 * name, the items in the machine, the current balance, and the transaction history.
 */
public class VendingMachine {

    /**
     * The name of the vending machine.
     */
    private String name;

    /**
     * The list of items available in the vending machine.
     */
    private ArrayList<Item> itemList;

    /**
     * The list of money denominations available as balance in the vending machine.
     */
    private ArrayList<MoneyDenomination> balance;

    /**
     * The list of items purchased in previous transactions from the vending machine.
     */
    private ArrayList<Item> transactionHistory;

    // INSTANTIATION

    /**
     * The Constants instance used for providing special characters and formatting.
     */
    Constants c = new Constants();

    /**
     * The StringSystem instance used for string manipulation and formatting.
     */
    StringSystem s = new StringSystem();

    // CONSTRUCTOR

    /**
     * Constructs a new VendingMachine with the given name.
     *
     * @param name the name of the vending machine
     */
    public VendingMachine(String name) {
        this.name = name;
        this.itemList = new ArrayList<>();
        this.balance = new ArrayList<>();
        this.transactionHistory = new ArrayList<>();
    }

    // GETTERS

    /**
     * Gets the name of the vending machine.
     *
     * @return the name of the vending machine
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the list of items available in the vending machine.
     *
     * @return the list of items in the vending machine
     */
    public ArrayList<Item> getItemList() {
        return itemList;
    }
    
    /**
     * Gets the list of items purchased in previous transactions from the vending machine.
     *
     * @return the list of items in the transaction history
     */
    public ArrayList<Item> getTransactionHistory() {
        return transactionHistory;
    }
    
    /**
     * Gets the list of money denominations available as balance in the vending machine.
     *
     * @return the list of money denominations in the vending machine
     */
    public ArrayList<MoneyDenomination> getBalance() {
        return balance;
    }
    
    /**
     * Sets the name of the vending machine.
     *
     * @param name the new name of the vending machine
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Sets the list of money denominations available as balance in the vending machine.
     *
     * @param balance the new list of money denominations for the vending machine balance
     */
    public void setBalance(ArrayList<MoneyDenomination> balance) {
        this.balance = balance;
    }
    
    // FEATURES

    /**
     * Adds an item to the vending machine with the specified details.
     *
     * @param name       the name of the item
     * @param price      the price of the item
     * @param calories   the calorie count of the item
     * @param initStock  the initial stock of the item
     * 
     * @return true if the item is successfully added, false if the maximum item count is reached
     */
    public boolean addItem(String name, float price, float calories, int initStock) {

        if(Item.itemCount < Constants.MAX_ITEMS) {

            Item item = new Item(name, price, calories, initStock);
            itemList.add(item);
            return true;
        } 
        
        else
            return false;
    }

    /**
     * Adds a money denomination to the vending machine's balance.
     *
     * @param denomination the money denomination to add
     */
    public void addMoneyDenomination(MoneyDenomination denomination) {
        this.balance.add(denomination);
    }
    
    /**
     * Adds a transaction to the transaction history.
     *
     * @param item the item to add to the transaction history
     */
    public void addTransaction(Item item) {
        Item transactionItem = new Item(item.getName(), item.getPrice(), item.getCalories(), 0);
        transactionHistory.add(transactionItem);
    }

    /**
     * Displays a summary of the transaction history and calculates the total earnings.
     *
     * @param transactionHistory the list of items in the transaction history
     */
    public void transactionSummary(ArrayList<Item> transactionHistory) {
        float totalEarnings = 0;

        System.out.println("\n>========< TRANSACTION HISTORY >========<\n");
        for(Item item : transactionHistory) {
            System.out.println(c.SPACER + item.getName() + " | PHP " + item.getPrice());
            totalEarnings += item.getPrice();
        }
        System.out.println("\n" + s.centerString(c.GRN + "TOTAL EARNINGS : PHP " + totalEarnings + c.RST, 51));
        System.out.println("\n>=======================================<");
    }

    /**
     * Calculates and returns the change to be given based on the cost and payment made.
     *
     * @param cost    the cost of the item
     * @param payment the payment made
     * 
     * @return the list of money denominations representing the change
     */
    public ArrayList<MoneyDenomination> produceChange(float cost, float payment) {
        int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

        ArrayList<MoneyDenomination> changeList = new ArrayList<>();

        for (int denomination : denominations) {
            changeList.add(new MoneyDenomination("PHP " + denomination, denomination, 0));
        }

        float change = payment - cost;

        int i = 0;

        for(MoneyDenomination denomination : balance) {
            if(denomination.getQuantity() > 0) {
                if(denomination.getValue() <= change) {
                    while(denomination.getValue() <= change) {
                        denomination.setQuantity(denomination.getQuantity() - 1);
                        (changeList.get(i)).setQuantity((changeList.get(i)).getQuantity() + 1);
                        change -= denomination.getValue();
                    }
                }
            }
            i++;
        }

        return changeList;
    }

    /**
     * Dispenses the change to the user and verifies if the vending machine has sufficient balance.
     *
     * @param changeList the list of money denominations representing the change
     * @param cost       the cost of the item
     * @param payment    the payment made
     * 
     * @return true if the change is successfully dispensed, false if the machine has insufficient balance
     */
    public boolean dispenseChange(ArrayList<MoneyDenomination> changeList, float cost, float payment) {
        float totalChange = 0;
        float change = payment - cost;
        System.out.println();

        for(MoneyDenomination denomination : changeList) {
            if(denomination.getQuantity() > 0) {
                if(denomination.getValue() > 20) {
                    if(denomination.getQuantity() == 1)
                        System.out.println("   Dispensing " + denomination.getQuantity() + " " + denomination.getName() + " bill...");
                    else
                        System.out.println("   Dispensing " + denomination.getQuantity() + " " + denomination.getName() + " bills...");
                    }
                else {
                    if(denomination.getQuantity() == 1)
                        System.out.println("   Dispensing " + denomination.getQuantity() + " " + denomination.getName() + " coin...");
                    else
                        System.out.println("   Dispensing " + denomination.getQuantity() + " " + denomination.getName() + " coins...");
                }
            }
            totalChange += denomination.getValue() * denomination.getQuantity();
        }

        if(totalChange != change) {
            System.out.println(s.centerString(c.RED + "ERROR! Machine has insufficient balance." + c.RST, 51));
            return false;
        }

        System.out.println("\n" + s.centerString(c.GRN + "TOTAL CHANGE : PHP " + totalChange + c.RST, 51));
        return true;
    }
}
