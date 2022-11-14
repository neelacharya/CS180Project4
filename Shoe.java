import java.util.ArrayList;

public class Shoe {
    private String name;
    private String storeName;
    private String description;
    private ArrayList<String> review;

    public Shoe(String name, int quantity, double price, String description, String storeName) {
        this.name = name;
        this.storeName = storeName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Shoe) {
            return (((Shoe) o).getName().equals(this.name) && ((Shoe) o).getQuantity() == this.quantity && ((Shoe) o).getPrice()
                    == this.price && ((Shoe) o).getDescription().equals(this.description)
                    && ((Shoe) o).getStore().equals(this.storeName));
        }
        return false;
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
        return this.storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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
        return String.format("%s,%d,%.2f,%s,%s", this.name, this.quantity, this.price, this.description, this.storeName);
    }

}
