package prpo;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class FileDownload {
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
    public void cspCreate() {
        driver.get("https://prpo-test.intervale.ru/console/");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin0011");
        driver.findElement(By.tagName("button")).click();
        wait.until(urlToBe("https://prpo-test.intervale.ru/console/import-charges-trx"));

        driver.getCurrentUrl();
        List<WebElement> element = driver.findElements(By.cssSelector("a.tabmenuitem-link"));
        WebElement button = element.get(3);
        button.click();

        WebElement download = driver.findElement(By.xpath("//*[text() = 'Экспорт платежей']"));
        download.click();

        WebElement downloadButton = driver.findElement(By.xpath("//*[text() = 'Скачать файл платежей']"));
        downloadButton.click();

        WebElement drop = driver.findElement(By.cssSelector("#export-payments-form p-dropdown"));
        drop.click();

        WebElement lastHour = driver.findElement(By.xpath("//li[@role='option']//span[text()='Последний час']"));
        lastHour.click();

        WebElement webEl = driver.findElement(By.cssSelector("app-csp-select-control[formcontrolname='csp'] button"));
        webEl.click();

        WebElement csp = driver.findElement(By.xpath("//li[@role='option']//span[text()='yprokopenko_test']"));
        csp.click();

        WebElement dwn = driver.findElement(By.cssSelector("button[label='Скачать']"));
        dwn.click();



    }

}
