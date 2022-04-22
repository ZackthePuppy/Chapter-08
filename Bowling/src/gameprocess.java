import java.util.Random;
import java.util.Scanner;

public class gameprocess {

    bowlingdata bowlInfo = new bowlingdata();
    Scanner sc = new Scanner(System.in);
    Random r = new Random();
    String format = "%-11s %7s %7s %7s %7s %7s %7s %7s %7s %7s %7s";
    String format2 = "%-5s %5s";

    public void enterToContinue() {
        System.out.println("Press ENTER to proceed to next player/frame...");
        sc.nextLine();
    }

    private int getStrLen(String... strings) {
        int len = Integer.MIN_VALUE;
        for (String str : strings) {
            len = Math.max(str.length(), len);
        }
        return len;
    }

    private String padString(String str, int len) {
        StringBuilder sb = new StringBuilder(str);
        return sb.append(fill(' ', len - str.length())).toString();
    }

    private String fill(char ch, int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public void printBox(String... strings) {
        int maxBoxWidth = getStrLen(strings);
        String line = "+" + fill('-', maxBoxWidth + 2) + "+";
        System.out.println("\n" + line);
        for (String str : strings) {
            System.out.printf("| %s |%n", padString(str, maxBoxWidth));
        }
        System.out.println(line);
    }

    public void play(int players) {
        for (int frames = 1; frames < 11; frames += 1) {
            bowlInfo.setScore("\nFRAME (" + frames + ") ==>>");

            for (int x = 1; x <= players; x++) {

                App.Line();
                System.out.print("SCORES");
                App.Line();
                System.out.print("\nPlayer =====>> ");

                for (int dis = 1; dis <= players; dis++) {
                    System.out.print("\t" + dis);
                }

                System.out.print(bowlInfo.getScore());
                printBox("Frame: " + frames + " Player: " + x + "'s TURN!");
                bowlInfo.setPins(10);
                int pins = bowlInfo.getPins();
                bowlInfo.setFailScore(0);
                int failScore = bowlInfo.getFailScore();

                for (int chance = 1; chance <= 2; chance++) {
                    System.out.print("Throw(" + chance + "): ");
                    int player = r.nextInt(pins + 1);
                    pins -= player;
                    if (chance == 1) {
                        if (player == 10) {
                            bowlInfo.setScore("20");
                            System.out.print(player + " STRIKE");
                            failScore += 20;
                            chance++;
                        } else if (player != 10) {
                            System.out.print(player + "\t");
                            failScore += player;
                        }
                    } else if (chance == 2) {
                        if (pins == 0) {
                            bowlInfo.setScore("15");
                            System.out.print(player + " STRIKE ");
                            failScore = 15;
                        } else if (pins != 0) {
                            failScore += player;
                            System.out.print(player + "\t");
                            bowlInfo.setScore(failScore + "");
                        }
                    }
                }
                printBox("SCORE: " + failScore);
                enterToContinue();
                App.clearConsole();
            }
        }

        App.clearConsole();

        App.Line();
        System.out.print("FINAL SCORE");
        App.Line();

        System.out.print("\nPlayer =====>>");
        for (int dis = 1; dis <= players; dis++) {
            System.out.print("\t" + dis);
        }

        System.out.println(bowlInfo.getScore());
        App.longerLine();

        System.out.print("\nDo you want to play again? [Y] - Yes [AnyKey] - No: ");
        String again = sc.next();

        if (again.equalsIgnoreCase("Y")) {
            System.out.println("Okay, lets go back to main menu");
            App.enterToContinue();
        } else {
            System.out.println("Thank you for Playing!!");
            App.mainLoop = true;
        }

    }

}
