package SelenidePages;

import static com.codeborne.selenide.Selenide.page;

public class SelenideBasePage<T> {

    public T me() {
        return page((T) this);
    }
}
