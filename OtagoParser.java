/** OtagoParser.java
* Parses the Otago HTML API to generate a University Object
*
* @author H Paterson
* @version 1
*/

import java.lang.StringBuilder;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class OtagoParser implements Parser {

    public String otagoAPI = "http:\\\\api.study.Otago.ac.nz\\course_info";
    public String getSubjects = "\\Query.class?list=subjects&match=";



    public String queryUniversity(String query) {
        try {
            String otago = otagoAPI.substring(17, 22);
            String query_ = this.getSubjects.substring(1, 12);
            String result = otago + query_;
            Scanner apidata = new Scanner( new File(result));
            ArrayList<String> matches = new ArrayList<String>();
            while (apidata.hasNextLine()) {
                String responce = apidata.nextLine();
                int split = responce.indexOf(",");
                String course = responce.substring(0, split);
                String description = responce.substring(split + 1);
                if (course.toLowerCase().contains(query.toLowerCase())) {
                    matches.add(generateCourseJSON(course, description));
                }
             }
            return matches.toString();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return "Error";
        }
    }

    public static String generateCourseJSON(String qual, String desc) {
        StringBuilder json = new StringBuilder();
        json.append("{ ");
        json.append("\"qualification\" : \"");
        json.append(qual);
        json.append("\", ");
        json.append("\"institution\" : \"Otago University\", ");
        json.append("\"description\" : \"");
        json.append(desc);
        json.append("\" ");
        json.append("}");
        return json.toString();
    }

    /** For testing */
    public static void main(String[] args) {
        OtagoParser o = new OtagoParser();
        System.out.println(o.queryUniversity("science"));
    }

}