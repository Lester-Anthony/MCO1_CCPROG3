import java.util.ArrayList;

public class VendingMachine {
    private String name;
    private ArrayList<Item> itemList;
    private ArrayList<MoneyDenomination> balance;
    private ArrayList<Item> transactionHistory;

    Constants c = new Constants();
    StringSystem s = new StringSystem();

    public VendingMachine(String name) {
        this.name = name;
        this.itemList = new ArrayList<>();
        this.balance = new ArrayList<>();
        this.transactionHistory = new ArrayList<>();
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

    public ArrayList<Item> getTransactionHistory() {
        return transactionHistory;
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

    public ArrayList<MoneyDenomination> produceChange(float cost, float payment) {
        // Implementation
        ArrayList<MoneyDenomination> changeList = new ArrayList<>();

        changeList.add(new MoneyDenomination("PHP 1000", 1000,0));
        changeList.add(new MoneyDenomination("PHP 500", 500, 0));
        changeList.add(new MoneyDenomination("PHP 200", 200, 0));
        changeList.add(new MoneyDenomination("PHP 100", 100, 0));
        changeList.add(new MoneyDenomination("PHP 50", 50, 0));
        changeList.add(new MoneyDenomination("PHP 20", 20, 0));
        changeList.add(new MoneyDenomination("PHP 10", 10, 0));
        changeList.add(new MoneyDenomination("PHP 5", 5, 0));
        changeList.add(new MoneyDenomination("PHP 1", 1, 0));

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
        System.out.println(totalChange + " " + change);
        if(totalChange != change) {
            System.out.println(s.centerString(c.RED + "ERROR! Machine has insufficient balance." + c.RST, 51));
            return false;
        }
        System.out.println("\n" + s.centerString(c.GRN + "TOTAL CHANGE : PHP " + totalChange + c.RST, 51));
        return true;
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

    public void addTransaction(Item item) {
        Item transactionItem = new Item(item.getName(), item.getPrice(), item.getCalories(), 0);
        transactionHistory.add(transactionItem);
    }
    public void transactionSummary(ArrayList<Item> transactionHistory) {
        float totalEarnings = 0;

        System.out.println("\n>========< TRANSACTION HISTORY >========<\n");
        for(Item item : transactionHistory) {
            System.out.println(c.SPACER + item.getName() + " | PHP " + item.getPrice());
            totalEarnings += item.getPrice();
        }
        System.out.println("\n" + s.centerString(c.GRN + "TOTAL EARNINGS : PHP" + totalEarnings + c.RST, 51));
        System.out.println("\n>=======================================<");
    }
}
