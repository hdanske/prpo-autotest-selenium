package prpo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class CspCreate {
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
        WebElement button = element.get(6);
        button.click();

        WebElement cspButton = driver.findElement(By.xpath("//*[text() = 'Поставщики коммерческих услуг']"));
        cspButton.click();

        driver.findElement(By.xpath("//*[text() = 'Добавить']")).click();

        driver.findElement(By.id("ui-tabpanel-1-label")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-fieldset-3-content\"]/div/p-scrollpanel/div/div[1]/div/div[1]/div[1]/p-spinner/span/button[1]")).click();

//        List<WebElement> elements = driver.findElements(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\"]"));
//        WebElement el = elements;
        WebElement elementFrom = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' cspChargeId ')]"));
//        System.out.println(elements.size());

        WebElement elementsTo = driver.findElement(By.xpath("//div[@class='field field-external']"));
//        System.out.println(elementsTo.size());

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);", elementFrom, elementsTo);

//        driver.findElement(By.id("username")).sendKeys("admin");
//        driver.findElement(By.id("password")).sendKeys("admin0011");
//        driver.findElement(By.tagName("button")).click();
//        wait.until(urlToBe("https://prpo-test.intervale.ru/console/import-charges-trx"));
//        String URL = driver.getCurrentUrl();
//        Assert.assertEquals(URL,"https://prpo-test.intervale.ru/console/import-charges-trx");
    }

//    @After
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }
}
