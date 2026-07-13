import java.util.Scanner;

public class Main {

    public static void welcomeMessage() {
        System.out.println("=== Welcome to ATM ===");
        System.out.println("======================\n");
    }

    public static boolean logIn() {
        boolean logIn = false;
        String correctPIN = "1234";
        int count = 0;
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Please Enter a 4-digit PIN: ");
            String pin = input.nextLine();

            if (pin.length() != 4) {
                System.out.println("\nThe PIN must be 4 digits!\n");
                count++;
            }

            else if (pin.equals(correctPIN)) {
                logIn = true;
                System.out.println("\nYou have successfully logged in!\n");
            }

            else {
                System.out.println("\nInvalid PIN!\n");
                count++;
            }

            if (count >= 3 && !logIn) {
                System.out.println("\nYour account has been locked.\n");
                System.exit(0);
            }

        } while (!logIn && count < 3);

        System.out.println("===============================\n");
        return logIn;
    }

    public static void mainMenu() {
        System.out.println("===== ATM Menu =====");
        System.out.println("====================\n");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Show Account Status");
        System.out.println("5. Exit\n");
    }

    public static void checkBalance(float balance) {

        if(balance <= 0)
            System.out.println("Warning: Your account is empty.");
    }

    public static float deposit(float balance, float amount) {
        return balance + amount;
    }

    public static float withdraw(float balance, float amount) {
        return balance - amount;
    }

    public static void showAccountStatus(float balance) {

        if(balance >= 5000) {
            System.out.println("\nYour Account Status is: VIP Customer\n");
        }

        else if(balance >= 1000) {
            System.out.println("\nYour Account Status is: Regular Customer\n");
        }

        else if (balance < 1000) {
            System.out.println("\nYour Account Status is: Low Balance\n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float balance = 2500.75F;
        int countWithDraw = 0;
        int countDeposit = 0;

        welcomeMessage();

        boolean logged = logIn();

        while (logged) {

            mainMenu();
            System.out.print("Please Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nYour Balance is: " + balance);
                    System.out.println("===============================\n");

                    break;

                case 2:
                    System.out.print("\nEnter amount to deposit: ");
                    float amount = sc.nextFloat();

                    if (amount > 0) {
                        balance = deposit(balance, amount);
                        countDeposit++;
                        System.out.println("\nThe Deposit operation is done successfully!\n");
                        System.out.println("Your Balance now is: " + balance);
                    }

                    else {
                        System.out.println("\nInvalid amount.");
                    }

                    System.out.println("=============================================\n");

                    break;

                case 3:
                    System.out.print("\nEnter amount to withdraw: ");
                    float amountt = sc.nextFloat();

                    if (amountt > 0 && amountt <= balance) {
                        balance = withdraw(balance, amountt);
                        countWithDraw++;
                        System.out.println("\nThe WithDraw operation is done successfully!\n");
                        System.out.println("Your Balance now is: " + balance);
                    }

                    else if (amountt == 0) {
                        System.out.println("\nTransaction Canceled.");
                    }

                    else {
                        System.out.println("\nInsufficient balance.");
                    }

                    System.out.println("=============================================\n");

                    break;

                case 4:
                    showAccountStatus(balance);
                    System.out.println("===============================\n");

                    break;

                case 5:
                    System.out.println("\nThank you for using our ATM.\n");
                    System.out.println("You have done " + countDeposit + " successful deposit(s).\n");
                    System.out.println("You have done " + countWithDraw + " successful withdraw(s).\n");

                    System.out.println("Goodbye:)\n");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nInvalid option");
            }

            checkBalance(balance);
        }
    }
}