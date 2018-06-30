package ebay.qa.test;

import ebay.qa.test.stepdefs.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class DriverUtils  {

    public static RemoteWebDriver driver;

    protected void WaitFor(WebElement element){

        WebDriverWait wait = new WebDriverWait(driver,30000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void WaitFor(){

        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
    }

    protected void WaitForReadyState() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        boolean status = false;
        int count=0;
        while (!status&&count<=30){
          status = js.executeScript("return document.readyState").toString().equals("complete");
          driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.MILLISECONDS);
          count++;
        }
    }

    public void WaitforElementTobeClicable(WebElement ele){
        GenerateWebDriverWait(30).until(ExpectedConditions.elementToBeClickable(ele));
    }

    private WebDriverWait GenerateWebDriverWait(int seconds){
        return new WebDriverWait(driver,seconds);
    }

    public void WaitForElementsTobeDisplayed(List<WebElement> elements){
        GenerateWebDriverWait(30).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

}
