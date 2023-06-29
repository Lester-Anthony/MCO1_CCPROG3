import java.util.ArrayList;
import java.util.Scanner;


public class Menu {

    Constants c = new Constants();
    StringSystem s = new StringSystem();
    Scanner sc = new Scanner(System.in);
    public Menu(){}

    // Display Item List

    public void displayItemList(ArrayList<Item> itemList) {
        int nItem = 1;

        for( Item item : itemList) {
            if(item.getStock() == 0)
                System.out.println(c.RED + c.SPACER + nItem + ". " + item.getName() + c.RST + " : N/A");
            else
                System.out.println(c.GRN + c.SPACER + nItem + ". " + item.getName() + c.RST);
            nItem++;
        }
    }

    public int selectItem(VendingMachine vm) {
        String input = "0";

        System.out.print(c.BLU + "\n" + c.SPACER + "Select Item : " + c.RST);
        while(Integer.parseInt(input) < 1 || Integer.parseInt(input) > (vm.getItemList()).size()) {

            input = sc.nextLine();

            if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > (vm.getItemList()).size()) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Item : " + c.RST);
            }
        }

        return Integer.parseInt(input) - 1; // returns Item index
    }

    // Main Menu

    public void mainMenu() {

        System.out.println("\n>=============< MAIN MENU >=============<\n");
        System.out.println(c.SPACER + "1. Create Vending Machine");
        System.out.println(c.SPACER + "2. Test Vending Machine");
        System.out.println(c.SPACER + "3. Exit");
        System.out.println("\n>=======================================<");

    }
    public int mainInput() {
        String input = "0";

        System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
        while(!input.equals("1")  && !input.equals("2") && !input.equals("3")) {

            input = sc.nextLine();

            if(!input.equals("1")  && !input.equals("2") && !input.equals("3")) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
            }
        }

        return Integer.parseInt(input);
    }

    // Create Vending Machine

    public void createVendingMachineMenu() {

        System.out.println("\n>=============< CREATE VM >=============<\n");
        System.out.println(c.SPACER + "1. Create Regular Vending Machine");
        System.out.println(c.SPACER + "2. Create Special Vending Machine");
        System.out.println(c.SPACER + "3. Exit");
        System.out.println("\n>=======================================<");

    }

    public int createVendingMachineInput() {
        String input = "0";

        System.out.print(c.BLU + "\n" + c.SPACER + "Select VM Type : " + c.RST);
        while(!input.equals("1")  && !input.equals("2") && !input.equals("3")) {

            input = sc.nextLine();

            if(!input.equals("1")  && !input.equals("2") && !input.equals("3")) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Type : " + c.RST);
            }
        }

        return Integer.parseInt(input);
    }

    // Create Regular Vending Machine

    public void createRegularVendingMachineMenu(VendingMachine vm) {

        System.out.println("\n>=============< CREATE VM >=============<\n");
        System.out.println(s.centerString(c.BLU + "<Name>\n" + c.RST, 51));
        System.out.println(s.centerString(vm.getName(), 41));
        System.out.println();
        System.out.println(s.centerString(c.BLU + "<Item List>\n" + c.RST, 51));

        displayItemList(vm.getItemList());

        System.out.println("\n" + c.SPACER + "--------------------------------");
        System.out.println("\n" + c.SPACER + "1. Set Name");
        System.out.println(c.SPACER + "2. Add Item");
        System.out.println(c.SPACER + "3. Create");

        System.out.println("\n>=======================================<");
    }

    public int createRegularVendingMachineInput(VendingMachine vm) {
        String input = "0";

        String tempName = "__________";
        float tempPrice = 0;
        float tempCalories = 0;
        int tempInitStock = -1;

        System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
        while(!input.equals("1")  && !input.equals("2") && !input.equals("3")) {

            input = sc.nextLine();

            if(!input.equals("1")  && !input.equals("2") && !input.equals("3")) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
            }
        }

        switch(Integer.parseInt(input)) {
            case 1 : // Sets Name
                System.out.print("\n" + c.SPACER + "Enter Name : ");
                vm.setName(sc.nextLine());
                break;
                case 2 : // Adds Item
                // Item Name
                System.out.print("\n" + c.SPACER + "Enter Item Name : ");
                tempName = sc.nextLine();
                
                // Item Price
                System.out.print(c.SPACER + "Enter Item Price : ");
                while(tempPrice <= 0) {
                    tempPrice = sc.nextFloat();
                    if(tempPrice <= 0) {
                        System.out.println(c.SPACER + "Enter Valid Price : ");
                    }
                }
                
                // Calorie Count
                System.out.print(c.SPACER + "Enter Calorie Count : ");
                while(tempCalories <= 0) {
                    tempCalories = sc.nextFloat();
                    if(tempCalories <= 0) {
                        System.out.println(c.SPACER + "Enter Valid Amount : ");
                    }
                }
                
                // Initial Stock
                System.out.print(c.SPACER + "Enter Initial Stock : ");
                while(tempInitStock < 0) {
                    tempInitStock = sc.nextInt();
                    if(tempInitStock < 0) {
                        System.out.println(c.SPACER + "Enter Valid Amount : ");
                    }
                }

                // Adding Object
                vm.addItem(tempName, tempPrice, tempCalories, tempInitStock);
                

                break;
        }

        return Integer.parseInt(input);

    }

    // Test Vending Machine Features
    
    public void testVendingMachineFeaturesMenu() {
        System.out.println("\n>===========< TEST FEATURES >===========<\n");
        System.out.println(c.SPACER + "1. Vending Features");
        System.out.println(c.SPACER + "2. Maintenance Features");
        System.out.println(c.SPACER + "3. Exit");
        System.out.println("\n>=======================================<");
    }

    public int testVendingMachineFeaturesInput() {
        String input = "0";

        System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
        while(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 3) {
    
            input = sc.nextLine();
    
            if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 3) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
            }
        }

        return Integer.parseInt(input);
    }

    // Maintenance Features

    public void maintenanceFeaturesMenu() {
        System.out.println("\n>=======< MAINTENANCE  FEATURES >=======<\n");
        System.out.println(c.SPACER + "1. Stock Item");
        System.out.println(c.SPACER + "2. Set Item Price");
        System.out.println(c.SPACER + "3. Collect Earnings");
        System.out.println(c.SPACER + "4. Replenish Money");
        System.out.println(c.SPACER + "5. Transaction Summary");
        System.out.println("\n>=======================================<");
    }
    
    public void maintenanceFeaturesInput(VendingMachine vm) { // Add Features
        String input = "0";

        int itemIndex;
        int stock = -1;
        float price = -1;


        System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
        while(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 5) {

            input = sc.nextLine();

            if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 5) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
            }
        }

        System.out.println("\n>=============< ITEM LIST >=============<\n");
        displayItemList(vm.getItemList());
        System.out.println("\n>=======================================<");
        
        itemIndex = selectItem(vm);  

        switch(Integer.parseInt(input)) {
            case 1 : // Stock Item
                
                System.out.print(c.BLU + "\n" + c.SPACER + "Enter Stock : " + c.RST);
                while(stock < 0) {
                    
                    stock = sc.nextInt();
                    
                    if(stock < 0) {
                        System.out.print(c.BLU + c.SPACER + "Select Valid Amount : " + c.RST);
                    }
                }
                
                ((vm.getItemList()).get(itemIndex)).setStock( ((vm.getItemList()).get(itemIndex)).getStock() + stock );
                break;

            case 2 : // Set Item Price
                System.out.print(c.BLU + "\n" + c.SPACER + "Enter Price : " + c.RST);
                while(price < 0) {
                    
                    price = sc.nextFloat();
                    
                    if(price < 0) {
                        System.out.print(c.BLU + c.SPACER + "Select Valid Cost : " + c.RST);
                    }
                }

                ((vm.getItemList()).get(itemIndex)).setPrice(price);
                break;


                // PROGRAM THESE LATER
            case 3 : // Collect Earnings
                break;
            case 4 : // Replenish Money
                break;
            case 5 : // Transaction Summary
                break;
        }
    }


    // Vending Machine

    public void vendingMachineMenu(VendingMachine vm) {
        // System.out.println(sc.hasNextLine());
        System.out.println("\n>==========< VENDING MACHINE >==========<\n");

        displayItemList(vm.getItemList());

        System.out.println(c.BLU + "\n" + c.SPACER + "NOTE: Color indicates availability!" + c.RST);

        System.out.println("\n>=======================================<");
    }

    public int vendingMachineInput(VendingMachine vm) {
        String input = "0";

        System.out.print(c.BLU + "\n" + c.SPACER + "Select Item to Inspect : " + c.RST);
        while(Integer.parseInt(input) < 1 || Integer.parseInt(input) > (vm.getItemList()).size()) {

            input = sc.nextLine();

            if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > (vm.getItemList()).size()) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Item : " + c.RST);
            }
        }

        return Integer.parseInt(input);
    }

    // Item Menu

    public void itemMenu(Item item) {
        System.out.println("\n>=============< ITEM MENU >=============<\n");

        System.out.println(s.centerString(item.getName(), 41));
        System.out.println(s.centerString(c.YLW + "(" + item.getCalories() + " cal" + ")" + c.RST, 53));
        System.out.println();
        System.out.println(s.centerString(c.BLU + "PHP " + item.getPrice() + c.RST, 51));
        System.out.println(s.centerString(c.BLU + item.getStock() + " Left in Machine" + c.RST, 51));

        System.out.println("\n>=======================================<");
    }
}
