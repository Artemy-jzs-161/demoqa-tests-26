package tests;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String gender = faker.options().option("Male", "Female", "Other");
    String year = faker.number().numberBetween(1900, 2020) + "";
    String month = faker.options().option("January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December");
    String day = faker.number().numberBetween(1, 31) + "";
    String subject = faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry",
            "Computer Science", "Commerce", "Accounting", "Economics",
            "Arts", "Social Studies", "History", "Civics");
    String hobby = faker.options().option("Sports", "Reading", "Music");
    String picture = "img/kitty.jpg";
    String currentAddress = faker.address().streetAddress();
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String city = "Delhi";



}
