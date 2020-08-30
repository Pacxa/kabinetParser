import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by PC on 05.08.2020.
 */
public class Kabinet {
    private Main main;
    String from="";
    String to="";
    String offset="";
    String limit="";
    String devices;


    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public void sendGet() throws Exception{
        from = "2020-08-26T00:00:00.000Z";
        to = "2020-08-26T23:59:59.999Z";
        offset = "";
        limit = "1000";
        devices = "";
        HttpGet request = new HttpGet("https://kabinet.dreamkas.by/api/receipts?from="+from+"&to="+to+"&offset="+offset+"&limit="+limit+"&devices="+devices);
        //HttpGet request = new HttpGet("https://kabinet.dreamkas.by/api/receipts?from="+from);


        //request.setHeader("Authorization: Bearer","ebbc0471-b36e-4cce-b3fc-7df8aaa4bfa2");
        request.addHeader("Authorization","Bearer 528395a1-e544-4611-8f14-a9e8896098ea");
        System.out.println("REQUEST_LINE: " + request.getRequestLine());

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println("Result: "+result + "\n");
                parser(result);
            }
        }
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
    LocalDate dateTime;

    private void parser(String result) throws Exception{
        JSON dat = main.objectMapper.readValue(result, JSON.class);
        //data res = main.objectMapper.readValue(result, data.class);
        for(data check : dat.getData()) {
            dateTime = dateTime = LocalDate.parse(check.getDate().substring(0, 10), formatter);
            for(positions pos : check.getPositions())
                for(payments pay : check.getPayments())
            System.out.println("RESULT: " + "\n" + check.getShopId() + "\n" +
                                            dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "\n" +
                                            check.getDate().substring(11, 19) + "\n" +
                                            check.getShiftId() + "." +check.getNumber() + "\n" +
                                            pos.getName() + "\n" +
                                            pos.getVendorCode() + "\n" +
                                            pos.getBarcode() + "\n" +
                                            Double.parseDouble(pos.getQuantity())/1000 + "\n" +
                                            Double.parseDouble(pay.getAmount())/100 + "\n" +
                                            Double.parseDouble(pos.getPrice())/100 + "\n" +
                                            check.getDiscount() + "\n" +
                                            pay.getType());
        }
        writer(dat);
        System.out.println("DIR: " + dir);
    }

    String head = "shopcode t-date  t-time  t-id    barname local   barcode salesitem   salesvalue  price   discount    t-type" + "\n";
    String res;
    String paym;
    String pType;
    String ptp = "";
    String disc;
    int vendorKey;
    boolean fileIsEmpty = true;
    final String dir = System.getProperty("user.dir");
    BufferedReader br;

    private void writer(JSON dat){

        try
        {
            File reader = new File(dir +"/notes3.txt");
            br = new BufferedReader(new InputStreamReader(new FileInputStream(reader), "windows-1251"));
            // читаем посимвольно
            int c;
            while(br.readLine() != null){
                fileIsEmpty = false;
            }
        }
        catch(Exception ex){
            File file = new File(dir +"/notes3.txt");
            System.out.println(ex.getMessage());
        }

        try(FileWriter writer = new FileWriter(dir +"/notes3.txt", true)){

        //try(FileWriter fw = new OutputStreamWriter(new FileOutputStream(dir +"/notes3.txt"),Charset.forName("windows-1251"))){
        //try(Writer writer = new OutputStreamWriter(new FileOutputStream(dir +"/notes3.txt"), Charset.forName("windows-1251"))){
            if(fileIsEmpty == true){
                writer.write(head);
            }
            for(data check : dat.getData()) {
                dateTime = dateTime = LocalDate.parse(check.getDate().substring(0, 10), formatter);
                for (positions pos : check.getPositions()) {
                    for (payments pay : check.getPayments()) {
                        paym = Double.parseDouble(pay.getAmount()) / 100 + "    ";
                        pType = pay.getType().toString();
                        switch (pType){
                            case "CASH":
                                ptp += "N";
                                break;
                            case "CASHLESS":
                                ptp += "B";
                        }
                    }
                    if (pos.getVendorCode() == "null") vendorKey = 0;
                    res = check.getShopId() + "    " +
                            dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "    " +
                            check.getDate().substring(11, 19) + " " +
                            check.getShiftId() + "." + check.getNumber() + "   " +
                            pos.getName() + " " +
                            vendorKey + "   " +
                            pos.getBarcode() + "  " +
                            Double.parseDouble(pos.getQuantity()) / 1000 + "    " +
                            Double.parseDouble(paym) / 100 + "   " +
                            Double.parseDouble(pos.getPrice()) / 100 + "    " +
                            check.getDiscount() + "    " +
                            ptp;
                    writer.append(res+ "\n");
                    ptp = "";
                }
            }
            //writer.write(res + "\n");

        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
