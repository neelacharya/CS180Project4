import java.util.ArrayList;

public class Shoe {
    private String name;
    private String store;
    private String description;
    private ArrayList<String> review;

    public Shoe(String name, int quantity, double price, String description, String store) {
        this.name = name;
        this.store = store;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public ArrayList<String> getReview() {
        return review;
    }

    public void setReview(ArrayList<String> review) {
        this.review = review;
    }

    public void addReview(String input, String rev){
        review.add(input + ": " + rev);
    }

    private int quantity;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return this.store;
    }

    public void setStore(String store) {
        this.store = store;
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
        String s = String.format("Name: %s, Quantity: %d, Price: %.2f, Description: %s, Store: %s\n", this.name, this.quantity, this.description, this.store);
        if(review != null){
            s = s + "Reviews by customers: \n";
            for(int i = 0; i < review.size(); i++){
                s = s + review.get(i) + "\n";
            }
        }
        return s;
    }
}
