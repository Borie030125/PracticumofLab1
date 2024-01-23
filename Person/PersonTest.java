package Person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;

    @BeforeEach
    void setUp() {
        // Initializing a Person object with sample data for testing
        person = new Person();
        person.firstName = "John";
        person.lastName = "Doe";
        person.ID = "123456";
        person.title = "Mr.";
        person.YOB = 1980;
    }

    @Test
    void fullName() {
        System.out.println("Testing fullName()");
        assertEquals("John Doe", person.fullName(), "The fullName method should concatenate first name and last name.");
    }

    @Test
    void formalName() {
        System.out.println("Testing formalName()");
        assertEquals("Mr. John Doe", person.formalName(), "The formalName method should concatenate title, first name, and last name.");
    }

    @Test
    void getAge() {
        System.out.println("Testing getAge()");
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int expectedAge = currentYear - person.YOB;
        assertEquals(expectedAge, person.getAge(), "The getAge method should calculate the age based on the current year.");
    }

    @Test
    void testGetAge() {
        System.out.println("Testing testGetAge()");
        int year = 2020;
        int expectedAge = year - person.YOB;
        assertEquals(expectedAge, person.getAge(year), "The getAge method should calculate the age based on the provided year.");
    }

    @Test
    void toCSVDataRecord() {
        System.out.println("Testing toCSVDataRecord()");
        String expectedCSV = "123456,John,Doe,Mr.,1980";
        assertEquals(expectedCSV, person.toCSVDataRecord(), "The toCSVDataRecord method should return a CSV string of the person's data.");
    }
}