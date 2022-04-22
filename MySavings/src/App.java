import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
public class App {
    
    static Scanner scmain = new Scanner (System.in);

    public static void enterToContinue () {
        System.out.println("\nPress \"ENTER\" to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
        ClearScreen();
    }

    public static void ClearScreen (){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    
    public static void main(String[] args) throws Exception {
        selectedChoice chosenMenu = new selectedChoice();
        boolean mainLoop = false;

        while (!mainLoop){
        System.out.print("MY SAVINGS \n[1] - Show total in bank"
        + "\n[2] - Add a penny" + "\n[3] - Add a nickel" + "\n[4] - Add a dime"
        + "\n[5] - Add a quarter" + "\n[6] - Take money out of bank"
        + "\n[0] - Enter 0 to quit" + "\n\nEnter your choice: ");

        try {
            int mainchoice = scmain.nextInt();
            switch (mainchoice){
                case 1:
                chosenMenu.showTotal();
                    break;

                case 2:
                chosenMenu.addMoney(1, "Penny");
                    break;

                case 3:
                chosenMenu.addMoney(5, "Nickel");
                    break;

                case 4:
                chosenMenu.addMoney(10, "Dime");
                    break;

                case 5:
                chosenMenu.addMoney(25, "Quarter");
                    break;

                case 6:
                chosenMenu.subMoney();
                    break;

                case 0:
                    System.out.println("Bye have a nice day!");
                    mainLoop = true;
                    break;

                default:
                    System.out.println("Invalid input. Try again.");
            }
        }

        catch (InputMismatchException strInput){
            System.out.println("Error! Invalid Choice. Try again.");
            scmain.nextLine();
        }

        enterToContinue();
        ClearScreen();
    }


    }
}
