package ebayTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.dickens.testing.gmail.parent.Browser;

import ebay.Ebay;

public class EbayTest {

	public WebDriver webDriver;
	
	@BeforeSuite
	public void setUp() {
		this.webDriver = Browser.getDriver();
	}
	
	@AfterSuite
	public void shutDown() {
		webDriver.close();
	}
	@Test
	public void searchForGuitarPrices() {
		Ebay ebay = new Ebay(webDriver);
		ebay.execute("Electric Guitar");
		System.out.println(ebay.getFirstPriceResults());
	}
}
