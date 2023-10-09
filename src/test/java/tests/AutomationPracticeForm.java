package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class AutomationPracticeForm extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    void fillFormTest() {

        registrationPage
                .openPage()
                .deleteBanner()
                .setFirstNameInput(testData.firstName)
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
                .setCity(testData.city)
                .clickSubmit()
                .checkModalForm()
                .checkModalFormTitle(testData.textForCheck)


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


    }


    @Test
    void fillFormTestMondatory() {

        registrationPage
                .openPage()
                .deleteBanner()
                .setFirstNameInput(testData.firstName)
                .setLastNameInput(testData.lastName)
                .setGenderWrapperInput(testData.gender)
                .setUserNumberInput(testData.userNumber)
                .setDateOfBirt(testData.day, testData.month, testData.year)
                .clickSubmit()
                .checkModalForm()
                .checkModalFormTitle(testData.textForCheck)


                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year);


    }

    @Test
    void fillFormTestFaled() {

        registrationPage
                .openPage()
                .deleteBanner()
                .setFirstNameInput(testData.firstName)
                .setLastNameInput(testData.lastName)
                .setGenderWrapperInput(testData.gender)
                .setUserNumberInput(testData.userNumber)
                .clickSubmit();


    }
}





