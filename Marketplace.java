import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Marketplace {
    public static final String WELCOME_PROMPT = "Welcome to our Marketplace!";
    public static final String ENTER_YOUR_EMAIL = "Please enter your e-mail.";
    public static final String SIGN_IN_PROMPT = "1: Sign In\n2: Create an account.";

    public static final String LOGIN_PASSWORD_PROMPT = "Please enter your password.";

    public static final String CREATE_PASSWORD_PROMPT = "Please enter a password greater than 5 characters.";

    public static final String BUYER_OR_SELLER = "1: Customer\n2: Seller";

    public static void sortByQuantity() {
        File f = new File("market.txt");
        if (f.exists()) {
            try (BufferedReader bfr = new BufferedReader(new FileReader(f))) {
                ArrayList<String> prices = new ArrayList<>();
                String line = "";
                while ((line = bfr.readLine()) != null) {
                    String[] arr = line.split(",");
                    int quantity = Integer.parseInt(arr[1]);
                    if (quantity != 0) {
                        prices.add(line);
                    }
                }
                for (int i = 0; i < prices.size(); i++) {
                    String s = prices.get(i).replaceAll(",", ", ");
                    System.out.println("Product " + (i+1) + " " + s);
                }

            } catch (Exception e) {
                System.out.println("Error searching the market.");
            }
        } else {
            System.out.println("There are no products on the market.");
        }
    }

    public static void searchByPrice(double threshold) {
        File f = new File("market.txt");
        if (f.exists()) {
            try (BufferedReader bfr = new BufferedReader(new FileReader(f))) {
                ArrayList<String> prices = new ArrayList<>();
                String line = "";
                while ((line = bfr.readLine()) != null) {
                    String[] arr = line.split(",");
                    double price = Double.parseDouble(arr[2]);
                    if (price < threshold) {
                        prices.add(line);
                    }
                }
                if (prices.size() == 0) {
                    System.out.println("There were no matches to your search.");
                } else {
                    for (int i = 0; i < prices.size(); i++) {
                        String s = prices.get(i).replaceAll(",", ", ");
                        System.out.println("Product " + (i+1) + " " + s);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error searching the market.");
            }
        } else {
            System.out.println("There are no products on the market.");
        }

    }

    public static void searchByDescription(String description) {
        File f = new File("market.txt");
        if (f.exists()) {
            try (BufferedReader bfr = new BufferedReader(new FileReader(f))) {
                ArrayList<String> descriptions = new ArrayList<>();
                String line = "";
                while ((line = bfr.readLine()) != null) {
                    String[] arr = line.split(",");
                    if (arr[3].contains(description)) {
                        descriptions.add(line);
                    }
                }
                if (descriptions.size() == 0) {
                    System.out.println("There were no matches to your search.");
                } else {
                    for (int i = 0; i < descriptions.size(); i++) {
                        String s = descriptions.get(i).replaceAll(",", ", ");
                        System.out.println("Product " + (i+1) + " " + s);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error searching the market.");
            }
        } else {
            System.out.println("There are no products on the market.");
        }
    }

    public static void searchByName(String name) {
        File f = new File("market.txt");
        if (f.exists()) {
            try (BufferedReader bfr = new BufferedReader(new FileReader(f))) {
                ArrayList<String> names = new ArrayList<>();
                String line = "";
                while ((line = bfr.readLine()) != null) {
                    String[] arr = line.split(",");
                    if (arr[0].contains(name)) {
                        names.add(line);
                    }
                }
                if (names.size() == 0) {
                    System.out.println("There were no matches to your search.");
                } else {
                    for (int i = 0; i < names.size(); i++) {
                        String s = names.get(i).replaceAll(",", ", ");
                        System.out.println("Product " + (i+1) + " " + s);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error searching the market.");
            }
        } else {
            System.out.println("There are no products on the market.");
        }

    }

    public static void searchByStore(String store) {
        File f = new File("market.txt");
        if (f.exists()) {
            try (BufferedReader bfr = new BufferedReader(new FileReader(f))) {
                ArrayList<String> storeNames = new ArrayList<>();
                String line = "";
                while ((line = bfr.readLine()) != null) {
                    String[] arr = line.split(",");
                    if (arr[4].contains(store)) {
                        storeNames.add(line);
                    }
                }
                if (storeNames.size() == 0) {
                    System.out.println("There were no matches to your search.");
                } else {
                    for (int i = 0; i < storeNames.size(); i++) {
                        String s = storeNames.get(i).replaceAll(",", ", ");
                        System.out.println("Product " + (i+1) + " " + s);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error searching the market.");
            }
        } else {
            System.out.println("There are no products on the market.");
        }

    }


    public static void viewMarket() {
        File f = new File("market.txt");
        if (f.exists()) {
            try (BufferedReader bfr = new BufferedReader(new FileReader(f))) {
                String line = "";
                ArrayList<String> overallProducts = new ArrayList<>();
                while ((line = bfr.readLine()) != null) {
                    overallProducts.add(line);
                }
                for (int i = 0; i < overallProducts.size(); i++) {
                    System.out.println("Product " + (i + 1) + ":" + overallProducts.get(i));
                }
            } catch (Exception e) {
                System.out.println();
            }
        } else {
            System.out.println("There are no products on the market.");
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_PROMPT);
        System.out.println(SIGN_IN_PROMPT);
        String response = scanner.nextLine();

        while (!"1".equals(response) && !"2".equals(response)) {
            System.out.println("Please either select 1 or 2.");
            response = scanner.nextLine();
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
        String ch;
        String storeName;
        Store store;
        if (userType.equals("SELLER")) {
            System.out.println("WELCOME SELLER!");
            Seller seller = new Seller(email);
            // seller viewing page
            String ch1;
            do {
                System.out.println("Menu");
                System.out.println("1: Edit a Product");
                System.out.println("2: Edit a Store");
                System.out.println("3: View the store and its details");
                System.out.println("4: Add a store");
                System.out.println("5: Remove a Store");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        String c = "no";
                        do {
                            System.out.println("Enter the name of the Product you want to edit");
                            String name = scanner.nextLine();
                            for (int i = 0; i < seller.getStores().size(); i++) {
                                for (int j = 0; j < seller.getStores().get(i).getProducts().size(); j++) {
                                    if (seller.getStores().get(i).getProducts().get(j).getName().equals(name)) {
                                        System.out.println("Editing Menu");
                                        System.out.println("1: Edit the name");
                                        System.out.println("2: Edit the price");
                                        System.out.println("3: Edit the description");
                                        System.out.println("4: Edit the quantity");
                                        System.out.println("5: Edit the store");
                                        int choice1 = scanner.nextInt();
                                        scanner.nextLine();
                                        String tempName = seller.getStores().get(i).getProducts().get(j).getName();
                                        double tempPrice = seller.getStores().get(i).getProducts().get(j).getPrice();
                                        int tempQuan = seller.getStores().get(i).getProducts().get(j).getQuantity();
                                        String tempDes = seller.getStores().get(i).getProducts().get(j).getDescription();
                                        String tempStore = seller.getStores().get(i).getProducts().get(j).getStore();
                                        switch (choice1) {
                                            case 1:
                                                System.out.println("Enter the new name");
                                                String newName = scanner.nextLine();
                                                seller.getStores().get(i).getProducts().get(j).setName(newName);
                                                break;
                                            case 2:
                                                System.out.println("Enter the new price");
                                                double newPrice = scanner.nextDouble();
                                                scanner.nextLine();
                                                seller.getStores().get(i).getProducts().get(j).setPrice(newPrice);
                                                break;
                                            case 3:
                                                System.out.println("Enter the new description");
                                                String newDes = scanner.nextLine();
                                                seller.getStores().get(i).getProducts().get(j).setDescription(newDes);
                                                break;
                                            case 4:
                                                System.out.println("Enter the new Store");
                                                String newStore = scanner.nextLine();
                                                int co = 0;
                                                for (int k = 0; k < seller.getStores().size(); k++) {
                                                    if (seller.getStores().get(k).getName().equals(newStore)) {
                                                        seller.getStores().get(k).addProduct(seller.getStores().get(i).getProducts().get(j));
                                                        seller.getStores().get(i).getProducts().get(j).setStore(newStore);
                                                        co = 1;
                                                        break;
                                                    }
                                                }
                                                if (co != 1) {
                                                    System.out.println("Error! Please enter the new store before adding products to it!");
                                                }
                                                break;
                                            default:
                                                System.out.println("Error! Please enter a valid choice!");
                                        }
                                    } else {
                                        System.out.println("Please add the product by editing the store. You cannot add products here");
                                    }
                                }
                            }
                            System.out.println("Do you want to edit more (y/n)?");
                            c = scanner.nextLine();
                        } while (c.equals("y") || c.equals("yes"));
                    case 2:
                        do {
                            System.out.println("Enter the name of the store you want to edit");
                            String editName = scanner.nextLine();
                            for (int i = 0; i < seller.getStores().size(); i++) {
                                if (seller.getStores().get(i).getName().equals(editName)) {
                                    System.out.println("Edit Menu");
                                    System.out.println("1: Change the name of the store");
                                    System.out.println("2: Add a product to the store");
                                    System.out.println("3: Remove a product from the store");
                                    int choice2 = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (choice2) {
                                        case 1:
                                            System.out.println("Enter the new name of the store");
                                            String newName = scanner.nextLine();
                                            seller.getStores().get(i).setName(newName);
                                            break;
                                        case 2:
                                            System.out.println("Enter the name of the product");
                                            String pName = scanner.nextLine();
                                            System.out.println("Enter the price of the product");
                                            double pPrice = scanner.nextDouble();
                                            scanner.nextLine();
                                            System.out.println("Enter the description of the product");
                                            String pDes = scanner.nextLine();
                                            System.out.println("Enter the quantity of the product");
                                            int pQuan = scanner.nextInt();
                                            scanner.nextLine();
                                            Shoe shoe = new Shoe(pName, editName, pDes, pQuan, pPrice);
                                            seller.getStores().get(i).addProduct(shoe);
                                            break;
                                        case 3:
                                            System.out.println("Enter the name of the product that is to be removed");
                                            String remName = scanner.nextLine();
                                            for (int j = 0; j < seller.getStores().get(i).getProducts().size(); j++) {
                                                if (seller.getStores().get(i).getProducts().get(i).getName().equals(remName)) {
                                                    seller.getStores().get(i).removeProduct(seller.getStores().get(i).getProducts().get(i));
                                                }
                                            }
                                            break;
                                        default:
                                            System.out.println("Please enter a valid choice");
                                    }
                                } else {
                                    System.out.println("The store doesnt exist");
                                }
                            }
                            System.out.println("Do you want to edit more stores?(y/n)");
                            ch = scanner.nextLine();
                        } while (ch.equals("y") || ch.equals("yes"));
                        break;
                    case 3:
                        do {
                            System.out.println("Enter the name of the store");
                            String nameStore = scanner.nextLine();
                            for (int i = 0; i < seller.getStores().size(); i++) {
                                if (seller.getStores().get(i).equals(nameStore)) {
                                    System.out.println(seller.getStores().get(i).toString());
                                }
                            }
                            System.out.println("Would you like to view another store?");
                            ch = scanner.nextLine();
                        } while (ch.equals("y") || ch.equals("yes"));

                        break;
                    case 4:
                        System.out.println("Enter the name of the store you would like to add:");
                        storeName = scanner.nextLine();
                        store = new Store(storeName);
                        if (seller.addStores(store)) {
                            System.out.println("Store has been added!");

                        } else {
                            System.out.println("Store already exists!");
                        }
                        break;
                    case 5:
                        System.out.println("Enter the name of the store that you would like to remove:");
                        storeName = scanner.nextLine();
                        store = new Store(storeName);
                        if (seller.removeStores(store)) {
                            System.out.println("Store has been removed");
                        } else {
                            System.out.println("Store does not exist!");
                        }
                        break;
                    default:
                        System.out.println("Please enter a valid choice!");
                }
                System.out.println("Would you like to perform any other activity?(y/n)");
                ch1 = scanner.nextLine();

            } while (ch1.equals("y") || ch1.equals("yes"));


        } else if (userType.equals("CUSTOMER")) {
            System.out.println("WELCOME CUSTOMER!");
            Customers customer = new Customers(email);
            System.out.println("Customer Menu");
            System.out.println("1: Search the market and the various products it has to offer");
            System.out.println("2: View your shopping cart");
            System.out.println("3: View your purchase history");
            int choice3 = scanner.nextInt();
            scanner.nextLine();
            switch (choice3){
                case 1: System.out.println("On what basis would you like ro search by?");
                System.out.println("1. NAME");
                System.out.println("2. PRICE");
                System.out.println("3. STORE");
                System.out.println("4. DESCRIPTION");
                System.out.println("5. QUANTITY");
                System.out.println("6. NO FILTERS, VIEW ENTIRE MARKETPLACE");
                int choice4 = scanner.nextInt();
                scanner.nextLine();
                switch (choice4) {
                    case 1:
                        System.out.println("What is the name of the product you wish to search by:");
                        String searchName = scanner.nextLine();
                        searchByName(searchName);
                        break;
                    case 2:
                        System.out.println("What is the threshold price of your search?");
                        double searchPrice = scanner.nextDouble();
                        scanner.nextLine();
                        searchByPrice(searchPrice);
                        break;
                    case 3:
                        System.out.println("What is the name of the store you would like to search in?");
                        String searchStore = scanner.nextLine();
                        searchByStore(searchStore);
                        break;
                    case 4:
                        System.out.println("What is the description of shoe you wish to purchase?");
                        String searchDescription = scanner.nextLine();
                        searchByDescription(searchDescription);
                        break;
                    case 5:
                        System.out.println("Displaying all the in-stock products:");
                        sortByQuantity();
                        break;
                    case 6:
                        System.out.println("Displaying the entire marketplace:");
                        viewMarket();
                        break;
                    default:
                        System.out.println("Please enter a valid choice!");
                        break;
                }


            }
            // customer viewing page
        }
        //close the file readers
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
