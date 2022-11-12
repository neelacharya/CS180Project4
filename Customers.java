import java.util.ArrayList;
import java.io.*;

public class Customers {
    private ArrayList<Shoe> shoppingCart = new ArrayList<>();

    public Customers(String email) {
        this.email = email;
    }

    public String email;

    private ArrayList<String> previouslyPurchased;




    public void viewCart(String email) throws IOException {
        ArrayList<String> temp = new ArrayList<>();
        File f = new File(email);
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
        File f = new File(email);
        if (!f.isDirectory()) {
            PrintWriter pw = new PrintWriter(new FileOutputStream(f), true);
            pw.append("Shopping cart: \n");
            for (int i = 0; i < shoppingCart.size(); i++) {
                pw.append(shoppingCart.get(i).toString());
            }

        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Done


    //Done
    


    //Done
    public void addToShoppingCart(Shoe shoe) {
        this.shoppingCart.add(shoe);
    }
}
