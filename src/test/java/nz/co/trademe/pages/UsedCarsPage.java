package nz.co.trademe.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

import static nz.co.trademe.lib.Driver.driver;

/**
 * User comes after clicking on used cars, Key in the inputs searches for particular car and validates following:-
 * Number plate
 * seat
 * Body
 * Kilometers
 * */

public class UsedCarsPage {

    @FindBy(xpath = "//tg-tab-heading[text() = ' Used ']")
    WebElement BTN_USED;
    @FindBy(xpath = "//tg-tab-heading[text() = ' New ']")
    WebElement BTN_NEW;
    @FindBy(xpath = "//input[@placeholder = 'Search using keywords']")
    WebElement TXT_SEARCH_KEYWORD;
    @FindBy(xpath = "//button[text() = ' Search ']")
    WebElement BTN_SEARCH;
    //@FindBy(xpath = "//h4[contains(text(), '2011 Mercedes-Benz ML 350 CDI')]")
    @FindBy(xpath = "//h4[contains(text(), '2011 Mercedes-Benz ML 350')]")
    WebElement LBL_SEARCHED_KEYWORD;
    @FindBy(xpath = "//tg-icon[@name = 'vehicle-odometer']/../..")
    WebElement LBL_KILOMETERS;
    @FindBy(xpath = "//span[contains(text(), 'Number plate')]")
    WebElement LBL_NUMBER_PLATE;
    @FindBy(xpath = "//span[contains(text(), 'Number plate')]/..")
    WebElement LBL_CAR_NUMBER;
    @FindBy(xpath = "//tg-icon[@name = 'vehicle-seat']")
    WebElement ICON_SEATS;
    @FindBy(xpath = "//tg-icon[@name = 'vehicle-seat']/../..")
    WebElement LBL_SEATS;
    @FindBy(xpath = "//tg-icon[@name = 'vehicle-car']")
    WebElement ICON_BODY;
    @FindBy(xpath = "//tg-icon[@name = 'vehicle-car']/../..")
    WebElement LBL_BODY;

    public UsedCarsPage(){
        PageFactory.initElements(driver, this);
    }


    /**
     *
     * @param keyword
     * @param type
     */
    public void searchCar(String keyword, String type) {
        if (type.equalsIgnoreCase("used"))
            BTN_USED.click();
        else if (type.equalsIgnoreCase("new"))
            BTN_NEW.click();

        TXT_SEARCH_KEYWORD.sendKeys(keyword);
        BTN_SEARCH.click();
        LBL_SEARCHED_KEYWORD.click();
    }

    /**
     *
     * @param expectedLables
     */
    public void validateCarLabels(List<String> expectedLables) {
        for(String expectedLabel : expectedLables){
            if(expectedLabel.equalsIgnoreCase("number plate"))
                Assert.assertTrue("Could not find the Number Plate details on the car search page!",
                        LBL_NUMBER_PLATE.isDisplayed());
            else if (expectedLabel.equalsIgnoreCase("kilometers"))
                Assert.assertTrue("Could not find the Kilometers details on the car search page!",
                        LBL_KILOMETERS.getText().contains("km"));
            else if (expectedLabel.equalsIgnoreCase("seats"))
                Assert.assertTrue("Could not find the number of car seats details on the car search page!",
                        ICON_SEATS.isDisplayed());
            else if (expectedLabel.equalsIgnoreCase("body"))
                Assert.assertTrue("Could not find the car Body details on the car search page!",
                        ICON_BODY.isDisplayed());
        }
    }

    /**
     *
     * @param expectedCarDetails
     */
    public void validateCarDetails(Map<String, String> expectedCarDetails) {
        for (String expectedDetail : expectedCarDetails.keySet()) {
            switch (expectedDetail.toLowerCase()) {
                case "number plate":
                    Assert.assertTrue("Expected the car number to contain " + expectedCarDetails.get(expectedDetail) + ", but got " + LBL_CAR_NUMBER.getText().trim(),
                            LBL_CAR_NUMBER.getText().contains(expectedCarDetails.get(expectedDetail)));
                    break;
                case "kilometers":
                    Assert.assertTrue("Expected the car kilometers to be " + expectedCarDetails.get(expectedDetail) + ", but got " + LBL_KILOMETERS.getText().trim(),
                            LBL_KILOMETERS.getText().trim().equalsIgnoreCase(expectedCarDetails.get(expectedDetail)));
                    break;
                case "seats":
                    Assert.assertTrue("Expected the car seats to be " + expectedCarDetails.get(expectedDetail) + ", but got " + LBL_SEATS.getText().trim(),
                            LBL_SEATS.getText().trim().contains(expectedCarDetails.get(expectedDetail)));
                    break;
                case "body":
                    Assert.assertTrue("Expected the car body to be " + expectedCarDetails.get(expectedDetail) + ", but got " + LBL_BODY.getText().trim(),
                            LBL_BODY.getText().trim().contains(expectedCarDetails.get(expectedDetail)));
                    break;

            }
        }
    }
}

