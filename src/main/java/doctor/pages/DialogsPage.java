package doctor.pages;

import doctor.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class DialogsPage extends BasePage {

    public DialogsPage(WebDriver driver) {
        super(driver);
    }
   // DialogsPage dialogsPage = new DialogsPage(driver);
    @FindBy(xpath = "//div[contains(text(),'Timeslots')]")
    WebElement timeslots;
    public boolean isDialogsPageTimeslots() {
        wait.until(ExpectedConditions.visibilityOf(timeslots));
        return timeslots.isDisplayed();
    }

    @FindBy(xpath = "//div[@class='modal-body']//select[2]")
    WebElement infusionstherapieclick;
    public DialogsPage clickInfusionstherapie() {
        click(infusionstherapieclick);
        return this;
    }


    @FindBy(xpath = "(//div[@class='modal-footer']//button)[2]")
    WebElement terminVereinbar;
    public DialogsPage clickTerminVereinbar() {
        //scrollWithPageDown(1,100);
        click(terminVereinbar);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Schließen')]")
    WebElement schlissenButton;
    public DialogsPage clickSchlissenButton() {
        click(schlissenButton);
        return this;
    }

    @FindBy(xpath = "//div[contains(text(),'Bitte melden Sie sich an, um fortzufahren.')]")
    WebElement terminVereinbarInfoMessage;
    public boolean isDialogsPageInfo() {
        wait.until(ExpectedConditions.visibilityOf(terminVereinbarInfoMessage)); // Wait for the info message
        return terminVereinbarInfoMessage.isDisplayed();
    }

    @FindBy(xpath = "//div[normalize-space(text())='Diese Zeit ist bereits vergeben']")
    private WebElement zeitVergebenMessage;

    @FindBy(xpath = "//div[normalize-space(text())='Falsche Daten: Zeit']")
    private WebElement falscheDatenZeitMessage;

    @FindBy(xpath = "//div[normalize-space(text())='Ihr Termin wurde erfolgreich abgeschlossen. Sie erhalten eine Bestätigung per E-Mail.']")
    WebElement terminErfolgreichMessage;

    @FindBy(xpath = "//div[normalize-space(text())='Bitte melden Sie sich an, um fortzufahren.']")
    WebElement bitteAnmeldenMessage;

    @FindBy(xpath = "//div[contains(text(),'Bitte wählen Sie eine Dienstleistung aus')]")
    WebElement terminVereinbarInfoMessage1;

    public DialogsPage selectTerminDate(String date) {
        WebElement dateElement = driver.findElement(By.xpath("//button[contains(text(),'" + date + "')]"));
        click(dateElement);
        return this;
    }

    public DialogsPage selectTerminTime(String time) {
        String timeXpath = String.format("//input[@id='%s']", time);
        click(driver.findElement(By.xpath(timeXpath)));
        return this;
    }

    @FindBy(xpath = "(//div[@class='modal-footer']//button)[2]")
    WebElement terminVereinbarButton;
    public DialogsPage clickTerminVereinbarmod() {
        click(terminVereinbarButton);
        return this;
    }

    @FindBy(xpath = "//div[normalize-space(text())='Ihr Termin wurde erfolgreich abgeschlossen. Sie erhalten eine Bestätigung per E-Mail.']")
    WebElement terminInfoMessage;

    public boolean isDialogsPageInfoMessageDisplayed(String expectedMessage) {
        WebElement messageElement = null;
        try {
            switch (expectedMessage) {
                case "Ihr Termin wurde erfolgreich abgeschlossen. Sie erhalten eine Bestätigung per E-Mail.":
                    messageElement = terminInfoMessage;
                    break;
                case "Bitte melden Sie sich an, um fortzufahren.":
                    messageElement = bitteAnmeldenMessage;
                    break;
                case "Diese Zeit ist bereits vergeben":
                    messageElement = zeitVergebenMessage;
                    break;
                case "Falsche Daten: Zeit":
                    messageElement = falscheDatenZeitMessage;
                    break;
                case "Bitte wählen Sie eine Dienstleistung aus":
                    messageElement = terminVereinbarInfoMessage1;
                    break;
                default:
                    throw new RuntimeException("No such message: " + expectedMessage);
            }

            if (messageElement != null) {
                wait.until(ExpectedConditions.visibilityOf(messageElement));
                return messageElement.isDisplayed();
            }

        } catch (TimeoutException e) {
            System.err.println("Message not displayed within timeout: " + e.getMessage());
            return false;

        } catch (NoSuchElementException e) {
            System.err.println("Element not found on the page: " + e.getMessage());
            return false;
        }
        return false;
    }

    @FindBy(xpath = "//div[@class='modal-body']//select[1]")
    WebElement clikservice;
    public DialogsPage clickService() {
        click(clikservice);
        return new DialogsPage(driver);
    }

    @FindBy(xpath = "//div[@class='calendar-grid']//button[not(contains(@class, 'disabled'))]")
    List<WebElement> allDates;

    @FindBy(xpath = "//input[@class='form-check-input' and @type='radio' and @name='time']")
    List<WebElement> allTimeslots;
    public DialogsPage selectDateAndTimeslot(int dateIndex, int timeslotIndex) {
        // Собираем все доступные даты
        List<WebElement> dates = allDates;
        if (dateIndex >= 0 && dateIndex < dates.size()) {
            // Выбираем дату по индексу
            click(dates.get(dateIndex));
            System.out.println("Выбрана дата с индексом: " + dateIndex);

            // После выбора даты собираем таймслоты
            List<WebElement> timeslots = allTimeslots;
            if (timeslotIndex >= 0 && timeslotIndex < timeslots.size()) {
                // Выбираем таймслот по индексу
                click(timeslots.get(timeslotIndex));
                System.out.println("Выбран таймслот с индексом: " + timeslotIndex);
            } else {
                System.err.println("Индекс таймслота вне диапазона: " + timeslotIndex);
            }
        } else
            System.err.println("Индекс даты вне диапазона: " + dateIndex);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'16.12.2024')]")
    WebElement cliksDate;
    public DialogsPage clickstDate() {
        click(cliksDate);
        System.out.println("Clicked date: " + cliksDate.getText());
        return new DialogsPage(driver);
//        // Локатор для доступных дат
//        List<WebElement> availableDates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//                By.xpath("//button[contains(text(),'20.12.2024')]"))); // Замените на реальный XPath для дат
//        ////button[contains(text(),'16.12.2024')]   //div[contains(@class, 'timeslot-date')] //div[@id='aTimeslots']//button
//        // Проверка наличия доступных дат
//        if (availableDates.isEmpty()) {
//            throw new IllegalStateException("Нет доступных дат для выбора!");
//        }
//
//        // Выбор случайной даты
//        WebElement randomDate = availableDates.get(new Random().nextInt(availableDates.size()));
//
//        // Скролл к выбранной дате (если нужно)
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomDate);
//
//        // Клик по случайной дате
//        randomDate.click();
//
//        // Логирование выбранной даты
//        System.out.println("Выбрана дата: " + randomDate.getText());
    }

    public void clickstTime() {
        // 1. Wait for at least one time slot to be clickable:
        WebElement time = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"8at4\"]")));
        click(time);
        System.out.println("Clicked time: " + time.getAttribute("id"));
//        // Локатор для всех доступных времен
//        List<WebElement> availableTimes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//                By.xpath("//*[@id=\"aTimeslot8\"]/div/div/div[1]/div")));
//////body/div[3]/div[1]/div[1]/div[2]/div[2]/div[3]//input[@type='radio']
//        // Проверка наличия доступных временных интервалов
//        if (availableTimes.isEmpty()) {
//            throw new IllegalStateException("Нет доступных временных интервалов для выбора!");
//        }
//
//        // Выбор случайного времени
//        WebElement randomTime = availableTimes.get(new Random().nextInt(availableTimes.size()));
//
//        // Скролл к выбранному времени (если нужно)
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomTime);
//
//        // Клик по случайному времени
//        randomTime.click();
//
//        // Получение текста времени для логирования (опционально)
//        WebElement timeLabel = randomTime.findElement(By.xpath("./following-sibling::label"));
//        System.out.println("Выбрано время: " + timeLabel.getText());
    }

    @FindBy(xpath = "//div[contains(text(), 'Bitte melden Sie sich an, um fortzufahren.')]")
    WebElement loginErrorMessage;
    public boolean isDialogsPageMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(), 'Bitte melden Sie sich an, um fortzufahren.')]"))); // Wait for visibility
            return loginErrorMessage.isDisplayed(); // Check if the message is displayed
        } catch (Exception e) {
            return false; // Return false if the element is not found or not visible within the timeout
        }
    }


    @FindBy(xpath = "//div[normalize-space(text())='Bitte melden Sie sich an, um fortzufahren.']")
    WebElement infoMessage;
    public boolean isDialogsPageInfoMessage() {
        wait.until(ExpectedConditions.visibilityOf(infoMessage)); // Wait for the info message
        return infoMessage.isDisplayed();
    }

    public boolean isInfoMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(terminInfoMessage)); // Wait for the *element* to be visible
            return true; // If it's visible, return true
        } catch (TimeoutException e) {
            return false; // If it's not visible within the timeout, return false
        }
    }
}
