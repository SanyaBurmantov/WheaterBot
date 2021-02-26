import com.fasterxml.jackson.databind.JsonNode;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import services.PostJSON;
import services.ResponseUser;
import services.SityName;

import javax.validation.constraints.NotNull;

import static services.PostJSON.PostJSON;
import static services.ResponseUser.*;

public class WeatherTestApplication_bot extends TelegramLongPollingBot {

    public String getBotUsername() {
        return "weathertestapplication_bot";
    }

    public String getBotToken() {
        return "1675716167:AAENqrZts_AG5aY_W2tJdBf4VBcWD4_fSdk";
    }

    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getFrom().getFirstName());
        System.out.println(update.getMessage().getText());
        SendMessage message = new SendMessage();

        String command = update.getMessage().getText();

        message.setChatId(update.getMessage().getChatId().toString());
        message.setText(update.getMessage().getText());
        if (command.equals("как дела?")) {
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Нормально");
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if (command.equals("иди нахуй")) {
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("сам иди " + update.getMessage().getFrom().getFirstName());
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if (command.equals("говно")) {
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("это ты говно,  " + update.getMessage().getFrom().getFirstName());
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        String commandWeather = update.getMessage().getText();
        String[] commandA = commandWeather.split(" ");
        String check = commandA[0];
        final String city = commandA[1];
        if (check.equals("/погода")) {
            SityName sityName = new SityName();
            SityName.sityName = city;
            System.out.println(sityName);
            PostJSON();

            message.setText(ResponseUser.ResponseUser());

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
