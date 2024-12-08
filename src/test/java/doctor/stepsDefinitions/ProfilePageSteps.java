package doctor.stepsDefinitions;

import doctor.pages.DialogsPage;
import doctor.pages.LoginPage;
import doctor.pages.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

//    @And("The user clicks on the Termin Vereinbar")
//    public void userClicksTerminVereinbar() {
//        new ProfilePage(driver).clickTerminVereinbar();
//    }

    @Then("The user selects that he is not a new user")
    public void userSelectsThatHeIsNotANewUser() {
        new ProfilePage(driver).clickHeIsNotANewUser();
    }

    @And("User selects the termin date {string}")
    public void userSelectsTheTerminDate(String date) {
        new DialogsPage(driver).selectTerminDate(date);
    }

    @And("User selects the termin time {string}")
    public void userSelectsTheTerminTime(String time) {
        new DialogsPage(driver).selectTerminTime(time);
    }

    @And("The user confirms the appointment")
    public void userConfirmsTheAppointment() {
        new DialogsPage(driver).clickTerminVereinbar();
    }

    @Then("Verify the appointment is successfully booked")
    public void verifyTheAppointmentIsSuccessfullyBooked() {
        // Проверить наличие сообщения об успешном бронировании
        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(),'Erfolgreich gebucht')]"));
        Assert.assertTrue("Ihr Termin wurde erfolgreich abgeschlossen. Sie erhalten eine Bestätigung per E-Mail.", successMessage.isDisplayed());
    }
}
