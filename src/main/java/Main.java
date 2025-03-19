import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException, TelegramApiException {
        new NasaBot("your_username",    //put username of your bot
                "your_token");                      //put your bot token
    }
}
