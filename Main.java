public class Main {
    public static void main(String[] args) {
        
        // Creating an instance of VendingMachine class
        
        VendingMachine vm = new VendingMachine("Frozen Yogurt");

        Menu menuSystem = new Menu();

        boolean stopProgram = false;

        // Creating instances of MoneyDenomination objects based on Filipino currency
        MoneyDenomination p1000 = new MoneyDenomination("PHP 1000", 1000, 10);
        MoneyDenomination p500 = new MoneyDenomination("PHP 500", 500, 10);
        MoneyDenomination p200 = new MoneyDenomination("PHP 200",200, 10);
        MoneyDenomination p100 = new MoneyDenomination("PHP 100",100, 10);
        MoneyDenomination p50 = new MoneyDenomination("PHP 50",50, 10);
        MoneyDenomination p20 = new MoneyDenomination("PHP 20",20, 10);
        MoneyDenomination p10 = new MoneyDenomination("PHP 10",10, 10);
        MoneyDenomination p5 = new MoneyDenomination("PHP 5", 5, 10);
        MoneyDenomination p1 = new MoneyDenomination("PHP 1", 1, 100);

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

        // Adding each item to vm's itemList
        vm.addItem("Chocolate Froyo", 100, 160, 5);
        vm.addItem("Vanilla Froyo", 100, 160, 0);
        vm.addItem("Strawberry Froyo", 100, 160, 5);
        vm.addItem("Mango Froyo", 100, 160, 0);
        vm.addItem("Banana Froyo", 100, 160, 0);
        vm.addItem("Caramel Froyo", 100, 160, 5);

        while(!stopProgram) {
            int input;

            // Main Menu
            menuSystem.mainMenu();
            input = menuSystem.mainInput();

            switch(input) {
                case 1 : // Create Vending Machine Menu
                    menuSystem.createVendingMachineMenu();
                    input = menuSystem.createVendingMachineInput();

                    switch(input) {
                        case 1 : // Create Regular Vending Machine
                            while(input != 3) {
                                menuSystem.createRegularVendingMachineMenu(vm);
                                input = menuSystem.createRegularVendingMachineInput(vm);
                            }
                            break;
                        case 2 : // Create Special Vending Machine
                            while(input != 0) {
                                menuSystem.createSpecialVendingMachineMenu();
                                input = menuSystem.createSpecialVendingMachineInput();
                            }
                            break;
                        case 3 :
                            break;
                    }
                    break;
                case 2 : // Test Vending Machine Features
                    menuSystem.testVendingMachineFeaturesMenu();
                    input = menuSystem.testVendingMachineFeaturesInput();

                    boolean exitSubMenu = false;
                    switch(input) {
                        case 1 : // Vending  Features
                            float paymentValue = 0;

                            while(!exitSubMenu) {

                                menuSystem.vendingFeaturesMenu();
                                input = menuSystem.vendingFeaturesInput();
                                
                                switch(input) {
                                    case 1 : // Insert Payment
                                        paymentValue = menuSystem.receivePaymentMenu(vm);
                                        break;
                                    case 2 : // Select Item
                                        menuSystem.vendingMachineMenu(vm, paymentValue);
                                        input = menuSystem.vendingMachineInput(vm);
                                        if(input > 0) {
                                            if(menuSystem.itemMenu(vm, (vm.getItemList()).get(input - 1), paymentValue)) {
                                                vm.addTransaction((vm.getItemList()).get(input - 1));
                                                vm.dispenseChange(vm.produceChange(((vm.getItemList()).get(input - 1)).getPrice(), paymentValue), ((vm.getItemList()).get(input- 1)).getPrice(), paymentValue);
                                            }
                                        }
                                        break;
                                    case 3 : // Exit
                                        exitSubMenu = true;
                                        break;
                                }
                            }
                            break;
                        case 2 : // Maintenance Features
                            while(!exitSubMenu) {
                                menuSystem.maintenanceFeaturesMenu();
                                exitSubMenu = menuSystem.maintenanceFeaturesInput(vm);
                            }
                            break;
                        case 3 :
                            break;
                    }
                    break;
                case 3 : // Exit
                    stopProgram = true;
                    break;
            }

        }
    }
}
