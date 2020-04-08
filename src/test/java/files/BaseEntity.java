package files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BaseEntity {
    public void pause(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e){

        }
    }

    public static void rigtClick(WebDriver driver, WebElement link ) {//throws InterruptedException {
        Actions action = new Actions(driver);
        action.contextClick(link).perform();
    }
}
