import java.util.ArrayList;
import java.io.*;

public class Customers {
    private ArrayList<Shoe> shoppingCart = new ArrayList<>();

    public Customers(String name) {
        this.name = name;
    }

    public String customerReview;

    public String name;

    private ArrayList<Store> stores;


    public void viewCart(String name) throws IOException {
        ArrayList<String> temp = new ArrayList<>();
        File f = new File(name);
        if (!f.isDirectory()) {
            BufferedReader br = new BufferedReader(new FileReader(f));
            boolean trip = false;
            String line = br.readLine();
            while (line != null) {
                if(trip){
                    temp.add(line);
                }
                if (line.equals("-------")) {
                    trip = true;
                }
                
                line = br.readLine();
            }
        }
        for (int i = 0; i < temp.size(); i++){
            System.out.println(temp.get(i) + "\n");
        }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
    }

    public void addToCart(Shoe shoe) {
        shoppingCart.add(shoe);
    }

    public void removeProduct(Shoe shoe) {
        for (int i = 0; i < shoppingCart.size(); i++) {
            if (shoppingCart.get(i).equals(shoe)) {
                shoppingCart.remove(shoppingCart.get(i));
            }
        }
    }

    public void writeCart() throws IOException {
        File f = new File(name);
        if (!f.isDirectory()) {
            PrintWriter pw = new PrintWriter(new FileOutputStream(f), true);
            pw.append("Shopping cart: \n");
            for (int i = 0; i < shoppingCart.size(); i++) {
                pw.append(shoppingCart.get(i).toString());
            }

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
