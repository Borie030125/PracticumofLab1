package Product;

public class Product {
    String name;
    String description;
    String ID;  // should never change
    double cost;

    // Constructor
    public Product(String ID, String name, String description, double cost) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    // Getters and setters...

    // Method to return a CSV string representation of the product
    public String toCSVDataRecord() {
        return ID + "," + name + "," + description + "," + cost;
    }
}
