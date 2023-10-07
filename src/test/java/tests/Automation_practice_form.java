package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static utils.RandomUtils.*;


public class Automation_practice_form {
    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker(new Locale("en-GB"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = getRandomEmail();
    String gender = getRandomGender();
    String userNumber = getRandomNumbers(11);
    String day = getRandomDay(10,28);
    String month = getRandomMonth();

    String year = String.valueOf(getRandomInt(1900,2100));


    @Test
    void fillFormTest() {

        registrationPage.beforeAllCase()
                .openPage()
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setUserEmailInput(userEmail)
                .setGenderWrapperInput(gender)
                .setUserNumberInput(userNumber)
                .setDateOfBirt(day, month, year)
                .setSubjectsInput("maths")
                .setHobbies("Sports")
                .setUploadPicture("test.jpg")
                .setCurrentAddress("my Adress")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit()
                .checkModalForm()
                .checkModalFormTitle("Thanks for submitting the form")


                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", "19 June,1994")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "test.jpg")
                .checkResult("Address", "my Adress")
                .checkResult("State and City", "NCR Delhi");


    }


//    @Test
//    void fillFormTestMondatory() {
//
//        registrationPage.beforeAllCase()
//                .openPage()
//                .setFirstNameInput(firstName)
//                .setLastNameInput(lastName)
//                .setGenderWrapperInput(gender)
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
//        registrationPage.beforeAllCase()
//                .openPage()
//                .setLastNameInput(firstName)
//                .setGenderWrapperInput("Male")
//                .setUserNumberInput("8988888888")
//                .setDateOfBirt("19", "June", "1994")
//                .clickSubmit()
//                .checkModalFormFail();
//
//
//    }
}





