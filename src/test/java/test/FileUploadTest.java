package test;

import java.awt.AWTException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseliberary.BaseLiberary;
import pages.FileUpload;

public class FileUploadTest extends BaseLiberary {

	FileUpload fileupload;

	@BeforeTest
	public void openurl() {
		launchurl();
		fileupload = new FileUpload();
	}

	// @Test(priority=1)
	public void singlefilefileupload() {
		fileupload.choosefileclick();
	}

	@Test(priority = 2)
	public void multifileupload() throws AWTException, InterruptedException {
		fileupload.uploadmultifile();

	}

	// @AfterTest
	public void close() {
		closeurl();

	}

}
