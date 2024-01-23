package Person;

import java.util.Calendar;

public class Person {
    String firstName;
    String lastName;
    String ID;
    String title;
    int YOB;


    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - YOB;
    }

    public int getAge(int year) {
        return year - YOB;
    }

    public String toCSVDataRecord() {
        return ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

}