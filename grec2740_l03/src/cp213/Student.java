package cp213;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Student class definition.
 *
 * @author your name here
 * @version 2022-01-17
 */
public class Student implements Comparable<Student> {

    // Attributes
    private LocalDate birthDate = null;
    private String forename = "";
    private int id = 0;
    private String surname = "";

    /**
     * Instantiates a Student object.
     *
     * @param id        student ID number
     * @param surname   student surname
     * @param forename  name of forename
     * @param birthDate birthDate in 'YYYY-MM-DD' format
     */
    public Student(final int id, final String surname, final String forename, final LocalDate birthDate) {

	this.id = id;
	this.surname = surname;
	this.forename = forename;
	this.birthDate = birthDate;

	return;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString() Creates a formatted string of student data.
     */
    @Override
    public String toString() {
	String string = "";

	string += String.format("\nName: %10s, %-10s", surname, forename);
	string += String.format("\nID: %13s", id);
	string += String.format("\nBirthDate: %s", birthDate);

	return string;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Student target) {
	int result = 0;

	// Assigning Variables:
	// Targets:

	String tFn = target.getForename();
	String tSn = target.getSurname();
	int tId = target.getId();

	// Student:
	String Fn = this.forename;
	String Sn = this.surname;
	int Id = this.id;

	// If - Else, Statements:
	if (Sn.equals(tSn)) {
	    if (Fn.equals(tFn)) {
		if (Id == tId) {
		    result = 0;
		} else {

		    if (Id < tId) {
			result = -1;

		    } else {
			result = 1;
		    }

		}
	    } else {

		String[] temp = { Fn, tFn };

		Arrays.sort(temp);

		if (Fn.equals(temp[0])) {
		    result = -1;

		} else {
		    result = 1;
		}
	    }

	} else {

	    String[] temp = { Sn, tSn };

	    Arrays.sort(temp);

	    if (Sn.equals(temp[0])) {
		result = -1;

	    } else {
		result = 1;

	    }

	}
	return result;
    }

    /**
     * @return the birthDate
     */
    public LocalDate getBirthDate() {
	return this.birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

    /**
     * @return the forename
     */
    public String getForename() {
	return this.forename;
    }

    /**
     * @param forename the forename to set
     */
    public void setForename(String forename) {
	this.forename = forename;
    }

    /**
     * @return the id
     */
    public int getId() {
	return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
	return this.surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
	this.surname = surname;
    }

}
