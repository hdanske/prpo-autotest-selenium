package prpo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 40);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void login() {
        driver.get("https://prpo-test.intervale.ru/console/");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin0011");
        driver.findElement(By.tagName("button")).click();
        wait.until(urlToBe("https://prpo-test.intervale.ru/console/import-charges-trx"));
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL,"https://prpo-test.intervale.ru/console/import-charges-trx");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
