package Person;

import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);

        System.out.println("Please select a person file to read:");
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            readFile(selectedFile);
        } else {
            System.out.println("No file was selected.");
        }
    }

    private static void readFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            System.out.printf("\n%-8s%-15s%-15s%-10s%5s\n", "ID#", "Firstname", "Lastname", "Title", "YOB");
            System.out.println("===============================================");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    System.out.printf("%-8s%-15s%-15s%-10s%5s\n", data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim());
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