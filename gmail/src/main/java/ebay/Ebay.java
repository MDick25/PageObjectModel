package ebay;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.dickens.testing.gmail.objects.EbayPage;

import com.dickens.testing.gmail.parent.ModelPage;

public class Ebay extends ModelPage {

	EbayPage ebayPage;
	
	public Ebay(WebDriver webDriver) {
		
		this.driver = webDriver;
		
		ebayPage = PageFactory.initElements(webDriver, EbayPage.class);
	}
		
	public void execute(String search){
			open("https://ebay.com");
			inputfield(ebayPage.searchBox, search);
			click(ebayPage.searchButton);
		}
	public String getFirstPriceResults(){
		List<String> results = new ArrayList<String>();
		
		List<WebElement> priceResults = ebayPage.priceResults;
		
		for(WebElement webElement : priceResults) {
			results.add(webElement.getText());
			
		}
		String firstResult = results.get(0);
		return firstResult;
	}
		
	
}
