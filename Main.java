public class Main {
    public static void main(String[] args) {
        // Creating an instance of VendingMachine class
        VendingMachine vm = new VendingMachine("Frozen Yogurt");

        Menu menuSystem = new Menu();

        // Creating instances of MoneyDenomination objects based on Filipino currency
        MoneyDenomination p1000 = new MoneyDenomination(1000, 0);
        MoneyDenomination p500 = new MoneyDenomination(500, 0);
        MoneyDenomination p200 = new MoneyDenomination(200, 0);
        MoneyDenomination p100 = new MoneyDenomination(100, 0);
        MoneyDenomination p50 = new MoneyDenomination(50, 0);
        MoneyDenomination p20 = new MoneyDenomination(20, 0);
        MoneyDenomination p10 = new MoneyDenomination(10, 0);
        MoneyDenomination p5 = new MoneyDenomination( 5, 0);
        MoneyDenomination p1 = new MoneyDenomination( 1, 0);

        // Adding each denomination of money to the vending machine's balance
        vm.addMoneyDenomination(p1000);
        vm.addMoneyDenomination(p500);
        vm.addMoneyDenomination(p200);
        vm.addMoneyDenomination(p100);
        vm.addMoneyDenomination(p50);
        vm.addMoneyDenomination(p20);
        vm.addMoneyDenomination(p10);
        vm.addMoneyDenomination(p5);
        vm.addMoneyDenomination(p1);

        // Creating Item objects
        // Item item1 = new Item("Chocolate Froyo", 100, 160, 5);
        // Item item2 = new Item("Vanilla Froyo", 100, 160, 5);
        // Item item3 = new Item("Strawberry Froyo", 100, 160, 5);

        // Adding each item to vm's itemList
        vm.addItem("Chocolate Froyo", 100, 160, 5);
        vm.addItem("Vanilla Froyo", 100, 160, 0);
        vm.addItem("Strawberry Froyo", 100, 160, 5);
        vm.addItem("Mango Froyo", 100, 160, 0);
        vm.addItem("Banana Froyo", 100, 160, 0);
        vm.addItem("Caramel Froyo", 100, 160, 5);

        // for(Item item : vm.getItemList()) {
        //     System.out.println("Item : " + item.getName());
        //     System.out.println("Price : PHP" + item.getPrice());
        //     System.out.println("Calories : " + item.getCalories());
        //     System.out.println("Stock : " + item.getStock() + "\n");

        // }


        menuSystem.mainMenu();
        menuSystem.mainMenuInput();

        menuSystem.vendingMachineMenu(vm, vm.getItemList());
        menuSystem.vendingMachineMenuInput(vm, vm.getItemList());
        
        // menuSystem.itemMenu((vm.getItemList()).get(0));
    }
}
