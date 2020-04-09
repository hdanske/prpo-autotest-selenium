package prpo;

import org.junit.Assert;
import org.junit.Test;

import static files.ImportChargeTrxPage.IMPORT_CHARGE_TRX;
import static files.LoginPage.LOGIN_URL;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class RegionTest extends InitTest{

    @Test
    public void test01_createRegion () {
        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("admin");
        loginPage.typePassword("admin0011");
        loginPage.clickLogin();

        wait.until(urlToBe(IMPORT_CHARGE_TRX));

        sideBar.administrationButtonClick();
        sideBar.regionManageButtonClick();

        regionPage.addRegionClick();
        Assert.assertTrue(regionForm.regionFormIsPresent());

        regionForm.clickSaveRegion();
        Assert.assertTrue(regionForm.errorMessages("Данное поле обязательно").size() == 2);
        regionForm.clickCancel();

        regionPage.pause(1);
        Assert.assertFalse(regionForm.regionFormIsPresent());

        regionForm.typeCode("a");
        Assert.assertTrue(regionForm.errorMessages("Допустим ввод только числовых символов").size() == 1);

        regionForm.typeCode("49");
        regionForm.typeRegion("Магадан");

        regionForm.clickSaveRegion();

        regionPage.typeRegionInFilter("Магадан");

        regionPage.pause(2);
        Assert.assertTrue(regionPage.getCspTable().getValueFromCell(1, 2).equals("Магадан"));




    }

    @Test
    public void test02_editRegion () {

    }

    @Test void test03_deleteRegion () {

    }

}
