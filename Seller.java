import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.function.BiFunction;

public class Seller {
    private ArrayList<Store> stores = new ArrayList<>();
    private String email;

    public Seller(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.email = name;
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public boolean checkIfStoreExists(String storeName) {
        for (Store store : stores) {
            if (store.getName().equalsIgnoreCase(storeName)) {
                return true;
            }
        }
        return false;
    }

    public void addStores(String storeName) {
        Store store = new Store(storeName);
        this.stores.add(store);
    }
    public void addStores(Store store) {
        this.stores.add(store);
    }



    public void createProduct(String storeName, String shoeName,
                              int quantity, double price, String description) {
        int count = 0;
        for (Store s : stores) {
            if (s.getName().equalsIgnoreCase(storeName)) {
                int index = stores.indexOf(s);
                stores.get(index).addProduct(new Shoe(shoeName, quantity, price, description, storeName));
            }
            count++;
        }
        if (count == 0) {
            System.out.println("You are not affiliated with " + storeName);
        }
    }


    public void removeProduct(String storeName, Shoe shoe) {
        for (Store s : stores) {
            if (s.getName().equalsIgnoreCase(storeName)) {
                if (s.getProducts().size() != 0) {
                    int index = stores.indexOf(s);
                    stores.get(index).removeShoe(shoe);
                } else {
                    System.out.println("There are no products in this store.");
                }

            }
        }
        // whenever this method is called, UPDATE SELLER FILE WITH WRITE TO SELLER
    }

    public void editProduct(Shoe oldShoe, String newName, String newDesc, String storeName, int newQuantity, double newPrice) {
        Shoe newShoe = new Shoe(newName, newQuantity, newPrice, newDesc, storeName);
        for (Store s : stores) {
            if (s.getName().equals(storeName)) {
                int index = stores.indexOf(s);
                stores.get(index).setProduct(oldShoe, newShoe);
            }
        }

    }

    public void writerToSellerFileEditProduct(String oldName, int oldQuantity, double oldPrice, String oldDesc, String storeName,
                                              String newName, int newQuantity, double newPrice, String newDesc) {
       removeProduct(storeName, new Shoe(oldName, oldQuantity, oldPrice, oldDesc, storeName));
       createProduct(storeName, newName, newQuantity, newPrice, newDesc);
        ArrayList<String> otherSellers = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < stores.size(); i++) {
            if (stores.get(i).getName().equalsIgnoreCase(storeName)) {
                index = i;
            }
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader("Sellers.txt"))) {
            String line = "";
            while ((line = bfr.readLine()) != null) {
                if (!line.startsWith(this.email) || !line.contains(storeName)) {
                    otherSellers.add(line);
                }
            }
            bfr.close();
        } catch (IOException e) {
            System.out.println();
        }
        try (BufferedWriter bwr = new BufferedWriter(new FileWriter("Sellers.txt"))) {
            for (int i = 0; i < otherSellers.size(); i++) {
                bwr.write(otherSellers.get(i) + "\n");
            }

            bwr.write(this.email + "," + stores.get(index).toString());

            bwr.flush();
        } catch (IOException e) {
            System.out.println();
        }
    }
    public Store searchStore(String storeName) {
        for (Store s : stores) {
            if (s.getName().equalsIgnoreCase(storeName)) {
                int index = stores.indexOf(s);
                return stores.get(index);
            }
        }
        return null;
    }
    public void writeToSellerFileAddProduct(String storeName, String name, int quantity, double price, String description) {
        createProduct(storeName, name, quantity, price, description);
        ArrayList<String> otherSellers = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < stores.size(); i++) {
            if (stores.get(i).getName().equalsIgnoreCase(storeName)) {
                index = i;
            }
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader("Sellers.txt"))) {
            String line = "";
            while ((line = bfr.readLine()) != null) {
                if (!line.startsWith(this.email) || !line.contains(storeName)) {
                    otherSellers.add(line);
                }
            }
            bfr.close();
        } catch (IOException e) {
            System.out.println();
        }
        try (BufferedWriter bwr = new BufferedWriter(new FileWriter("Sellers.txt"))) {
            for (int i = 0; i < otherSellers.size(); i++) {
                bwr.write(otherSellers.get(i) + "\n");
            }

            bwr.write(this.email + "," + stores.get(index).toString());

            bwr.flush();
        } catch (IOException e) {
            System.out.println();
        }
    }

    public void writeToSellerFileRemoveProduct(String storeName, String shoeName, int quantity, double price, String description) {
        removeProduct(storeName, new Shoe(shoeName, quantity, price, description, storeName));
        ArrayList<String> otherSellers = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < stores.size(); i++) {
            if (stores.get(i).getName().equalsIgnoreCase(storeName)) {
                index = i;
            }
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader("Sellers.txt"))) {
            String line = "";
            while ((line = bfr.readLine()) != null) {
                if (!line.startsWith(this.email) || !line.contains(storeName)) {
                    otherSellers.add(line);
                }
            }
            bfr.close();
        } catch (IOException e) {
            System.out.println();
        }
        try (BufferedWriter bwr = new BufferedWriter(new FileWriter("Sellers.txt"))) {
            for (int i = 0; i < otherSellers.size(); i++) {
                bwr.write(otherSellers.get(i) + "\n");
            }

            bwr.write(this.email + "," + stores.get(index).toString());

            bwr.flush();
        } catch (IOException e) {
            System.out.println();
        }
    }

    public void writeToSellerFileAddStore(String storeName) {
        ArrayList<String> otherSellers = new ArrayList<>();

        /*
        seller@gmail.com,Jordan,
        seller@seller.com,Nike,
        seller@seller.com,Adidas,
         */
        Store store = new Store(storeName);
        try (BufferedReader bfr = new BufferedReader(new FileReader("Sellers.txt"))) {
            String line = "";
            while ((line = bfr.readLine()) != null) {
                if (!line.startsWith(this.email) || !line.contains(storeName)) {
                    otherSellers.add(line);
                }
            }
            bfr.close();
        } catch (IOException e) {
            System.out.println();
        }
        try (BufferedWriter bwr = new BufferedWriter(new FileWriter("Sellers.txt"))) {
            for (int i = 0; i < otherSellers.size(); i++) {
                bwr.write(otherSellers.get(i) + "\n");
            }

            bwr.write(this.email + "," + store.toString() + "\n");

            bwr.flush();
        } catch (IOException e) {
            System.out.println();
        }
    }


    public void viewStoreInfo() {
        ArrayList<String> sales;
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(email));
            for (Store store : stores) {
                printWriter.println("--------------------");
                printWriter.println(store.getName());
                sales = store.getSales();
                if (sales.size() == 0) {
                    printWriter.println("No sales yet.");
                } else {
                    for (String sale : sales) {
                        printWriter.println(sale);
                    }
                }
            }
            printWriter.flush();
            printWriter.close();
        } catch (Exception ex) {
            System.out.println("Error in displaying file");
            return;
        }
    }
}


