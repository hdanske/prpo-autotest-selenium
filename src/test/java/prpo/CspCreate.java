package prpo;

import files.CspPage;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static files.ImportChargeTrxPage.IMPORT_CHARGE_TRX;
import static files.LoginPage.LOGIN_URL;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class CspCreate extends InitTest {

    @Test
    public void cspCreate() throws IOException {

        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("admin");
        loginPage.typePassword("admin0011");
        loginPage.clickLogin();

        wait.until(urlToBe(IMPORT_CHARGE_TRX));

        sideBar.administrationButtonClick();
        sideBar.cspManageButtonClick();

        cspPage.addCspClick();

        WebElement dropDownCspType = driver.findElement(By.cssSelector("p-dropdown[formcontrolname='cspType']"));
        dropDownCspType.click();

        WebElement cspType = driver.findElement(By.cssSelector("li[aria-label='Индивидуальный предприниматель']"));
        cspType.click();

        WebElement regionButton = driver.findElement(By.cssSelector("p-autocomplete[formcontrolname='region'] button"));
        regionButton.click();

        WebElement region = driver.findElement(By.xpath("//li[@role='option']//span[text()='Санкт - Петербург']"));
        region.click();

        WebElement dropDownService = driver.findElement(By.cssSelector("p-dropdown[formcontrolname='servicesSector']"));
        dropDownService.click();

        WebElement serviceType = driver.findElement(By.cssSelector("li[aria-label='Электроэнергия']"));
        serviceType.click();

        driver.findElement(By.id("fullName")).sendKeys("ОАО Селениум");
        driver.findElement(By.id("workPhone")).sendKeys("+37529990099");
        driver.findElement(By.id("email")).sendKeys("selenium@gmail.com");
        driver.findElement(By.id("inn")).sendKeys("123456789012");
        driver.findElement(By.id("kpp")).sendKeys("123");
        driver.findElement(By.id("ogrnip")).sendKeys("123456789012345");
        driver.findElement(By.id("okved")).sendKeys("123");
        driver.findElement(By.id("okpo")).sendKeys("123");
        driver.findElement(By.id("okato")).sendKeys("123");

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

        dragAndDrop(elementFrom, elementTo);

        elementFrom = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' payerAddress ')]"));
        elementTo = elementsTo.get(1);

        dragAndDrop(elementFrom, elementTo);

        elementFrom = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' payerFullName ')]"));
        elementTo = elementsTo.get(2);

        dragAndDrop(elementFrom, elementTo);

        elementFrom = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' totalAmount ')]"));
        elementTo = elementsTo.get(3);

        dragAndDrop(elementFrom, elementTo);

        elementFrom = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' asppNumber ')]"));
        elementTo = elementsTo.get(4);

        dragAndDrop(elementFrom, elementTo);

        elementFrom = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' paidPeriod ')]"));
        elementTo = elementsTo.get(5);

        dragAndDrop(elementFrom, elementTo);
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n" + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n" + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n" + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n" + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" + "var dragEndEvent = createEvent('dragend');\n" + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n" + "var source = arguments[0];\n" + "var destination = arguments[1];\n" + "simulateHTML5DragAndDrop(source,destination);", elementFrom, elementTo);

        List<WebElement> checkBox = driver.findElements(By.tagName("p-checkbox"));
        System.out.println(checkBox.size());
        checkBox.get(0).click();

        List<WebElement> elements = driver.findElements(By.xpath("//label[text()='Разделитель:']/following-sibling::input"));
        elements.get(0).sendKeys(";");

// -----------------------------Факты оплат------------------------------------------------------------------------------//
        driver.findElement(By.id("ui-tabpanel-2-label")).click();

        spinnerButton = driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-2\"]//p-spinner//button"));
        spinnerButton.click();
        spinnerButton.click();
        spinnerButton.click();

        elementFrom = driver.findElement(By.xpath("//div[@class='field field-internal' and contains(.,' Индекс ОПС ')]"));

        elementsTo = driver.findElements(By.xpath("//div[@class='field field-external']"));
        System.out.println(elementsTo.size());

        elementTo = elementsTo.get(6);

        dragAndDrop(elementFrom, elementTo);

        elementFrom = driver.findElement(By.xpath("//div[@class='field field-internal' and contains(.,' Оплачено ')]"));
        elementTo = elementsTo.get(7);

        dragAndDrop(elementFrom, elementTo);

        elementFrom = driver.findElement(By.xpath("//div[@class='field field-internal' and contains(.,' Оплаченная коммиссия ')]"));
        elementTo = elementsTo.get(8);

        dragAndDrop(elementFrom, elementTo);

        checkBox = driver.findElements(By.cssSelector("#ui-tabpanel-2 p-checkbox"));
        checkBox.get(0).click();

        elements = driver.findElements(By.xpath("//div[@id=\"ui-tabpanel-2\"]//label[text()='Разделитель:']/following-sibling::input"));
        elements.get(0).sendKeys(";");

        WebElement submit = driver.findElement(By.id("csp-submit"));
        submit.click();


    }

    public static void dragAndDrop(WebElement elementFrom, WebElement elementTo) throws IOException {
        String filePath = "src/test/resources/simulateDragDrop.js";
        StringBuffer buffer = new StringBuffer();

        String line;
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {
            buffer.append(line);
            buffer.append("\n");
        }

        String javaScript = buffer.toString();

        js.executeScript(javaScript + "simulateDragDrop(arguments[0], arguments[1])", elementFrom, elementTo);
    }
}
