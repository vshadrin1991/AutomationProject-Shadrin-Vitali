package Lecture_17.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LogoUrls {
    public String original;
    @JsonProperty("240")
    public String _240;
    @JsonProperty("90")
    public String _90;
}
