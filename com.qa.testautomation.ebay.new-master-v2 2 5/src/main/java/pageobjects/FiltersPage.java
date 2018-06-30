package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FiltersPage  {

    private WebDriver Driver;

    public FiltersPage(WebDriver driver){

        PageFactory.initElements(driver,this);
        Driver =driver;
    }


    @FindBy(css="input[aria-label='Buy it now']")
    public WebElement BuyItNowButton;

    @FindBy(css = "button[aria-label*='Show more categories']")
    public WebElement MoreCategoriesButton;

    @FindBy(css = "ul.srp-refine__category__list li.srp-refine__category__item [data-scope='PRIMARY']")
    public List<WebElement> CategoriesList;



    public void SelectCategory(){

        int rnum = new PageUtils(Driver).Random(1,CategoriesList.size());
        CategoriesList.get(rnum).click();
    }


    public void ClickOnBuyItNow(){

        new PageUtils(Driver).ClickOnElementUsingJavaScript(BuyItNowButton);
    }

    public void ClickOnMoreCategories(){

        new PageUtils(Driver).ClickOnElementUsingJavaScript(MoreCategoriesButton);
    }


}
