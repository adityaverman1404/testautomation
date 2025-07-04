package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseliberary.BaseLiberary;

public class Homepage extends BaseLiberary {

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='PageList2']//a[normalize-space()='Home']")
	private WebElement Home;

	@FindBy(xpath = "//a[text()='Udemy Courses']")
	private WebElement UdemyCourses;

	public void clickHome() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Home.click();
	}

	public void clickUdemyCourses() {

		UdemyCourses.click();
	}

}