package doctor.pages;

import doctor.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class DialogsPage extends BasePage {

    public DialogsPage(WebDriver driver) {
        super(driver);
    }

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
        // Collecting all available dates
        List<WebElement> dates = allDates;
        if (dateIndex >= 0 && dateIndex < dates.size()) {
            // Select a date by index
            click(dates.get(dateIndex));
            System.out.println("Selected date with index: " + dateIndex);

            // After choosing a date, we collect timeslots
            List<WebElement> timeslots = allTimeslots;
            if (timeslotIndex >= 0 && timeslotIndex < timeslots.size()) {
                // Select a timeslot by index
                click(timeslots.get(timeslotIndex));
                System.out.println("Timeslot with index selected:" + timeslotIndex);
            } else {
                System.err.println("Timeslot index out of range: " + timeslotIndex);
            }
        } else
            System.err.println("Date index out of range:" + dateIndex);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'20.12.2024')]")
    WebElement cliksDate;
    public DialogsPage clickstDate() {
        click(cliksDate);
        System.out.println("Clicked date: " + cliksDate.getText());
        return new DialogsPage(driver);
//
//        List<WebElement> availableDates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//                By.xpath("//button[contains(text(),'20.12.2024')]")));
//        ////button[contains(text(),'16.12.2024')]   //div[contains(@class, 'timeslot-date')] //div[@id='aTimeslots']//button
//        if (availableDates.isEmpty()) {
//            throw new IllegalStateException("There are no available dates to choose from!");
//        }
//        // Pick a random date
//        WebElement randomDate = availableDates.get(new Random().nextInt(availableDates.size()));
//        // Scroll to the selected date (if necessary)
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomDate);
//        // Click on a random date
//        randomDate.click();
//        // Logging the selected date
//        System.out.println("Selected date:" + randomDate.getText());
    }

    public void clickstTime() {
        // 1. Wait for at least one time slot to be clickable:
        WebElement time = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"6at5\"]")));
        click(time);
        System.out.println("Clicked time: " + time.getAttribute("id"));
//        List<WebElement> availableTimes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//                By.xpath("//*[@id=\"aTimeslot8\"]/div/div/div[1]/div")));
//////body/div[3]/div[1]/div[1]/div[2]/div[2]/div[3]//input[@type='radio']
//        if (availableTimes.isEmpty()) {
//            throw new IllegalStateException("There are no available time slots to choose from!");
//        }
//        WebElement randomTime = availableTimes.get(new Random().nextInt(availableTimes.size()));
//        // Scroll to the selected time (if necessary)
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomTime);
//        // Click on a random time
//        randomTime.click();
//        // Receiving time text for logging (optional)
//        WebElement timeLabel = randomTime.findElement(By.xpath("./following-sibling::label"));
//        System.out.println("Time selected:" + timeLabel.getText());
    }

    @FindBy(xpath = "//div[contains(text(), 'Bitte melden Sie sich an, um fortzufahren.')]")
    WebElement loginErrorMessage;
    public boolean isDialogsPageMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(), 'Bitte melden Sie sich an, um fortzufahren.')]")));
            return loginErrorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "//div[normalize-space(text())='Bitte melden Sie sich an, um fortzufahren.']")
    WebElement infoMessage;
    public boolean isDialogsPageInfoMessage() {
        wait.until(ExpectedConditions.visibilityOf(infoMessage));
        return infoMessage.isDisplayed();
    }

    public boolean isInfoMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(terminInfoMessage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
