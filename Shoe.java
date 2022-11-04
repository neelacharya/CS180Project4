import java.util.ArrayList;

public class Shoe implements Buyable{
    private String name;
    private ArrayList <String> store;
    private String description;
    private int quantity;
    private double price;

    public Shoe(String name, ArrayList<String> store, String description,
                int quantity, double price) {
        this.name = name;
        this.store = store;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getStore() {
        return store;
    }

    public void setStore(ArrayList<String> store) {
        this.store = store;
    }

    public void addStore(String store){
        this.store.add(store);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        String s = String.format("Name: %s\nQuantity: %d\nPrice: %.2f\nDescription: %s\nStores: ");
        for(int i = 0; i < store.size(); i++){
            s = s + store.get(i) + " ";
        }
        return s;
    }
}
