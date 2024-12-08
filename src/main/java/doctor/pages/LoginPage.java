package doctor.pages;

import doctor.core.BasePage;
import doctor.utils.UserDataUtils;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Willkommen zurück')]")
    WebElement loginPageTitle;
    public boolean isLoginPageTitlePresent() {
        return isElementPresent(loginPageTitle);
    }

    @FindBy(xpath = "(//div[@class='form-group']//input)[1]")
    WebElement emailInput;

    @FindBy(xpath = "(//div[@class='form-group']//input)[2]")
    WebElement passwordInput;

    public LoginPage enterPazientData(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        return this;
    }

    @FindBy(xpath = "//button[contains(@class,'btn btn-primary')]")
    WebElement anmeldenLink;
    public LoginPage clickOnAnmeldenLink() {
        click(anmeldenLink);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Konto erstellen')]")
    WebElement kontoErstellen;

    public LoginPage clickKontoErstellen() {
        click(kontoErstellen);
        return new LoginPage(driver);

    }

    @FindBy(xpath = "//input[@id='isPersistent']")
    WebElement angemeldet;

    public LoginPage clickAngemeldet() {
        click(angemeldet);
        return this;
    }

    public LoginPage enterCredentials(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps();
        String email = dataTable.get(0).get("email");
        String password = dataTable.get(0).get("password");

        enterCredentials(email,password);
        return this;
    }

    public LoginPage enterCredentials(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        return this;
    }

    @FindBy(xpath = "//div[contains(text(), 'Falsche Daten')]")
    WebElement unsuccessfulLoginMessage;
    public boolean isUnsuccessfulLoginMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Falsche Daten')]"))); // Wait for visibility
            return unsuccessfulLoginMessage.isDisplayed();  // Check if displayed
        } catch (TimeoutException e) {
            return false; // Return false if the element is not found or visible within the timeout
        }
    }

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement loginLink;
    public LoginPage clickOnLoginLink() {
        click(loginLink);
        return new LoginPage(driver);
    }

    public LoginPage enterPazientData1() {
        String[] userData = UserDataUtils.getRandomUserData();
        if (userData != null) {
            String email = userData[0];
            String password = userData[1];
            enterPazientData(email, password);
        } else {
            System.out.println("No user data found!");
        }
        return this;
    }
}




