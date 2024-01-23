package Person;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> persons = new ArrayList<>();
        String fileName = SafeInput.getNonZeroLenString(scanner, "Enter the filename to save data");

        boolean moreData = true;
        while (moreData) {
            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter first name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter last name");
            String title = SafeInput.getNonZeroLenString(scanner, "Enter title");
            int yearOfBirth = SafeInput.getInt(scanner, "Enter year of birth");

            persons.add(id + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth);

            moreData = SafeInput.getYNConfirm(scanner, "Want to add a new person?");
        }

        try {
            writeToFile(persons, fileName);
            System.out.println("Successfully written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }

    private static void writeToFile(ArrayList<String> data, String fileName) throws IOException {
        OutputStream out = Files.newOutputStream(Paths.get(fileName));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        for (String record : data) {
            writer.write(record);
            writer.newLine();
        }
        writer.close();
    }
}