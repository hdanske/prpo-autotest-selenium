package training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.login.Configuration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MyFirstTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        //driver = new InternetExplorerDriver();


//        DesiredCapabilities caps = new DesiredCapabilities();
//        InternetExplorerOptions options = new InternetExplorerOptions();
//        caps.setCapability("strictFileInteractability",true);
//        options.merge(caps);
//        driver = new InternetExplorerDriver(options);



        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("strictFileInteractability", true);
        //driver = new InternetExplorerDriver(caps);

        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        System.out.println(((HasCapabilities)driver).getCapabilities());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 40);
    }

    @Test
    public void myFirstTest() {
        driver.get("http://www.google.com/");
        //driver.navigate().to("http://www.google.ru");
        driver.findElement(By.name("q")).sendKeys("web");
        driver.findElement(By.name("q")).sendKeys(Keys.ESCAPE);
        //wait.until(visibilityOf(driver.findElement(By.name("btnK"))));
        //WebElement el = driver.findElement(By.name("btnK"));
        driver.findElement(By.name("btnK")).click();
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click();", el);

        //driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);

        //wait.until(ExpectedConditions.elementToBeClickable(el));
        //el.click();
        wait.until(titleIs("web - Поиск в Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
