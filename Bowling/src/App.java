import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static gameprocess bowl = new gameprocess();
    static Scanner sc = new Scanner(System.in);
    static boolean mainLoop = false;

    public static void Line() {
        for (int x = 0; x <= 20; x++) {
            System.out.print("==");
        }
    }

    public static void longerLine() {
        for (int x = 0; x <= 45; x++) {
            System.out.print("==");
        }
    }

    public static void enterToContinue() {
        System.out.println("\nPress \"ENTER\" to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
        ClearScreen();
    }

    public static void ClearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    }

    public static void main(String[] args) throws Exception {
        clearConsole();

        while (!mainLoop){
        Line();
        String format = "%-5s %-33s %2s";
        System.out.println();
        System.out.format(format, "||", "BOWLING GAME", "||" + "\n");
        System.out.format(format, "||","Up to 10 players!", "||" +"\n");
        System.out.format(format, "||","You can Bowl up to 10 Frames", "||" +"\n");
        System.out.format(format, "||","Each Frame has 2 Throws", "||" +"\n");
        System.out.format(format, "||","Press 0 to Quit", "||" +"\n");
        Line();
        System.out.println();

        System.out.print("How many players? (Maximum of 10): ");

        try {
            int player = sc.nextInt();

            if (player > 10 || player < 0){
                System.out.println("Cannot play with more than 10 players OR...\nYou have typed negative number!");
                enterToContinue();
            }

            else if (player == 0){
                System.out.println("Thank you for playing!");
                mainLoop = true;
            }

            else {
                for (int x = 1; x <= player; x++){
                    if (player == x){
                        bowl.play(x);
                    }
                }
            }

        } catch (InputMismatchException wrongInput) {
            System.out.println("Invalid input, please try again.");
            sc.nextLine();
            enterToContinue();
        }

    }

}
}
