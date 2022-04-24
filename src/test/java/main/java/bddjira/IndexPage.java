package main.java.bddjira;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import util.WebelementWait;

public class IndexPage {
    private final WebDriver driver;
    private static final String LOGIN_TEST_DATA_PATH = "src/test/resources/login.csv";
    private final int USERNAME_COLUMN_INDEX = 1;
    private final int PASSWORD_COLUMN_INDEX = 2;
    public static final String issueURL = "https://jira-auto.codecool.metastage.net/issues/?jql=project%20%3D%20%22Main%20Testing%20Project%22%20AND%20summary%20~%20MTP-8982431";

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 3), this);
    }

    @FindBy(xpath = "//input[@id='login-form-username']")
    WebElement usernameInputField;

    @FindBy(xpath = "//input[@id='login-form-password']")
    WebElement passwordInputField;

    @FindBy(xpath = "//input[@name='login']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='aui-message aui-message-error']/p")
    WebElement wrongCredentials;

    @FindBy(xpath = "//a[@id='header-details-user-fullname']")
    WebElement userIcon;

    @FindBy(xpath = "//a[@id='log_out']")
    WebElement logoutButton;

    @FindBy(xpath = "//p[@class='title']/strong")
    WebElement logoutNotification;

    @FindBy(xpath = "//a[@id='create_link']")
    WebElement createButton;

    @FindBy(xpath = "//input[@id='project-field']")
    WebElement projectInputField;

    @FindBy(xpath = "//input[@id='issuetype-field']")
    WebElement issueTypeField;

    @FindBy(xpath = "//input[@id='summary']")
    WebElement summaryInputField;

    @FindBy(xpath = "//a[@id='opsbar-operations_more']")
    WebElement moreButton;

    @FindBy(xpath = "//a/span[contains(text(), 'Delete')]")
    WebElement deleteButton;

    @FindBy(xpath = "//input[@id='create-issue-submit']")
    WebElement createIssueCreateButton;

    @FindBy(xpath = "//a[@class='issue-created-key issue-link']")
    WebElement createIssuePopUp;

    public void goToIndexPage(){
        driver.get("https://jira-auto.codecool.metastage.net/");
    }

    public void fillUsername(String username){
        WebelementWait.waitUntilVisible(driver,usernameInputField);
        usernameInputField.sendKeys(username);
    }

    public void fillPassword(String password){
        WebelementWait.waitUntilVisible(driver,passwordInputField);
        passwordInputField.sendKeys(password);
    }

    public void clickLogin(){
        WebelementWait.waitUntilClickable(driver,loginButton);
        loginButton.click();
    }

    public String getUsernameOfIcon(){
        WebelementWait.waitUntilVisible(driver, userIcon);
        return userIcon.getDomAttribute("data-username");
    }


}
