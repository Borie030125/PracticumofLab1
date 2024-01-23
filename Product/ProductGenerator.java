package Product;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        String fileName = "ProductTestData.txt";

        // Example loop for inputting product data
        boolean moreProducts = true;
        while (moreProducts) {
            System.out.println("Enter product ID:");
            String id = scanner.nextLine();

            System.out.println("Enter product name:");
            String name = scanner.nextLine();

            System.out.println("Enter product description:");
            String description = scanner.nextLine();

            System.out.println("Enter product cost:");
            double cost = Double.parseDouble(scanner.nextLine());

            // Creating a new Product object and adding it to the list
            products.add(new Product(id, name, description, cost));

            System.out.println("Want to add more products? (yes/no)");
            String response = scanner.nextLine();
            moreProducts = response.equalsIgnoreCase("yes");
        }

        try (BufferedWriter writer = new BufferedWriter(
                Files.newBufferedWriter(Paths.get(fileName)))) {
            for (Product product : products) {
                writer.write(product.toCSVDataRecord());
                writer.newLine();
            }
            System.out.println("Successfully written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }
}
