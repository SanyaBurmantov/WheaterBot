import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {

            botsApi.registerBot(new WeatherTestApplication_bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
   List<Integer> list = new LinkedList<Integer>();

}