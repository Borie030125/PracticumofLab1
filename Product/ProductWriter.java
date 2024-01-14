package Product;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "ProductTestData.txt";

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                Files.newOutputStream(Paths.get(fileName))))) {
            String[] products = {
                    "000001, Pipeweed, Long Bottom Leaf, 600.0",
                    "000002, Lembas, Elven Wayfare Bread, 200.0",
                    "000003, Wine, Woodland Elf Wine, 400.0",
                    "000004, Mushrooms, Farmer Took’s Finest, 125.0",
                    "000005, Mithril, Enchanted Dwarven Armor, 3000.0"
            };

            for (String product : products) {
                writer.write(product);
                writer.newLine();
            }

            System.out.println("Product data successfully written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }
}
