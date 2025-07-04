package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseliberary.BaseLiberary;
import pages.DatePicker;

public class DatePickerTest extends BaseLiberary {

    DatePicker dp;

    @BeforeTest
    public void openurl() {
        launchurl();
        dp = new DatePicker();
    }

    @Test(priority = 1)
    public void datepickWithSendKeys() {
        dp.datepicker(); // Direct sendKeys method
    }

    @Test(priority = 2)
    public void datepickUsingCalendar() throws InterruptedException {
        dp.datepicker_1("07", "01","2025"); // Use full month name
    }

    @AfterTest
    public void close() {
        closeurl();
    }
}
