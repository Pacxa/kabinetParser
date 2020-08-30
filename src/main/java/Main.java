import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by PC on 05.08.2020.
 */
public class Main {
    protected static ObjectMapper objectMapper;

    public static void main(String[] args) {

        objectMapper = new ObjectMapper();

        Kabinet kabinet = new Kabinet();

        try{
            kabinet.sendGet();
        }catch (Exception ex){
            System.out.println(ex);
        }

    }


}
