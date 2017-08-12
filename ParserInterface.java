/**
* ParserInterface.java
* Interface for the University Classes which search individual
* university websites for courses and papers
*
* @Date 12/07/17
* @Version 1
*/

/**
*
* University should be implimented by classes which search 
* University websites, databases, or APIs, to provide uniform data
* There should be one implimentation per university 
*/
public interface ParserInterface {
  
  /** querryCourses returns an ArrayList of course objects 
  * (Details to be determined) from the university matching the 
  * user's querry courseQuerry.
  *
  * @param courseQuerry - Subject to find courses for
  * @return ArrayList<Course> the List of courses provided by the university
  */
  public University queryUniversity();
  
}
