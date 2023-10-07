package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.RandomUtils.*;

public class TestData {

    Faker faker = new Faker(new Locale("en-GB"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String gender = getRandomGender();
    public String userNumber = getRandomNumbers(10);
    public String day = getRandomDay(10, 28);
    public String month = getRandomMonth();
    public String year = String.valueOf(getRandomInt(1900, 2100));
    public String subject = getRandomSubject();
    public String hobbies = getRandomHobbies();
    public String picture = "test.jpg";
    public String address = faker.address().fullAddress();
    public String state = getRandomState() ;
    public String city = getRandomCity() ;
    public String textForCheck = "Thanks for submitting the form";

}
