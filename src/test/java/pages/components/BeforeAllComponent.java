package pages.components;

import com.codeborne.selenide.Configuration;

public class BeforeAllComponent {
    public void beforeAllCase (){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";


    }
}
