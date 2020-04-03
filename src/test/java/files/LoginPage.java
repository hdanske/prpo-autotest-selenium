package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //    @FindBy(id = "username")
//    private WebElement usernameField;
    private By usernameField = By.id("username");

    //    @FindBy(id = "password")
//    private WebElement passwordField;
    private By passwordField = By.id("password");

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

    public LoginPage typeUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

//    public files.LoginPage typeUsername(String username){
//        usernameField.sendKeys(username);
//        return this;
//    }

    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

//    public files.LoginPage typePassword(String password) {
//        passwordField.sendKeys(password);
//        return this;
//    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
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
