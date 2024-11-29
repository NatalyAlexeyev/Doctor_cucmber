package doctor.pages;

import doctor.core.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Profile')]")
    WebElement profileLink;
    public ProfilePage clickProfile() {
        click(profileLink);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Profile')]")
    WebElement profileTitle;
    public boolean isProfileLinkPresent() {
        return isElementPresent(profileTitle);
    }

    @FindBy(xpath = "(//div[contains(@class,'col-sm-6 mb-3')]//input)[2]")
    WebElement vorName;
    public ProfilePage enterVornameData(String text) {
        type(vorName,text);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Speichern')]")
    WebElement speichern;
    public ProfilePage clickSpeichern() {
        click(speichern);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Vorgang erfolgreich abgeschlossen')]")
    WebElement unsuccessfulRegistrationMessage;
    public boolean isErfolgreichMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(unsuccessfulRegistrationMessage)); // Wait for the *element* to be visible
            return true; // If it's visible, return true
        } catch (TimeoutException e) {
            return false; // If it's not visible within the timeout, return false
        }
    }

    @FindBy(xpath = "//body/div[@id='root']/nav[@id='mainNav']/div[1]")
    WebElement startBootstrapLink;
    public ProfilePage clickStartBootstrap() {
        click(startBootstrapLink);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "(//div[@class='col-sm-6']//input)[2]")
    WebElement nachName;
    public ProfilePage enterNachname(String text) {
        type(nachName,text);
        return this;
    }

    @FindBy(xpath = "(//div[@class='col-sm-6']//input)[1]")
    WebElement telefonNummer;
    public ProfilePage enterTelefonnummerData(String number) {
        type(telefonNummer,number);
        return this;
    }
}
