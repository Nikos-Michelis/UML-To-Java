import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CardCreation {
    private int choice = 1;
    private double withdrawLimit = 0, purchaseLimit = 0;
    private double creditLimit = 0, interestRate = 0;
    private String  Username, ID;
    private String birthYear;
    private Owner NewOwner;
    CardCreation(){

    }
    public Date ValidDate(String birthYear){

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date ValidBirthYear = null;
        try {
            //Parsing the String
            ValidBirthYear = dateFormat.parse(birthYear);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ValidBirthYear;
    }
    public Owner CreateOwner(Scanner sc){
            System.out.println("____Bank_DB - Create owner: Owner's personal information____");
            System.out.print("Username: ");
            Username = sc.nextLine();
            System.out.print("ID: ");
            ID = sc.nextLine();
            System.out.print("BirthYear (Format: Date-Month-Year): ");
            birthYear = sc.next();
            Owner owner = new Owner(Username, ID, ValidDate(birthYear));
            NewOwner = owner;
            return NewOwner;
    }
    public ArrayList<Object> CreateCard(Scanner sc, ArrayList<Object> ArrayCards, Owner owner){

        while (choice != 0) {
            System.out.println("____Bank_DB - Create a Card: Create types of cards____");
            System.out.print("Choose a type of card you want to create CashCard (input 1) or CreditCard (input 2)? or (input 0) to quit : ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("____Bank_DB: CashCard Creation____");
                        System.out.print("Give withdraw Limit: ");
                        withdrawLimit = sc.nextDouble();
                        System.out.print("Give purchase Limit: ");
                        purchaseLimit = sc.nextDouble();
                        CashCard cashCard = new CashCard(Year.now().getValue(),(Year.now().getValue() + 5),owner, withdrawLimit, purchaseLimit,0);
                        ArrayCards.add(cashCard);
                        break;
                    case 2:
                        System.out.println("____CreditCard Creation____");
                        System.out.print("Give credit Limit: ");
                        creditLimit = sc.nextDouble();
                        System.out.print("Give interest Rate: ");
                        interestRate = sc.nextDouble();
                        CreditCard creditCard = new CreditCard(Year.now().getValue(),(Year.now().getValue() + 5),owner, creditLimit, interestRate);
                        ArrayCards.add(creditCard);
                        break;
                }
            }else{
                System.out.println("Error only integer: choice between 1 and 2 or 0 to exit");
                sc.next();
            }
        }
        return ArrayCards;
    }
}
