package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;


public class AutomationPracticeForm extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    @Tag("registratin")
    @Story("Регистрация клиента")
    @Owner("Meschikowa")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "automation-practice-form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Регистрация клиента")
    void fillFormTest() {
        step ("Открыть форму https://demoqa.com/automation-practice-form",() ->{
                registrationPage
                        .openPage()
                        .deleteBanner();
        });

        step ("Заполнить поля на форме",() ->{
            registrationPage
                    .setLastNameInput(testData.lastName)
                    .setUserEmailInput(testData.userEmail)
                    .setGenderWrapperInput(testData.gender)
                    .setUserNumberInput(testData.userNumber)
                    .setDateOfBirt(testData.day, testData.month, testData.year)
                    .setSubjectsInput(testData.subject)
                    .setHobbies(testData.hobbies)
                    .setUploadPicture(testData.picture)
                    .setCurrentAddress(testData.address)
                    .setState(testData.state)
                    .setCity(testData.city);
        });

        step ("Нажать кнопку Submit ",() ->{
            registrationPage
                    .checkModalFormTitle(testData.textForCheck)
                    .clickSubmit()
                    .checkModalForm();

        });

        step ("Проверить результат заполнения формы ",() ->{
            registrationPage
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Student Email", testData.userEmail)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                    .checkResult("Subjects", testData.subject)
                    .checkResult("Hobbies", testData.hobbies)
                    .checkResult("Picture", testData.picture)
                    .checkResult("Address", testData.address)
                    .checkResult("State and City", testData.state + " " + testData.city);

        });



    }


    @Test
    @Tag("registratin")
    @Story("Регистрация клиента")
    @Owner("Meschikowa")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "automation-practice-form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Регистрация клиента. Заполнены только обязательные поля")
    void fillFormTestMondatory() {

        step ("Открыть форму https://demoqa.com/automation-practice-form",() ->{
            registrationPage
                    .openPage()
                    .deleteBanner();
        });

        step ("Заполнить обязельные поля на форме",() ->{
            registrationPage
                    .setFirstNameInput(testData.firstName)
                    .setLastNameInput(testData.lastName)
                    .setGenderWrapperInput(testData.gender)
                    .setUserNumberInput(testData.userNumber)
                    .setDateOfBirt(testData.day, testData.month, testData.year)
                    .clickSubmit()
                    .checkModalForm()
                    .checkModalFormTitle(testData.textForCheck);
        });

        step ("Нажать кнопку Submit ",() ->{
            registrationPage
                    .checkModalFormTitle(testData.textForCheck)
                    .clickSubmit()
                    .checkModalForm();

        });

        step ("Проверить результат заполнения формы ",() ->{
            registrationPage
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year);


        });


    }

    @Test
    @Tag("registratin")
    @Story("Регистрация клиента")
    @Owner("Meschikowa")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "automation-practice-form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Регистрация клиента. Не заполнено обязательное поле")
    void fillFormTestFaled() {
            step ("Открыть форму https://demoqa.com/automation-practice-form",() ->{
                registrationPage
                        .openPage()
                        .deleteBanner();
            });

            step ("Заполнить не все обязельные поля на форме",() ->{
                registrationPage
                        .setLastNameInput(testData.lastName)
                        .setGenderWrapperInput(testData.gender)
                        .setUserNumberInput(testData.userNumber);
            });

            step ("Нажать кнопку Submit ",() ->{
                registrationPage
                        .clickSubmit()
                        .checkModalFormFail();

            });


    }
}





