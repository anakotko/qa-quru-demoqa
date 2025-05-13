package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__year-select").selectOption("2015");
        $(".react-datepicker__month-select").selectOption("March");
        $$("div.react-datepicker__day").findBy(text("4")).click();
    }
}
