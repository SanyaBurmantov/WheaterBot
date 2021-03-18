package services;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import telegram.WeatherTestApplication_bot;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class PostJSON {

    private String findCity;


    public PostJSON(CityName cityName) {
        findCity = cityName.getCityName();
    }

    public void postJson() {

    try {
        String queryUrl = "https://api.openweathermap.org/data/2.5/weather?q="+findCity+"&appid=1990243e7312ae38fd862cbf71da0bc8";
        URL url = new URL(queryUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.addRequestProperty("Content-type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");

        OutputStream os = conn.getOutputStream();
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


           String jsonNode1 = String.valueOf(actualObj.get("main").get("temp").asInt() - 273.15);
            String jsonNode2 = actualObj.get("name").toString();
            String jsonNode3 = String.valueOf(actualObj.get("weather").iterator().next().findValue("description"));
            String jsonNode4 = String.valueOf(actualObj.get("wind").get("speed").asInt());
            System.out.println("Погода в " + jsonNode2);
            System.out.println("Температура сейчас " + jsonNode1);
            System.out.println("Осадки " + jsonNode3);
            System.out.println("Скорость ветра " + jsonNode4);

        BeanJSON.close();
        conn.disconnect();

        ResponseUser responseUser = new ResponseUser(jsonNode2,jsonNode1,jsonNode3,jsonNode4);
        ResponseUser.sityName=jsonNode2;
        ResponseUser.temp = jsonNode1;
        ResponseUser.sky= jsonNode3;
        ResponseUser.speedWind=jsonNode4;

    }catch (Exception e){
        e.printStackTrace();
        }
    }
}