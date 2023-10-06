package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.BeforeAllComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    BeforeAllComponent beforeAll = new BeforeAllComponent();


    //SelenideElement

    SelenideElement
            fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            buttonSubmit = $("#submit"),
            resultTable = $("#output");


    //Actions

    public TextBoxPage beforeAllCase() {
        beforeAll.beforeAllCase();
        return this;
    }

    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public TextBoxPage setFullNameInput(String value) {
        fullNameInput.setValue(value);
        return this;
    }
    public TextBoxPage setEmailInput(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddressInput(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage clickButtonSubmit() {
        buttonSubmit.click();
        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        resultTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }


}
