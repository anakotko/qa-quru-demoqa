package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class FullPracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

        @Test
        void studentRegistrationFormTests() {
            registrationPage.openPage()
                    .setFirstName("Alex")
                    .setLastName("Morozov")
                    .setEmail("alex@morozov.com")
                    .setGender("Male")
                    .setUserNumber("3456789876")
                    .setDateOfBirth("04", "March", "2015")
                    .setSubjects("Arts")
                    .setHobbies()
                    .setPicture()
                    .setAddress("Some street 1 ")
                    .setState("Haryana")
                    .setCity("Panipat")
                    .clickSubmitBtn();

            registrationPage.checkResult("Label", "Values")
                            .checkResult("Student Name", "Alex Morozov")
                            .checkResult("Student Email", "alex@morozov.com")
                            .checkResult("Gender", "Male")
                            .checkResult("Mobile", "3456789876")
                            .checkResult("Date of Birth", "04 March,2015")
                            .checkResult("Subjects", "Arts")
                            .checkResult("Hobbies", "Reading")
                            .checkResult("Picture", "img.png")
                            .checkResult("Address", "Some street 1")
                            .checkResult("State and City", "Haryana Panipat");

        }
    }
