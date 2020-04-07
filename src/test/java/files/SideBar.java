package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SideBar{
    private WebDriver driver;
    private By sideBarButtons = By.cssSelector("a.tabmenuitem-link");
    private By cspManageButton = By.xpath("//*[text() = 'Поставщики коммерческих услуг']");

    private WebElement administrationButton;

    public SideBar(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllSideBarButtons (){
        List<WebElement> buttons = driver.findElements(sideBarButtons);
        return buttons;
    }
    public WebElement getAdministrationButton() {
        getAllSideBarButtons().get(6);
        return administrationButton;
    }

    public void administrationButtonClick(){
        List<WebElement> buttons = driver.findElements(sideBarButtons);
        buttons.get(6).click();
    }

    public void cspManageButtonClick(){
        driver.findElement(cspManageButton).click();
    }





}
