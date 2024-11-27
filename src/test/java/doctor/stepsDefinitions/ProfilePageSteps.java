package doctor.stepsDefinitions;

import doctor.pages.LoginPage;
import doctor.pages.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static doctor.core.BasePage.driver;

public class ProfilePageSteps {
    @Then("The user enters Vorname")
    public void userEntersVorname() {
        new ProfilePage(driver).enterVornameData("Milana");
    }

    @And("The user clicks Speichern")
    public void userClicksSpeichern() {
        new ProfilePage(driver).clickSpeichern();
    }

    @And("The user checks the display of successful enters message")
    public void userChecksDisplaySuccessfulEntersMessage() {
        Assert.assertTrue("Vorgang erfolgreich abgeschlossen", new ProfilePage(driver).isErfolgreichMessageDisplayed());
    }

    @Then("The user clicks Start Bootstrap")
    public void userClicksStartBootstrap() {
        new ProfilePage(driver).clickStartBootstrap();
    }

    @Then("The user enters Nachname")
    public void userEntersNachname() {
        new ProfilePage(driver).enterNachname("Kater");
    }

    @Then("The user enters Telefonnummer")
    public void userEntersTelefonnummer() {
        new ProfilePage(driver).enterTelefonnummerData("4917647056279");
    }
}
