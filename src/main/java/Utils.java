import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;

public class Utils {
    public static String getImage(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            ObjectMapper mapper = new ObjectMapper();
            NasaAnswer answer = mapper.readValue(response1.getEntity().getContent(), NasaAnswer.class);
            String imageUrl = answer.url;
            return imageUrl;
        } catch (IOException e) {
            return "Nasa APOD server doesn't answer";
        }
    }
}
