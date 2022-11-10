import java.util.ArrayList;

public class Customers {

    public Customers(String name) {
        this.name = name;
    }

    public String customerReview;

    public String name;

    private ArrayList<Store> stores;

    public ArrayList<Shoe> shoppingCart;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Done?
    public void viewMarket() {
        for (int i = 0; i < this.stores.size(); i++){
            for(int j = 0; j < stores.get(i).getProducts().size(); i++){
                System.out.println("-------\n" + stores.get(i).getProducts().get(i).toString());
            }
        }
    }

    public ArrayList<Shoe> searchStore(String search) {
        ArrayList<Shoe> shoes = new ArrayList<>();
        for (int i = 0; i < stores.size(); i++) {
            for (int j = 0; j < stores.get(i).getProducts().size(); j++) {
                String s = stores.get(i).getProducts().get(j).getName().toLowerCase();
                if (s.contains(search)) {
                    shoes.add(stores.get(i).getProducts().get(j));
                }
            }
        }
        return shoes;


        //returns an arraylist of all the shoes that contain the searched String.
    }

    public ArrayList<Shoe> searchByPrice(double price) {
        ArrayList<Shoe> shoes = new ArrayList<>();
        for (int i = 0; i < stores.size(); i++) {
            for (int j = 0; j < stores.get(i).getProducts().size(); j++) {
                double n = stores.get(i).getProducts().get(j).getPrice();
                if (n < price) {
                    shoes.add(stores.get(i).getProducts().get(j));
                }
            }
        }
        return shoes;
    }

    public ArrayList<Shoe> searchByShoeType(String search) {
        ArrayList<Shoe> shoes = new ArrayList<>();
        for (int i = 0; i < stores.size(); i++) {
            for (int j = 0; j < stores.get(i).getProducts().size(); j++) {
                String s = stores.get(i).getProducts().get(j).getDescription().toLowerCase();
                if (s.contains(search)) {
                    shoes.add(stores.get(i).getProducts().get(j));
                }
            }
        }
        return shoes;

    }

    //Done
    public String setReviews(String name, String review, int rating) {
        /*if the customer decides to leave a review they should be asked to rate the product out of 10, they will then
        be asked to provide a review as a String
         */
        String ratingString = String.valueOf(rating);
        String customerReview = name + ": " + ratingString + "; " + review;

        return customerReview;
    }

    //Done
    public String getReviews() {
        //Can be accessed by other customers or the product seller
        return customerReview;
    }


    //Done
    public void addToShoppingCart(Shoe shoe) {
        this.shoppingCart.add(shoe);
    }
}
