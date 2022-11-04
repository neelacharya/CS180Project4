import java.util.ArrayList;

public class Seller {
    private ArrayList<Store> stores;
    private String name;

    public Seller(String name, ArrayList<Store> stores) {
        this.name = name;
        this.stores = stores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public void setStores(ArrayList<Store> stores) {
        this.stores = stores;
    }

    public void createProduct(Store store, Shoe shoe) {
        /*
        checks if store exists in the seller's list of stores;
        if it does - adds shoe to the store
        if not, error message is printed.
         */
    }

    public void removeProduct(Store store, Shoe shoe) {
        /*
        checks if store exists in the seller's list of store,
        if it does, shoe is removed from that store
        if not, error message is printed.
         */
    }

    public void editProduct(Store store, Shoe shoe, int choice) {
        /*
        checks if seller has this store
        checks if given shoe exists in that store
        checks if choice is correct
        sets the new value accordingly
        error messages are printed accordingly
         */
    }

    public void viewStoreInfo(Store store) {
        /*
        calls returnPurchase from store to log seller's 
        selling details.
         */
    }
}
