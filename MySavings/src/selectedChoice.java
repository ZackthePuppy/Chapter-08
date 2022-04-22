import java.util.InputMismatchException;
import java.util.Scanner;

public class selectedChoice {

    Scanner scadd = new Scanner(System.in);
    piggybankdata piggy = new piggybankdata();

    public void addSuccess(String coin, float value) {
        System.out.println("Success! You have added " + value + " in your " + coin);
    }

    public void addMoney(float value, String coinName) {
        App.ClearScreen();
        System.out.print("Add a " + coinName + "\nHow Much? ");

        try {
            float addCoin = scadd.nextFloat();

            if (addCoin <= 0) {
                System.out.println("Error! Cannot add negative/zero number!");
                App.enterToContinue();
            }

            else if (coinName == "Penny") {
                piggy.setPenny(addCoin);
                addSuccess(coinName, addCoin / 100);
            }

            else if (coinName == "Nickel") {
                piggy.setNickel(addCoin, value);
                addSuccess(coinName, (addCoin * 5) / 100);
            }

            else if (coinName == "Dime") {
                piggy.setDime(addCoin, value);
                addSuccess(coinName, (addCoin * 10) / 100);
            }

            else if (coinName == "Quarter") {
                piggy.setQuarter(addCoin, value);
                addSuccess(coinName, (addCoin * 25) / 100);
            }

            else {
                System.out.println("Invalid Input. Sorry for inconvenience.");
                App.enterToContinue();
            }
        } catch (InputMismatchException strInput) {
            System.out.println("This is a character. Sorry");
            scadd.nextLine();
        }

    }

    public void subSuccess(String coinName, float withdrawed) {
        System.out.println("Success! You have taken " + withdrawed + " in your " + coinName);

    }

    public void subProcess(String coinName, float getMoney, float subCoin, float value) {
        if (((subCoin * value) / 100) > getMoney) {
            System.out.println("Error! Too much withdraw, not enough balance.");
        } else if (subCoin == 0) {
            System.out.println("Error! You cannot withdraw zero!");
        } else if (coinName == "Penny") {
            piggy.subPenny(subCoin);
            subSuccess(coinName, (subCoin * value) / 100);
        } else if (coinName == "Nickel") {
            piggy.subNickel(subCoin, value);
            subSuccess(coinName, (subCoin * value) / 100);
        } else if (coinName == "Dime") {
            piggy.subDime(subCoin, value);
            subSuccess(coinName, (subCoin * value) / 100);
        } else if (coinName == "Quarter") {
            piggy.subQuarter(subCoin, value);
            subSuccess(coinName, (subCoin * value) / 100);
        }

    }

    public void subMoney() {
        App.ClearScreen();
        float subMoney;
        System.out.print(
                "Choose which money \n[1] - Penny \n[2] - Nickel \n[3] - Dime \n[4] - Quarter \n[5] - ALL \n[6] - BACK \nChoose: ");

        try {
            int coinChoose = scadd.nextInt();
            switch (coinChoose) {
                case 1:
                    App.ClearScreen();
                    System.out.print("Withdraw a Penny\nHow Much? ");
                    subMoney = scadd.nextFloat();
                    subProcess("Penny", piggy.getPenny(), subMoney, 1);
                    break;
                case 2:
                    App.ClearScreen();
                    System.out.print("Withdraw a Nickel\nHow Much? ");
                    subMoney = scadd.nextFloat();
                    subProcess("Nickel", piggy.getNickel(), subMoney, 5);
                    break;
                case 3:
                    App.ClearScreen();
                    System.out.print("Withdraw a Dime\nHow Much? ");
                    subMoney = scadd.nextFloat();
                    subProcess("Dime", piggy.getDime(), subMoney, 10);
                    break;
                case 4:
                    App.ClearScreen();
                    System.out.print("Withdraw a Quarter\nHow Much? ");
                    subMoney = scadd.nextFloat();
                    subProcess("Quarter", piggy.getQuarter(), subMoney, 25);
                    break;
                case 5:
                boolean contLoop = false; 
                while (!contLoop){
                    System.out.print("Are you sure to take it all? [Y]/[N]: ");
                    String takeAll = scadd.next();

                    if (takeAll.equals("Y") || takeAll.equals("y")){
                        piggy.takeAll(0, 0, 0, 0, 0);
                        System.out.println("You have taken it all!");
                        contLoop = true;
                    }
                    else if (takeAll.equals("N") || takeAll.equals("n")){
                        System.out.println("Okay! Let's go back.");
                        contLoop = true;
                    }
                    else {
                        System.out.println("Invalid selection!");
                        scadd.nextLine();
                        App.enterToContinue();
                        App.ClearScreen();
                    }
                }
                case 6:
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } catch (InputMismatchException strInput) {
            System.out.println("Invalid Choice, Try again.");
            scadd.nextLine();
        }

    }

    public void showTotal() {
        App.ClearScreen();
        System.out.println("TOTAL MONEY IN BANK");
        String format = "%-15s %20s";
        System.out.format(format, "COIN", "VALUE" + "\n");
        System.out.format(format, "Penny", piggy.getPenny() + "\n");
        System.out.format(format, "Nickel", piggy.getNickel() + "\n");
        System.out.format(format, "Dime", piggy.getDime() + "\n");
        System.out.format(format, "Quarter", piggy.getQuarter() + "\n");
        System.out.format(format, "\nTOTAL: ", piggy.getTotal());
        System.out.println();

    }

}
