package services;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Predicate;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import sun.reflect.generics.tree.Tree;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.ws.Response;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Predicates.equalTo;

public class PostJSON {

    public static void PostJSON() {
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
        InputStream BeanJSON = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString( BeanJSON, "UTF-8");


        System.out.println(result);
        System.out.println("ОбработОЧКА");



        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(result);
        JsonNode actualObj = mapper.readTree(parser);


            double jsonNode1 = actualObj.get("main").get("temp").asInt() - 273.15;
            String jsonNode2 = actualObj.get("name").toString();

            JsonNode jsonNode3 = mapper.readTree(String.valueOf(actualObj.get("weather")));


            double jsonNode4 = actualObj.get("wind").get("speed").asInt();
            System.out.println("Погода в " + jsonNode2);
            System.out.println("Температура сейчас " + jsonNode1);
            System.out.println("Осадки " + jsonNode3);
            System.out.println("Скорость ветра" + jsonNode4);

        BeanJSON.close();
        conn.disconnect();

    }catch (Exception e){
        e.printStackTrace();
        }

    }




}