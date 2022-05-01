package nz.co.trademe.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;
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
                System.setProperty("webdriver.chrome.driver", projectPath + Properties.getProperty("firefox_path"));
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

        // set the implicit timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // maximize the browser
        driver.manage().window().maximize();
    }
}
