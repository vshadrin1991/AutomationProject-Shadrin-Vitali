package PageObject.Moodpanda;

public enum Titles {
    ABOUT("About"),
    FAQ("FAQs"),
    LOGIN("Login");

    private String title;

    Titles(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
