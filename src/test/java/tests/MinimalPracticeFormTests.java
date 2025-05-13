package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class MinimalPracticeFormTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void studentRegistrationFormTests() {

        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Morozov")
                .setGender("Male")
                .setUserNumber("3456789876")
                .clickSubmitBtn();

        registrationPage.checkResult("Label", "Values")
                .checkResult("Student Name", "Alex Morozov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "3456789876");
    }
}
