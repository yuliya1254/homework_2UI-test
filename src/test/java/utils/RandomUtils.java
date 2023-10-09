package utils;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static org.apache.commons.lang3.StringUtils.length;

public class RandomUtils {


    public static String state;

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

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomDay(int min, int max) {
        String day = String.valueOf(ThreadLocalRandom.current().nextInt(min, max + 1));
        if (length(day) < 2) {
            day = "0" + day;
        }
        return day;
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomSubject() {
        String[] subject = {"Maths", "Chemistry", "Hindi"};
        return getRandomItemFromArray(subject);
    }

    public static String getRandomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        return getRandomItemFromArray(month);
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        state = getRandomItemFromArray(states);
        return state;
    }


    public static String getRandomCity() {
        String city = null;
        if (Objects.equals(state, "NCR")) {
            String[] cities = {"Delhi", "Gurgaon", "Noida"};
            city = getRandomItemFromArray(cities);
        }
        if (Objects.equals(state, "Uttar Pradesh")) {
            String[] cities = {"Agra", "Lucknow", "Merrut"};
            city = getRandomItemFromArray(cities);
        }
        if (Objects.equals(state, "Haryana")) {
            String[] cities = {"Karnal", "Panipat"};
            city = getRandomItemFromArray(cities);
        }
        if (Objects.equals(state, "Rajasthan")) {
            String[] cities = {"Jaipur", "Jaiselmer"};
            city = getRandomItemFromArray(cities);
        }

        return city;
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }
}



