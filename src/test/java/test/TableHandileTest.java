package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseliberary.BaseLiberary;
import pages.TableHandling;

public class TableHandileTest extends BaseLiberary {

	TableHandling tablehandle;

	@BeforeTest
	public void openurl() {
		launchurl();
		tablehandle = new TableHandling();

	}

	@Test
	public void statictablehandletest() {
		tablehandle.statictablehandle();
	}

	@AfterTest
	public void closbrowser() {
		tablehandle.closeurl();
	}

}
