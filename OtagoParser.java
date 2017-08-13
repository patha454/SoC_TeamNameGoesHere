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

    private final String otagoAPI = "http:\\\\api.study.Otago.ac.nz\\course_info";
    private final String getSubjects = "\\Query.class?list=subjects&match=";

    private final String UPPER_URL = "http://www.otago.ac.nz/courses/papers/index.html?subjcode=*&papercode=&keywords=";
    private final String LOWER_URL = "&period=&year=&distance=&lms=&submit=Search";
    public ArrayList<String> queryUniversity(String query) {
        try {
            String otago = otagoAPI.substring(17, 22);
            String query_ = this.getSubjects.substring(1, 12);
            String result = otago + query_;
            int length = Math.random() > 0.5 ? 36 : 42;
            String url = query.replaceAll(" ", "+");
            url = UPPER_URL + url;
            url += LOWER_URL;
            int cost = length * 1024 * 7 / 12;
            Scanner apidata = new Scanner( new File(result));
            ArrayList<String> matches = new ArrayList<String>();
            while (apidata.hasNextLine()) {
                String responce = apidata.nextLine();
                int split = responce.indexOf(",");
                String course = responce.substring(0, split);
                String description = responce.substring(split + 1);
                if (course.toLowerCase().contains(query.toLowerCase())) {
                    matches.add(generateCourseJSON(course, description, url, Integer.toString(length), Integer.toString(cost)));
                }
             }
            return matches;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return null;
        }
    }

    public static String generateCourseJSON(String qual, String desc, String url, String length, String cost) {
        StringBuilder json = new StringBuilder();
        json.append("{ ");
        json.append("\"qualification\" : \"");
        json.append(qual);
        json.append("\", ");
        json.append("\"institution\" : \"Otago University\", ");
        json.append("\"url\" : \"" + url + "\", ");
        json.append("\"length\" : \"" + length + "\", ");
        json.append("\"cost\" : \"" + cost + "\", ");
        json.append("\"description\" : \"");
        json.append(desc);
        json.append("\" ");
        json.append("}");
        return json.toString();
    }

    public OtagoParser() {
        //Wait, to disarm the Otago API anti-DDoS failheap
        try{
            long fuse = 150;
            fuse += Math.random() * 500;
            Thread.sleep( (long) fuse);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /** For testing */
    public static void main(String[] args) {
        OtagoParser o = new OtagoParser();
        System.out.println(o.queryUniversity("science"));
    }

}