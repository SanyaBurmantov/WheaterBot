import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLOutput;

public class WeatherTestApplication_bot extends TelegramLongPollingBot {

    public String getBotUsername() {
        return "weathertestapplication_bot";
    }

    public String getBotToken() {
        return "1675716167:AAENqrZts_AG5aY_W2tJdBf4VBcWD4_fSdk";
    }

    public void onUpdateReceived(Update update) {

     
        String command= update.getMessage().getText();
        SendMessage message = new SendMessage();
        System.out.println(update.getMessage().getText());
        if(command.equals("/базарь")){
            System.out.println(update.getMessage().getFrom().getFirstName());
            System.out.println(update.getMessage().getText());
            message.setText(update.getMessage().getText());

        }

    }
}
