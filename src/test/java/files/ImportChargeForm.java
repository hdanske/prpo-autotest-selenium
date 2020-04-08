package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImportChargeForm{
    private WebDriver driver;
    private By chooseCSPDropdownButton = By.cssSelector("#import-charges-form button");
    private By dropAreaForFile = By.cssSelector("input[type='file']");
    private By uploadButtonClick = By.xpath("//button//span[text()='Загрузить']");

    public ImportChargeForm(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseCspButtonClick() {
        driver.findElement(chooseCSPDropdownButton).click();
    }

    public void chooseCSP(String cspName) {
        driver.findElement(By.xpath("//li[@role='option']//span[text()='" + cspName + "']")).click();
    }

    public void chooseFile(String pathToFile) {
        driver.findElement(dropAreaForFile).sendKeys(pathToFile);
    }

    public void uploadButtonClick() {
        driver.findElement(uploadButtonClick).click();
    }
}
