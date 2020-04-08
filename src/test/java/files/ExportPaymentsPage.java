package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExportPaymentsPage extends BaseEntity{
    private WebDriver driver;
    private Table exportPaymentsTable;

    private By tableHeader = By.xpath("//table[@class='ui-table-scrollable-header-table']");
    private By tableValye = By.xpath("//div[@class='ui-table-scrollable-body']/table");
    private By downloadFileButton = By.xpath("//*[text() = 'Скачать файл платежей']");
    private By tableSettings = By.cssSelector("[ptooltip=\"Обновить таблицу\"]");


    public ExportPaymentsPage(WebDriver driver) {
        this.driver = driver;
        exportPaymentsTable = new Table();
    }

    public Table getExportPaymentsTable() {
        exportPaymentsTable.setTableElement(driver.findElement(tableValye));
        exportPaymentsTable.setTableHeaderElement(driver.findElement(tableHeader));
        exportPaymentsTable.setDriver(this.driver);

        return exportPaymentsTable;
    }


    public void downloadFileButtonClick() {
        driver.findElement(downloadFileButton).click();
    }

    public void refreshTable() {
        driver.findElement(tableSettings).click();
    }
}
