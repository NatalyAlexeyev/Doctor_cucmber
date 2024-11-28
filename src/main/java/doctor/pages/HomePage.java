package doctor.pages;

import doctor.core.BasePage;
import doctor.utils.EmailUtils;
import doctor.utils.UserDataUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get("https://gesundheitspraxis-wertvoll.de");
    }

    @FindBy(xpath = "//h1[contains(text(),'Gesundheitspraxis Wertvoll')]")
    WebElement homePageTitl;
    public boolean isHomePageTitlePresent() {
        return isElementPresent(homePageTitl);
    }
//    public LoginPage clickOnLoginLink() {
//        click(loginLink);
//        return null;
//    }
   // @FindBy(xpath = "//div[text()='Infusionstherapie']/preceding::a[@class='portfolio-link']")
    //@FindBy(xpath = "(//a[@class='portfolio-link']//div)[1]")
   @FindBy(xpath = "//div[text()='Infusionstherapie']/preceding::a[1]")
    WebElement infusionstherapieLink;
    public HomePage clickInfusionstherapieLink() {
        //scrollWithPageDown(1,100);
        click(infusionstherapieLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Infusionstherapie')]")
    WebElement infusionstherapieTitle;
    public boolean isInfusionstherapieTitlePresent() {
        wait.until(ExpectedConditions.visibilityOf(infusionstherapieTitle));
        return infusionstherapieTitle.isDisplayed();
       // return isElementPresent(infusionstherapieTitle);
    }

    @FindBy(xpath = "//a[contains(text(),'Portfolio')]")
    WebElement portfolioLink;
    public HomePage clikPortfolio() {
        click(portfolioLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Meine Leistungen')]")
    WebElement meineLeistungenTitle;
    public boolean isMeineLeistungenTitle() {
        return isElementPresent(meineLeistungenTitle);
    }

    @FindBy(xpath = "//div[text()='Neuraltherapie']/preceding::a[1]")
   // @FindBy(xpath = "//div[text()='Neuraltherapie']/preceding::a[@class='portfolio-link']")
   // @FindBy(xpath = "(//a[@class='portfolio-link']//div)[3]")
    WebElement neuraltherapieLink;
    public HomePage clickNeuraltherapie() {
        click(neuraltherapieLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Neuraltherapie')]")
    WebElement neuraltherapieTitle;
    public boolean isNeuraltherapieTitlePresent() {
        wait.until(ExpectedConditions.visibilityOf(neuraltherapieTitle));
        return neuraltherapieTitle.isDisplayed();
    }

    @FindBy(xpath = "//div[text()='Schröpftherapie']/preceding::a[1]")
    //@FindBy(xpath = "//div[text()='Neuraltherapie']/preceding::a[@class='portfolio-link']")
    //@FindBy(xpath = "(//div[@class='portfolio-hover'])[3]")
    WebElement schropftherapieLink;
    public HomePage clickSchropftherapie() {
       // scrollWithPageDown(1,200);
        click(schropftherapieLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Schröpftherapie')]")
    WebElement schropftherapieTitle;
    public boolean isSchropftherapieTitlePresent() {
        wait.until(ExpectedConditions.visibilityOf(schropftherapieTitle));
        return schropftherapieTitle.isDisplayed();
    }
   // @FindBy(xpath = "//div[text()='Phytotherapie']/preceding::a[@class='portfolio-link']")
    @FindBy(xpath = "//div[text()='Phytotherapie']/preceding::a[1]")
    WebElement phytotherapieLink;
    public HomePage clickPhytotherapie() {
        scrollWithPageDown(3,250);
        click(phytotherapieLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Phytotherapie')]")
    WebElement phytotherapieTitle;
    public boolean isPhytotherapieTitlePresent() {
        wait.until(ExpectedConditions.visibilityOf(phytotherapieTitle));
        return phytotherapieTitle.isDisplayed();
    }

    @FindBy(xpath = "//div[text()='Aromatherapie']/preceding::a[1]")
    WebElement aromatherapieLink;
    public HomePage clickAromatherapie() {
        //scrollWithPageDown(3,250);
        click(aromatherapieLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Aromatherapie')]")
    WebElement aromatherapieTitle;
    public boolean isAromatherapieTitlePresent() {
        wait.until(ExpectedConditions.visibilityOf(aromatherapieTitle));
        return aromatherapieTitle.isDisplayed();
    }

    @FindBy(xpath = "//div[text()='Ernährungsberatung']/preceding::a[1]")
    WebElement ernahrungsberatungLink;
    public HomePage clickErnahrungsberatung() {
        scrollWithPageDown(3,250);
        click(ernahrungsberatungLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Ernährungsberatung')]")
    WebElement ernahrungsberatungTitle;
    public boolean isErnahrungsberatungTitlePresent() {
        wait.until(ExpectedConditions.visibilityOf(ernahrungsberatungTitle));
        return ernahrungsberatungTitle.isDisplayed();
    }

    @FindBy(xpath = "//div[text()='Labordiagnostik']/preceding::a[1]")
    WebElement labordiagnostikLink;
    public HomePage clickLabordiagnostik() {
        scrollWithPageDown(4,300);
//        scrollTo(1000);
//        scrollToElement(labordiagnostikLink);
        click(labordiagnostikLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Labordiagnostik')]")
    WebElement labordiagnostikTitle;
    public boolean isLabordiagnostikTitlePresent() {
        wait.until(ExpectedConditions.visibilityOf(labordiagnostikTitle));
        return labordiagnostikTitle.isDisplayed();
    }

    @FindBy(xpath = "//button[contains(text(),'Account')]") // Replace with the actual XPath of the Account button
    WebElement accountButton;
    public boolean isAccountButtonPresent() {
        return isElementPresent(accountButton);
    }

    @FindBy(xpath = "//button[contains(text(),'Account')]")
    WebElement accountLink;
    public HomePage clickAccount() {
        click(accountLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logautLink;
    public HomePage clickLogout() {
        click(logautLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement loginLink;

    public boolean isHomePageLogin() {
        return isElementPresent(loginLink);
    }

    @FindBy(xpath = "//a[contains(text(),'About')]")
    WebElement aboutLink;
    public HomePage clickAboutlink() {
        scrollWithPageDown(4,250);
        click(aboutLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'About')]")
    WebElement aboutTitle;
    public boolean isHomePageTitleAbout() {
        wait.until(ExpectedConditions.visibilityOf(aboutTitle));
        return aboutTitle.isDisplayed();
    }

    @FindBy(xpath = "//a[contains(text(),'Team')]")
    WebElement teamLink;
    public HomePage clickTeamlink() {

        click(teamLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Unser Team')]")
    WebElement teamTitle;
    public boolean isHomePageTitleTeam() {
        wait.until(ExpectedConditions.visibilityOf(teamTitle));
        return teamTitle.isDisplayed();
    }

    @FindBy(xpath = "//a[contains(text(),'Contact')]")
    WebElement contactLink;
    public HomePage clickContactlink() {
        scrollWithPageDown(13,100);
        click(contactLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Kontakt')]")
    WebElement contactTitle;
    public boolean isHomePageTitleContact() {
        wait.until(ExpectedConditions.visibilityOf(contactTitle));
        return contactTitle.isDisplayed();
    }

    @FindBy(xpath = "//a[contains(text(),'Services')]")
    WebElement servicesLink;
    public HomePage clickServices() {
        click(servicesLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Services')]")
    WebElement servicesTitle;
    public boolean isHomePageTitleServices() {
        wait.until(ExpectedConditions.visibilityOf(contactTitle));
        return contactTitle.isDisplayed();
    }

    @FindBy(xpath = "//a[contains(text(),'Termin vereinbaren')]")
    WebElement terminVereinbarLink;
    public HomePage clickTerminVereinbar() {
        scrollWithPageDown(1,100);
        click(terminVereinbarLink);
        return new HomePage(driver);
    }

    @FindBy(xpath = "//div[@class='form-group mb-md-0']//input[1]")
    WebElement telefonnummer;
    @FindBy(xpath = "(//div[@class='form-group']//input)[1]")
    WebElement nname;
    @FindBy(xpath = "(//div[@class='form-group']//input)[2]")
    WebElement email;
    @FindBy(xpath = "//div[contains(@class,'form-group form-group-textarea')]//textarea[1]")
    WebElement nachricht;

    public HomePage enterKontaktDetails(String name, String Email, String telefonNumber, String Nachricht) {
        type(nname, name);
        type(email, Email);
        type(telefonnummer, telefonNumber);
        type(nachricht, Nachricht);
        return this;
    }

    @FindBy(xpath = "//button[@id='submitButton']")
    WebElement nachrichtSenden;
    public HomePage clickNachrichtSenden() {
        click(nachrichtSenden);
        return new HomePage(driver);
    }

}

