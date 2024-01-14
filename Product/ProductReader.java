package Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ProductReader {
    public static void main(String[] args) {
        File file = new File("ProductTestData.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            System.out.printf("\n%-8s%-20s%-30s%-10s\n", "ID", "Name", "Description", "Cost");
            System.out.println("=======================================================================");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    System.out.printf("%-8s%-20s%-30s%-10s\n", data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim());
                } else {
                    System.out.println("Invalid record format: " + line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
