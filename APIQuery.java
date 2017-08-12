import java.lang.StringBuilder;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class APIQuery {


    public static void main(String[] args) {
        System.out.println(getJSON("accounting"));
    }
    public static String getJSON(String query) {
        try {
            Scanner apidata = new Scanner( new File ("OtagoQuery.class"));
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

}