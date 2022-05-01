package nz.co.trademe.lib;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import static nz.co.trademe.lib.Driver.driver;

public class Hooks {
    @Before
    public void beforeScenario(){
        // create the driver object
        Driver.initializeDriver();

        // launch application with base url
        driver.get(Properties.getProperty("base_url"));
    }

    @After
    public void afterScenario(){
        // quit the driver
        driver.quit();
    }
}
