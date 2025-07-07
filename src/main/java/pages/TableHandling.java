package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseliberary.BaseLiberary;

public class TableHandling extends BaseLiberary {
	int row, col;

	public TableHandling() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//table[@name='BookTable']//tr")
	private List<WebElement> tablerows;

	@FindBy(xpath = "//table[@name='BookTable']//tr[1]//th")
	private List<WebElement> tablecolumn;

	@FindBy(xpath = "//table[@name='BookTable']//tr[5]//td[1]")
	private WebElement dataofrow5column1;

	// @FindBy(xpath="//table[@name='BookTable']//tr["+row+"]//td["+col+"]")
	// private WebElement tablealldata;

	@SuppressWarnings("unused")
	public void statictablehandle() {

		System.out.println("Table size(no. of rows) including header : " + tablerows.size());
		System.out.println("No. of cloumn in table : " + tablecolumn.size());

		String actualtextinrow5col1 = dataofrow5column1.getText();
		System.out.println("value of row 5 & column 1 is: " + actualtextinrow5col1);
		Assert.assertEquals(actualtextinrow5col1, "Master In Selenium", "comparision of actual and expected values");

		// to read all the data from given table

		for (int row = 2; row <= tablerows.size(); row++) {

			for (int col = 1; col <= tablecolumn.size(); col++) {

				String dynamicvlaue = driver
						.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[" + col + "]"))
						.getText();

				System.out.print(dynamicvlaue + "\t");
			}
			System.out.println("\t");
		}

		// print book name who's author name is Mukesh

		for (int row = 2; row <= tablerows.size(); row++) {

			String authorname = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[2]"))
					.getText();
			if (authorname.equals("Mukesh")) {
				String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + row + "]//td[1]"))
						.getText();
				System.out.println(bookname);

			}
		}

		// to find total price available in the table
		int totalprice=0;
		for (int row = 2; row <= tablerows.size(); row++) {

			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]//td[4]")).getText();
			totalprice= totalprice+Integer.parseInt(price);
			
		}
		System.out.println("total price of all the books : "+totalprice);
	}

}
