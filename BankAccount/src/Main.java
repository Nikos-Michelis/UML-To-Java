import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void TransactionMenu(){
        System.out.println("1 - Deposit: ");
        System.out.println("2 - Withdraw: ");
        System.out.println("3 - Purchase: ");
        System.out.println("4 - Exit:");
        System.out.print("Your Choice: ");
    }
    public static void main(String[] args) {
        int CardChoice = -1, TransactionChoice, withdrawAmount;
        double DepositAmount, PurchaseAmount;
        ArrayList<Object> ArrayCards = new ArrayList<>();
        CardCreation creation = new CardCreation();
        Random random = new Random(500);

        try (Scanner sc = new Scanner(System.in)) {
            Owner owner = creation.CreateOwner(sc);
            creation.CreateCard(sc, ArrayCards, owner);
            System.out.println("___Transactions___");

            System.out.print("Choose a card for Transactions CashCard(press 1) or CreditCard(press 2) or (press 0 to exit): ");
            CardChoice = sc.nextInt();
            while (CardChoice != 0) {
                switch (CardChoice) {
                    case 1:
                        for (Object elem : ArrayCards) {
                            // checking the type of the object whether is CashCard or CreditCard
                            if (elem instanceof CashCard) {
                                System.out.println("___CashCard Transactions___");
                                TransactionMenu();
                                if (sc.hasNextInt()) {
                                    TransactionChoice = sc.nextInt();
                                    while (TransactionChoice != 4) {
                                        switch (TransactionChoice) {
                                            case 1:
                                                System.out.print("Amount for Deposit: ");
                                                DepositAmount = sc.nextDouble();
                                                ((CashCard) elem).deposit(DepositAmount);
                                                System.out.println(elem.toString());
                                                TransactionMenu();
                                                TransactionChoice = sc.nextInt();
                                                break;
                                            case 2:
                                                System.out.print("Amount for Withdraw: ");
                                                withdrawAmount = sc.nextInt();
                                                ((CashCard) elem).withdraw(withdrawAmount);
                                                System.out.println(elem.toString());
                                                TransactionMenu();
                                                TransactionChoice = sc.nextInt();
                                                break;
                                            case 3:
                                                PurchaseAmount = 100 + random.nextInt(500);
                                                System.out.print("Payment: " + PurchaseAmount);
                                                System.out.println(", Current Balance: " + ((CashCard) elem).getBalance());
                                                ((CashCard) elem).purchase(PurchaseAmount);
                                                System.out.println(elem.toString());
                                                TransactionMenu();
                                                TransactionChoice = sc.nextInt();
                                                break;
                                            case 4:
                                                exit(0);
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        for (Object elem : ArrayCards) {
                            // checking the type of the object whether is CashCard or CreditCard
                            if (elem instanceof CreditCard) {
                                System.out.println("CreditCard");
                                TransactionMenu();
                                if (sc.hasNextInt()) {
                                    TransactionChoice = sc.nextInt();
                                    while (TransactionChoice != 4) {
                                        switch (TransactionChoice) {
                                            case 1:
                                                System.out.print("Amount for Deposit: ");
                                                DepositAmount = sc.nextDouble();
                                                ((CreditCard) elem).deposit(DepositAmount);
                                                System.out.println(elem.toString());
                                                TransactionMenu();
                                                TransactionChoice = sc.nextInt();
                                                break;
                                            case 2:
                                                System.out.print("Amount for Withdraw: ");
                                                withdrawAmount = sc.nextInt();
                                                ((CreditCard) elem).withdraw(withdrawAmount);
                                                System.out.println(elem.toString());
                                                TransactionMenu();
                                                TransactionChoice = sc.nextInt();
                                                break;
                                            case 3:
                                                PurchaseAmount = 100 + random.nextDouble();
                                                System.out.println("Payment: " + PurchaseAmount);
                                                System.out.println("Current Balance: " + ((CreditCard) elem).getCreditLimit());
                                                ((CreditCard) elem).purchase(PurchaseAmount);
                                                System.out.println(elem.toString());
                                                TransactionMenu();
                                                TransactionChoice = sc.nextInt();
                                                break;
                                            case 4:
                                                exit(0);
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                }
                System.out.print("Choose a card for Transactions CashCard(press 1) or CreditCard(press 2) or (press 0 to exit): ");
                CardChoice = sc.nextInt();
            }
        }
    }
}