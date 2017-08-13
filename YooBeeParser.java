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

public class YooBeeParser implements Parser {

    public String mockData = "YoobeeMockData.txt";



    public ArrayList<String> queryUniversity(String query) {
        try {;
            Scanner apidata = new Scanner( new File(mockData));
            ArrayList<String> matches = new ArrayList<String>();
            while (apidata.hasNextLine()) {
                String responce = apidata.nextLine();
                int split = responce.indexOf(",");
                int length = 3 + (int) Math.random() * 24;
                int cost = 4000 + (int) Math.random() * 3000;
                String course = responce.substring(0, split);
                String description = responce.substring(split + 1);
                if (course.toLowerCase().contains(query.toLowerCase())) {
                    matches.add(generateCourseJSON(course, description, Integer.toString(cost), Integer.toString(length)));
                }
             }
            return matches;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return null;
        }
    }

    public static String generateCourseJSON(String qual, String desc, String cost, String length) {
        StringBuilder json = new StringBuilder();
        json.append("{ ");
        json.append("\"qualification\" : \"");
        json.append(qual);
        json.append("\", ");
        json.append("\"institution\" : \"Yoobee Polytech\", ");
        json.append("\"length\" : \"" + length + "\", ");
        json.append("\"cost\" : \"" + cost + "\", ");
        json.append("\"url\" : \"\", ");
        json.append("\"description\" : \"");
        json.append(desc);
        json.append("\" ");
        json.append("}");
        return json.toString();
    }

    /** For testing */
    public static void main(String[] args) {
        YooBeeParser o = new YooBeeParser();
        System.out.println(o.queryUniversity("design"));
    }

}