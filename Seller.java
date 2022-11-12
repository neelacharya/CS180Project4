import java.io.*;
import java.util.ArrayList;

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

    public void addStores(Store store) {
        this.stores.add(store);
    }

    public void createProduct(Store store, Shoe shoe) {
        try (BufferedWriter bwr = new BufferedWriter(new FileWriter("market.txt", true))) {
            if (stores.contains(store)) {
                bwr.write(shoe.getName() + "," + shoe.getQuantity() + "," + shoe.getPrice() + "," + shoe.getDescription() + "," +
                        shoe.getStore());
            } else {
                System.out.println("This seller is not affiliated with " + store.getName());
            }
        } catch (IOException e) {
            System.out.println();
        }

    }

    public void removeProduct(Store store) {
        if (stores.contains(store)) {
            ArrayList<String> currentMarketListing = new ArrayList<>();
            try (BufferedReader bfr = new BufferedReader(new FileReader("market.txt"))) {
                String line = "";
                while ((line = bfr.readLine()) != null) {
                    currentMarketListing.add(line);
                }

                for (int i = 0; i < currentMarketListing.size(); i++) {
                    String[] arr = currentMarketListing.get(i).split(",");
                    if (arr[4].equalsIgnoreCase(store.getName())) {
                        currentMarketListing.remove(currentMarketListing.get(i));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading to the market file.");
            }

            try (BufferedWriter bwr = new BufferedWriter(new FileWriter("market.txt"))) {
                for (int i = 0; i < currentMarketListing.size(); i++) {
                    bwr.write(currentMarketListing.get(i));
                }
            } catch (Exception e) {
                System.out.println("Error writing to the market file.");
            }
        } else {
            System.out.println("This seller is not affiliated with " + store.getName());
        }
    }

    public void editProduct(Store store, Shoe shoe, Shoe newShoe) {
        // buffered reader and writer
        if (stores.contains(store)) {
            if (store.getProducts().contains(shoe)) {
                store.editProduct(shoe, newShoe);
            } else {
                System.out.println("No such shoe exists");
            }
        } else {
            System.out.println("No such shoe exists");
        }
    }

    public void viewStoreInfo() {
        ArrayList<String> sales;
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(email));
            for (Store store: stores) {
                printWriter.println("--------------------");
                printWriter.println(store.getName());
                sales = store.getSales();
                if (sales.size() == 0) {
                    printWriter.println("No sales yet.");
                } else {
                    for (String sale: sales) {
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
