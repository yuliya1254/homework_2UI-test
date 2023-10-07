package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.BeforeAllComponent;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {


    CalendarComponent calendar = new CalendarComponent();
    BeforeAllComponent beforeAll = new BeforeAllComponent();

    CheckResultComponent checkResultComponent = new CheckResultComponent();

    //SelenideElement
    SelenideElement

            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateCity = $("#stateCity-wrapper"),
            city = $("#city"),
            submit = $("#submit"),
            modalForm = $(".modal-dialog"),
            modalFormTitle = $("#example-modal-sizes-title-lg");


    //Actions


    public RegistrationPage beforeAllCase() {
        beforeAll.beforeAllCase();

        return this;
    }

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstNameInput(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;

    }

    public RegistrationPage setUserEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;

    }

    public RegistrationPage setGenderWrapperInput(String value) {
        genderWrapperInput.$(byText(value)).click();
        return this;

    }

    public RegistrationPage setUserNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;

    }

    public RegistrationPage setDateOfBirt(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;

    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath("test.jpg");
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateCity.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        stateCity.$(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submit.click();
        return this;
    }

    public RegistrationPage checkModalForm() {
        modalForm.should(appear);
        return this;
    }

    public RegistrationPage checkModalFormFail() {
        modalForm.shouldNot(appear);
        return this;
    }

    public RegistrationPage checkModalFormTitle(String value) {

        modalFormTitle.shouldHave(text(value));
        return this;
    }


    public RegistrationPage checkResult(String key, String value) {
        checkResultComponent.checkResult(key, value);
        return this;
    }


}
