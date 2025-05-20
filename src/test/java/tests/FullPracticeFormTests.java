package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;

public class FullPracticeFormTests extends TestBase {

    String firstName = getRandomFirstName();
    String lastName = getRandomLastName();
    String email = getRandomEmail();
    String gender = getRandomGender();
    String userNumber = getRandomNumberPhone();
    String birthDay = getRandomBirthDay();
    String birthMonth = getRandomBirthMonth();
    String birthYear = getRandomBirthYear();
    String subject = getRandomSubject();
    String hobbies = getRandomHobby();
    String address = getRandomAddress();
    String state = getRandomState();
    String city = getRandomCity(state);


    RegistrationPage registrationPage = new RegistrationPage();

        @Test
        void studentRegistrationFormTests() {
            registrationPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setDateOfBirth(birthDay, birthMonth, birthYear)
                    .setSubjects(subject)
                    .setHobbies(hobbies)
                    .setPicture()
                    .setAddress(address)
                    .setState(state)
                    .setCity(city)
                    .clickSubmitBtn();

            registrationPage.checkResult("Label", "Values")
                            .checkResult("Student Name", firstName + " " + lastName)
                            .checkResult("Student Email", email)
                            .checkResult("Gender", gender)
                            .checkResult("Mobile", userNumber)
                            .checkResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                            .checkResult("Subjects", subject)
                            .checkResult("Hobbies", hobbies)
                            .checkResult("Picture", "img.png")
                            .checkResult("Address", address)
                            .checkResult("State and City", state + " " + city);

        }
    }
