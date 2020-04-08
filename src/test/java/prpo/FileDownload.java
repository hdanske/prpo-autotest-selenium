package prpo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static files.ImportChargeTrxPage.IMPORT_CHARGE_TRX;
import static files.LoginPage.LOGIN_URL;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class FileDownload extends InitTest {

    @Test
    public void downloadPaymentFile() {
        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("admin");
        loginPage.typePassword("admin0011");
        loginPage.clickLogin();

        wait.until(urlToBe(IMPORT_CHARGE_TRX));

        sideBar.paymentsButtonClick();
        sideBar.exportPaymentsButtonClick();

        exportPaymentsPage.pause(1);
        String trxId = exportPaymentsPage.getExportPaymentsTable().getValueFromCell(1,  3);
        System.out.println(trxId);

        exportPaymentsPage.downloadFileButtonClick();

        exportPaymentForm.choosePeriod("Последний час");
        exportPaymentForm.chooseTypeFile("CSV");
        exportPaymentForm.chooseCSPButtonClick();
        exportPaymentForm.chooseCSP("yprokopenko_test");
        exportPaymentForm.downloadClick();
//------------------------Проверка на выгрузку файла-------------------//

        exportPaymentsPage.pause(2);

        Assert.assertFalse(exportPaymentsPage.getExportPaymentsTable().getValueFromCell(1, 3).equals(trxId));
        //Assert.assertTrue(exportPaymentsPage.getExportPaymentsTable().getValueFromCell(1, 6).equals("Не завершена"));
        Assert.assertTrue(exportPaymentsPage.getExportPaymentsTable().getValueFromCell(1,2).equals("yprokopenko_test"));

        exportPaymentsPage.refreshTable();

        exportPaymentsPage.pause(1);
        Assert.assertTrue(exportPaymentsPage.getExportPaymentsTable().getValueFromCell(1,6).equals("Успешно"));
    }
}
