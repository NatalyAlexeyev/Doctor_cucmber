package doctor.pages;

import doctor.core.BasePage;

import doctor.utils.EmailUtils;
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
import java.util.NoSuchElementException;

public class RegistrationPage extends BasePage {
    private static String generatedEmail;

    public static String getGeneratedEmail() {
        return generatedEmail;
    }
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

   // private String email;
    @FindBy(xpath = "//a[contains(text(),'Konto erstellen')]")
    WebElement kontoErstellen;

    public RegistrationPage clickKontoErstellenButton() {
        click(kontoErstellen);
        return new RegistrationPage(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Konto erstellen')]")
    WebElement kontoErstellenPageTitle;

    public boolean isKontoErstellenPageTitlePresent() {
        return isElementPresent(kontoErstellenPageTitle);
    }

    //@FindBy(xpath = "(//div[contains(@class,'col-sm-6 mb-3')]//input)[1]")
    @FindBy(xpath = "(//div[@class='col-sm-6']//input)[1]")
    WebElement vorname;

    //@FindBy(xpath = "(//div[@class='col-sm-6']//input)[1]")
    @FindBy(xpath = "(//div[@class='col-sm-6']//input)[2]")
    WebElement nachname;

    //@FindBy(xpath = "(//div[contains(@class,'col-sm-6 mb-3')]//input)[2]")
    @FindBy(xpath = "(//div[@class='col-sm-6']//input)[3]")
    WebElement email1;

    //@FindBy(xpath = "(//div[@class='col-sm-6']//input)[2]")
    @FindBy(xpath = "//input[@name='PhoneNumber']")
    WebElement telefonnummer;

   // @FindBy(xpath = "//div[@class='form-group']//input[1]")
    @FindBy(xpath = "//div[@class='form-group']//input[1]")
    WebElement passwort;

    public RegistrationPage enterPatienDetails(String vorName, String nachName, String Email, String telefonNumber, String password) {
        type(vorname, vorName);
        type(nachname, nachName);
        String email2;
        email2 = EmailUtils.generateRandomEmail();
        type(email1, email2);
        type(telefonnummer, telefonNumber);
        type(passwort, password);
        UserDataUtils.saveUserData(email2, password);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Weiter')]")
    WebElement weiterButton;

    public RegistrationPage clickWeiterLink() {
        click(weiterButton);
        return new RegistrationPage(driver);
    }

    public boolean isErrorMessageDisplayed(String field, String expectedErrorMessage) {
        try {
            String xpath = String.format("//span[contains(text(),'%s')]/following-sibling::span", field);
            WebElement errorMessageElement = driver.findElement(By.xpath(xpath));
            wait.until(ExpectedConditions.visibilityOf(errorMessageElement));
            String actualErrorMessage = errorMessageElement.getText().trim();
            return actualErrorMessage.equals(expectedErrorMessage);
        } catch (NoSuchElementException | TimeoutException e) {
            System.err.println("Error message element not found or not visible: " + e.getMessage());
            return false;
        }
    }

    public String getErrorMessageByField(String field) {
        try {
            String xpath = String.format("//label[contains(text(), '%s')]/following-sibling::span", field);
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return errorMessageElement.getText().trim();
        } catch (NoSuchElementException | TimeoutException e) {
            String errorMessage = String.format("Error message element not found or not visible for field '%s': %s", field, e.getMessage());
            System.err.println(errorMessage);
            return "";
        }
    }


    public RegistrationPage enterInvalidDetails(DataTable table) {

        List<Map<String, String>> dataTable = table.asMaps();
        for (Map<String, String> row : dataTable) {
            String vormame = row.get("vorname");
            String nachname = row.get("nachname");
            String email = row.get("email");
            if (email == null || email.trim().isEmpty()) {
                email = EmailUtils.generateRandomEmail();
            } else {
                email = email.trim();
            }
            String telefonnummer = row.get("telefonnummer");
            String password = row.get("password");
            enterInvDetails(vormame, nachname, email, telefonnummer, password);
        }
        return this;
    }

    private RegistrationPage enterInvDetails(String vorName, String nachName, String Email, String Telefonnummer, String password) {
        type(vorname, vorName);
        type(nachname, nachName);
        type(email1, Email);
        type(telefonnummer, Telefonnummer);
        type(passwort, password);
        return this;
    }

    @FindBy(xpath = "//div[contains(text(),\"Passwords must have at least one lowercase ('a'-'z\")]") // **CORRECT XPATH IS CRUCIAL**
    WebElement invalidPasswordMessage;

    @FindBy(xpath = "//div[contains(text(),\"Username '\") and contains(text(),\"' is already taken.\")]")
    WebElement emailExistsMessage;

    public boolean isUnsuccessfulRegistrationMessageDisplayed(String expectedErrorMessage) {
        WebElement errorMessageElement = null; // Declare outside the switch

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            switch (expectedErrorMessage) {
                case "Passwords must have at least one lowercase ('a'-'z')":
                    errorMessageElement = invalidPasswordMessage;
                    break;
                case "This user already exists":
                    errorMessageElement = emailExistsMessage;
                    break;
                default:
                    throw new RuntimeException("No such error message: " + expectedErrorMessage);

            }
            if (errorMessageElement != null) {
                wait.until(ExpectedConditions.visibilityOf(errorMessageElement));
                return errorMessageElement.isDisplayed();
            }

        } catch (TimeoutException e) {
            System.err.println("Error message not displayed within timeout: " + e.getMessage());
            return false;

        } catch (NoSuchElementException e) {
            System.err.println("Element not found on the page: " + e.getMessage());
            return false;
        }
        return false;

    }

    @FindBy(xpath = "//a[contains(text(),'Anmelden')]")
    WebElement anmeldenLink;

    public RegistrationPage clickAnmeldenLink() {
        click(anmeldenLink);
        return new RegistrationPage(driver);
    }
}

