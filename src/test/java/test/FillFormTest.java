package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseliberary.BaseLiberary;
import pages.FillForm;

public class FillFormTest extends BaseLiberary{

	
	FillForm ff;

	@BeforeTest
	public void openurl() {
		launchurl();
		ff = new FillForm();

	}
	
	@Test
	public void fillform() {
		
		ff.entername();
		ff.email();
		ff.phone();
		ff.address();
		ff.gender();
		ff.days();
		ff.selectcountry();
		ff.selcolor();
	}
	
	@AfterTest
	public void close() {
		closeurl();
	}
	
}
