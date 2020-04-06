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

public class FileUpload {
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
        WebElement button = element.get(2);
        button.click();

        WebElement importCharge = driver.findElement(By.xpath("//*[text() = 'Импорт начислений']"));
        importCharge.click();

       // wait.until(urlToBe("https://prpo-test.intervale.ru/console/import-charges"));

        WebElement upload = driver.findElement(By.xpath("//*[text() = 'Загрузить начисления']"));
        upload.click();

        WebElement regionButton = driver.findElement(By.cssSelector("#import-charges-form button"));
        regionButton.click();

        WebElement csp = driver.findElement(By.xpath("//li[@role='option']//span[text()='yprokopenko_test']"));
        csp.click();

        WebElement chooseFile = driver.findElement(By.cssSelector("input[type='file']"));
        System.out.println(chooseFile.isEnabled());

//        chooseFile.sendKeys("src/test/resources/testupload_with_title_positive.csv");
        chooseFile.sendKeys("D:\\testing files\\upload\\testupload_with_title_positive.csv");

        WebElement send = driver.findElement(By.xpath("//button//span[text()='Загрузить']"));
        send.click();

//
//        driver.findElement(By.xpath("//*[text() = 'Добавить']")).click();
//
//        driver.findElement(By.xpath(""));
//
//        WebElement dropDownCspType = driver.findElement(By.cssSelector("p-dropdown[formcontrolname='cspType']"));
//        dropDownCspType.click();
//
//        WebElement cspType = driver.findElement(By.cssSelector("li[aria-label='Индивидуальный предприниматель']"));
//        cspType.click();
//
//        WebElement regionButton = driver.findElement(By.cssSelector("p-autocomplete[formcontrolname='region'] button"));
//        regionButton.click();
//
//        WebElement region = driver.findElement(By.xpath("//li[@role='option']//span[text()='Санкт - Петербург']"));
//        region.click();
//
//        WebElement dropDownService = driver.findElement(By.cssSelector("p-dropdown[formcontrolname='servicesSector']"));
//        dropDownService.click();
//
//        WebElement serviceType = driver.findElement(By.cssSelector("li[aria-label='Электроэнергия']"));
//        serviceType.click();
//
//        driver.findElement(By.id("fullName")).sendKeys("ОАО Селениум");
//        driver.findElement(By.id("workPhone")).sendKeys("+37529990099");
//        driver.findElement(By.id("email")).sendKeys("selenium@gmail.com");
//        driver.findElement(By.id("inn")).sendKeys("123456789012");
//        driver.findElement(By.id("kpp")).sendKeys("123");
//        driver.findElement(By.id("ogrnip")).sendKeys("123456789012345");
//        driver.findElement(By.id("okved")).sendKeys("123");
//        driver.findElement(By.id("okpo")).sendKeys("123");
//        driver.findElement(By.id("okato")).sendKeys("123");
//

        /* Работает кусок
        driver.findElement(By.id("ui-tabpanel-1-label")).click();

        WebElement spinnerButton = driver.findElement(By.xpath("//*[@id=\"ui-fieldset-3-content\"]/div/p-scrollpanel/div/div[1]/div/div[1]/div[1]/p-spinner/span/button[1]"));
        spinnerButton.click();
        spinnerButton.click();
        spinnerButton.click();
        spinnerButton.click();
        spinnerButton.click();
        spinnerButton.click();

        WebElement elementFrom = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' cspChargeId ')]"));

        List<WebElement> elementsTo = driver.findElements(By.xpath("//div[@class='field field-external']"));
        WebElement elementTo = elementsTo.get(0);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n" + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n" + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n" + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n" + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" + "var dragEndEvent = createEvent('dragend');\n" + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n" + "var source = arguments[0];\n" + "var destination = arguments[1];\n" + "simulateHTML5DragAndDrop(source,destination);", elementFrom, elementTo);

        elementFrom = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' payerAddress ')]"));
        elementTo = elementsTo.get(1);
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n" + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n" + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n" + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n" + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" + "var dragEndEvent = createEvent('dragend');\n" + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n" + "var source = arguments[0];\n" + "var destination = arguments[1];\n" + "simulateHTML5DragAndDrop(source,destination);", elementFrom, elementTo);

        elementFrom = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' payerFullName ')]"));
        elementTo = elementsTo.get(2);
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n" + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n" + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n" + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n" + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" + "var dragEndEvent = createEvent('dragend');\n" + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n" + "var source = arguments[0];\n" + "var destination = arguments[1];\n" + "simulateHTML5DragAndDrop(source,destination);", elementFrom, elementTo);

        elementFrom = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' totalAmount ')]"));
        elementTo = elementsTo.get(3);
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n" + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n" + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n" + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n" + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" + "var dragEndEvent = createEvent('dragend');\n" + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n" + "var source = arguments[0];\n" + "var destination = arguments[1];\n" + "simulateHTML5DragAndDrop(source,destination);", elementFrom, elementTo);

        elementFrom = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' asppNumber ')]"));
        elementTo = elementsTo.get(4);
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n" + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n" + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n" + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n" + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" + "var dragEndEvent = createEvent('dragend');\n" + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n" + "var source = arguments[0];\n" + "var destination = arguments[1];\n" + "simulateHTML5DragAndDrop(source,destination);", elementFrom, elementTo);

        elementFrom = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' paidPeriod ')]"));
        elementTo = elementsTo.get(5);
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n" + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n" + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n" + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n" + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" + "var dragEndEvent = createEvent('dragend');\n" + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n" + "var source = arguments[0];\n" + "var destination = arguments[1];\n" + "simulateHTML5DragAndDrop(source,destination);", elementFrom, elementTo);

        List<WebElement> checkBox = driver.findElements(By.tagName("p-checkbox"));
        System.out.println(checkBox.size());
        checkBox.get(0).click();

        List<WebElement> elements = driver.findElements(By.xpath("//label[text()='Разделитель:']/following-sibling::input"));
        elements.get(0).sendKeys(";");
*/

    }
}
