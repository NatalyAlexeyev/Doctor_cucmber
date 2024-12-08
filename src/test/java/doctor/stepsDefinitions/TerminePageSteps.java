package doctor.stepsDefinitions;

import doctor.pages.TerminePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static doctor.core.BasePage.driver;

public class TerminePageSteps {
    public int termineListBefore;

    @And("The user is redirected to the Termine page")
    public void theUserIsRedirectedToTheTerminePage() {
        Assert.assertTrue(new TerminePage(driver).isProfileLinkPresent());
    }

    @And("The user counts the number of terminen on the page")
    public void theUserCountsTheNumberOfTerminenOnThePage() {
        List<WebElement> termineList = driver.findElements(By.xpath("//div[contains(@class,'card shadow')]"));
        int termineCount = termineList.size();
        System.out.println("Number of term entries: " + termineCount);
        Assert.assertTrue("Termine list is empty!", termineCount > 0);
    }

    @When("The user attempts to delete a termin from the list")
    public void the_user_attempts_to_delete_a_termin_from_the_list() {
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//div[@class='col-sm-1']//button[1]"));
        if (deleteButtons.size() > 0) {
            // Trying to remove the first element
            deleteButtons.get(0).click();
            System.out.println("An attempt was made to delete the first term.");
        } else {
            System.err.println("There are no delete buttons!");
        }
    }
    @Then("Verify the termin is not deleted and the list remains unchanged")
    public void verify_the_termin_is_not_deleted_and_the_list_remains_unchanged() {
        List<WebElement> termineListAfter = driver.findElements(By.xpath("//div[contains(@class,'card shadow')]"));
        int termineCountAfter = termineListAfter.size();
        System.out.println("Number of term records after deletion: " + termineCountAfter);
        // Checking that the number of terms has not changed
        Assert.assertTrue("Termin was unexpectedly deleted!", termineCountAfter == termineListBefore);
    }

    @When("The user randomly selects a date from the list")
    public void the_user_randomly_selects_a_date_from_the_list() {
        // Find all available dates in a list
        List<WebElement> dateElements = driver.findElements(By.xpath("//div[@class='list-group-item']"));
        // Check that the list is not empty
        Assert.assertFalse("The list of available dates is empty!", dateElements.isEmpty());
        // Pick a random date
        Random random = new Random();
        int randomIndex = random.nextInt(dateElements.size());
        WebElement randomDate = dateElements.get(randomIndex);
        // Click on the selected date
        randomDate.click();
        System.out.println("Selected date:" + randomDate.getText());
    }

    @And("The user clicks the Termin vereinbaren button")
    public void theUserClicksTheTerminVereinbarenButton() {
        // Click on the "Termin vereinbaren" button
        WebElement confirmButton = driver.findElement(By.xpath("//div[@class='modal-body']//select[2]"));
        confirmButton.click();
    }

    @And("The user selects a service from the dropdown list")
    public void userSelectsAServiceFromDropdownList() {
        WebElement serviceDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Assert.assertTrue("The drop-down list of services is not displayed!", serviceDropdown.isDisplayed());
        // Open dropdown list
        serviceDropdown.click();
        // Find all available services
        List<WebElement> serviceOptions = driver.findElements(By.xpath("//select[@class='form-control']/option"));
        Assert.assertFalse("The list of services is empty!", serviceOptions.isEmpty());
        // Select a random service
        Random random = new Random();
        int randomServiceIndex = random.nextInt(serviceOptions.size());
        WebElement randomService = serviceOptions.get(randomServiceIndex);
        randomService.click();
        System.out.println("Service selected:" + randomService.getText());
    }

    @Then("The user opens the appointment booking page")
    public void userOpensAppointmentBookingPage() {
        // Click on the "Termin vereinbaren" button on the main page
        WebElement bookAppointmentButton = driver.findElement(By.xpath("//button[contains(text(),'Termin vereinbaren')]"));
        Assert.assertTrue("The 'Termin vereinbaren' button is not displayed!", bookAppointmentButton.isDisplayed());
        // Click on the button
        bookAppointmentButton.click();
        // Check that the booking page is open
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement timeslotsModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'modal') and contains(@class,'show')]")));
        Assert.assertTrue("The modal window for selecting terms did not open!", timeslotsModal.isDisplayed());
        WebElement serviceDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='serviceSelect']")));
        Assert.assertTrue("The drop-down list of services is not displayed!", serviceDropdown.isDisplayed());
        Select selectService = new Select(serviceDropdown);
        selectService.selectByVisibleText("Neuraltherapie");
        System.out.println("The service was successfully selected.");
    }

    @And("The user click on the Mehr termine zeigen")
    public void theUserClickOnTheMehrTermineZeigen() {
        new TerminePage(driver).clickMehr();
    }

    @And("display the total number of records")
    public void displayTheTotalNumberOfRecords() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set your timeout as needed
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    List<WebElement> newTermineList = driver.findElements(By.xpath("//div[contains(@class,'card shadow')]"));
                    int newSize = newTermineList.size();
                    System.out.println("Current Termine count: " + newSize);
                    return newSize > termineListBefore;
                }
            });
            List<WebElement> termineListAfter = driver.findElements(By.xpath("//div[contains(@class,'card shadow')]"));
            int termineCountAfter = termineListAfter.size();
            System.out.println("Final Termine count after click: " + termineCountAfter);
        } catch (TimeoutException e) {
            System.err.println("The expected number of termine did not appear within the timeout.");
        }
    }

    @And("The user counts the number of termine on the page")
    public void userCountsNumberTerminePage() {
        int termineCount =new TerminePage(driver).countTermine();
        System.out.println("Number of termine on the page: " + termineCount);
    }

    @And("The user deletes one termin from the list")
    public void theUserDeletesOneTerminFromTheList() {
        new TerminePage(driver).clickdeleteTermin();
    }
}

