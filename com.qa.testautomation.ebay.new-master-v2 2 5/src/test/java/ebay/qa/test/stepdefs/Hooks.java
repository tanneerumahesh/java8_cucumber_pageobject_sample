package ebay.qa.test.stepdefs;
import cucumber.api.java8.En;
import ebay.qa.test.DriverUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks extends DriverUtils implements En{


    public Hooks(){
        Before(()->{

            StartDriver("chrome");
            driver.get("about:blank");

        });

        After(()->{

            if (driver!=null) {
                driver.quit();
            }

        });
    }


    public void StartDriver(String browser) throws Exception {

        switch (browser){

            case "chrome":
                System.setProperty("webdriver.chrome.driver","/Users/maheshtanneeru/Downloads/com.qa.testautomation.ebay.new-master-v2 2 5/resources/chromedriver");
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("start-fullscreen");
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver","/resources/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

            default:
                throw new Exception("No implementation for Browser: "+browser);
        }
    }

}
