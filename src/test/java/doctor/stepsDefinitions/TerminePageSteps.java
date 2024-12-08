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
    public int termineListBefore; // Глобальная переменная для хранения количества терминов до удаления


    @And("The user is redirected to the Termine page")
    public void theUserIsRedirectedToTheTerminePage() {
        Assert.assertTrue(new TerminePage(driver).isProfileLinkPresent());
    }

    @And("The user counts the number of terminen on the page")
    public void theUserCountsTheNumberOfTerminenOnThePage() {
        List<WebElement> termineList = driver.findElements(By.xpath("//div[contains(@class,'card shadow')]"));
        int termineCount = termineList.size();
        System.out.println("Количество записей терминов: " + termineCount);
        Assert.assertTrue("Termine list is empty!", termineCount > 0); // Убедимся, что список не пустой
    }

    @When("The user attempts to delete a termin from the list")
    public void the_user_attempts_to_delete_a_termin_from_the_list() {
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//div[@class='col-sm-1']//button[1]"));
        if (deleteButtons.size() > 0) {
            // Попытка удаления первого элемента
            deleteButtons.get(0).click();
            System.out.println("Попытка удаления первого термина.");
        } else {
            System.err.println("Кнопки удаления отсутствуют!");
        }
    }
    @Then("Verify the termin is not deleted and the list remains unchanged")
    public void verify_the_termin_is_not_deleted_and_the_list_remains_unchanged() {
        List<WebElement> termineListAfter = driver.findElements(By.xpath("//div[contains(@class,'card shadow')]"));
        int termineCountAfter = termineListAfter.size();
        System.out.println("Количество записей терминов после удаления: " + termineCountAfter);
        // Проверка, что количество терминов не изменилось
        Assert.assertTrue("Termin was unexpectedly deleted!", termineCountAfter == termineListBefore);
    }


    @Then("Verify the number of termine on the page is greater than zero")
    public void verifyTheNumberOfTermineOnThePageIsGreaterThanZero() {
        List<WebElement> termineListAfter = driver.findElements(By.xpath("//div[contains(@class,'card shadow')]"));
        int termineCountAfter = termineListAfter.size(); // Получаем количество терминов после удаления
        System.out.println("Количество записей терминов после попытки удаления: " + termineCountAfter);
        // Проверяем, что количество терминов не изменилось
        Assert.assertEquals("Количество терминов изменилось, хотя не должно!", termineListBefore, termineCountAfter);
    }

    @When("The user randomly selects a date from the list")
    public void the_user_randomly_selects_a_date_from_the_list() {
        // Найти все доступные даты в списке
        List<WebElement> dateElements = driver.findElements(By.xpath("//div[@class='list-group-item']"));

        // Проверить, что список не пуст
        Assert.assertFalse("Список доступных дат пуст!", dateElements.isEmpty());

        // Выбрать случайную дату
        Random random = new Random();
        int randomIndex = random.nextInt(dateElements.size());
        WebElement randomDate = dateElements.get(randomIndex);

        // Нажать на выбранную дату
        randomDate.click();

        System.out.println("Выбрана дата: " + randomDate.getText());
    }

    @And("The user clicks the Termin vereinbaren button")
    public void theUserClicksTheTerminVereinbarenButton() {
        // Нажать на кнопку "Termin vereinbaren"
        WebElement confirmButton = driver.findElement(By.xpath("//div[@class='modal-body']//select[2]"));
        confirmButton.click();
    }

    @And("The user selects a service from the dropdown list")
    public void userSelectsAServiceFromDropdownList() {
        WebElement serviceDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Assert.assertTrue("Выпадающий список услуг не отображается!", serviceDropdown.isDisplayed());

        // Открыть выпадающий список
        serviceDropdown.click();

        // Найти все доступные услуги
        List<WebElement> serviceOptions = driver.findElements(By.xpath("//select[@class='form-control']/option"));
        Assert.assertFalse("Список услуг пуст!", serviceOptions.isEmpty());

        // Выбрать случайную услугу
        Random random = new Random();
        int randomServiceIndex = random.nextInt(serviceOptions.size());
        WebElement randomService = serviceOptions.get(randomServiceIndex);
        randomService.click();

        System.out.println("Выбрана услуга: " + randomService.getText());

    }

    @Then("The user opens the appointment booking page")
    public void userOpensAppointmentBookingPage() {
        // Клик на кнопку "Termin vereinbaren" на главной странице
        WebElement bookAppointmentButton = driver.findElement(By.xpath("//button[contains(text(),'Termin vereinbaren')]"));
        Assert.assertTrue("Кнопка 'Termin vereinbaren' не отображается!", bookAppointmentButton.isDisplayed());

        // Клик по кнопке
        bookAppointmentButton.click();

        // Проверить, что открылась страница для бронирования
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement timeslotsModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'modal') and contains(@class,'show')]")));
        Assert.assertTrue("Модальное окно для выбора терминов не открылось!", timeslotsModal.isDisplayed());

        // Выбрать услугу из выпадающего списка
        WebElement serviceDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='serviceSelect']")));
        Assert.assertTrue("Выпадающий список услуг не отображается!", serviceDropdown.isDisplayed());

        Select selectService = new Select(serviceDropdown);
        selectService.selectByVisibleText("Neuraltherapie"); // Замените на нужную услугу

        System.out.println("Услуга успешно выбрана.");
    }

    @And("The user click on the Mehr termine zeigen")
    public void theUserClickOnTheMehrTermineZeigen() {
        new TerminePage(driver).clickMehr();
    }

    @And("display the total number of records")
    public void displayTheTotalNumberOfRecords() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set your timeout as needed

        try {
            // Wait until the number of termine elements is greater than the initial count
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    List<WebElement> newTermineList = driver.findElements(By.xpath("//div[contains(@class,'card shadow')]"));
                    int newSize = newTermineList.size();
                    // Log the intermediate sizes for debugging
                    System.out.println("Current Termine count: " + newSize);
                    return newSize > termineListBefore;
                }
            });
            List<WebElement> termineListAfter = driver.findElements(By.xpath("//div[contains(@class,'card shadow')]"));
            int termineCountAfter = termineListAfter.size();
            System.out.println("Final Termine count after click: " + termineCountAfter); // Log the count only after wait
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

