import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Marketplace {
    ArrayList<File> userFiles = new ArrayList<>();

    public static final String WELCOME_PROMPT = "Welcome to our Marketplace!";
    public static final String ENTER_YOUR_USERNAME = "Please enter your username";
    public static final String SIGN_IN_PROMPT = "1: Sign In\n2: Create an account";
    public static final String PASSWORD_PROMPT = "Please enter a password greater than 5 characters:";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_PROMPT);
        System.out.println(SIGN_IN_PROMPT);
        String response = scanner.nextLine();

        // global variables
        boolean isSeller = true;
        boolean isBuyer = true;

        if ("1".equals(response)) { // if they want to sign in
            System.out.println(ENTER_YOUR_USERNAME);
            String username = scanner.nextLine();

            

            System.out.println(PASSWORD_PROMPT);
            String password = scanner.nextLine();

            // case of invalid password
            if (password == null || password.length() <= 5) {
                boolean validPassword = false;
                while (!validPassword) {
                    System.out.println("Invalid password. Please enter a valid Password:");
                    password = scanner.nextLine();
                    if (password != null && password.length() > 5) {
                        validPassword = true;
                    }
                }
            }

            // zeyad start here
            


            


        } else { // if they want to create an account
            // ask for email
            System.out.println(ENTER_YOUR_USERNAME);
            String username = scanner.nextLine();
            File f = new File(username);

            boolean validUsername = false;
            boolean badUsername = false;

            while (!validUsername) { // re-prompt user if username is already taken
                // {joe, moe, roe}
                // username = "joe"
                for (File userFile : userFiles) {
                    if (userFile.getName().equals(f.getName())) {
                        badUsername = true;
                        break;
                    }
                }
                if (badUsername) {
                    System.out.println("This username has already been taken! Please enter a new one.");
                    username = scanner.nextLine();
                    f = new File(username);
                } else {
                    validUsername = true;
                }
            }
            



            // ask for password
            System.out.println(PASSWORD_PROMPT);
            String password = scanner.nextLine();

            // case of invalid password
            if (password == null || password.length() <= 5) {
                boolean validPassword = false;
                while (!validPassword) {
                    System.out.println("Invalid password. Please enter a valid Password:");
                    password = scanner.nextLine();
                    if (password != null && password.length() > 5) {
                        validPassword = true;
                    }
                }
            }

            System.out.println(BUYER_OR_SELLER);
            String buyerOrSeller = scanner.nextLine();
            boolean badResponse = true;
            if (!"1".equals(buyerOrSeller) && !"2".equals(buyerOrSeller)) {
                while (badResponse) {
                    System.out.println("Please enter either a 1 or 2");
                    buyerOrSeller = scanner.nextLine();
                    if ("1".equals(buyerOrSeller) || "2".equals(buyerOrSeller)) {
                        badResponse = false;
                    }
                }
            }
            String customerType = "";
            
            if ("1".equals(buyerOrSeller)) {
                customerType = "BUYER";
            } else {
                customerType = "SELLER";
            } 
            
            try (BufferedWriter bwr = new BufferedWriter(new FileWriter(f))) {
                bwr.write(username + "," + password + "," + customerType);
            } catch (IOException io) {
                System.out.println("Could not write to the file");
            }
        }


        /*
        Present our product listing page
        format should be:

        store1, productName1, price1
        store2, productName2, price2

        The marketplace listing page will show the store, product name, and price of the available goods.
        Customers can select a specific product to be taken to that product's page, which will include a description and the quantity available.
        When items are purchased, the quantity available for all users decreases by the amount being purchased.

        
         */
        
        
        // everybody work here
    }


}
