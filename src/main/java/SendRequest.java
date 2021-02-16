import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SendRequest {
ObjectMapper mapper = new ObjectMapper();
Sity sity = new Sity("Minsk");
String str = mapper.writeValueAsString(sity);

public SendRequest() throws JsonProcessingException {
        System.out.println(str);
    }
}


class Sity{
    public Sity(String sity){

    }
    private String sity;



    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }
}