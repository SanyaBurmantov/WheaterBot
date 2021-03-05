package telegram;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class StartBot {
public static void StartBot() throws TelegramApiException{

    TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
    try {
        botsApi.registerBot(new WeatherTestApplication_bot());
    } catch (TelegramApiException e) {
        e.printStackTrace();
    }


}

}
