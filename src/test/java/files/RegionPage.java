package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegionPage extends BaseEntity {
    public static String CSP_URL = "https://prpo-test.intervale.ru/console/regions";

    private WebDriver driver;
    private Table cspTable;

    private By addButton = By.xpath("//button/span[contains(text(), 'Добавить')]");
    private By filterRegionName = By.xpath("//table[@class='ui-table-scrollable-header-table']//th[2]//input");
    //private By tableValye = ;
    //private By tableHeader = ;

    public RegionPage(WebDriver driver) {
        this.driver = driver;
        cspTable = new Table();
    }

    public void addRegionClick() {
        driver.findElement(addButton).click();
    }

    public void typeRegionInFilter(String regionMessage){
        driver.findElement(filterRegionName).clear();
        driver.findElement(filterRegionName).sendKeys(regionMessage);
    }

/*    public Table getCspTable() {
        WebElement table = driver.findElement(tableValye);
        WebElement header = driver.findElement(tableHeader);
        return new Table(table, header, driver);
    }*/
}
