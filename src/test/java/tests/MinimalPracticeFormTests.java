package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomNumberPhone;

public class MinimalPracticeFormTests extends TestBase{

    String firstName = getRandomFirstName();
    String lastName = getRandomLastName();
    String gender = getRandomGender();
    String userNumber = getRandomNumberPhone();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void studentRegistrationFormTests() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickSubmitBtn();

        registrationPage.checkResult("Label", "Values")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }
}
