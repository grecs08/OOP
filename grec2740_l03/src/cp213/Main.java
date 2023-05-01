package cp213;

import java.time.LocalDate;

/**
 * Tests the Student class.
 *
 * @author your name here
 * @version 2022-01-17
 */
public class Main {

    public static void main(String[] args) {
	final String line = "-".repeat(40);
	int id = 123456;
	String surname = "Brown";
	String forename = "David";
	LocalDate birthDate = LocalDate.parse("1962-10-25");
	Student student = new Student(id, surname, forename, birthDate);
	System.out.println("New Student:");
	System.out.println(student);
	System.out.println(line);
	System.out.println("Test Getters");

	System.out.println(student.getSurname());
	System.out.println(student.getForename());
	System.out.println(student.getId());
	System.out.println(student.getBirthDate());

	System.out.println(line);
	System.out.println("Test Setters");

	student.setSurname("Brown");
	student.setForename("David");
	student.setId(123456);
	student.setBirthDate(LocalDate.parse("1962-10-25"));

	System.out.println("Updated Student:");
	System.out.println(student);
	System.out.println(line);
	System.out.println("Test compareTo");
	System.out.println(student);
	System.out.println(line);

    }

}
