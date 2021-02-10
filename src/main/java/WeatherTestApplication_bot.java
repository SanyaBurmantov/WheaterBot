import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class WeatherTestApplication_bot extends TelegramLongPollingBot {

    public String getBotUsername() {
        return "weathertestapplication_bot";
    }

    public String getBotToken() {
        return "1675716167:AAENqrZts_AG5aY_W2tJdBf4VBcWD4_fSdk";
    }

    public void onUpdateReceived(Update update) {

    }
}
