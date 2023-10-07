package utils;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

import static org.apache.commons.lang3.StringUtils.length;

public class RandomUtils {



    public static String getRandomString(int len) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static String getRandomNumbers(int len) {

        String AB = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }


    public static String getRandomEmail() {
        return getRandomString(10) + "@qa.guru";
    }

//    public static String getRandomAddress() {
//        return getRandomString(10) + " " + getRandomString(10) + " " + getRandomString(10);
//    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomDay(int min, int max) {
        String  day = String.valueOf(ThreadLocalRandom.current().nextInt(min, max + 1));
        if (length(day)<2){
            day =  "0" + day;
        }
        return day;
    }


//    public static String getRandomPhone() {
//        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
//                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
//    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomSubject() {
        String[] subject = {"Moths", "Chemistry", "Hindi"};
        return getRandomItemFromArray(subject);
    }

    public static String getRandomMonth() {
        String[]  month = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October","November","December"};
        return getRandomItemFromArray(month);
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }
}



