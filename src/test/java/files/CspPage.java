package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CspPage extends BaseEntity {
    private WebDriver driver;
    private Table cspTable;
    public static String CSP_URL = "https://prpo-test.intervale.ru/console/csp";

    public CspPage(WebDriver driver) {
        this.driver = driver;
        cspTable = new Table();
    }

    private By addButton = By.xpath("//button/span[contains(text(), 'Добавить')]");
    private By editButton = By.xpath("//button/span[contains(text(), 'Редактировать')]");

    private By lineAfterFilter = By.xpath("//tr[@class='ui-cut-overflow ng-star-inserted ui-state-highlight']");
    //    private By lineAfterFilter = By.xpath("//span[contains(text(),'AutotestCSP_noTitle')]");
    private By lineAfterFilter2 = By.xpath("//tr[@class='ui-cut-overflow ng-star-inserted']");

//    private By filterFieldSchortName = By.xpath("//th[1]//div[1]//div[1]//input[1]");
    private By filterFieldSchortName = By.xpath("//table[@class='ui-treetable-scrollable-header-table']//th[1]//input");

    private By sortByFieldName = By.xpath("//th[contains(text(), ' Сокращенное наименование ')]");
    private By buttonDelete = By.xpath("//button//span[contains(text(), 'Удалить')]");
    private By buttonConfirmDelete = By.xpath("//button/span[contains(text(),'Да')]");
    private By topPannel = By.xpath("//div[@class='card card-w-title']");

    private By tableHeader = By.xpath("//table[@class='ui-treetable-scrollable-header-table']");
    private By tableValye = By.xpath("//div[@class='ui-treetable-scrollable-body']/table");

    private By tableSettings = By.cssSelector("[ptooltip=\"Настройки таблицы\"]");
    private By clearAllFilter = By.linkText("Сбросить все фильтры");
    private By resetTableButton = By.xpath("//span[@class='ui-menuitem-icon pi pi-fw pi-refresh ng-star-inserted']");

    public WebElement getLine(int numberLine) {
        String xpathLine = String.format("//tr[@class='ui-cut-overflow ng-star-inserted'][%d]", numberLine);
        By cspLine = By.xpath(xpathLine);
        return driver.findElement(cspLine);
    }

    public WebElement deleteCspButton() {
        return driver.findElement(buttonDelete);
    }

    public WebElement confirmDeleteButton() {
        By confirmButton = By.xpath("//button//*[contains(text(), 'Да')]");
//        driver.findElement(confirmButton).doubleCl
        return driver.findElement(confirmButton);
    }


//    private By tableSettings = By.cssSelector("[ptooltip=\"Настройки таблицы\"]");
//    private By clearAllFilter = By.linkText("Сбросить все фильтры");


//    private By fieldsortByOperation = By.xpath("//th[contains(text(),' Операция ')]");
//    private By fieldSortByCspName = By.xpath("//th[contains(text(),' Наименование ПКУ ')]");
//    private By fieldSortByRegion = By.xpath("//th[contains(text(),' Регион ')]");
//    private By fieldSortByCount = By.xpath("//th[contains(text(),' Колличество загруженных начислений ')]");
//    private By fieldSortByFileName = By.xpath("//th[contains(text(),' Наименование файла ')]");
//    private By fieldSortByService = By.xpath("//th[contains(text(),' Услуга ')]");
//    private By fieldSortStatus = By.xpath("//th[contains(text(),' Состояние ')]");
//    private By fieldSortStatusDescriprion = By.xpath("//th[contains(text(),' Описание состояния ')]");

    public void addCspClick() {
        driver.findElement(addButton).click();
    }

    public void typeCspNameInFilter(String name) {
        driver.findElement(filterFieldSchortName).sendKeys(name);
    }

    public void clickElement() {
        driver.findElement(lineAfterFilter2).click();
//        pause(5);
//        driver.findElement(sortByFieldName).click();
//        System.out.println(driver.findElement(lineAfterFilter).getText());
//        System.out.println(driver.findElement(lineAfterFilter).isEnabled());
//        System.out.println(driver.findElement(lineAfterFilter).isSelected());
//        pause(5);
//        driver.findElement(lineAfterFilter).click();
//        pause(3);
//        driver.findElement(buttonDelete).click();
//        pause(3);
//        driver.findElement(buttonConfirmDelete).click();
//        driver.findElement(topPannel).click();
//        driver.findElement(topPannel).getText();

    }

    public void selectOneElement() {

    }

    public CspAddForm openNewCSPForm() {
        driver.findElement(addButton).click();
        return new CspAddForm(driver);
    }


    public Table getCspTable() {
        WebElement table = driver.findElement(tableValye);
        WebElement header = driver.findElement(tableHeader);
        return new Table(table, header, driver);
    }

    public void clearAllFilter() {
        driver.findElement(tableSettings).click();
        driver.findElement(clearAllFilter).click();
    }

    public void resetTable() {
//        rigtClick(driver, this.getLine(1));
//        driver.findElement(resetTableButton).click();
    }

    public CspPage goTo(String url) {
        driver.get(url);
        return this;
    }

    public void editButtonClick() {
        driver.findElement(editButton).click();
    }

    public boolean mappingAlertMessage(String alertText) {
        WebElement alert = driver.findElement(By.xpath("//p-toastitem//div[text()='" + alertText + "']"));
        if (alert.isDisplayed()) return true;
        else return false;
    }


}
