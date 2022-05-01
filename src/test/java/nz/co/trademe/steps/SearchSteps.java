package nz.co.trademe.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import nz.co.trademe.lib.Driver;
import nz.co.trademe.lib.Properties;
import nz.co.trademe.pages.LandingPage;
import nz.co.trademe.pages.UsedCarsPage;

import java.util.List;
import java.util.Map;

import static nz.co.trademe.lib.Driver.driver;

public class SearchSteps {

    LandingPage landingPage;
    UsedCarsPage usedCarsPage;

    @Given("I am on the TradeMe site")
    public void accessApplication() throws InterruptedException {
        landingPage = new LandingPage();
        landingPage.selectTab("Motors");
    }

    @When("I search for {string} {string} car")
    public void i_search_for_an_used_car(String carModel, String type) throws InterruptedException {
        usedCarsPage = new UsedCarsPage();
        usedCarsPage.searchCar(carModel, type);
    }
    @Then("I should see the following labels")
    public void i_should_see_the_details(DataTable dataTable) throws InterruptedException {
        List<String> carLabels = dataTable.asList(String.class);
        usedCarsPage = new UsedCarsPage();
        usedCarsPage.validateCarLabels(carLabels);
    }

    @Then("The details should match the following data")
    public void checkCarData(DataTable dataTable){
        Map<String, String> carDetails = dataTable.asMap(String.class, String.class);
        usedCarsPage = new UsedCarsPage();
        usedCarsPage.validateCarDetails(carDetails);
    }
}
