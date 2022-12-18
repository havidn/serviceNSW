package starter.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.Pages.HomePage;

import static org.junit.Assert.*;

public class SearchPageStepDef {
    HomePage homePage;
    @Given("User already on home page")
    public void userAlreadyOnPage() {
        homePage.open();
    }
    @And("User search for {string}")
    public void userSearchFor(String service) {
        homePage.InputService(service);
        homePage.clickSearch();

    }

    @When("User click on Locate us button")
    public void userClickOnLocateUsButton() {
        homePage.servicePageButton();
    }

    @And("User enter suburb {string}")
    public void userEnterSuburb(String location) {
        homePage.inputFieldLocation(location);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.findLocation();
    }

    @Then("Should show service centre name as {string}")
    public void itShouldUseServiceCentreNamedAs(String location) {
        homePage.getServiceCenter(location);
        assertEquals(location,homePage.getHeaderTittle());
    }

    @Then("User redirect to {string} page")
    public void userRedirectToPage(String location) {
        assertEquals(location,homePage.getHeaderTittle());
    }
}
