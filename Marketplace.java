import java.util.Scanner;
import java.io.*;
public class Marketplace {
    public static final String WELCOME_PROMPT = "Welcome to our Marketplace!";
    public static final String EMAIL_PROMPT = "Please enter your email";
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

        if ("1".equals(response)) {
            System.out.println(EMAIL_PROMPT);
            String email = scanner.nextLine();


            System.out.println(PASSWORD_PROMPT);
            String password = scanner.nextLine();

            int index = email.indexOf("@");
            String fileName = email.substring(0, index);
            File f = new File(fileName);
            if (f.exists()) {
                try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))) {
                    String line = bfr.readLine();
                    String[] accountInfo = line.split(",");
                    if (accountInfo[2].equals(password)) {
                        // correct password
                    } else {
                        // incorrect password
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("We have not detected an account in our system based on that information.");
            }



        } else {
            // ask for email
            System.out.println(EMAIL_PROMPT);
            String email = scanner.nextLine();

            // case of invalid email
            if (!email.contains("@")) {
                boolean validEmail = false;
                while (!validEmail) {
                    System.out.println("Invalid Email. " + EMAIL_PROMPT);
                    email = scanner.nextLine();
                    if (email.contains("@")) {
                        validEmail = true;
                    }
                }
            }

            // ask for password
            System.out.println("Please enter a password greater than 5 characters");
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

            // ask if seller of buyer
            System.out.println("1: Buyer\n2: Seller");
            String role = scanner.nextLine();

            String buyerOrSeller = "";
            if (role.equals("1")) {
                // use this boolean variable later on. if buyer, make a buyer object
                isBuyer = true;
                buyerOrSeller = "Buyer";
            } else {
                // use this boolean variable later on. if seller, make a seller object
                isSeller = true;
                buyerOrSeller = "Seller";
            }

            // make file based on the user's email
            int index = email.indexOf("@");
            String fileName = email.substring(0, index);
            File f = new File(fileName);

            try (BufferedWriter bwr = new BufferedWriter(new FileWriter(f))) {
                bwr.write(email + "," + password + "," + buyerOrSeller);
            } catch (IOException e) {
                e.printStackTrace();
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
    }



}
