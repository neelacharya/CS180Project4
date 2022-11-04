import java.lang.reflect.Array;
import java.util.ArrayList;

public class Store {
    private String name;
    private ArrayList<String> customers;
    private ArrayList<Shoes> products;
    private double revenue;


    /*
    public Store(String name, ArrayList<Buyer> customers, ArrayList<Shoe> products) {
        this.name = name;
        this.customers = customers;
        this.products = products;
    }
     */

    public void addProduct(Shoes shoe) {
        products.add(shoe);
    }

    public void removeProduct(Shoes shoe) {
        products.remove(shoe);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void editProduct(Shoes shoe) {
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).equals(shoe)){
                products.set(i, shoe);
            }
        }
    }

    public void processPurchase(ArrayList <String> purchase) {
        for(int i = 0; i < purchase.size(); i++){
            String[] temp = purchase.get(i).split(",");
            for (int j = 0; j < products.size(); j++) {
                if(temp[0].equals(products.get(i).getName())){
                    customers.add(temp[2]);
                    int q = Integer.parseInt(temp[1]);
                    if(products.get(i).getQuantity() < q){
                        System.out.println("There arent enough items in stock! you can order a max of " + products.get(i).getQuantity() + " items.");
                    }else {
                        products.get(i).setQuantity(products.get(i).getQuantity() - q);
                        revenue = revenue  + (q * products.get(i).getPrice());
                    }
                }
            }
        }
    }
}
