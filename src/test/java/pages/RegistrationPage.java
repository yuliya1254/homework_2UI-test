package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.BeforeAllComponent;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    BeforeAllComponent beforeAll = new BeforeAllComponent();

    //SelenideElement
    SelenideElement

            firstNameInput = $("#firstName"),
            lastNameInput =  $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber");


    //Actions


    public RegistrationPage beforeAllCase (){
        beforeAll.beforeAllCase();

        return this;
    }
    public RegistrationPage openPage (){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public RegistrationPage setFirstNameInput(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastNameInput (String value){
        lastNameInput.setValue(value);
        return this;

    }

    public RegistrationPage setUserEmailInput(String value){
        userEmailInput.setValue(value);
        return this;

    }

    public RegistrationPage setGenderWrapperInput(String value){
        genderWrapperInput.$(byText(value)).click();
        return this;

    }

    public RegistrationPage setUserNumberInput(String value){
        userNumberInput.setValue(value);
        return this;

    }

    public RegistrationPage setDateOfBirt(String day,String month, String year){
        $("#dateOfBirthInput").click();
        calendar.setDate("19","June", "1994" );
        return this;

    }



}
