package doctor.stepsDefinitions;

import doctor.pages.RegistrationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static doctor.core.BasePage.driver;

public class RegistrationPageSteps {

    @Then("Check that the Konto erstellen page title is displayed")
    public void checkKontoErstellenPageTitleDisplayed() {
        Assert.assertTrue(new RegistrationPage(driver).isKontoErstellenPageTitlePresent());
    }

    @When("The user enters valid details")
    public void userEntersValidDetails() {
        new RegistrationPage(driver).enterPatienDetails("Milka","Katze","maq@gmx.test","0123456789","milkacat");
    }

    @Then("The user clicks the Weiter button")
    public void userClickWeiter() {
        new RegistrationPage(driver).clickWeiterLink();
    }


    @When("The user enters the following invalid details:")
    public void userEntersFollowingInvalidDetails(DataTable table) {
        new RegistrationPage(driver).enterInvalidDetails(table);
    }

    @Then("The following error messages are displayed:")
    public void theFollowingErrorMessagesAreDisplayed(DataTable errorTable) {
        List<Map<String, String>> errors = errorTable.asMaps(String.class, String.class);
        for (Map<String, String> error : errors) {
            String field = error.get("Field");
            String errorMessage = error.get("Error Message");

            Assert.assertTrue(
                    String.format("Error message for '%s' is incorrect. Expected: '%s', Actual: '%s'",
                            field, errorMessage, new RegistrationPage(driver).getErrorMessageByField(field)),
                    new RegistrationPage(driver).isErrorMessageDisplayed(field, errorMessage)
            );
        }
    }

    @And("The user enters invalid details and invalid password")
    public void userEntersValidDetailsInvalidPassword(DataTable table) {
        new RegistrationPage(driver).enterInvalidDetails(table);
    }

    @And("The user checks the display of an unsuccessful registration message {string}")
    public void userChecksDisplayRegistrationMessage(String expectedErrorMessage) {
        Assert.assertTrue(
                String.format("Expected error message '%s' was not displayed", expectedErrorMessage),
                new RegistrationPage(driver).isUnsuccessfulRegistrationMessageDisplayed(expectedErrorMessage));
    }


    @And("The user clicks on the Anmelden link")
    public void userClicksAnmeldenLink() {
        new RegistrationPage(driver).clickAnmeldenLink();
    }
}

