package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class Automation_practice_form {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        registrationPage.beforeAllCase()
                .openPage()
                .setFirstNameInput("Ivan")
                .setLastNameInput("Ivanov")
                .setUserEmailInput("Ivanov@gmail.ru")
                .setGenderWrapperInput("Male")
                .setUserNumberInput("8988888888")
                .setDateOfBirt("19", "June", "1994")
                .setSubjectsInput("maths")
                .setHobbies("Sports")
                .setUploadPicture("test.jpg")
                .setCurrentAddress("my Adress")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit()
                .checkModalForm("Thanks for submitting the form")


                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "Ivanov@gmail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8988888888")
                .checkResult("Date of Birth", "19 June,1994")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "test.jpg")
                .checkResult("Address", "my Adress")
                .checkResult("State and City", "NCR Delhi");


    }


@Test
    void fillFormTestMondatory() {

        registrationPage.beforeAllCase()
                .openPage()
                .setFirstNameInput("Ivan")
                .setLastNameInput("Ivanov")
                .setGenderWrapperInput("Male")
                .setUserNumberInput("8988888888")
                .setDateOfBirt("19", "June", "1994")
                .clickSubmit()
                .checkModalForm("Thanks for submitting the form")


                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8988888888")
                .checkResult("Date of Birth", "19 June,1994");


    }

    @Test
    void fillFormTestFaled() {

        registrationPage.beforeAllCase()
                .openPage()
                .setLastNameInput("Ivanov")
                .setGenderWrapperInput("Male")
                .setUserNumberInput("8988888888")
                .setDateOfBirt("19", "June", "1994")
                .clickSubmit()
                .checkModalForm("Thanks for submitting the form")


                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8988888888")
                .checkResult("Date of Birth", "19 June,1994");


    }
}





