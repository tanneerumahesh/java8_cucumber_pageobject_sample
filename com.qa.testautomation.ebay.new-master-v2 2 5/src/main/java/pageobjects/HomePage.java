package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".gh-tb.ui-autocomplete-input")
    public WebElement SearchBar;

    @FindBy(css = ".btn.btn-prim.gh-spr")
    public WebElement SearchButton;


    public void Search(String searchText ) {
        SearchBar.clear();
        SearchBar.sendKeys(searchText);
        SearchButton.click();
    }


}
