package bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By usernameInputLocator = By.name("user-name");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//input[@name='login-button']");
    // private By hamburgerMenu = By.xpath("//button[@id='react-burger-cross-btn']");
    private By logoutButton = By.xpath("//a[@id='logout_sidebar_link']");
    private By homepageTitle = By.xpath("//div[@class='app_logo']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //methods:

    public void enterUsername(String username){
        WebElement usernameInput = driver.findElement(usernameInputLocator);
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    // Confirmation of homepage after logged in.
    public boolean logoOnHomePage(){
        return driver.findElement(homepageTitle).isDisplayed();
    }

    // User clicks on Menu button after login in.
    public void clickOnHamburgerMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='react-burger-menu-btn']")));
        menuButton.click();
    }

    // Confirms if the logout button is displayed on the home page
    public boolean logoutButtonDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).isDisplayed();

    }




}
