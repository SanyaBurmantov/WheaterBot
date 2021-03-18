package services;

public class CitySetter {
    public void execute(CityName cityName){
        PostJSON postJSON= new PostJSON(cityName);
        postJSON.postJson();
    }
}
