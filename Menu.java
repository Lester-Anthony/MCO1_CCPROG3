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

    // Receive Payment Menu

    public float receivePaymentMenu(VendingMachine vm) {
        int[] tempQuantity = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean exitFlag = false;
        float total = 0;
        while(!exitFlag) {

            System.out.println("\n>============< INSERT CASH >============<\n");
            System.out.println(c.SPACER + "     AMOUNT     |  QTY & VALUE");
            System.out.println("  >-----------------|-----------------<");
            System.out.println(c.SPACER + " 1.  PHP 1000   |   " + tempQuantity[0] + " - PHP " + tempQuantity[0] * 1000);
            System.out.println(c.SPACER + " 2.  PHP 500    |   " + tempQuantity[1] + " - PHP " + tempQuantity[1] * 500);
            System.out.println(c.SPACER + " 3.  PHP 200    |   " + tempQuantity[2] + " - PHP " + tempQuantity[2] * 200);
            System.out.println(c.SPACER + " 4.  PHP 100    |   " + tempQuantity[3] + " - PHP " + tempQuantity[3] * 100);
            System.out.println(c.SPACER + " 5.  PHP 50     |   " + tempQuantity[4] + " - PHP " + tempQuantity[4] * 50);
            System.out.println(c.SPACER + " 6.  PHP 20     |   " + tempQuantity[5] + " - PHP " + tempQuantity[5] * 20);
            System.out.println(c.SPACER + " 7.  PHP 10     |   " + tempQuantity[6] + " - PHP " + tempQuantity[6] * 10);
            System.out.println(c.SPACER + " 8.  PHP 5      |   " + tempQuantity[7] + " - PHP " + tempQuantity[7] * 5);
            System.out.println(c.SPACER + " 9.  PHP 1      |   " + tempQuantity[8] + " - PHP " + tempQuantity[8]);
            
            total = tempQuantity[0] * 1000 + tempQuantity[1] * 500 + tempQuantity[2] * 200 +
            tempQuantity[3] * 100  + tempQuantity[4] * 50  + tempQuantity[5] * 20  +
            tempQuantity[6] * 10   + tempQuantity[7] * 5   + tempQuantity[8];
            
            System.out.println("\n" + s.centerString(c.GRN + "TOTAL : PHP " + total + c.RST, 51));
            System.out.println("\n" + s.centerString(c.BLU + "Enter [0] to Exit" + c.RST, 51));
            System.out.println("\n>=======================================<");
            
            String moneyDenominationIndex = "-1";
            String quantity = "0";
            
            System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
            while(Integer.parseInt(moneyDenominationIndex) < 0 || Integer.parseInt(moneyDenominationIndex) > 9) {
                
                moneyDenominationIndex = sc.nextLine();
                
                if(Integer.parseInt(moneyDenominationIndex) < 0 || Integer.parseInt(moneyDenominationIndex) > 9) {
                    System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
                }
            }
            
            if(Integer.parseInt(moneyDenominationIndex) > 0) {

                System.out.print(c.BLU + c.SPACER + "Enter Quantity : " + c.RST);
                while(Integer.parseInt(quantity) <= 0) {
                    
                    quantity = sc.nextLine();
                    
                    if(Integer.parseInt(quantity) <= 0) {
                        System.out.print(c.BLU + c.SPACER + "Select Valid Amount : " + c.RST);
                    }
                }
                tempQuantity[Integer.parseInt(moneyDenominationIndex) - 1] += Integer.parseInt(quantity);
            }

            if(Integer.parseInt(moneyDenominationIndex) == 0) {
                int i;

                for(i = 0; i < 9; i++)
                ((vm.getBalance()).get(i)).setQuantity(((vm.getBalance()).get(i)).getQuantity() + tempQuantity[i]);

                exitFlag = true;
            }
        }
        return total;
    }

    public float collectPaymentMenu(VendingMachine vm) {
        int[] tempQuantity = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean exitFlag = false;
        float total = 0;
        while(!exitFlag) {

            System.out.println("\n>===========< COLLECT MONEY >===========<\n");
            System.out.println(c.SPACER + "     AMOUNT     |  QTY & VALUE");
            System.out.println("  >-----------------|-----------------<");
            System.out.println(c.SPACER + " 1.  PHP 1000   |   " + ((vm.getBalance()).get(0)).getQuantity() + " - PHP " + ((vm.getBalance()).get(0)).getQuantity() * 1000);
            System.out.println(c.SPACER + " 2.  PHP 500    |   " + ((vm.getBalance()).get(1)).getQuantity() + " - PHP " + ((vm.getBalance()).get(1)).getQuantity() * 500);
            System.out.println(c.SPACER + " 3.  PHP 200    |   " + ((vm.getBalance()).get(2)).getQuantity() + " - PHP " + ((vm.getBalance()).get(2)).getQuantity() * 200);
            System.out.println(c.SPACER + " 4.  PHP 100    |   " + ((vm.getBalance()).get(3)).getQuantity() + " - PHP " + ((vm.getBalance()).get(3)).getQuantity() * 100);
            System.out.println(c.SPACER + " 5.  PHP 50     |   " + ((vm.getBalance()).get(4)).getQuantity() + " - PHP " + ((vm.getBalance()).get(4)).getQuantity() * 50);
            System.out.println(c.SPACER + " 6.  PHP 20     |   " + ((vm.getBalance()).get(5)).getQuantity() + " - PHP " + ((vm.getBalance()).get(5)).getQuantity() * 20);
            System.out.println(c.SPACER + " 7.  PHP 10     |   " + ((vm.getBalance()).get(6)).getQuantity() + " - PHP " + ((vm.getBalance()).get(6)).getQuantity() * 10);
            System.out.println(c.SPACER + " 8.  PHP 5      |   " + ((vm.getBalance()).get(7)).getQuantity() + " - PHP " + ((vm.getBalance()).get(7)).getQuantity() * 5);
            System.out.println(c.SPACER + " 9.  PHP 1      |   " + ((vm.getBalance()).get(8)).getQuantity() + " - PHP " + ((vm.getBalance()).get(8)).getQuantity());
        
            total = ((vm.getBalance()).get(0)).getQuantity() * 1000 + ((vm.getBalance()).get(1)).getQuantity() * 500 + ((vm.getBalance()).get(2)).getQuantity() * 200 +
                    ((vm.getBalance()).get(3)).getQuantity() * 100  + ((vm.getBalance()).get(4)).getQuantity() * 50  + ((vm.getBalance()).get(5)).getQuantity() * 20  +
                    ((vm.getBalance()).get(6)).getQuantity() * 10   + ((vm.getBalance()).get(7)).getQuantity() * 5   + ((vm.getBalance()).get(8)).getQuantity();

        
            System.out.println("\n" + s.centerString(c.GRN + "TOTAL : PHP " + total + c.RST, 51));
            System.out.println("\n" + s.centerString(c.BLU + "Enter [0] to Exit" + c.RST, 51));
            System.out.println("\n>=======================================<");
            
            String moneyDenominationIndex = "-1";
            String quantity = "0";
            
            System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
            while(Integer.parseInt(moneyDenominationIndex) < 0 || Integer.parseInt(moneyDenominationIndex) > 9) {
                
                moneyDenominationIndex = sc.nextLine();
                
                if(Integer.parseInt(moneyDenominationIndex) < 0 || Integer.parseInt(moneyDenominationIndex) > 9) {
                    System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
                }
            }
            int currentQuantity = (vm.getBalance()).get(Integer.parseInt(moneyDenominationIndex) - 1).getQuantity();
            
            if(Integer.parseInt(moneyDenominationIndex) > 0) {

                System.out.print(c.BLU + c.SPACER + "Enter Quantity : " + c.RST);
                while(Integer.parseInt(quantity) <= currentQuantity) {
                    
                    quantity = sc.nextLine();
                    
                    if(Integer.parseInt(quantity) <= currentQuantity) {
                        System.out.print(c.BLU + c.SPACER + "Select Valid Amount : " + c.RST);
                    }
                }
                // tempQuantity[Integer.parseInt(moneyDenominationIndex) - 1] -= Integer.parseInt(quantity);
                ((vm.getBalance()).get(Integer.parseInt(moneyDenominationIndex) - 1)).setQuantity(currentQuantity - Integer.parseInt(quantity));
            }

            if(Integer.parseInt(moneyDenominationIndex) == 0) {
                int i;

                for(i = 0; i < 9; i++)
                ((vm.getBalance()).get(i)).setQuantity(((vm.getBalance()).get(i)).getQuantity() + tempQuantity[i]);
                

                exitFlag = true;
            }
        }
        return total;
    }

    public float replenishMoneyMenu(VendingMachine vm) {
        int[] tempQuantity = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean exitFlag = false;
        float total = 0;
        while(!exitFlag) {

            System.out.println("\n>===========< COLLECT MONEY >===========<\n");
            System.out.println(c.SPACER + "     AMOUNT     |  QTY & VALUE");
            System.out.println("  >-----------------|-----------------<");
            System.out.println(c.SPACER + " 1.  PHP 1000   |   " + ((vm.getBalance()).get(0)).getQuantity() + " - PHP " + ((vm.getBalance()).get(0)).getQuantity() * 1000);
            System.out.println(c.SPACER + " 2.  PHP 500    |   " + ((vm.getBalance()).get(1)).getQuantity() + " - PHP " + ((vm.getBalance()).get(1)).getQuantity() * 500);
            System.out.println(c.SPACER + " 3.  PHP 200    |   " + ((vm.getBalance()).get(2)).getQuantity() + " - PHP " + ((vm.getBalance()).get(2)).getQuantity() * 200);
            System.out.println(c.SPACER + " 4.  PHP 100    |   " + ((vm.getBalance()).get(3)).getQuantity() + " - PHP " + ((vm.getBalance()).get(3)).getQuantity() * 100);
            System.out.println(c.SPACER + " 5.  PHP 50     |   " + ((vm.getBalance()).get(4)).getQuantity() + " - PHP " + ((vm.getBalance()).get(4)).getQuantity() * 50);
            System.out.println(c.SPACER + " 6.  PHP 20     |   " + ((vm.getBalance()).get(5)).getQuantity() + " - PHP " + ((vm.getBalance()).get(5)).getQuantity() * 20);
            System.out.println(c.SPACER + " 7.  PHP 10     |   " + ((vm.getBalance()).get(6)).getQuantity() + " - PHP " + ((vm.getBalance()).get(6)).getQuantity() * 10);
            System.out.println(c.SPACER + " 8.  PHP 5      |   " + ((vm.getBalance()).get(7)).getQuantity() + " - PHP " + ((vm.getBalance()).get(7)).getQuantity() * 5);
            System.out.println(c.SPACER + " 9.  PHP 1      |   " + ((vm.getBalance()).get(8)).getQuantity() + " - PHP " + ((vm.getBalance()).get(8)).getQuantity());
        
            total = ((vm.getBalance()).get(0)).getQuantity() * 1000 + ((vm.getBalance()).get(1)).getQuantity() * 500 + ((vm.getBalance()).get(2)).getQuantity() * 200 +
                    ((vm.getBalance()).get(3)).getQuantity() * 100  + ((vm.getBalance()).get(4)).getQuantity() * 50  + ((vm.getBalance()).get(5)).getQuantity() * 20  +
                    ((vm.getBalance()).get(6)).getQuantity() * 10   + ((vm.getBalance()).get(7)).getQuantity() * 5   + ((vm.getBalance()).get(8)).getQuantity();

        
            System.out.println("\n" + s.centerString(c.GRN + "TOTAL : PHP " + total + c.RST, 51));
            System.out.println("\n" + s.centerString(c.BLU + "Enter [0] to Exit" + c.RST, 51));
            System.out.println("\n>=======================================<");
            
            String moneyDenominationIndex = "-1";
            String quantity = "0";
            
            System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
            while(Integer.parseInt(moneyDenominationIndex) < 0 || Integer.parseInt(moneyDenominationIndex) > 9) {
                
                moneyDenominationIndex = sc.nextLine();
                
                if(Integer.parseInt(moneyDenominationIndex) < 0 || Integer.parseInt(moneyDenominationIndex) > 9) {
                    System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
                }
            }
            
            if(Integer.parseInt(moneyDenominationIndex) > 0) {
                int currentQuantity = (vm.getBalance()).get(Integer.parseInt(moneyDenominationIndex) - 1).getQuantity();

                System.out.print(c.BLU + c.SPACER + "Enter Quantity : " + c.RST);
                while(Integer.parseInt(quantity) <= 0) {
                    
                    quantity = sc.nextLine();
                    
                    if(Integer.parseInt(quantity) <= 0) {
                        System.out.print(c.BLU + c.SPACER + "Select Valid Amount : " + c.RST);
                    }
                }
                ((vm.getBalance()).get(Integer.parseInt(moneyDenominationIndex) - 1)).setQuantity(currentQuantity + Integer.parseInt(quantity));
            }

            else if(Integer.parseInt(moneyDenominationIndex) == 0) {
                int i;

                for(i = 0; i < 9; i++)
                ((vm.getBalance()).get(i)).setQuantity(((vm.getBalance()).get(i)).getQuantity() + tempQuantity[i]);
                

                exitFlag = true;
            }
        }
        return total;
    }
    
    // Vending Machine Balance
    
    public void vendingMachineBalanceMenu(VendingMachine vm) {
        float total;

        System.out.println("\n>==========< CURRENT BALANCE >==========<\n");
        System.out.println(c.SPACER + "     AMOUNT     |  QTY & VALUE");
        System.out.println("  >-----------------|-----------------<");
        System.out.println(c.SPACER + " 1.  PHP 1000   |   " + ((vm.getBalance()).get(0)).getQuantity() + " - PHP " + ((vm.getBalance()).get(0)).getQuantity() * 1000);
        System.out.println(c.SPACER + " 2.  PHP 500    |   " + ((vm.getBalance()).get(1)).getQuantity() + " - PHP " + ((vm.getBalance()).get(1)).getQuantity() * 500);
        System.out.println(c.SPACER + " 3.  PHP 200    |   " + ((vm.getBalance()).get(2)).getQuantity() + " - PHP " + ((vm.getBalance()).get(2)).getQuantity() * 200);
        System.out.println(c.SPACER + " 4.  PHP 100    |   " + ((vm.getBalance()).get(3)).getQuantity() + " - PHP " + ((vm.getBalance()).get(3)).getQuantity() * 100);
        System.out.println(c.SPACER + " 5.  PHP 50     |   " + ((vm.getBalance()).get(4)).getQuantity() + " - PHP " + ((vm.getBalance()).get(4)).getQuantity() * 50);
        System.out.println(c.SPACER + " 6.  PHP 20     |   " + ((vm.getBalance()).get(5)).getQuantity() + " - PHP " + ((vm.getBalance()).get(5)).getQuantity() * 20);
        System.out.println(c.SPACER + " 7.  PHP 10     |   " + ((vm.getBalance()).get(6)).getQuantity() + " - PHP " + ((vm.getBalance()).get(6)).getQuantity() * 10);
        System.out.println(c.SPACER + " 8.  PHP 5      |   " + ((vm.getBalance()).get(7)).getQuantity() + " - PHP " + ((vm.getBalance()).get(7)).getQuantity() * 5);
        System.out.println(c.SPACER + " 9.  PHP 1      |   " + ((vm.getBalance()).get(8)).getQuantity() + " - PHP " + ((vm.getBalance()).get(8)).getQuantity());
        
        total = ((vm.getBalance()).get(0)).getQuantity() * 1000 + ((vm.getBalance()).get(1)).getQuantity() * 500 + ((vm.getBalance()).get(2)).getQuantity() * 200 +
                ((vm.getBalance()).get(3)).getQuantity() * 100  + ((vm.getBalance()).get(4)).getQuantity() * 50  + ((vm.getBalance()).get(5)).getQuantity() * 20  +
                ((vm.getBalance()).get(6)).getQuantity() * 10   + ((vm.getBalance()).get(7)).getQuantity() * 5   + ((vm.getBalance()).get(8)).getQuantity();

        
        System.out.println("\n" + s.centerString(c.GRN + "TOTAL : PHP " + total + c.RST, 51));
        System.out.println("\n" + s.centerString(c.BLU + "Enter [0] to Exit" + c.RST, 51));
        System.out.println("\n>=======================================<");
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
        // String input = "0";
        int input = 0;

        String tempName = "__________";
        float tempPrice = 0;
        float tempCalories = 0;
        int tempInitStock = -1;

        System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
        while(input < 1 || input > 3) {

            input = sc.nextInt();
            sc.nextLine();

            if(input < 1 || input > 3) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
            }
        }

        // System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
        // while(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 3) {

        //     input = sc.nextLine();

        //     if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 3) {
        //         System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
        //     }
        // }

        switch(input) {
        // switch(Integer.parseInt(input)) {
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

        // return Integer.parseInt(input);
        return input;

    }

    // Create Special Vending Machine

    public void createSpecialVendingMachineMenu() {
        System.out.println("\n>=============< CREATE VM >=============<\n");
        System.out.println(s.centerString(c.RED + "RESERCED FOR MCO2" + c.RST, 51));
        System.out.println("\n" + s.centerString(c.BLU + "Enter [0] to Exit" + c.RST, 51));
        System.out.println("\n>=======================================<");
    }

    public int createSpecialVendingMachineInput() {
        String input = "-1";

        System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
        while(Integer.parseInt(input) != 0) {
    
            input = sc.nextLine();
    
            if(Integer.parseInt(input) != 0) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
            }
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

    // Vending Features

    public void vendingFeaturesMenu() {
        System.out.println("\n>=========< VENDING  FEATURES >=========<\n");
        System.out.println(c.SPACER + "1. Insert Payment");
        System.out.println(c.SPACER + "2. Select Item");
        System.out.println(c.SPACER + "3. Exit");
        System.out.println("\n>=======================================<");
    }

    public int vendingFeaturesInput() {
        String input = "0";

        System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
        while(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 3) {

            input = sc.nextLine();

            if(Integer.parseInt(input) < 3 || Integer.parseInt(input) > 3) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
            }
        }
        return Integer.parseInt(input);
    }

    public void acceptPaymentMenu() {
        
    }

    // Maintenance Features

    public void maintenanceFeaturesMenu() {
        System.out.println("\n>=======< MAINTENANCE  FEATURES >=======<\n");
        System.out.println(c.SPACER + "1. Stock Item");
        System.out.println(c.SPACER + "2. Set Item Price");
        System.out.println(c.SPACER + "3. Collect Earnings");
        System.out.println(c.SPACER + "4. Replenish Money");
        System.out.println(c.SPACER + "5. Transaction Summary");
        System.out.println(c.SPACER + "6. Exit");
        System.out.println("\n>=======================================<");
    }
    
    public boolean maintenanceFeaturesInput(VendingMachine vm) { // Add Features
        int input = 0;

        int itemIndex;
        int stock = -1;
        float price = -1;


        System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
        while(input < 1 || input > 6) {

            input = sc.nextInt();
            sc.nextLine();

            if(input < 1 || input > 6) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
            }
        }

        
        
        switch(input) {
            case 1 : // Stock Item
                System.out.println("\n>=============< ITEM LIST >=============<\n");
                displayItemList(vm.getItemList());
                System.out.println("\n>=======================================<");
            
                itemIndex = selectItem(vm);  
                
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
                System.out.println("\n>=============< ITEM LIST >=============<\n");
                displayItemList(vm.getItemList());
                System.out.println("\n>=======================================<");
            
                itemIndex = selectItem(vm);  

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
                collectPaymentMenu(vm);
                break;
            case 4 : // Replenish Money
                replenishMoneyMenu(vm);
                break;
            case 5 : // Transaction Summary
                vm.transactionSummary(vm.getTransactionHistory());
                break;
            case 6 :
                return true;
        }
        return false;
    }


    // Vending Machine

    public void vendingMachineMenu(VendingMachine vm, float currentBalance) {
        // System.out.println(sc.hasNextLine());
        System.out.println("\n>==========< VENDING MACHINE >==========<\n");

        System.out.println(s.centerString(c.BLU + vm.getName() + c.RST, 51));

        displayItemList(vm.getItemList());

        System.out.println(c.BLU + "\n" + c.SPACER + "NOTE: Color indicates availability!" + c.RST);
        System.out.println("\n" + s.centerString(c.GRN + "Current Balance : PHP " + currentBalance + c.RST, 51));
        System.out.println("\n" + s.centerString(c.BLU + "Enter [0] to Exit" + c.RST, 51));
        System.out.println("\n>=======================================<");
    }

    public int vendingMachineInput(VendingMachine vm) {
        String input = "-1";

        System.out.print(c.BLU + "\n" + c.SPACER + "Select Item to Inspect : " + c.RST);
        while(Integer.parseInt(input) < 0 || Integer.parseInt(input) > (vm.getItemList()).size()) {

            input = sc.nextLine();

            if(Integer.parseInt(input) < 0 || Integer.parseInt(input) > (vm.getItemList()).size()) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Item : " + c.RST);
            }
        }

        return Integer.parseInt(input);
    }

    // Item Menu

    public boolean itemMenu(VendingMachine vm, Item  item, float currentBalance) {
        System.out.println("\n>=============< ITEM MENU >=============<\n");

        System.out.println(s.centerString(item.getName(), 41));
        System.out.println(s.centerString(c.YLW + "(" + item.getCalories() + " cal" + ")" + c.RST, 53));
        System.out.println();
        System.out.println(s.centerString(c.BLU + "PHP " + item.getPrice() + c.RST, 51));
        if(item.getStock() > 0)
            System.out.println(s.centerString(c.BLU + item.getStock() + " Left in Machine" + c.RST, 51));
        else
            System.out.println(s.centerString(c.RED + item.getStock() + " Left in Machine" + c.RST, 51));
            

        System.out.println("\n" + s.centerString(c.GRN + "Current Balance : PHP " + currentBalance + c.RST, 51));
        System.out.println("\n  >-----------------------------------<");
        System.out.println("\n" + c.SPACER + "1. Purchase");
        System.out.println(c.SPACER + "2. Exit");

        System.out.println("\n>=======================================<");


        String input = "0";

        System.out.print(c.BLU + "\n" + c.SPACER + "Select Option : " + c.RST);
        while(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 2) {

            input = sc.nextLine();

            if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 2) {
                System.out.print(c.BLU + c.SPACER + "Select Valid Option : " + c.RST);
            }

            switch(Integer.parseInt(input)) {
                case 1 : // Purchase
                    if(currentBalance < item.getPrice()) {
                        System.out.println(s.centerString(c.RED + "ERROR! Insufficient Balance" + c.RST, 51));
                        return false;
                    }
                    if(item.getStock() < 1) {
                        System.out.println(s.centerString(c.RED + "ERROR! Item is out of stock." + c.RST, 51));
                        return false;
                    }
                    else {
                        System.out.println(s.centerString(c.GRN + "Purchase successful!" + c.RST, 51));
                        System.out.println(s.centerString(c.BLU + "Dispensing item..." + c.RST, 51));
                        item.setStock(item.getStock() - 1);
                        return true;
                    }
                case 2 : // Exit
                    return false;
            }
        }
        return false;
    }
}
