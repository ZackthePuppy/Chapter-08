import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);

    public static void Line() {
        for (int x = 0; x <= 80; x++) {
            System.out.print("=");
        }
    }

    public static void singleLine() {
        for (int x = 0; x <= 80; x++) {
            System.out.print("-");
        }
    }

    public static void main(String[] args) throws Exception {
        Line();
        System.out.println("\nLUNCH ORDER");
        String format = "%-15s %15s %10s %20s %10s";

        double hamburgerPrice = 1.85, saladPrice = 2.00, ffPrice = 1.30, sodaPrice = 0.95, totalPrice;
        int hamburgerQty, saladQty, ffQty, sodaQty;

        System.out.format(format, "ITEM", "PRICE", "FAT(g)", "CARBOHYDRATES(g)", "FIBER(g)" + "\n");
        singleLine();
        System.out.println();
        System.out.format(format, "Hamburger", hamburgerPrice, "9", "33", "1" + "\n");
        System.out.format(format, "Salad", saladPrice, "1", "11", "5" + "\n");
        System.out.format(format, "French Fries", ffPrice, "11", "36", "4" + "\n");
        System.out.format(format, "Soda", sodaPrice, "0", "38", "0" + "\n");
        Line();

        try {
            System.out.print("\nEnter number of Hamburger/s: ");
            hamburgerQty = sc.nextInt();
            System.out.println("Each Hamburger has 9g of FAT, 33g of CARBS, and 1g of FIBER.\n");

            System.out.print("Enter number of Salad/s: ");
            saladQty = sc.nextInt();
            System.out.println("Each Salad has 1g of FAT, 11g of CARBS, and 5g of FIBER.\n");

            System.out.print("Enter number of Fries: ");
            ffQty = sc.nextInt();
            System.out.println("French Fries have 11g of FAT, 36g of CARBS, and 4g of FIBER.\n");

            System.out.print("Enter number of Soda/s: ");
            sodaQty = sc.nextInt();
            System.out.println("Each Soda has zero FAT, 38g of CARBS, and also zero FIBER.\n");

            totalPrice = ((hamburgerPrice * hamburgerQty) + (saladPrice * saladQty) + (ffPrice * ffQty)
                    + (sodaPrice * sodaQty));

            System.out.format("Your order comes to: $%.2f", totalPrice);
        } catch (InputMismatchException wrongInput) {
            System.out.println("You entered string, not number.");
        }
    }
}
