package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckBox = $("[for=hobbies-checkbox-2]"),
            pictureButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            selectState = $("#state"),
            stateInput = $("#react-select-3-input"),
            selectCity = $("#city"),
            cityInput = $("#react-select-4-input"),
            submitBtn = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbiesCheckBox.setValue(value).click();

        return this;

    }
    public RegistrationPage setPicture(){
        pictureButton.uploadFromClasspath("img.png");

        return this;
    }

    public RegistrationPage setAddress(String value){
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value){
        selectState.click();
        stateInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String value){
        selectCity.click();
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }

    public RegistrationPage checkResult(String key, String value){

        checkResultComponent.checkResultFullForm(key, value);
        return this;
    }
}