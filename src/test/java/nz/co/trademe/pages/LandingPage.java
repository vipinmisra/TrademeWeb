package nz.co.trademe.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static nz.co.trademe.lib.Driver.driver;

/**
 * User comes on Home page, based on the search clicks the link Motors.
 */

public class LandingPage {

    @FindBy(xpath = "//a[text() = ' Motors ']")
    WebElement BTN_MOTORS;

    public LandingPage(){
        PageFactory.initElements(driver, this);
    }

    /**
     *
     * @param tabName
     */
    public void selectTab(String tabName){
        if(tabName.equalsIgnoreCase("motors"))
            BTN_MOTORS.click();
    }
}
