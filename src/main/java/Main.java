import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by PC on 05.08.2020.
 */
public class Main {
    final static String dir = System.getProperty("user.dir");
    protected static ObjectMapper objectMapper;
    private static FileInputStream fis;
    protected static String from="";
    protected static String to="";
    protected static String offset="";
    protected static String limit="";
    protected static String devices;
    protected static String mounth;
    private static String delimeter = ", ";
    private static String[] clients;

    public static void main(String[] args) {
        Properties config = new Properties();
        Kabinet kabinet = new Kabinet();

        try{
            fis = new FileInputStream(dir + "/config.properties");
            config.load(fis);
            separ(config.getProperty("clients"));
            from = config.getProperty("from");
            to = config.getProperty("to");
            offset = config.getProperty("offset");
            limit = config.getProperty("limit");
            devices = config.getProperty("devices");
            mounth = config.getProperty("mounth");
            objectMapper = new ObjectMapper();


            for(String cl : separ(config.getProperty("clients"))){
                kabinet.sendGet(cl);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

    }

    private static String[] separ(String clnts){

        try {
            clients = clnts.split(delimeter);
            for(String client : clients)
            System.out.println(client);
        }catch (Exception ex){
            System.out.println("Methot: separ - " + ex);
        }
        return clients;
    }

}
