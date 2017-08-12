
/** Unify.java
* Unify provides the public web interface to the backend
* Once the Unity backend is running, the frontend can 
* use it to find matching courses with:
* 127.0.0.1:8080/?search=query
*
* A JSON array of matching courses is returned.
*/
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Unify {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new MyHandler());
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            try {
                String query = t.getRequestURI().getQuery();
                query = query.substring(7);
                String response = APIQuery.getJSON(query);
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