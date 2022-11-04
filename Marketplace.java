import java.util.Scanner;
import java.io.*;
public class Marketplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our Marketplace!");
        System.out.println("1: Sign In\n2: Create an account");
        String response = scanner.nextLine();

        if ("1".equals(response)) {

            // ask for email
            System.out.println("Please enter your email:");
            String email = scanner.nextLine();

            // case of invalid email
            if (!email.contains("@")) {
                boolean validEmail = false;
                while (!validEmail) {
                    System.out.println("Invalid Email. Please enter a valid Email:");
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

            // make file based on the user's email
            int index = email.indexOf("@");
            String fileName = email.substring(0, index);
            File f = new File(fileName);
        } else {

        }

        // if 1, prompt for email and password, and create a specific file with that account


        // if 2, check if file exists within our database

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
