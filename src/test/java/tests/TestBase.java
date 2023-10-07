package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeEach
    public void beforeAllCase() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
    }

        @AfterEach
        public void afterEach () {
            Selenide.clearBrowserCookies();
            Selenide.clearBrowserLocalStorage();

    }
}
