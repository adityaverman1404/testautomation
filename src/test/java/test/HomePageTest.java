package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseliberary.BaseLiberary;
import pages.Homepage;

public class HomePageTest extends BaseLiberary {
	Homepage hp;

	@BeforeTest
	public void openurl() {
		launchurl();
		hp = new Homepage();

	}

	@Test(priority = 1)
	public void clickonHome() {
		hp.clickHome();

	}

	@Test(priority = 2)
	public void udemycourses() {

		hp.clickUdemyCourses();

	}

	@AfterTest
	public void close() {
		closeurl();
	}

}