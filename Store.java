import java.util.ArrayList;

public class Store {
    private String name;
    // private ArrayList<Buyer> customers;
    private ArrayList<Shoe> products;
    private double revenue;


    /*
    public Store(String name, ArrayList<Buyer> customers, ArrayList<Shoe> products) {
        this.name = name;
        this.customers = customers;
        this.products = products;
    }
     */

    public void addProduct(Shoe shoe) {
        products.add(shoe);
    }

    public void removeProduct(Shoe shoe) {
        products.remove(shoe);
    }

    public void editProduct(Shoe shoe) {

    }

    public String purchaseDetail() {
        
    }

}