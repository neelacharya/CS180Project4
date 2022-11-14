# Happy Feet #
- [Description](#description "Goto Description")
- [Classes](#classes "Goto Classes")
- [Files](#files "Goto Files")
- [Testing](#testing "Goto Testing")
## Description ##
## Classes ##
This project implements five classes for a fully functioning shoe martketplace, namely: Shoe, Store, Seller, Customers, and Marketplace. We'll go over the functionalities and implementation of each class one by one.
### Shoe.java ###
#### Fields ####
 Data Type          |     Name      |   Description
--------------------|-------------- |--------------------------------------------------
  String            |    name       | The name of the shoe
  String            |    store      | The name of the store where the shoe is located
  String            |  description  | The details of the shoe including the size, material etc
  double            |    price      | The cost of each pair of that shoe (product)
   int              |   quantity    | The number of pairs available in that store
ArrayList<String>   |   reviews     | The list of all the reviews given by customers for this shoe
#### Methods ####
- All the accessor and mutator methods of each global fields except reviews
- toString() for shoe - prints the string formatted version of the shoe along with each review of the shoe
### Store.java ###
#### Fields ####
    Data Type         |    Name       |  Description
----------------------|---------------|---------------------------------------------------
      String          |     name      | The name of the store
ArrayList<Customers>  |   customers
### Seller.java ###
### Customers.java ###
### Marketplace.java ###
## Files ##
## Testing ##
