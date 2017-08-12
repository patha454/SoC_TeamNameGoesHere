import java.util.ArrayList;

/** Univserity.java
* Contains uniformly formatted data on a university and the courses
* it offers
*/
public class University {

    /**List of the courses offered */
    private ArrayList<Course> courses;

    /** University name */
    private String name;

    /** University Location 
     Type may change as design is developed*/
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location; 
    }
    
    /*Accessor*/ 
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /* Mutator */
    public void addCourses(ArrayList<Course> newCourses) {
        this.courses.addAll(newCourses);
    }


    /* C.tor */
    public University() {
        courses = new ArrayList<Course>();

    }


}