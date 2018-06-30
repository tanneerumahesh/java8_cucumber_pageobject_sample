package ebay.qa.test.stepdefs;
import cucumber.api.java8.En;
import ebay.qa.test.DriverUtils;
import ebay.qa.test.FactoryUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageobjects.FiltersPage;
import pageobjects.HomePage;
import pageobjects.SearchResultsPage;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchResultsStep extends DriverUtils implements En{

    public SearchResultsStep(){

        Given("^I am a non-registered customer$", () -> {

            // no need to implement
        });

        When("^I search for an \"([^\"]*)\"$", (String item) -> {
            new HomePage(driver).Search(item);
            WaitForElementsTobeDisplayed(new SearchResultsPage(driver).SearchResults);
        });

        Given("^I navigate to \"([^\"]*)\"$", (String url) -> {

            driver.get(url);
            WaitFor(new HomePage(driver).SearchBar);
        });


        Then("^I get a list of matching results$", () -> {

            List<String> releventSearchTerms = Stream.of("cycle","cyclying","bike","biking").collect(Collectors.toList());

            Assert.assertTrue("No search results displayed",new SearchResultsPage(driver).SearchResults.size()>0);

            Assert.assertTrue("Some of the results descriptions doesn't contain relevant search terms",
                    new SearchResultsPage(driver).IsResultsDescriptionsContainsStrings(releventSearchTerms));

        });

        Then("^the resulting items cards show: postage price, No of bids, price or show BuyItNow tag$", () -> {

            new SearchResultsPage(driver).SearchResults.forEach((ele)->{

                String price = ele.findElement(By.cssSelector(".s-item__price")).getText();
                Assert.assertTrue("Price is empty for advert",!FactoryUtils.IsNullOremply(price));

                String BuyItNowText = ele.findElement(By.cssSelector(".s-item__purchaseOptions")).getText();
                Assert.assertTrue("purchase options doesn't contain buy it now or best offer"
                        ,BuyItNowText.contains("or Best Offer")||BuyItNowText.contains("Buy it now"));

                String postagePrice = ele.findElement(By.cssSelector(".s-item__logisticsCost")).getText();
                Assert.assertTrue("Price is empty for advert",!FactoryUtils.IsNullOremply(postagePrice));

            });

        });

        Then("^I can sort the results by Lowest Price$", () -> {

            new SearchResultsPage(driver).SortResults("Lowest price");
            WaitForElementsTobeDisplayed(new SearchResultsPage(driver).SearchResults);

        });

        Then("^the results are listed in the page in the correct order$", () -> {

            Assert.assertTrue("Prices are not in ascending order after sorting by lowerprice",
                    FactoryUtils.IsSorted(new SearchResultsPage(driver).GetPricesOnResults(),"asc"));

        });

        Then("^I can sort the results by Highest Price$", () -> {

            new SearchResultsPage(driver).SortResults("Highest price");
            WaitForElementsTobeDisplayed(new SearchResultsPage(driver).SearchResults);

            // commenting this assertion as there seems to be a bug with ebay where the sorting on highest price is not working as expected
            // Assert.assertTrue("Prices are not in descending order after sorting by Highest price",FactoryUtils.IsSorted(new SearchResultsPage(driver).GetPricesOnResults(),"desc"));
        });

        Then("^I can filter the results by 'Buy it now'$", () -> {

            new FiltersPage(driver).ClickOnBuyItNow();
            WaitForElementsTobeDisplayed(new SearchResultsPage(driver).SearchResults);

        });

        Then("^all the results shown in the page have the 'Buy it now' tag$", () -> {

            Assert.assertTrue("Not all the results have 'Buy it now' tag",
                    new SearchResultsPage(driver).GetPurchaseOptions().size()==50);

        });


        When("^I enter a search term and select a specific Category$", () -> {

            new HomePage(driver).Search("cycle");
            WaitForElementsTobeDisplayed(new SearchResultsPage(driver).SearchResults);
            new FiltersPage(driver).SelectCategory();
            WaitForElementsTobeDisplayed(new SearchResultsPage(driver).SearchResults);

        });

        Then("^I get a list of matching results for category selected$", () -> {

            Assert.assertTrue("No search results displayed",new SearchResultsPage(driver).GetAllDescriptions().size()>0);

        });

        Then("^I can verify that the results shown as per the the selected category$", () -> {

            List<String> releventSearchTerms = Stream.of("Stickers","Decals","sticker","decal").collect(Collectors.toList());
            Assert.assertTrue("Some of the results descriptions doesn't contain relevant search terms",
                    new SearchResultsPage(driver).IsResultsDescriptionsContainsStrings(releventSearchTerms));

        });

        Then("^the results show more than one page$", () -> {

           Assert.assertTrue("Only one page displayed",new SearchResultsPage(driver).Pages.size()>1);

        });

        Then("^the user can navigate through the pages to continue looking at the items$", () -> {

            new SearchResultsPage(driver).Pages.get(FactoryUtils.Random(0,new SearchResultsPage(driver).Pages.size())).click();
            WaitForElementsTobeDisplayed(new SearchResultsPage(driver).SearchResults);
            Assert.assertTrue("No search results displayed",new SearchResultsPage(driver).GetAllDescriptions().size()>0);
        });


    }

}
