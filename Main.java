public class Main {
    public static void main(String[] args) {
        
        boolean stopProgram = false;

        // Creating an instance of VendingMachine class and Menu class
        VendingMachine vm = new VendingMachine("Vending Machine");
        Constants c = new Constants();
        Menu menuSystem = new Menu();

        // Creating instances of MoneyDenomination objects based on Filipino currency
        MoneyDenomination[] denominations = {
            new MoneyDenomination("PHP 1000", 1000, 10),
            new MoneyDenomination("PHP 500", 500, 10),
            new MoneyDenomination("PHP 200", 200, 10),
            new MoneyDenomination("PHP 100", 100, 10),
            new MoneyDenomination("PHP 50", 50, 10),
            new MoneyDenomination("PHP 20", 20, 10),
            new MoneyDenomination("PHP 10", 10, 10),
            new MoneyDenomination("PHP 5", 5, 10),
            new MoneyDenomination("PHP 1", 1, 100)
        };
        
        // Adding each denomination of money to the vending machine's balance
        for (MoneyDenomination denomination : denominations) {
            vm.addMoneyDenomination(denomination);
        }

        // PROGRAM PROPER

        while(!stopProgram) {
            int input;

            // Main Menu
            menuSystem.mainMenu();
            input = menuSystem.mainInput();
            boolean exitSubMenu = false;

            switch(input) {
                case 1 : // Create Vending Machine Menu
                    menuSystem.createVendingMachineMenu();
                    input = menuSystem.createVendingMachineInput();
                    
                    exitSubMenu = false;
                        switch(input) {
                            case 1 : // Create Regular Vending Machine
                                while(input != 3) {
                                    while(!exitSubMenu) {
                                        menuSystem.createRegularVendingMachineMenu(vm);
                                        input = menuSystem.createRegularVendingMachineInput(vm);

                                        if(input == 3) {
                                            exitSubMenu = ((vm.getItemList()).size() > 7);
                                            if(!exitSubMenu)
                                            System.out.println(c.SPACER + c.RED + "ERROR! You need at least 8 items." + c.RST);
                                        }
                                    }
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

                    exitSubMenu = false;
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