package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseliberary.BaseLiberary;

public class DatePicker extends BaseLiberary {

    public DatePicker() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "datepicker")
    private WebElement datepicker1;

    @FindBy(className = "ui-datepicker-month")
    private WebElement currentMonth;

    @FindBy(className = "ui-datepicker-year")
    private WebElement currentYear;

    @FindBy(xpath = "//a[@title='Prev']")
    private WebElement previousButton;

    @FindBy(xpath = "//a[@title='Next']")
    private WebElement nextButton;

    // 1st way — SendKeys directly
    public void datepicker() {
        datepicker1.sendKeys("04/07/2025"); // dd/MM/yyyy
    }

    // 2nd way — Calendar UI
    public void datepicker_1(String targetMonth, String targetDay, String targetYear) throws InterruptedException {
        datepicker1.click();

        while (true) {
            String displayedMonth = currentMonth.getText();
            String displayedYear = currentYear.getText();

            if (displayedMonth.equals(targetMonth) && displayedYear.equals(targetYear)) {
                break;
            }

            int displayedYearInt = Integer.parseInt(displayedYear);
            int targetYearInt = Integer.parseInt(targetYear);

            if (displayedYearInt > targetYearInt ||
                (displayedYearInt == targetYearInt && isMonthAfter(displayedMonth, targetMonth))) {
                previousButton.click();
            } else {
                nextButton.click();
            }

            Thread.sleep(300);
        }

        driver.findElement(
            org.openqa.selenium.By.xpath("//a[text()='" + targetDay + "']")
        ).click();
    }

    // Month comparison
    private boolean isMonthAfter(String displayedMonth, String targetMonth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        int displayedMonthValue = LocalDate.parse("07"+"01 " +  " 2025", formatter).getMonthValue();
        int targetMonthValue = LocalDate.parse("04"+"01 " +  " 2025", formatter).getMonthValue();
        return displayedMonthValue > targetMonthValue;
    }
}
