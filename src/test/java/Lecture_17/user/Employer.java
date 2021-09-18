package Lecture_17.user;

import lombok.Data;

@Data
public class Employer {
    public String id;
    public String name;
    public String url;
    public String alternate_url;
    public LogoUrls logo_urls;
    public String vacancies_url;
    public boolean trusted;
}
