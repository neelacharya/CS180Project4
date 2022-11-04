import java.util.*;
public interface Buyable {
    public String getName();

    public void setName(String name);

    public ArrayList<String> getStore();

    //public void setStore(ArrayList<String> store);

    //public void addStore(String store);

    public String getDescription();

    public void setDescription(String description);

    public int getQuantity();

    public void setQuantity(int quantity);

    public double getPrice();

    public void setPrice(double price);
}

