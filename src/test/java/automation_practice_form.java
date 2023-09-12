import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class automation_practice_form {
        @BeforeAll
        static void beforeAll() {
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.pageLoadStrategy = "eager";
            Configuration.holdBrowserOpen = false;
            Configuration.browserSize = "1920x1080";



        }

        @Test
        void fillFormTest() {
            open("/automation-practice-form");
            $("#firstName").setValue("Ivan");
            $("#lastName").setValue("Ivanov");
            $("#userEmail").setValue("Ivanov@gmail.ru");
            executeJavaScript("document.getElementById('submit').click()");
            $(new ByText("Male")).click();
            $("#userNumber").setValue("8988888888");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-dropdown-container").$(byText("June")).click();
            $(".react-datepicker__year-select").selectOption("1994");
            $(".react-datepicker__day--019").click();
            $("#subjectsInput").setValue("maths").pressEnter();
            $(new ByText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("test.jpg");
            $("#currentAddress").setValue("my Adress");
            $("#state").click();
            $("#react-select-3-input").setValue("NCR").pressEnter();
            $("#city").click();
            $("#react-select-4-input").setValue("Delhi").pressEnter();
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
            $("#submit").click();

            $(".table-responsive").shouldHave(
                    text("Ivan Ivanov"),
                    text("Ivanov@gmail.ru"),
                    text("Male"),
                    text("8988888888"),
                    text("19 June,1994"),
                    text("maths"),
                    text("Sports"),
                    text("test.jpg"),
                    text("my Adress"),
                    text("NCR Delhi"));


        }
    }






