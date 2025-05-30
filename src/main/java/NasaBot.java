import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class NasaBot extends TelegramLongPollingBot {
    String url = "https://api.nasa.gov/planetary/apod" +
            "?api_key=sUbHGg3CgCH7Y0778DKvBCWNt6Bpvy91sC5RZbdB";
    String botUserName;
    String botToken;

    public NasaBot(String botUserName, String botToken) throws TelegramApiException {
        this.botUserName = botUserName;
        this.botToken = botToken;
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();
            DataBase(chatId, text);
            System.out.println(update.getMessage().getChatId() + ": " + text);
            String[] splitedText = text.split(" ");
            String option = splitedText[0];
            switch (option) {
                case "/start":
                    sendMessage(chatId, "I'm Nasa bot. I'm able to send Astronomic picture of the day. Use /help");
                    break;
                case "/help":
                    sendMessage(chatId, "Enter /image to get today's picture,\n" +
                            "or /date YYYY-MM-DD, to get image of any your day");
                    break;
                case "/image":
                    String image = Utils.getImage(url);
                    sendMessage(chatId, image);
                    break;
                case "/date":
                    String date = splitedText[1];
                    image = Utils.getImage(url + "&date=" + date);
                    sendMessage(chatId, image);
                    break;
                default:
                    sendMessage(chatId, "Unknown option");
            }
        }
    }

    void sendMessage(long chatId, String option) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(option);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public static void DataBase(long ChatId, String text) {
        Path path = Path.of("C:\\Users\\admin\\NasaBot2\\src\\main\\Users\\" + ChatId + ".md");
        Date dateofmessage = new Date();
        String textCollecter = dateofmessage + ": " + text;
        try {
            if (Files.exists(path)) {
                Files.writeString(path, Files.readString(path) + "\n" + textCollecter);
            } else {
                Files.createFile(path);
                Files.writeString(path, Files.readString(path) + textCollecter);
            }
        } catch (IOException e) {
        throw new RuntimeException(e);
        }
    }
}
