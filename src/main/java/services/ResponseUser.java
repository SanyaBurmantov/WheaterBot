package services;


public class ResponseUser {
    public static String sityName;
    public static String temp;
    public static String sky;
    public static String speedWind;




    public ResponseUser(String sityName,String temp, String sky, String speedWind) {
        this.sityName = sityName;
        this.temp= temp;
        this.sky=sky;
        this.speedWind=speedWind;

    }

    public static String ResponseUser(){
        String responseMessage= "Погода в городе " + sityName +"\n"+ temp+ "%.3f" +"\n"+ "градусов цельсия "+"\n"+"небо "+ sky+"\n"+ "скорость ветра " +speedWind;
        return responseMessage;
    }


}
