package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImportChargeTrxPage extends BaseEntity{
    public static String IMPORT_CHARGE_TRX = "https://prpo-dev.intervale.ru/console/import-charges-trx";

    private WebDriver driver;
    private Table importChargesTable;

    public ImportChargeTrxPage(WebDriver driver) {
        this.driver = driver;
        importChargesTable = new Table();
    }

    private By colId = By.xpath("//th[contains(text(),'ID')]");
    private By textTrxIdFilter = By.cssSelector("[data-cy-iv-table-filter-text]");
    private By tableSettings = By.cssSelector("[ptooltip=\"Обновить таблицу\"]");
    private By clearAllFilter = By.linkText("Сбросить все фильтры");
    private By sortBystartedAt = By.xpath("//th[contains(text(),' Начало (время системы) ')]");
    private By fieldsortByEndTime = By.xpath("//th[contains(text(),' Окончание (время системы) ')]");
    private By fieldsortByOperation = By.xpath("//th[contains(text(),' Операция ')]");
    private By fieldSortByCspName = By.xpath("//th[contains(text(),' Наименование ПКУ ')]");
    private By fieldSortByRegion = By.xpath("//th[contains(text(),' Регион ')]");
    private By fieldSortByCount = By.xpath("//th[contains(text(),' Колличество загруженных начислений ')]");
    private By fieldSortByFileName = By.xpath("//th[contains(text(),' Наименование файла ')]");
    private By fieldSortByService = By.xpath("//th[contains(text(),' Услуга ')]");
    private By fieldSortStatus = By.xpath("//th[contains(text(),' Состояние ')]");
    private By fieldSortStatusDescriprion = By.xpath("//th[contains(text(),' Описание состояния ')]");
    private By refreshTableButton = By.xpath("//button[@ptooltip=\"Обновить таблицу\"]");

    private By uploadChargesButton = By.xpath("//*[text() = 'Загрузить начисления']");
    private By tableHeader = By.xpath("//table[@class='ui-table-scrollable-header-table']");
    private By tableValye = By.xpath("//div[@class='ui-table-scrollable-body']/table");

    public void sortByTrxId(){
        driver.findElement(colId).click();
    }

    public void sortByStartedAt(){
        driver.findElement(sortBystartedAt).click();
    }

    public void sortByEndTime(){
        driver.findElement(fieldsortByEndTime).click();
    }

    public void sortByOperationId(){
        driver.findElement(fieldsortByOperation).click();
    }

    public void sortByCSPName(){
        driver.findElement(fieldSortByCspName).click();
    }

    public void sortByRegion(){
        driver.findElement(fieldSortByRegion).click();
    }

    public void sortByCount(){
        driver.findElement(fieldSortByCount).click();
    }

    public void sortByFileName(){
        driver.findElement(fieldSortByFileName).click();
    }

    public void sortByService(){
        driver.findElement(fieldSortByService).click();
    }

    public void sortByStatus(){
        driver.findElement(fieldSortStatus).click();
    }

    public void sortByStatusDescription(){
        driver.findElement(fieldSortStatusDescriprion).click();
    }

    public Table getImportChargesTable(){
//        WebElement table = driver.findElement(tableValye);
//        WebElement header =  driver.findElement(tableHeader);
        importChargesTable.setTableElement(driver.findElement(tableValye));
        importChargesTable.setTableHeaderElement(driver.findElement(tableHeader));
        importChargesTable.setDriver(this.driver);
//        return new Table(table, header, driver);
        return importChargesTable;
    }

    public void typeTrxId(String trxId){
        driver.findElement(textTrxIdFilter).click();
        driver.findElement(textTrxIdFilter).sendKeys(trxId);
    }

    public void resetTable(){
        driver.findElement(tableSettings).click();
        driver.findElement(clearAllFilter).click();
    }

    public void uploadChargeClick() {
        driver.findElement(uploadChargesButton).click();
    }

    public void refreshTable() {
        driver.findElement(tableSettings).click();
    }
}
