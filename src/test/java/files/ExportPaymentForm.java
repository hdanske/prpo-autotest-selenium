package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExportPaymentForm {
    private By choosePeriodDropdown = By.cssSelector("#export-payments-form p-dropdown");
    private By chooseCsp = By.cssSelector("app-csp-select-control[formcontrolname='csp'] button");
    private By chooseTypeFile = By.xpath("//p-dropdown[@formcontrolname='fileType']");
    private By downloadFile = By.cssSelector("button[label='Скачать']");

    private WebDriver driver;

    public ExportPaymentForm(WebDriver driver) {
        this.driver = driver;
    }


    public void choosePeriod(String period) {
        driver.findElement(choosePeriodDropdown).click();
        driver.findElement(By.xpath("//li[@role='option']//span[text()='" + period + "']")).click();
    }

    public void chooseCSP(String cspName) {
        driver.findElement(By.xpath("//li[@role='option']//span[text()='" + cspName + "']")).click();
    }

    public void chooseCSPButtonClick() {
        driver.findElement(chooseCsp).click();
    }

    public void chooseTypeFile(String type) {
        driver.findElement(chooseTypeFile).click();
        driver.findElement(By.xpath("//li[@role='option']//span[text()='" + type + "']")).click();
    }

    public void downloadClick() {
        driver.findElement(downloadFile).click();
    }
}
