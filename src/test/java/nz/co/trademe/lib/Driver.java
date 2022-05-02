package nz.co.trademe.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;

    /**
     *
     */
    public static void initializeDriver(){

        String projectPath = System.getProperty("user.dir");

        String browser = System.getProperty("browser");
        if ( browser == null)
            browser = "";

        switch(browser) {
            case "chrome":
            {
                System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            }
            case "firefox":
            {
                System.setProperty("webdriver.gecko.driver", projectPath + "\\src\\test\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            }
            case "edge":
            default:
            {
                System.setProperty("webdriver.edge.driver", projectPath + "\\src\\test\\resources\\drivers\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            }
        }

        // setting the implicit timeouts
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        // maximize the browser
        driver.manage().window().maximize();
    }
}
