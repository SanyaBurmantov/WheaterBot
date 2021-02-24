import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import services.PostJSON;

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

        String command= update.getMessage().getText();

        message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());
        if(command.equals("как дела?")) {
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Нормально");
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if(command.equals("иди нахуй")) {
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("сам иди "+update.getMessage().getFrom().getFirstName());
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if(command.equals("говно")) {
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("это ты говно,  " + update.getMessage().getFrom().getFirstName());
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if(command.equals("/погода")) {

            System.out.println("В разработке");
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("Вводи город братик");
            PostJSON.PostJSON();
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();}

            if (command != null){
                update.getMessage().getText();
                message.setChatId(update.getMessage().getChatId().toString());
                message.setText("Отсоси, потом проси");

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
