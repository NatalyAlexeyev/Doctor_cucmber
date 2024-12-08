package doctor.stepsDefinitions;

import doctor.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static doctor.core.BasePage.driver;

public class HomePageSteps {

    @Given("The user launches the browser")
    public void userLaunchBrowser() {
        new HomePage(driver).launchBrowser();
    }

    @When("The user opens the gesundheitspraxis home page")
    public void userOpensGesundheitspraxisHomePage() {
        new HomePage(driver).openHomePage();
    }

    @Then("Check that the home page title is displayed")
    public void checkHomePageTitleDisplayed() {
        Assert.assertTrue(new HomePage(driver).isHomePageTitlePresent());
    }

    @After
    @And("The user closes the browser")
    public void userClosesTheBrowser() {
        driver.quit();
    }

    @Then("The user clicks on the Login button")
    public void clickLoginButtonHomePage() {
        new LoginPage(driver).clickOnLoginLink();
    }

    @When("The user clicks on the Infusionstherapie")
    public void clicksInfusionstherapie() {
        new HomePage(driver).clickInfusionstherapieLink();
    }

    @Then("Check that the title Infusionstherapie is displayed")
    public void checkTitleInfusionstherapieIsDisplayed() {
        Assert.assertTrue(new HomePage(driver).isInfusionstherapieTitlePresent());
    }

    @Then("The user clicks on the Leisungen")
    public void userClicksOnLeistungen() {
        new HomePage(driver).clikLeistungen();
    }

    @Then("Check that the title Meine Leistungen is displayed")
    public void checkTitleMeineLeistungenIsDisplayed() {
        Assert.assertTrue(new HomePage(driver).isMeineLeistungenTitle());
    }

    @When("The user clicks on the Neuraltherapie")
    public void userClicksOnNeuraltherapie() {
        new HomePage(driver).clickNeuraltherapie();
    }

    @Then("Check that the title Neuraltherapie is displayed")
    public void checkTitleNeuraltherapieIsDisplayed() {
        Assert.assertTrue(new HomePage(driver).isNeuraltherapieTitlePresent());
    }

    @When("The user click on the Schropftherapie")
    public void userClickOnSchropftherapie() {
        new HomePage(driver).clickSchropftherapie();
    }

    @Then("Check that Schrüpftherapie is displayed")
    public void checkSchrupftherapieIsDisplayed() {
       Assert.assertTrue(new HomePage(driver).isSchropftherapieTitlePresent());
    }

    @When("The user click on the Phytotherapie")
    public void userClickPhytotherapie() {
        new HomePage(driver).clickPhytotherapie();
    }

    @Then("Check that Phytotherapie is displayed")
    public void checkPhytotherapieIsDisplayed() {
        Assert.assertTrue(new HomePage(driver).isPhytotherapieTitlePresent());
    }

    @When("The user click on the Aromatherapie")
    public void userClickAromatherapie() {
        new HomePage(driver).clickAromatherapie();
    }

    @Then("Check that Aromatherapie is displayed")
    public void checkAromatherapieIsDisplayed() {
        Assert.assertTrue(new HomePage(driver).isAromatherapieTitlePresent());
    }

    @When("The user click on the Ernährungsberatung")
    public void userClickOnErnahrungsberatung() {
        new HomePage(driver).clickErnahrungsberatung();
    }

    @Then("Check that Ernährungsberatung is displayed")
    public void checkErnahrungsberatungIsDisplayed() {
        Assert.assertTrue(new HomePage(driver).isErnahrungsberatungTitlePresent());
    }

    @When("The user click on the Labordiagnostik")
    public void userClickOnTheLabordiagnostik() {
        new HomePage(driver).clickLabordiagnostik();
    }

    @Then("Check that Labordiagnostik is displayed")
    public void checkLabordiagnostikIsDisplayed() {
        Assert.assertTrue(new HomePage(driver).isLabordiagnostikTitlePresent());
    }

    @Then("The user is redirected to the home page")
    public void userIsRedirectedToTheHomePage() {
        Assert.assertTrue(new HomePage(driver).isHomePageTitlePresent());
    }

    @And("The user verifies that the Account button is displayed")
    public void verifyButtonIsDisplayed() {
        Assert.assertTrue(new HomePage(driver).isAccountButtonPresent()); // Implement isAccountButtonPresent() in HomePage.java
    }

    @When("The user clicks on the Account")
    public void userClicksAccount() {
        new HomePage(driver).clickAccount();
    }

    @Then("The user clicks on the Logout")
    public void userClicksLogout() {
        new HomePage(driver).clickLogout();
    }

    @And("The user verifies that the Login button is displayed")
    public void userVerifiesLoginButtonIsDisplayed() {
        Assert.assertTrue(new HomePage(driver).isHomePageLogin());
    }

    @When("The user clicks on the Profile")
    public void userClicksProfile() {
        new ProfilePage(driver).clickProfile();
    }

    @And("The user is redirected to the Profile page")
    public void userIsRedirectedProfilePage() {
        Assert.assertTrue(new ProfilePage(driver).isProfileLinkPresent());
    }

    @And("The user clicks on the Uber Mich link")
    public void userClicksUberMichLink() {
        new HomePage(driver).clickUberMichlink();
    }

    @And("Check that the home page title Uber Mich is displayed")
    public void checkHomePageTitleUberMichIsDisplayed() {
        Assert.assertTrue(new HomePage(driver).isHomePageTitleUberMich());
    }

    @And("The user clicks on the Team link")
    public void userClicksTeamLink() {
        new HomePage(driver).clickTeamlink();
    }

    @And("Check that the home page title Team is displayed")
    public void checkHomePageTitleTeamIsDisplayed() {
        Assert.assertTrue(new HomePage(driver).isHomePageTitleTeam());
    }

    @And("The user clicks on the Contact link")
    public void userClicksContactLink() {
        new HomePage(driver).clickContactlink();
    }

    @And("Check that the home page title Contact is displayed")
    public void checkHomePageTitleContactIsDisplayed() {
        Assert.assertTrue(new HomePage(driver).isHomePageTitleContact());
    }

    @And("The user clicks on the Termin Vereinbar button")
    public void userClicksTerminVereinbarButton() {
        new HomePage(driver).clickTerminVereinbar();
    }

    @Then("The user enters Kontaktvalid details")
    public void userEntersKontaktvalidDetails() {
        new HomePage(driver).enterKontaktDetails("Milka","maq@gmx.test","0123456789","Guten Tag. Ich bin ein Test");
    }

    @And("The user clicks on the Nachricht senden button")
    public void userClicksNachrichtSenden() {
        new HomePage(driver).clickNachrichtSenden();
    }

    @When("The user clicks on the Termine")
    public void userClicksTermine() {
        new TerminePage(driver).clickTermine();
    }

}
