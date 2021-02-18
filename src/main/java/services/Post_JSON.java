package services;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Post_JSON {

    public static void Post_JSON() {
    try {
        String sityName= "Minsk";

        String query_url = "https://api.openweathermap.org/data/2.5/weather?q="+sityName+"&appid=1990243e7312ae38fd862cbf71da0bc8";

        URL url = new URL(query_url);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.addRequestProperty("Content-type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");

        OutputStream os = conn.getOutputStream();
        //os.write(json.getBytes("UTF-8"));
        os.close();

        //работа с ответом
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");


        System.out.println(result);
        System.out.println("ОбработОЧКА");

        JSONObject myResponse = new JSONObject(result);
        System.out.println(result);

        in.close();
        conn.disconnect();

    }catch (Exception e){
        System.out.println("ты обосрался"+ e);
        }
    }
}