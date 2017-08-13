
/** Unify.java
* Unify provides the public web interface to the backend
* Once the Unity backend is running, the frontend can 
* use it to find matching courses with:
* 127.0.0.1:8080/?search=query
*
* A JSON array of matching courses is returned.
*/

//Allow Access-Control-Allow-Origin, "*"
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Unify {

    public static void main(String[] args) {
        try {
             HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
             server.createContext("/", new MyHandler());
              server.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            try {
                String query = t.getRequestURI().getQuery();
                query = query.substring(7);
                String response = APIQuery.getJSON(query);
                //t.addResponseHeader("Access-Control-Allow-Origin", "*");
                Map<String, List<String>> m = t.getResponseHeaders();
                ArrayList<String> l = new ArrayList<String>();
                l.add("*");
                m.put("Access-Control-Allow-Origin", l);
                t.sendResponseHeaders(200, response.length());
                OutputStream os = t.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } catch (Exception e) {
                System.err.println("Error processing result: " + e.getMessage());
            }
        }
    }

}