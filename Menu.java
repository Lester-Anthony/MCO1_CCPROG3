import java.util.ArrayList;
import java.util.Scanner;


public class Menu {

    Constants c = new Constants();
    StringSystem s = new StringSystem();
    Scanner sc = new Scanner(System.in);
    public Menu(){}

    // Main Menu

    public void mainMenu() {

        System.out.println("\n>=============< MAIN MENU >=============<\n");
        System.out.println(c.SPACER + "1. Create Vending Machine");
        System.out.println(c.SPACER + "2. Test Vending Machine");
        System.out.println(c.SPACER + "3. Exit");
        System.out.println("\n>=======================================<");

    }
    public int mainMenuInput() {
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

    // Vending Machine

    public void vendingMachineMenu(VendingMachine vendingMachine, ArrayList<Item> itemList) {
        int nItem = 1;
        // System.out.println(sc.hasNextLine());
        System.out.println("\n>==========< VENDING MACHINE >==========<\n");

        for( Item item : itemList) {
            if(item.getStock() == 0)
                System.out.println(c.RED + c.SPACER + nItem + ". " + item.getName() + c.RST + " : N/A");
            else
                System.out.println(c.GRN + c.SPACER + nItem + ". " + item.getName() + c.RST);
            nItem++;
        }

        System.out.println(c.BLU + "\n" + c.SPACER + "NOTE: Color indicates availability!" + c.RST);

        System.out.println("\n>=======================================<");
    }

    public int vendingMachineMenuInput(VendingMachine vendingMachine, ArrayList<Item> itemList) {
        String input = "0";

        System.out.print(c.BLU + "\n" + c.SPACER + "Select Item to Inspect : " + c.RST);
        while(Integer.parseInt(input) < 1 || Integer.parseInt(input) > itemList.size()) {

            input = sc.nextLine();

            if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > itemList.size()) {
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
