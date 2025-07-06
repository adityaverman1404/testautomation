package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtility.WaitUtils;
import baseliberary.BaseLiberary;

public class FileUpload extends BaseLiberary  {

	WaitUtils wait;

	public FileUpload() {

		PageFactory.initElements(driver, this);
		wait = new WaitUtils(driver);
	}

	// ****************************************//

	@FindBy(xpath = "//input[@id='singleFileInput']")
	private WebElement choosefile;

	@FindBy(xpath ="//button[text()='Upload Single File']")
	private WebElement upload;

	@FindBy(xpath ="//input[@id='multipleFilesInput']")
	private WebElement choosefilemulti;

	@FindBy(xpath = "//button[text()='Upload Multiple Files']")
	private WebElement uploadmulti;

	// Single file upload
	public void choosefileclick() {

		wait.waitForElementVisible(choosefile, 5).sendKeys("C:\\Users\\AdityaMaurya\\Downloads\\aditya.txt");
		//choosefile.sendKeys("C:\\Users\\AdityaMaurya\\Downloads\\test.txt");
		wait.waitForElementClickable(upload, 5).click();
		
		
	}

	// multi file upload
	public void uploadmultifile() throws AWTException, InterruptedException {
		
		//wait.waitForElementVisible(choosefilemulti, 5).click();
		choosefilemulti.click();
		
	/*	String Filepath= "C:\\Users\\AdityaMaurya\\Downloads\\aditya.txt\nC:\\Users\\AdityaMaurya\\Downloads\\test.txt";
		
		StringSelection selection= new StringSelection(Filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		 
		
		wait.waitForElementClickable(uploadmulti, 5).click();
		*/
		
	
	}
	
	
	

}
