package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {


    CalendarComponent calendar = new CalendarComponent();

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
            uploadPicture = $("input[type=file]"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateCity = $("#stateCity-wrapper"),
            city = $("#city"),
            submit = $("#submit"),
            modalForm = $(".modal-dialog"),
            modalFormTitle = $("#example-modal-sizes-title-lg");


    //Actions


    @Step("Открыть страницу")
    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    @Step("Закрыть баннеры")
    public RegistrationPage deleteBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Ввести имя")
    public RegistrationPage setFirstNameInput(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Ввести фамилию")
    public RegistrationPage setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;

    }

    @Step("Ввести Email")
    public RegistrationPage setUserEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;

    }

    @Step("Выбрать пол")
    public RegistrationPage setGenderWrapperInput(String value) {
        genderWrapperInput.$(byText(value)).click();
        return this;

    }

    @Step("Ввести номер телефона")
    public RegistrationPage setUserNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;

    }

    @Step("Ввести дату рождения")
    public RegistrationPage setDateOfBirt(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;

    }

    @Step("Выбрать предмет")
    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Ввести хобби")
    public RegistrationPage setHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }

    @Step("Загрузить изображение")
    public RegistrationPage setUploadPicture(String value) {
        if (!browser.equals("firefox")) {
            uploadPicture.uploadFromClasspath(value);;
        }
        return this;
    }

    @Step("Ввести адрес")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Выбрать штат")
    public RegistrationPage setState(String value) {
        state.click();
        stateCity.$(byText(value)).click();
        return this;
    }

    @Step("Выбрать город")
    public RegistrationPage setCity(String value) {
        city.click();
        stateCity.$(byText(value)).click();
        return this;
    }

    @Step("Нажать на кнопку Sumbit")
    public RegistrationPage clickSubmit() {
        submit.click();
        return this;
    }

    @Step("Проверить открытие модельной формы")
    public RegistrationPage checkModalForm() {
        modalForm.should(appear);
        return this;
    }

    @Step("Проверить, что модельная форма не открылась")
    public RegistrationPage checkModalFormFail() {
        modalForm.shouldNot(appear);
        return this;
    }

    @Step("Проверить заголовок формы")
    public RegistrationPage checkModalFormTitle(String value) {

        modalFormTitle.shouldHave(text(value));
        return this;
    }


    @Step("Проверить результат заполнения формы")
    public RegistrationPage checkResult(String key, String value) {
        if (!(browser.equals("firefox") && key.equals("Picture"))) {
            checkResultComponent.checkResult(key, value);
        }
        return this;
    }


}
