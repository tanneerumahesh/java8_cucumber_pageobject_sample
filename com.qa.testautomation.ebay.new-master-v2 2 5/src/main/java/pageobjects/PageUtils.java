package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class PageUtils {
    private JavascriptExecutor jse;
    public PageUtils(WebDriver _driver){
        jse = (JavascriptExecutor) _driver;
    }

    public void ChangeAttributeUsingJavaScript(String script, WebElement element){

        jse.executeScript(script,element);
    }

    public void ClickOnElementUsingJavaScript(WebElement element){
        jse.executeScript("arguments[0].click()",element);
    }

    public Integer Random(int min,int max){
        Random r = new Random();
        return r.nextInt(max-min) + min;
    }
}
