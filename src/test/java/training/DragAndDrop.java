package training;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import prpo.InitTest;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DragAndDrop extends InitTest {
    @Test
    public void dragAndDrop() throws AWTException, InterruptedException, IOException {
        driver.get("http://www.seleniumeasy.com/test/drag-and-drop-demo.html");
//        driver.get("https://jqueryui.com/resources/demos/sortable/connect-lists.html");

//        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
//        driver.get("https://demoqa.com/droppable/");
//        driver.get("https://react-beautiful-dnd.netlify.com/iframe.html?selectedKind=single%20vertical%20list&selectedStory=basic");
//        Actions act = new Actions(driver);
//        WebElement elementFrom = driver.findElement(By.xpath("//span[text()='Draggable 3']"));
//        WebElement source = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
//        WebElement target = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
//        WebElement elementTo = driver.findElement(By.xpath("//*[@id=\"mydropzone\"]"));
//
//
//        act.clickAndHold(elementFrom).moveByOffset(10, 0).moveToElement(elementTo, 10, 0).release().build().perform();
        WebElement elements1 = driver.findElement(By.xpath("//span[text()='Draggable 1']"));
        WebElement elements2 = driver.findElement(By.xpath("//*[@id=\"mydropzone\"]"));
//        WebElement elements1 = driver.findElement(By.xpath("//*[@id=\"sortable1\"]/li[1]"));
//        WebElement elements2 = driver.findElement(By.xpath("//*[@id=\"sortable2\"]/li[2]"));

        String filePath = "D:\\projects\\prpo-autotest-selenium\\src\\test\\java\\prpo\\simulateDragDrop.js";
        StringBuffer buffer = new StringBuffer();

        String line;
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null){
            buffer.append(line);
            buffer.append("\n");
        }

        String javaScript = buffer.toString();

        System.out.println(javaScript);
        JavascriptExecutor js = (JavascriptExecutor) driver;



//        js.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" + "simulateHTML5DragAndDrop(arguments[0],arguments[1])", elements1, elements2);
        js.executeScript( javaScript + "simulateDragDrop(arguments[0], arguments[1])", elements1, elements2);

    }

//    @After
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }
}
