package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    private final Faker faker = new Faker(new Locale("en-GB"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String gender = faker.options().option("Male", "Female", "Other");
    String year = String.valueOf(faker.number().numberBetween(1950, 2023));
    String month = faker.options().option("January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December");
    String day = setDay(String.valueOf(faker.number().numberBetween(1, 28)));
    String subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry",
            "Computer Science", "Commerce", "Accounting", "Economics",
            "Arts", "Social Studies", "History", "Civics");
    String hobby = faker.options().option("Sports", "Reading", "Music");
    String picture = "kitty.jpg";
    String currentAddress = faker.address().streetAddress();
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String city = setRandomCity(state);

    public String setRandomCity(String state) {
        switch (state) {
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
        }
        return city;
    }

    public String setDay(String day) {
        if (day.length() < 2) {
            return "0" + day;
        } else return day;

    }
}

