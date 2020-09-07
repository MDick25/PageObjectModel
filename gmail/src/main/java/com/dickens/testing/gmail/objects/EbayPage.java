package com.dickens.testing.gmail.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EbayPage {
		@FindBy(className="gh-tb ui-autocomplete-input")
		public WebElement searchBox;
		
		@FindBy(how = How.ID, using="gh-btn")
		public WebElement searchButton;
		
		@FindBy(className="s-item__price")
		public List<WebElement> priceResults;
		
		
}
