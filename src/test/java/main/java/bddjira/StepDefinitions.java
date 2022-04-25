package main.java.bddjira;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

    static IndexPage mainPage;

    @Before
    public void setup(){
        if (System.getProperty("os.name").equals("Linux")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        }
        mainPage = new IndexPage(new ChromeDriver());
    }

    @Given("Jira page is open")
    public void loginPage(){
        mainPage.goToIndexPage();
    }

    @When("user enters proper passwords")
    @ParameterizedTest
    @CsvSource
    @CsvFileSource(resources = "/mainpagelogin/login.csv", numLinesToSkip = 1)
    public void enterProperPassword(String key, String username, String password) {
        mainPage.fillUsername(username);
        mainPage.fillPassword(password);
    }

    @And("clicks login button")
    public void clicksLoginButton() {
        mainPage.clickLogin();
    }

    @Then("I see the create button")
    public void iSeeTheCreateButton() {
        Assertions.assertTrue(mainPage.createButton.isDisplayed());
    }

    @And("I see a user logged in")
    public void iSeeAUserLoggedIn() {
        Assertions.assertTrue(mainPage.userIcon.isDisplayed());
    }
}
