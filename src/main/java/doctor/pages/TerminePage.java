package doctor.pages;

import doctor.core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TerminePage extends BasePage {
    public int termineListBefore;
    public TerminePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Termine')]")
    WebElement clickTermine;
    public TerminePage clickTermine() {
        click(clickTermine);
        return new TerminePage(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Termine')]")
    WebElement termineTitle;
    public boolean isProfileLinkPresent() {
        return isElementPresent(termineTitle);
    }

    @FindBy(xpath = "//button[contains(text(),'Mehr')]")
    WebElement clickMehr;
    public TerminePage clickMehr() {
        scrollWithPageDown(1,100);
        click(clickMehr);
        WebElement mehrButton = driver.findElement(By.xpath("//button[contains(text(),'Mehr')]"));

        List<WebElement> termineList = driver.findElements(By.xpath("//div[contains(@class,'card shadow')]"));
        int initialTermineCount = termineList.size();

        if (initialTermineCount >= 5 && mehrButton.isDisplayed() && mehrButton.isEnabled()) {
            termineListBefore = initialTermineCount;
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mehrButton);

            } catch (StaleElementReferenceException ex) {
                mehrButton = driver.findElement(By.xpath("//button[contains(text(),'Mehr')]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mehrButton);
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set your timeout as needed
            try {
                wait.until(ExpectedConditions.elementToBeClickable(mehrButton)).click();
                System.out.println("Clicked 'Mehr termine zeigen' successfully.");

                // It's crucial to wait for the new termine to load AFTER the click
                wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[contains(@class,'card shadow')]"), termineListBefore));

                int termineCountAfter = driver.findElements(By.xpath("//div[contains(@class,'card shadow')]")).size();
                Assert.assertTrue("More termine did not load!", termineCountAfter > termineListBefore);
                System.out.println("Termine count increased from " + termineListBefore + " to " + termineCountAfter);

            } catch (TimeoutException e) {
                System.err.println("'Mehr termine zeigen' not clickable after 10 seconds.");
                throw e; // Re-throw to fail the test
            }

        } else {
            System.out.println("'Mehr termine zeigen' not clickable.  Initial termine count: " + initialTermineCount);
        }
        return new TerminePage(driver);
    }

    public int countTermine() {
        List<WebElement> termineList = driver.findElements(By.xpath("//div[contains(@class,'card shadow')]"));
        int termineCount = termineList.size();
        return termineCount;
    }

    public TerminePage clickdeleteTermin() {
        List<WebElement> deleteButtons = driver.findElements(By.xpath("(//div[@class='col-sm-1']//button)[1]"));
        if (!deleteButtons.isEmpty()) {
            WebElement deleteButton = deleteButtons.get(0);
            // Scroll to delete button (if necessary)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteButton);
            // Click on the delete button
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
            // Waiting for the modal window to appear
            WebElement confirmButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='swal2-actions']//button)[3]")));
            // Click on the confirmation button
            confirmButton.click();
            // Waiting for the modal window to disappear
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(confirmButton));

            System.out.println("The first term was successfully removed.");
        } else {
            System.err.println("There are no delete buttons!");
        }
        return new TerminePage(driver);
    }
}
