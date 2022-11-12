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

    public void removeProduct(Store store, Shoe shoe) {
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

    public void editProductName(Store store, Shoe shoe, String newName) {
        if (!stores.contains(store)) {
            System.out.println("You are not associated with " + store.getName());
        } else {
            try (BufferedReader bfr = new BufferedReader(new FileReader("market.txt"))) {
                String line = "";
                ArrayList<String> marketProducts = new ArrayList<>();
                while ((line = bfr.readLine()) != null) {
                    marketProducts.add(line);
                }
                for (int i = 0; i < marketProducts.size(); i++) {
                    String[] arr = marketProducts.get(i).split(",");
                    if (arr[4].equals(store.getName()) && arr[0].equalsIgnoreCase(shoe.getName())) {
                        marketProducts.add(newName + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," + arr[4]);
                        marketProducts.remove(marketProducts.get(i));
                        
                    }
                }
                
                BufferedWriter bwr = new BufferedWriter(new FileWriter("market.txt"));
                for (int i = 0; i < marketProducts.size(); i++) {
                    bwr.write(marketProducts.get(i));
                }


            } catch (IOException e) {
                System.out.println("There was an error reading to the seller file.");
            }
        }
        
    }

    public void editProductDescription(Store store, Shoe shoe, String newDesc) {
        if (!stores.contains(store)) {
            System.out.println("You are not associated with " + store.getName());
        } else {
            try (BufferedReader bfr = new BufferedReader(new FileReader("market.txt"))) {
                String line = "";
                ArrayList<String> marketProducts = new ArrayList<>();
                while ((line = bfr.readLine()) != null) {
                    marketProducts.add(line);
                }
                for (int i = 0; i < marketProducts.size(); i++) {
                    String[] arr = marketProducts.get(i).split(",");
                    if (arr[4].equals(store.getName()) && arr[3].equalsIgnoreCase(shoe.getDescription())) {
                        marketProducts.add(arr[0] + "," + arr[1] + "," + arr[2] + "," + newDesc + "," + arr[4]);
                        marketProducts.remove(marketProducts.get(i));

                    }
                }

                BufferedWriter bwr = new BufferedWriter(new FileWriter("market.txt"));
                for (int i = 0; i < marketProducts.size(); i++) {
                    bwr.write(marketProducts.get(i));
                }


            } catch (IOException e) {
                System.out.println("There was an error reading to the seller file.");
            }
        }
    }
    public void editProductPrice(double price) {

    }
    public void editProductQuantity(int quantity) {

    }
    public void editProductStore(String store) {

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
