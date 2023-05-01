package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author David Brown
 * @version 2022-02-25
 */
public class IA extends Student {

    protected String course = null;

    public IA(final String lastName, final String firstName, final String id, final String course) {
	super(lastName, firstName, course);
	this.id = id;
	this.course = course;
    }

    /**
     * Getter for course.
     *
     * @return this.course
     */
    public String getCourse() {
	return this.course;
    }

    /**
     * Creates formatted string version of Student.
     */
    @Override
    public String toString() {
	return (super.toString() + "\nCourse: " + this.course);
    }

}
