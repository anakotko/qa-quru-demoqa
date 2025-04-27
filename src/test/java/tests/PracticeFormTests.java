package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

        @BeforeAll
        static void setupConfig(){
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.pageLoadStrategy = "eager";
            Configuration.holdBrowserOpen = true;
            Configuration.timeout = 5000;
        }

        @Test
        void studentRegistrationFormTests() {
            open("/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");

            $("#firstName").setValue("Alex");
            $("#lastName").setValue("Morozov");
            $("#userEmail").setValue("alex@morozov.com");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("3456789876");


            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption("2015");
            $(".react-datepicker__month-select").selectOption("March");
            $$("div.react-datepicker__day").findBy(text("4")).click();


            $("#subjectsInput").setValue("Arts").pressEnter();
            $("[for=hobbies-checkbox-2]").click();
            $("#uploadPicture").uploadFromClasspath("img.png");
            $("#currentAddress").setValue("Some street 1 ");

            $("#state").click();
            $("#react-select-3-input").setValue("Haryana").pressEnter();
            $("#city").click();
            $("#react-select-4-input").setValue("Panipat").pressEnter();

            $("#submit").click();

            $$("table tr").findBy(text("Label")).shouldHave(text("Values"));
            $$("table tr").findBy(text("Student Name")).shouldHave(text("Alex Morozov"));
            $$("table tr").findBy(text("Student Email")).shouldHave(text("alex@morozov.com"));
            $$("table tr").findBy(text("Gender")).shouldHave(text("Male"));
            $$("table tr").findBy(text("Mobile")).shouldHave(text("3456789876"));
            $$("table tr").findBy(text("Date of Birth")).shouldHave(text("04 March,2015"));
            $$("table tr").findBy(text("Subjects")).shouldHave(text("Arts"));
            $$("table tr").findBy(text("Hobbies")).shouldHave(text("Reading"));
            $$("table tr").findBy(text("Picture")).shouldHave(text("img.png"));
            $$("table tr").findBy(text("Address")).shouldHave(text("Some street 1"));
            $$("table tr").findBy(text("State and City")).shouldHave(text("Haryana Panipat"));



        }
    }
