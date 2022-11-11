import java.util.ArrayList;

public class Store {
    private String name;
    private ArrayList<Customers> customers;
    private ArrayList<Shoe> shoes;
    private ArrayList<String> sales;


    public Store(String name, ArrayList<Customers> customers, ArrayList<Shoe> shoes) {
        this.name = name;
        this.customers = customers;
        this.shoes = shoes;
        this.sales = new ArrayList<>();
    }
    public Store(String name){
        this.name = name;
    }


    public void addProduct(Shoe shoe) {
        shoes.add(shoe);
    }

    public void removeProduct(Shoe shoe) {
        shoes.remove(shoe);
    }

    public void editProduct(Shoe shoe, Shoe newShoe) {
        for(int i = 0; i < shoes.size(); i++){
            if(shoes.get(i).equals(shoe)){
                shoes.set(i, shoe);
            }
        }
    }

    public void processPurchase(String shoeName, int quantity, Customers customer) {
        for (Shoe shoe: shoes) {
            if (shoe.getName().equalsIgnoreCase(shoeName)) {
                if (quantity <= shoe.getQuantity()) {
                    shoe.setQuantity(shoe.getQuantity() - quantity);
                    purchaseDetail(shoe, quantity, customer);
                    break;
                } else {
                    System.out.println("Sorry! We're out of stock!");
                }
            } else {
                System.out.println("Sorry this product does not exist in this store!");
            }
        }
    }

    public void purchaseDetail(Shoe shoe, int quantity, Customers customer) {
        double revenue = shoe.getPrice() * quantity;
        sales.add(customer.getName() + " bought " + quantity + " " + shoe.getName() +
                " .Revenue generated: " + revenue );
    }

    public ArrayList<Customers> getCustomers() {
        return customers;
    }

    public ArrayList<String> getSales() {
        return sales;
    }

    public void setCustomers(ArrayList<Customers> customers) {
        this.customers = customers;
    }
    public ArrayList<Shoe> getProducts() {
        return shoes;
    }

    public void setProducts(ArrayList<Shoe> products) {
        this.shoes = products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        //TODO
        String s="";
        return s;
    }
}
