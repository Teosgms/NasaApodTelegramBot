import com.fasterxml.jackson.annotation.JsonProperty;

public class NasaAnswer {
    String copyright;
    String date;
    String explanation;
    String hdurl;
    String media_type;
    String service_version;
    String title;
    String url;

    public NasaAnswer(@JsonProperty("copyright") String copyright,
                      @JsonProperty("date") String date,
                      @JsonProperty("explanation") String explanation,
                      @JsonProperty("hdurl") String hdurl,
                      @JsonProperty("url") String url,
                      @JsonProperty("service_version") String service_version,
                      @JsonProperty("media_type") String media_type,
                      @JsonProperty("title") String title) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.url = url;
        this.service_version = service_version;
        this.media_type = media_type;
        this.title = title;
    }
}