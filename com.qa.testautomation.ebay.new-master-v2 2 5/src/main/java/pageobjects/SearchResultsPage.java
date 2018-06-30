package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {

    private WebDriver Driver;
    public SearchResultsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.Driver = driver;
    }

    @FindBy(css="li.s-item")
    public List<WebElement> SearchResults ;

    @FindBy(css = "#srp-river-results-SEARCH_STATUS_MODEL_V2-w0-w1_btn")
    public WebElement SortButton;

    @FindBy(css="#SortMenu")
    public WebElement SortMenu;

    @FindBy(css="#srp-river-results-SEARCH_STATUS_MODEL_V2-w0-w1")
    public WebElement SortButtonContainer;

    @FindBy(css = "ul.srp-sort__menu>li>a")
    public List<WebElement> SortOptions;

    @FindBy(css = "[aria-label*='Page']")
    public List<WebElement> Pages;


    public void SortResults(String sorting){

        Actions acts = new Actions(Driver);
        acts.moveToElement(SortButtonContainer).moveToElement(SortOptions.get(3)).click().build().perform();

        for (WebElement ele:SortOptions) {
            if (ele.getText().equals(sorting))
            {
                new PageUtils(Driver).ClickOnElementUsingJavaScript(ele);
                break;
            }
        }

    }


    public List<BigDecimal> GetPricesOnResults(){

        List<BigDecimal> prices = new ArrayList<>();
        SearchResults.forEach((ele) ->
                prices.add(new BigDecimal(GetPriceFromElement(ele.findElement(By.cssSelector(".s-item__price"))))));
        return prices;
    }

    public List<String> GetPurchaseOptions(){

        List<String> poptions = new ArrayList<>();
        SearchResults.forEach((ele) ->
                poptions.add(ele.findElement(By.cssSelector(".s-item__purchaseOptions")).getText()));
        return poptions;
    }


    public boolean IsResultsDescriptionsContainsStrings(List<String> releventSearchTerms)
    {
        boolean result=true;

        for (String des: GetAllDescriptions())
        {

            result = des.toLowerCase().contains(releventSearchTerms.get(0))
                    || des.toLowerCase().contains(releventSearchTerms.get(1))
                    || des.toLowerCase().contains(releventSearchTerms.get(2))
                    || des.toLowerCase().contains(releventSearchTerms.get(3));

        }
        return result;
    }


    public List<String> GetAllDescriptions(){

        List<String> dess = new ArrayList<>();
        SearchResults.forEach((ele)->{
            String description = ele.findElement(By.cssSelector("h3")).getText();
            dess.add(description);
        });
        return dess;
    }

    private String GetPriceFromElement (WebElement ele){

        String initPrice = ele.getText();
        String price;
        if (initPrice.contains("to")){
            price = initPrice.split("to")[1];
        }else {
            price = initPrice;
        }

        return price.replace("£","")
                .replace(",","").trim();
    }

}
