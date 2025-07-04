package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import baseliberary.BaseLiberary;

public class FillForm extends BaseLiberary {

	public FillForm() {
		PageFactory.initElements(driver, this);
	}

	// ****************************************************//
	@FindBy(xpath = "//input[@id='name']")
	private WebElement name;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phone;

	@FindBy(xpath = "//textarea[@id='textarea']")
	private WebElement address;

	@FindBy(xpath = "//input[@id='male']")
	private WebElement gender;

	@FindBy(xpath = "//input[@id='sunday']")
	private WebElement sunday;

	@FindBy(xpath = "//input[@id='monday']")
	private WebElement monday;

	@FindBy(xpath = "//select[@id='country']")
	private WebElement country;

	@FindBy(xpath = "//select[@id='colors']")
	private WebElement colors;

	// ****************************************************//
	public void entername() {
		name.sendKeys("aditya");
	}

	public void email() {
		email.sendKeys("test@gmail.com");
	}

	public void phone() {
		phone.sendKeys("9876543210");
	}

	public void address() {
		address.sendKeys("jkdfhf fi efooief foifeoife ff of eofff eofefef oiefef ");
	}

	public void gender() {
		gender.click();
	}

	public void days() {
		sunday.click();
		monday.click();
	}

	public void selectcountry() {
		// country.click();
		Select ctry = new Select(country);
		// ctry.deselectByVisibleText("India");
		ctry.selectByValue("india");

		List<WebElement> options = ctry.getOptions();
		System.out.println("size of dropdown: " + options.size());

		for (int i = 0; i < options.size(); i++) {

			Object value = options.get(i).getText();
			System.out.println("all dropdown countries are: " + value);
		}

	}

	public void selcolor() {

		Select col = new Select(colors);
        col.selectByIndex(0);
        col.selectByVisibleText("Blue");
        col.selectByIndex(2);
        List<WebElement> mutsle= col.getAllSelectedOptions();
        System.out.println( "::-Selected Color");
        for(WebElement color: mutsle)
        {
        	System.out.println(color.getText());
        }
        
        System.out.println("All Colors");
        
        List<WebElement> allcolors= col.getOptions();
        System.out.println("size of dropdown:"+allcolors.size());
        for(WebElement color: allcolors)
        {      
        	  System.out.println("::-"+color.getText());
        	
        }
	
      
		}

	}


