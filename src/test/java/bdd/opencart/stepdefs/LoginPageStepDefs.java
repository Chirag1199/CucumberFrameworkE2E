package bdd.opencart.stepdefs;

import bdd.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class LoginPageStepDefs {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am on the sauceDemo login page")
    public void i_am_on_the_sauce_demo_login_page() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered valid login credentials")
    public void i_have_entered_valid_login_credentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the home page")
    public void i_should_be_redirected_to_the_home_page() {
        loginPage.logoOnHomePage();
    }

    @When("I click on the hamburger menu")
    public void i_click_on_the_hamburger_menu(){
        loginPage.clickOnHamburgerMenu();
    }

    @Then("the Logout button should be displayed successfully")
    public void the_logout_button_should_be_displayed_successfully() {
        Assert.assertTrue(loginPage.logoutButtonDisplayed(), "Logout button is not displayed");
    }

    @Given("I have entered the username {string} and password {string}")
    public void i_have_entered_the_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message() {

        Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed());

    }



}
