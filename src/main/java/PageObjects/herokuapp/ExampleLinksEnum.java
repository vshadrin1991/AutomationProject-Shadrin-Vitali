package PageObjects.herokuapp;

public enum ExampleLinksEnum {
    AB_TESTING("A/B Testing"),
    ADD_REMOVE("Add/Remove Elements"),
    BASIC_AUTH("Basic Auth"),
    BROKEN_IMAGES("Broken Images"),
    CHALLENGING_DOM("Challenging DOM"),
    CHECKBOXES("Checkboxes"),
    CONTEXT_MENU("Context Menu"),
    DIGEST_AUTH("Digest Authentication"),
    DISAPPEARING_ELEMENTS("Disappearing Elements"),
    DRAG_AND_DROP("Drag and Drop"),
    DROPDOWN("Dropdown"),
    DYNAMIC_CONTENT("Dynamic Content"),
    DYNAMIC_CONTROLS("Dynamic Controls"),
    DYNAMIC_LOADING("Dynamic Loading"),
    ENTRY_AD("Entry Ad"),
    EXIT_INTENT("Exit Intent"),
    FILE_DOWNLOAD("File Download"),
    FILE_UPLOAD("File Upload"),
    FLOATING_MENU("Floating Menu"),
    FORGOT_PASSWORD("Forgot Password"),
    FORM_AUTH("Form Authentication"),
    FRAMES("Frames"),
    GEOLOCATION("Geolocation"),
    HORIZONTAL_SLIDER("Horizontal Slider"),
    HOVERS("Hovers"),
    INFINITE_SCROLL("Infinite Scroll"),
    INPUTS("Inputs"),
    JQUERY_MENU("JQuery UI Menus"),
    JS_ALERTS("JavaScript Alerts"),
    JS_ERROR("JavaScript onload event error"),
    KEY_PRESSES("Key Presses"),
    DEEP_DOM("Large & Deep DOM"),
    MULTIPLE_WINDOWS("Multiple Windows"),
    NESTED_FRAMES("Nested Frames"),
    NOTIFICATION("Notification Messages"),
    REDIRECT_LINK("Redirect Link"),
    SECURE_FILE_DOWNLOAD("Secure File Download"),
    SHADOW_DOM("Shadow DOM"),
    SHIFTING_CONTENT("Shifting Content"),
    SLOW_RESOURCES("Slow Resources"),
    SORTABLE_DATA_TABLES("Sortable Data Tables"),
    STATUS_CODE("Status Codes"),
    TYPOS("Typos"),
    WYSIWYG("WYSIWYG Editor");

    public String example;

    ExampleLinksEnum(String example) {
        this.example = example;
    }

    public String getExample() {
        return example;
    }
}
