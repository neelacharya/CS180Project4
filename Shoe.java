public class Shoes extends Store {
    private String name;
    private String store;
    private String description;
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
        String s = String.format("Name: %s\nQuantity: %d\nPrice: %.2f\nDescription: %s\nStore: %s", this.name, this.quantity, this.description, this.store);
        return s;
    }
}
