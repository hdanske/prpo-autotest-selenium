package files;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {
    private WebDriver driver;
    public static String LOGIN_URL = "https://prpo-test.intervale.ru/console/";
    public static String USERNAME = "username";
    public static String PASSWORD = "password";
    public static String LOGINBUTTON = "button";

    private By alertCloseButton = By.xpath("//p-messages//a");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage goTo(String url) {
        driver.get(url);
        return this;
    }

    //    @FindBy(id = "username")
//    private WebElement usernameField;
    private By usernameField = By.id(USERNAME);

    //    @FindBy(id = "password")
//    private WebElement passwordField;
    private By passwordField = By.id(PASSWORD);

    //    @FindBy(tagName = "button")
//    private WebElement loginButton;
    private By loginButton = By.tagName("button");


//    @FindBy(xpath = "//*[@id=\"ui-panel-4-content\"]/div/p-messages/div/ul/li/span[1]")
//    private WebElement errorSummary;
//
//    @FindBy(xpath = "//p-messages//ul/li//span[@class='ui-messages-summary ng-tns-c30-163 ng-star-inserted']")
//    private WebElement errorDetail;
//
//    @FindBy(className = "pi pi-times")
//    private WebElement iconClose;

    public LoginPage typeUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

//    public files.LoginPage typeUsername(String username){
//        usernameField.sendKeys(username);
//        return this;
//    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

//    public files.LoginPage typePassword(String password) {
//        passwordField.sendKeys(password);
//        return this;
//    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public WebElement getloginButton() {
        return driver.findElement(loginButton);
    }

    public void closeAlert() {
        driver.findElement(alertCloseButton).click();
    }

    public WebElement checkMessage(String login_failed) {
        WebElement error = driver.findElement(By.xpath("//span[text()=\"" + login_failed + "\"]"));
        return error;
    }

    public void clearField(String field) {
        WebElement element = driver.findElement(By.id(field));

        String text = element.getAttribute("value");

        int n = text.length();

        while (n > 0) {
            element.sendKeys(Keys.BACK_SPACE);
            n --;
        }
    }

    public void clickCloseErrorWindow() {
        driver.findElement(By.cssSelector("a[class=ui-messages-close]"));
    }

    public List<WebElement> checkHints(String hint) {
        List<WebElement> messages = driver.findElements(By.xpath("//span[text()='" + hint + "']"));
        return messages;
    }

//    public void clickLogin(){
//        loginButton.submit();
//    }


//    public files.LoginPage loginWithIncorrectCred(String username, String password){
//        this.typeUsername(username);
//        this.typePassword(password);
//        this.clickLogin();
//        return new files.LoginPage(driver);
//    }

//    public ImportChargeTrxPage successLogin (String username, String password){
//        this.typeUsername(username);
//        this.typePassword(password);
//        try{
//            Thread.sleep(2000);
//        } catch (Exception e) {
//
//        }

//        this.clickLogin();
//        return new ImportChargeTrxPage(driver);
//    }

//    public String getErrorSummary(){
//        return errorSummary.getText();
//    }
//
//    public void getErrorDetail(){
//        iconClose.click();
//    }


}
