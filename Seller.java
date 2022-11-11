import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Seller {
    private ArrayList<Store> stores;
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

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

    public void createProduct(Store store, Shoe shoe) {
        if (stores.contains(store)) {
            store.addProduct(shoe);
        } else {
            System.out.println("Store does not exist");
        }
    }

    public void removeProduct(Store store, Shoe shoe) {
        if (stores.contains(store)) {
            store.removeProduct(shoe);
        } else {
            System.out.println("Store does not exist");
        }
    }

    public void editProduct(Store store, Shoe shoe, Shoe newShoe) {
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
