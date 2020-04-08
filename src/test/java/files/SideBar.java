package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SideBar {
    private WebDriver driver;
    private By sideBarButtons = By.cssSelector("a.tabmenuitem-link");
    private By cspManageButton = By.xpath("//*[text() = 'Поставщики коммерческих услуг']");
    private By importChargesButton = By.xpath("//*[text() = 'Импорт начислений']");
    private By exportPayment = By.xpath("//*[text() = 'Экспорт платежей']");

    private WebElement administrationButton;

    public SideBar(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllSideBarButtons() {
        List<WebElement> buttons = driver.findElements(sideBarButtons);
        return buttons;
    }

    public WebElement getAdministrationButton() {
        getAllSideBarButtons().get(6);
        return administrationButton;
    }

    public void administrationButtonClick() {
        List<WebElement> buttons = driver.findElements(sideBarButtons);
        buttons.get(6).click();
    }

    public void chargesButtonClick() {
        List<WebElement> buttons = driver.findElements(sideBarButtons);
        buttons.get(2).click();
    }

    public void paymentsButtonClick() {
        List<WebElement> buttons = driver.findElements(sideBarButtons);
        buttons.get(3).click();
    }

    public void exportPaymentsButtonClick() {
        driver.findElement(exportPayment).click();
    }


    public void importChargesButtonClick() {
        driver.findElement(importChargesButton).click();
    }

    public void cspManageButtonClick() {
        driver.findElement(cspManageButton).click();
    }


}
