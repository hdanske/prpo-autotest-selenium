package prpo;

import org.junit.Assert;
import org.junit.Test;

import static files.ImportChargeTrxPage.IMPORT_CHARGE_TRX;
import static files.LoginPage.LOGIN_URL;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class FileUpload extends InitTest {

    @Test
    public void fileImport() {
        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("admin");
        loginPage.typePassword("admin0011");
        loginPage.clickLogin();

        wait.until(urlToBe(IMPORT_CHARGE_TRX));

        sideBar.chargesButtonClick();
        sideBar.importChargesButtonClick();

        importChargeTrxPage.pause(1);

        String trxId = importChargeTrxPage.getImportChargesTable().getValueFromCell(1,  3);
        System.out.println(trxId);

        importChargeTrxPage.uploadChargeClick();

        importChargeForm.chooseCspButtonClick();
        importChargeForm.chooseCSP("yprokopenko_test");
        importChargeForm.chooseFile("D:\\testing files\\upload\\testupload_with_title_positive.csv");
        importChargeForm.uploadButtonClick();
//----------------------------------Проверка загружен ли файл--------------------------------------------------------//
        importChargeTrxPage.pause(1);

        Assert.assertFalse(importChargeTrxPage.getImportChargesTable().getValueFromCell(1, 3).equals(trxId));
        Assert.assertTrue(importChargeTrxPage.getImportChargesTable().getValueFromCell(1, 7).equals("Не завершена"));
        Assert.assertTrue(importChargeTrxPage.getImportChargesTable().getValueFromCell(1,2).equals("yprokopenko_test"));

        importChargeTrxPage.refreshTable();

        importChargeTrxPage.pause(1);
        Assert.assertTrue(importChargeTrxPage.getImportChargesTable().getValueFromCell(1,7).equals("Успешно"));
    }
}
