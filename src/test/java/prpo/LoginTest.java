package prpo;

import files.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static files.LoginPage.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 40);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void unSuccessLogin() {

        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("a");
        loginPage.typePassword("a");
        loginPage.clickLogin();
        loginPage.checkMessage("Login failed");
        loginPage.checkMessage("Неправильные логин или пароль");

        WebElement xButton = driver.findElement(By.xpath("//p-messages//a"));
        xButton.click();

        driver.findElement(By.id("username")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.id("password")).sendKeys(Keys.BACK_SPACE);

        List<WebElement> messages = driver.findElements(By.xpath("//span[text()='Данное поле обязательно']"));
        Assert.assertTrue(messages.size() == 2);

        WebElement loginButton = driver.findElement(By.tagName("button"));
        Assert.assertFalse(isClickable(driver, loginButton));





//        loginPage.clickCloseErrorWindow();
//        loginPage.clearField(USERNAME);
//        loginPage.checkMessage("Данное поле обязательно");
//        loginPage.clearField(PASSWORD);


//        wait.until(urlToBe("https://prpo-test.intervale.ru/console/import-charges-trx"));
//        String URL = driver.getCurrentUrl();
//        Assert.assertEquals(URL,"https://prpo-test.intervale.ru/console/import-charges-trx");
    }

    public static boolean isClickable(WebDriver driver, WebElement element)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }


//    @After
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }
}
