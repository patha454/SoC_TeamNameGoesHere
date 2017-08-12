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

    /** URL for cost information */
    private String costPage;

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

    public void setCost(String cost) {
        this.costPage = cost;
    }

    public String getCost() {
        return costPage;
    }
    
    /*Accessor*/ 
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /* Mutator */
    public void addCourses(ArrayList<Course> newCourses) {
        this.courses.addAll(newCourses);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }


    /* C.tor */
    public University() {
        courses = new ArrayList<Course>();
    }


}