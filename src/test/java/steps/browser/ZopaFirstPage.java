package steps.browser;

//import cucumber.api.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import pageobjects.BasePage;
import pageobjects.ZopaPageObjects;



public class ZopaFirstPage extends BasePage {
    ZopaPageObjects zopaPageObjects = new ZopaPageObjects();

    @Given("^I am on the Zopa loans home page$")
    public void iAmOnTheZopaHomePage() {
        driver = initializeDriver();
        driver.get("https://www.zopa.com/loans");
        zopaPageObjects.infoLog("I am on the Zopa loans home page");
    }


    @When("^I click on the Personalised Loan button$")
    public void iClickPersonalisedButton()
    {
        zopaPageObjects.setPersonalisedButton();
    }

    @Then("the Loan page is displayed$")

 public void theLoanPageDisplayed() {
       String loanPageURL = driver.getCurrentUrl();
        if (loanPageURL.contains("https://rates.zopa.com/")){
            softAssert.assertThat(loanPageURL);
        }
   }

    @Before
    public void beforeScenario(Scenario scenario) {
        softAssert = new SoftAssertions();
      //  zopaPageObjects.generateReport(scenario.getName());

    }

    @After
    public void closeBrowserAfterExecution() {
     //   zopaPageObjects.flushReports();
        softAssert.assertAll();
        driver.quit();

    }
}
