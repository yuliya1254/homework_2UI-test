package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import java.util.Locale;

import static utils.RandomUtils.*;


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
                .checkResult("Date of Birth", testData.day +" "+ testData.month + "," +testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);


    }


//    @Test
//    void fillFormTestMondatory() {
//
//        registrationPage
//                .openPage()
//                .deleteBanner()
//                .setFirstNameInput("Ivan")
//                .setLastNameInput("Ivanov")
//                .setGenderWrapperInput("Male")
//                .setUserNumberInput("8988888888")
//                .setDateOfBirt("19", "June", "1994")
//                .clickSubmit()
//                .checkModalForm()
//                .checkModalFormTitle("Thanks for submitting the form")
//
//
//                .checkResult("Student Name", "Ivan Ivanov")
//                .checkResult("Gender", "Male")
//                .checkResult("Mobile", "8988888888")
//                .checkResult("Date of Birth", "19 June,1994");
//
//
//    }
//
//    @Test
//    void fillFormTestFaled() {
//
//        registrationPage
//                .openPage()
//                .deleteBanner()
//                .setLastNameInput("Ivanov")
//                .setGenderWrapperInput("Male")
//                .setUserNumberInput("8988888888")
//                .setDateOfBirt("19", "June", "1994")
//                .clickSubmit()
//                .checkModalFormFail();
//
//
//    }
}





