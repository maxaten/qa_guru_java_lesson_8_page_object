package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year){
        $(".react-datepicker__month-select").click();
        $(".react-datepicker").$("[value='" + month + "']").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$("[value='" + year + "']").click();
        $(".react-datepicker__day--0" +day).click();

    }

}
