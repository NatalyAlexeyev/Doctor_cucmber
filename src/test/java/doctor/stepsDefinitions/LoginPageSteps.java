package doctor.stepsDefinitions;

import doctor.pages.LoginPage;
import doctor.pages.RegistrationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static doctor.core.BasePage.driver;

public class LoginPageSteps {
    @And("Check that the Login page title is displayed")
    public void checkLoginPageTitleDisplayed() {
        Assert.assertTrue(new LoginPage(driver).isLoginPageTitlePresent());
    }
    
    @When("The user enters valid data")
    public void userEntersValidData() {

        String email = "Milka@gmx.test";//RegistrationPage.getGeneratedEmail();


        String password = "milkacat";
        new LoginPage(driver).enterPazientData(email, password);

    }

    @And("The user clicks on the Anmelden button")
    public void userClicksAnmeldenButton() {
        new LoginPage(driver).clickOnAnmeldenLink();
    }

    @Then("The user clicks on the Kontoerstellen button")
    public void userClickKontoErstellen() {
        new LoginPage(driver).clickKontoErstellen();
    }

    @Then("The user enters Angemeldet bleiben")
    public void userEntersAngemeldetBleiben() {
        new LoginPage(driver).clickAngemeldet();
    }

    @And("The user enters valid email and invalid password")
    public void userEntersValidEmailInvalidPassword(DataTable table) {
        new LoginPage(driver).enterCredentials(table);
    }

    @Then("The user checks the display of a unsuccessful login message")
    public void userChecksDisplayOfAUnsuccessfulLoginMessage() {
        Assert.assertTrue("Unsuccessful login message not displayed", new LoginPage(driver).isUnsuccessfulLoginMessageDisplayed());
    }

    @When("The user logs in with random valid credentials")
    public void userLogsInWithRandomValidCredentials() {
        new LoginPage(driver).enterPazientData1();
    }

    @Then("The user is redirected to the Login page")
    public void theUserIsRedirectedToTheLoginPage() {
        Assert.assertTrue(new LoginPage(driver).isLoginPageTitlePresent());
    }
}
