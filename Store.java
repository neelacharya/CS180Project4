import java.util.ArrayList;

public class Store {
    private String name;
    private ArrayList<Customers> customers;
    private ArrayList<Shoe> products;
    private ArrayList<String> sales;


    public Store(String name, ArrayList<Customers> customers, ArrayList<Shoe> products) {
        this.name = name;
        this.customers = customers;
        this.products = products;
        this.sales = new ArrayList<>();
    }


    public void addProduct(Shoe shoe) {
        products.add(shoe);
    }

    public void removeProduct(Shoe shoe) {
        products.remove(shoe);
    }

    public void editProduct(Shoe shoe, Shoe newShoe) {
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).equals(shoe)){
                products.set(i, shoe);
            }
        }
    }

    public void processPurchase(String shoeName, int quantity, Customers customer) {
        for (Shoe shoe: products) {
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
        return products;
    }

    public void setProducts(ArrayList<Shoe> products) {
        this.products = products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
