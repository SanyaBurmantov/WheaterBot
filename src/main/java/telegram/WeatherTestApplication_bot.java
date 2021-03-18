package telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import services.CityName;
import services.CitySetter;

public class WeatherTestApplication_bot extends TelegramLongPollingBot {

    public String getBotUsername() {
        return "weathertestapplication_bot";
    }

    public String getBotToken() {
        return "1675716167:AAGAuXKWjmF-aznUZIdGRzKcjnRDT5JD4kI";
    }

    public void onUpdateReceived(Update update) {

        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText(update.getMessage().getText());

        String commandWeather = update.getMessage().getText();
        String[] commandA = commandWeather.split(" ");
        String check = commandA[0];
        String city = commandA[1];
        if (check.equals("/погода")) {
            CityName cityName = new CityName(city);
            CitySetter citySetter = new CitySetter();
            citySetter.execute(cityName);

            System.out.println(cityName.getCityName());

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }






    }
}
