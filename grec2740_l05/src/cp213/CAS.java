package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author
 * @version 2022-02-25
 */
public class CAS extends Professor {
    private String term = null;

    /**
     * @param lastName   Professor last name (surname): defined in Person
     * @param firstName  Professor first name (given name): defined in Person
     * @param department Professor department
     */
    public CAS(final String lastName, final String firstName, final String department, final String term) {
	super(lastName, firstName, department);
	this.term = term;
    }

    /**
     * Getter for department.
     *
     * @return this.department
     */
    public String getTerm() {
	return this.term;
    }

    /**
     * Creates formatted string version of Professor.
     */
    @Override
    public String toString() {
	return (super.toString() + "\nTerm: " + this.term);
    }

}
