package SelenidePages;

public enum NavigationEnum {
    LOGIN("Login"),
    OVERVIEW("Overview"),
    IOS("iOS"),
    ANDROID("Android"),
    ABOUT("About");

    private String menu;

    NavigationEnum(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }
}
