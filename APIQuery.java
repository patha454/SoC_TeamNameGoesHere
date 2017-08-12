import java.lang.StringBuilder;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class APIQuery {

    public static void main(String[] args) {
        System.out.println(getJSON("accounting"));
    }
    public static String getJSON(String query) {
        ArrayList<String> results = new ArrayList<String>();
        OtagoParser otago = new OtagoParser();
        YooBeeParser yoobee = new YooBeeParser();
        results.addAll(otago.queryUniversity(query));
        results.addAll(yoobee.queryUniversity(query));
        return results.toString();
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