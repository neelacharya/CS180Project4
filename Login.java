import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Scanner;
import java.io.*;
import java.util.function.BiFunction;

public class Login {
    public static final String WELCOME_PROMPT = "Welcome to our Marketplace!";
    public static final String ENTER_YOUR_EMAIL = "Please enter your e-mail.";
    public static final String SIGN_IN_PROMPT = "1: Sign In\n2: Create an account.";

    public static final String LOGIN_PASSWORD_PROMPT = "Please enter your password.";

    public static final String CREATE_PASSWORD_PROMPT = "Please enter a password greater than 5 characters.";

    public static final String BUYER_OR_SELLER = "1: Customer\n2: Seller";

    private static ArrayList<Seller> sellers = new ArrayList<>();

    public static void loadMarket() {
        File f = new File("Sellers.txt");
        if (f.exists()) {
            try (BufferedReader bfr = new BufferedReader(new FileReader(f))) {
                String line = "";
                ArrayList<String> sellerInfo = new ArrayList<>();
                Seller seller = new Seller("");
                while ((line = bfr.readLine()) != null) {
                    String[] arr = line.split(",");
                    if (arr.length > 2) {
                        boolean no = false;
                        int index = sellers.size();
                        for (int i = 0; i < sellers.size(); i++) {
                            if (arr[0].equals(sellers.get(i).getEmail())) {
                                no = true;
                                index = i;
                            }
                        }

                        if (!no) {
                            seller = new Seller(arr[0]);
                            sellers.add(seller);
                        }
                        Store store = new Store(arr[1]);
                        for (int i = 2; i < arr.length; i+=5) {
                            Shoe shoe = new Shoe(arr[i], Integer.parseInt(arr[i+1]),
                                    Double.parseDouble(arr[i+2]), arr[i+3], arr[i+4]);
                            store.addProduct(shoe);
                        }
                        seller.addStores(store.getName());
                        sellers.set(index, seller);
                    } else {
                        /**
                         * WE HOPE THIS FUCKING WORKS REMEMBER IT!!!!!!!
                         */
                        boolean no = false;
                        int index = sellers.size();
                        for (int i = 0; i < sellers.size(); i++) {
                            if (arr[0].equals(sellers.get(i).getEmail())) {
                                no = true;
                                index = i;
                            }
                        }

                        if (!no) {
                            seller = new Seller(arr[0]);
                            sellers.add(seller);
                        }
                        Store store = new Store(arr[1]);
                        seller.addStores(store.getName());
                        sellers.set(index, seller);
                    }
                }

                sellers.add(new Seller(""));
            } catch (IOException e) {
                System.out.println("Error reading to the sellers file.");
            }
        } else {
            try  {
                boolean b = f.createNewFile();
            } catch (IOException e) {
                System.out.println("There was an error creating the sellers file.");
            }
        }

    }


    public static void main(String[] args) {
        String email = "";
        String password = "";
        String userType = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_PROMPT);
        System.out.println(SIGN_IN_PROMPT);
        String response = scanner.nextLine();


        while (!"1".equals(response) && !"2".equals(response)) {
            System.out.println("Please either select 1 or 2.");
            response = scanner.nextLine();
        }


        if ("1".equals(response)) { // sign in
            System.out.println(ENTER_YOUR_EMAIL);
            email = scanner.nextLine();

            System.out.println(LOGIN_PASSWORD_PROMPT);
            password = scanner.nextLine();

            File f = new File("Accounts.txt");
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                ArrayList<String> accountInfo = new ArrayList<>();
                String line = "";
                while ((line = br.readLine()) != null) {
                    accountInfo.add(line);
                }
                br.close();
                ArrayList<String> emails = new ArrayList<>();
                for (int i = 0; i < accountInfo.size(); i++) {
                    emails.add(accountInfo.get(i).split(",")[0]);
                }
                while (!emails.contains(email)) {
                    System.out.println("This e-mail does not exist in our database.");
                    System.out.println(ENTER_YOUR_EMAIL);
                    email = scanner.nextLine();
                }
                int index = emails.indexOf(email);
                while (!accountInfo.get(index).split(",")[1].equals(password)) {
                    System.out.println("Incorrect Password.");
                    System.out.println(LOGIN_PASSWORD_PROMPT);
                    password = scanner.nextLine();
                }
                System.out.println("Login successful!");


                if (accountInfo.get(index).split(",")[2].equals("SELLER")) {
                    userType = "SELLER";
                } else {
                    userType = "BUYER";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else { // create account
            System.out.println(ENTER_YOUR_EMAIL);
            email = scanner.nextLine();

            while (!email.contains("@") && (!email.contains(".com") || !email.contains(".edu") || !email.contains(".gov"))) {
                System.out.println("Invalid e-mail.");
                System.out.println(ENTER_YOUR_EMAIL);
                email = scanner.nextLine();
            }

            File f = new File("Accounts.txt");
            if (f.exists()) {
                try (BufferedReader bfr = new BufferedReader(new FileReader("Accounts.txt"))) {
                    String line = "";
                    while ((line = bfr.readLine()) != null ) {
                        String[] arr = line.split(",");
                        while (arr[0].equals(email)) {
                            System.out.println("This e-mail has already been taken.");
                            System.out.println(ENTER_YOUR_EMAIL);
                            email = scanner.nextLine();
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Unable to read to the accounts file.");
                }

                System.out.println(CREATE_PASSWORD_PROMPT);
                password = scanner.nextLine();
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
                    Seller seller = new Seller(email);
                    sellers.add(seller); // hope it works
                }


                try (BufferedWriter bwr = new BufferedWriter(new FileWriter("Accounts.txt",true ))) {
                    bwr.write(email + "," + password + "," + userType + "\n");
                } catch (IOException io) {
                    System.out.println("Error writing to the accounts file.");
                }
            } else {
                f = new File("Accounts.txt");
                System.out.println(CREATE_PASSWORD_PROMPT);
                password = scanner.nextLine();
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
                    Seller seller = new Seller(email);
                    sellers.add(seller); // hope it works
                }
                try (BufferedWriter bwr = new BufferedWriter(new FileWriter("Accounts.txt", true))) {
                    bwr.write(email + "," + password + "," + userType + "\n");
                } catch (IOException e) {
                    System.out.println("Error writing to the accounts file.");
                }
            }
        }

        loadMarket();


        if (userType.equals("SELLER")) {
            Seller s = new Seller(email);
            int index = 0;
            if (sellers.size() == 1) {
                sellers.set(0, s);
                index = sellers.indexOf(s);
            }

            for (int i = 0; i < sellers.size(); i++) {
                if (sellers.get(i).getEmail().equals(email)) {
                    index = i;
                    break;
                }
            }



            String performActivity = "";
            do {
                /**
                 * below are the general variables we will use in your menu
                 */
                // ____________
                String storeName = "";

                // ____________
                System.out.println("Menu");
                System.out.println("1: Add a store");
                System.out.println("2: Add a product one of your Stores");
                System.out.println("3: Remove a product from one of your Stores");
                System.out.println("4: Edit a product from one of your Stores");
                System.out.println("5: View your stores and their details");
                System.out.println("6: View a customer shopping cart");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("What is the name of the store you would like to add?");
                        storeName = scanner.nextLine();
                        sellers.get(index).addStores(storeName);
                        sellers.get(index).writeToSellerFile();
                        break;
                    case 2:
                        System.out.println("What is the name of the store you would like to add a shoe to?");
                        storeName = scanner.nextLine();
                        if (sellers.get(index).checkIfStoreExists(storeName)) {
                            System.out.println("What is the name of your shoe?");
                            String shoeName = scanner.nextLine();
                            System.out.println("How many shoes do you want to manufacture?");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("What will the price of your shoe be?");
                            double price = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("What is the description of your shoe?");
                            String description = scanner.nextLine();
                            sellers.get(index).createProduct(storeName, shoeName, quantity, price, description);
                            sellers.get(index).writeToSellerFile();
                        } else {
                            System.out.println("Sorry, you are not affiliated with " + storeName);
                        }
                        break;
                    case 3:
                        System.out.println("What is the name of the store you would to remove a shoe from?");
                        storeName = scanner.nextLine();
                        if (sellers.get(index).checkIfStoreExists(storeName)) {
                            System.out.println("What is the name of your shoe?");
                            String shoeName = scanner.nextLine();
                            System.out.println("How many shoes do you want to manufacture?");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("What will the price of your shoe be?");
                            double price = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("What is the description of your shoe?");
                            String description = scanner.nextLine();
                            Shoe shoe = new Shoe(shoeName, quantity, price, description, storeName);
                            sellers.get(index).removeProduct(storeName, shoe);
                            sellers.get(index).writeToSellerFile();
                        }
                        break;
                    case 4:
                        System.out.println("What is the name of the store you would like to edit a shoe from?");
                        storeName = scanner.nextLine();
                        if (sellers.get(index).checkIfStoreExists(storeName)) {
                            System.out.println("What is the name of your old shoe?");
                            String shoeName = scanner.nextLine();
                            System.out.println("What was the quantity of the old shoes");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("What was the price of the old shoe");
                            double price = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("What is the description of the old shoe");
                            String description = scanner.nextLine();
                            Shoe oldShoe = new Shoe(shoeName, quantity, price, description, storeName);

                            System.out.println("What is the name of your old shoe?");
                            String newShoeName = scanner.nextLine();
                            System.out.println("What was the quantity of the old shoes");
                            int newQuantity = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("What was the price of the old shoe");
                            double newPrice = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("What is the description of the old shoe");
                            String newDescription = scanner.nextLine();
                            sellers.get(index).editProduct(oldShoe, newShoeName, newDescription, storeName, newQuantity, newPrice);
                            sellers.get(index).writeToSellerFile();
                        }
                        break;
                    case 5:
                        for (Store store : sellers.get(index).getStores()) {
                            System.out.println(store.toString());
                        }
                        break;
                    case 6:
                        System.out.println("This doesn't fucking work dumbass.");
                        break;
                    default:
                        System.out.println("YOOOOOO");
                }
                System.out.println("Would you like to perform another activity?");
                performActivity = scanner.nextLine();

            } while ("Yes".equalsIgnoreCase(performActivity) || "y".equalsIgnoreCase(performActivity));
            /**
             * END OF SELLER IMPLEMENTATION
             */

        }



    }
}
