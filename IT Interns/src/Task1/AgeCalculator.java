package Task1;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        // Get input 4 5 people
        System.out.println("Enter the date of birth for 5 users (format: YYYY-MM-DD):");
        for (int i = 1; i <= 5; i++) {
            System.out.print("User " + i + " Date of Birth: ");
            String dobInput = scanner.nextLine();
            LocalDate birthDate = LocalDate.parse(dobInput);
            people.add(new Person(birthDate));
        }

        System.out.println("\nCalculating age details for each user...");

        int userNumber = 1;
        for (Person person : people) {
            person.calculateAgeDetails();
            System.out.println("\nUser " + userNumber + ":");
            System.out.println("Years: " + person.getYears());
            System.out.println("Months: " + person.getMonths());
            System.out.println("Weeks: " + person.getWeeks());
            System.out.println("Days: " + person.getDays());
            userNumber++;
        }

        scanner.close();
    }
}

class Person {
    private LocalDate birthDate;
    private int years;
    private int months;
    private long weeks;
    private long days;

    public Person(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void calculateAgeDetails() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        this.years = period.getYears();
        this.months = period.getMonths();
        this.weeks = ChronoUnit.WEEKS.between(birthDate, currentDate);
        this.days = ChronoUnit.DAYS.between(birthDate, currentDate);
    }

    // Getter 4 agedata
    public int getYears() {
        return years;
    }

    public int getMonths() {
        return months;
    }

    public long getWeeks() {
        return weeks;
    }

    public long getDays() {
        return days;
    }
}
