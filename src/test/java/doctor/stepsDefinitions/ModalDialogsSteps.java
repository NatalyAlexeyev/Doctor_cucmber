package doctor.stepsDefinitions;

import doctor.pages.DialogsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.List;


import static doctor.core.BasePage.driver;

public class ModalDialogsSteps {

    @And("Check that title Timeslots  is displayed")
    public void checkTitleTimeslotsIsDisplayed() {
        Assert.assertTrue(new DialogsPage(driver).isDialogsPageTimeslots());
    }

    @Then("The user chooses the service Infusionstherapie")
    public void userChoosesServiceInfusionstherapie() {
        new DialogsPage(driver).clickInfusionstherapie();
    }

    @And("The user clicks on the TerminVereinbar button")
    public void userClicksTerminVereinbarButton() {
        new DialogsPage(driver).clickTerminVereinbar();
    }

    @And("The user clicks on the Schliessen button")
    public void userClicksSchliessenButton() {
        new DialogsPage(driver).clickSchlissenButton();
    }

    @And("The user clicks on the Termin Vereinbar")
    public void userClicksOnTheTerminVereinbar() {
        new DialogsPage(driver).clickTerminVereinbarmod();
    }

    @Then("The user checks the display info message messages:")
    public void checkDisplayInfoMessageIsOneOf(DataTable dataTable) {
        List<String> expectedMessages = dataTable.asList();
        boolean messageFound = false;
        for (String expectedMessage : expectedMessages) {
            if (new DialogsPage(driver).isDialogsPageInfoMessageDisplayed(expectedMessage)) {
                messageFound = true;
                break; // Exit the loop once a message is found
            }
        }
        Assert.assertTrue("None of the expected messages were displayed", messageFound);
    }

    @Then("The user checks the display info message {string}")
    public void theUserChecksTheDisplayInfoMessage(String expectedErrorMessage) {
        Assert.assertTrue(
                String.format("Expected error message '%s' was not displayed", expectedErrorMessage),
                new DialogsPage(driver).isDialogsPageInfoMessageDisplayed(expectedErrorMessage));
    }

    @And("The user selects the service")
    public void userChoosesService() {
        new DialogsPage(driver).clickService();
    }

    @And("The user checks the display infoMessage")
    public void userChecksDisplayInfoMessage () {
        Assert.assertTrue("Ihr Termin wurde erfolgreich abgeschlossen. Sie erhalten eine Bestätigung per E-Mail.", new DialogsPage(driver).isInfoMessageDisplayed());
    }

    @Then("The user checks the display info message")
    public void theUserChecksTheDisplayInfoMessage() {
        Assert.assertTrue("Bitte melden Sie sich an, um fortzufahren.", new DialogsPage(driver).isDialogsPageInfoMessage());
    }

    @And("The user clicks Date")
    public void userClicksDate() {
        new DialogsPage(driver).clickstDate();
    }

    @And("The user clicks Time")
    public void userClicksTime() {
        new DialogsPage(driver).clickstTime();
    }
}
