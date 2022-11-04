import java.util.ArrayList;

public class Customers {

    public String customerReview;

    public String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public ArrayList<Shoes> viewMarket() {
        //When called, this method should print all the shoe options that are on the market.

    }

    public ArrayList<String> sortShoes(String search) {
        //returns an arraylist of all the shoes that contain the searched String.
    }

    public ArrayList<String> sortByPrice(double price) {

    }



    public String setReviews(String name, String review, int rating) {
        /*if the customer decides to leave a review they should be asked to rate the product out of 10, he will then
        to provide a review as a String
         */
        String ratingString = String.valueOf(rating);
        String customerReview = name + ": " + ratingString + "; " + review;

        return customerReview;
    }

    public String getReviews() {
        //Can be accessed by other customers or the product seller
        return customerReview;
    }

    public ArrayList<String> customerHistory(String fileName) {
        //If the customer has no history with the marketPlace, create a new file for him and add the purchases.
        // If they already have a file append and add new purchases to it

    }

    public ArrayList<String> shoppingCart() {

    }






}
