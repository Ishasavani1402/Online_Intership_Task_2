import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONObject;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username for see github data : ");
        String user_name =  sc.nextLine();
        String uri = "https://api.github.com/users/"+user_name;

        //httprequest
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).GET().build();

        //response from server
        try{
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode()==200){
                System.out.println("Status Code :"+response.statusCode());
                JSONObject json_object = new JSONObject(response.body());
                System.out.println(json_object.toString(4));
            }
        }catch(InterruptedException e){
            System.out.println("Error "+ e.getMessage());
        }catch(IOException e){
            System.out.println("Error "+ e.getMessage());
        }
        sc.close();
        
    }
}
