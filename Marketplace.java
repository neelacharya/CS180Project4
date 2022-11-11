import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.*;

public class Marketplace {
    public static final String WELCOME_PROMPT = "Welcome to our Marketplace!";
    public static final String ENTER_YOUR_EMAIL = "Please enter your e-mail.";
    public static final String SIGN_IN_PROMPT = "1: Sign In\n2: Create an account.";

    public static final String LOGIN_PASSWORD_PROMPT = "Please enter your password.";

    public static final String CREATE_PASSWORD_PROMPT = "Please enter a password greater than 5 characters.";

    public static final String BUYER_OR_SELLER = "1: Customer\n2: Seller";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_PROMPT);
        System.out.println(SIGN_IN_PROMPT);
        String response = scanner.nextLine();

        while (!"1".equals(response) && !"2".equals(response)) {
            System.out.println("Please either select 1 or 2.");
        }

        String userType = "";
        String email = "";

        // global variables


        if ("1".equals(response)) { // if they want to sign in
            System.out.println(ENTER_YOUR_EMAIL);
            email = scanner.nextLine();

            System.out.println(LOGIN_PASSWORD_PROMPT);
            String password = scanner.nextLine();

            File f = new File(email);

            if (f.exists()) {
                try (BufferedReader bfr = new BufferedReader(new FileReader(f))) {
                    String line = bfr.readLine();
                    String[] firstLine = line.split(",");
                    if (password.equals(firstLine[1])) {
                        System.out.println("Login Successful.");
                    } else {
                        boolean validPassword = false;
                        while (!validPassword) { // case of invalid password
                            System.out.println("Wrong password.");
                            System.out.println(LOGIN_PASSWORD_PROMPT);
                            password = scanner.nextLine();
                            if (password.equals(firstLine[1])) {
                                validPassword = true;
                                System.out.println("Login Successful.");
                            }

                        }
                    }
                    if (firstLine[2].equals("CUSTOMER")) {
                        userType = "CUSTOMER";
                    } else {
                        userType = "SELLER";
                    }

                } catch (IOException io) {
                    System.out.println();
                }
            } else {
                System.out.println("We have not detected an account in our system based on that information.");
            }


        } else { // if they want to create an account
            System.out.println(ENTER_YOUR_EMAIL);
            email = scanner.nextLine();

            while (!email.contains("@") && (!email.contains(".com") || !email.contains(".edu") || !email.contains(".gov"))) {
                System.out.println("Invalid e-mail.");
                System.out.println(ENTER_YOUR_EMAIL);
                email = scanner.nextLine();
            }


            File f = new File(email);
            while (f.exists()) {
                System.out.println("This username has already been taken!");
                System.out.println(ENTER_YOUR_EMAIL);
                email = scanner.nextLine();
                f = new File(email);

            }





            System.out.println(CREATE_PASSWORD_PROMPT);
            String password = scanner.nextLine();


            if (password == null || password.length() <= 5) { // case of invalid password
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
            userType = scanner.nextLine();
            while (!"1".equals(userType) && !"2".equals(userType)) {
                System.out.println("Please enter either 1 or 2.");
            }
            if ("1".equals(userType)) {
                userType = "CUSTOMER";
            } else {
                userType = "SELLER";
            }


            try (BufferedWriter bwr = new BufferedWriter(new FileWriter(f))) {
                bwr.write(email + "," + password + "," + userType);
            } catch (IOException io) {
                System.out.println();
            }
        }
        if (userType.equals("SELLER")) {
            System.out.println("WELCOME SELLER!");
            // seller viewing page
        } else {
            System.out.println("WELCOME CUSTOMER!");
            // customer viewing page
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
