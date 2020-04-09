package files;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegionForm extends BaseEntity {
    private WebDriver driver;

    private By regionForm = By.cssSelector("div[role='dialog']");
    private By saveButton = By.cssSelector("button[type='submit']");
    private By inputErrorMessage = By.cssSelector("span.ui-message.ui-messages-error span");
    private By cancelButton = By.cssSelector("button[label='Отмена']");
    private By code = By.id("code");
    private By name = By.id("name");

    public RegionForm(WebDriver driver) {
        this.driver = driver;
    }

    public void typeCode(String codeRegion){
        driver.findElement(code).clear();
        driver.findElement(code).sendKeys(codeRegion);
    }

    public void typeRegion(String nameRegion){
        driver.findElement(code).clear();
        driver.findElement(name).sendKeys(nameRegion);
    }

    public boolean regionFormIsPresent() {
        try {
            driver.findElement(regionForm);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickSaveRegion() {
        driver.findElement(saveButton).click();
    }

    public List<WebElement> errorMessages(String errorMessage) {
        List<WebElement> elements = driver.findElements(inputErrorMessage);
        for (WebElement el:
                elements) {
            if (!(el.getText().equals(errorMessage))) elements.remove(el);
        }
        return elements;
    }

    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }
}
