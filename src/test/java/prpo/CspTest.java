package prpo;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static files.ImportChargeTrxPage.IMPORT_CHARGE_TRX;
import static files.LoginPage.LOGIN_URL;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CspTest extends InitTest {


    @Test
    public void test01_cspCreate() throws IOException {
        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("admin");
        loginPage.typePassword("admin0011");
        loginPage.clickLogin();

        wait.until(urlToBe(IMPORT_CHARGE_TRX));

        sideBar.administrationButtonClick();
        sideBar.cspManageButtonClick();

        cspPage.addCspClick();
        Assert.assertTrue(cspAddForm.addCspFormIsPresent());

        cspAddForm.clickSaveCSP();
        Assert.assertTrue(cspAddForm.errorMessages("Данное поле обязательно").size() == 13);
        cspAddForm.clickCancel();

        cspPage.pause(1);
        Assert.assertFalse(cspAddForm.addCspFormIsPresent());

        cspPage.addCspClick();
        cspAddForm.clickCspType("Индивидуальный предприниматель");
        cspAddForm.selectCspRegion("Москва");
        cspAddForm.selectServicesSector("Электроэнергия");
        cspAddForm.typeFullName("ОАО Селениум");
        cspAddForm.typeWorkPhone("+37529990099");
        cspAddForm.typeEmail("selenium@gmail.com");
        cspAddForm.typeInn("123456789012");
        cspAddForm.typeKpp("123");
        cspAddForm.typeOgrnip("123456789012345");
        cspAddForm.typeOkved("123");
        cspAddForm.typeOkpo("123");
        cspAddForm.typeOkato("123");
// -----------------------------Протокол начислений----------------------------------------------------------------------//
        cspAddForm.selectPanelChargeProtocolMapping();
        cspAddForm.clickAddChargeField(6);
        dragAndDrop(cspAddForm.getChargeField("cspChargeId"), cspAddForm.getfieldToMapp(0));
        dragAndDrop(cspAddForm.getChargeField("payerAddress"), cspAddForm.getfieldToMapp(1));
        dragAndDrop(cspAddForm.getChargeField("payerFullName"), cspAddForm.getfieldToMapp(2));
        dragAndDrop(cspAddForm.getChargeField("totalAmount"), cspAddForm.getfieldToMapp(3));
        dragAndDrop(cspAddForm.getChargeField("asppNumber"), cspAddForm.getfieldToMapp(4));
        dragAndDrop(cspAddForm.getChargeField("paidPeriod"), cspAddForm.getfieldToMapp(5));
        dragAndDrop(cspAddForm.getChargeField("payerFullName"), cspAddForm.getNarrowField());

        cspAddForm.separatorCheckBoxOnCharges();
        cspAddForm.typeSeparatorCharge(";");
// -----------------------------Факты оплат------------------------------------------------------------------------------//
        cspAddForm.selectPanelPanelExportMapping();
        cspAddForm.clickAddPaymentField(3);
        dragAndDrop(cspAddForm.getPaymentField("Индекс ОПС"), cspAddForm.getfieldToMapp(6));
        dragAndDrop(cspAddForm.getPaymentField("Оплачено"), cspAddForm.getfieldToMapp(7));
        dragAndDrop(cspAddForm.getPaymentField("Оплаченная коммиссия"), cspAddForm.getfieldToMapp(8));
        cspAddForm.separatorCheckBoxOnPayment();
        cspAddForm.typeSeparatorPayment(";");
//-----------------------------Сохранение ПКУ----------------------------------------------------------------------------//
        cspAddForm.clickSaveCSP();
        Assert.assertTrue(cspPage.mappingAlertMessage("Регистрация ПКУ прошла успешно"));
//-----------------------------Поиск Созданного ПКУ----------------------------------------------------------------------//
        cspPage.typeCspNameInFilter("Селениум");

        cspPage.pause(2);
        Assert.assertTrue(cspPage.getCspTable().getValueFromCell(1, 1).equals("ОАО Селениум"));
    }


//    span.ui-message.ui-messages-error span

    @Test
    public void test02_cspEmptyCreate() throws IOException {
        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("admin");
        loginPage.typePassword("admin0011");
        loginPage.clickLogin();

        wait.until(urlToBe(IMPORT_CHARGE_TRX));

        sideBar.administrationButtonClick();
        sideBar.cspManageButtonClick();

        cspPage.pause(2);
        cspPage.typeCspNameInFilter("Селениум");

        cspPage.pause(2);
        cspPage.getCspTable().getRows().get(0).click();

        cspPage.сopyMapping();

        cspPage.addCspClick();
        cspAddForm.clickCspType("Юридическое лицо - нерезидент РФ");
        cspAddForm.selectCspRegion("Алтайский край");
        cspAddForm.selectServicesSector("Электроэнергия");
        cspAddForm.selectCspOwner("ОАО Селениум");
        cspAddForm.typeFullName("ООО Селениум Филиал");
        cspAddForm.typeWorkPhone("+222222222222");
        cspAddForm.typeEmail("selenium@yandex.ru");
        cspAddForm.typeLegalAddres("г. Барнаул, ул. Советская 3");
        cspAddForm.typeInn("8901252345");
        cspAddForm.typeKpp("311");
        cspAddForm.typeOgrn("0012345123456");
        cspAddForm.typeOkved("056");
        cspAddForm.typeOkpo("089");
        cspAddForm.typeOkato("900");
// -----------------------------Протокол начислений----------------------------------------------------------------------//
        cspAddForm.selectPanelChargeProtocolMapping();
        cspAddForm.separatorCheckBoxOnCharges();
        cspAddForm.typeSeparatorCharge(";");
        cspAddForm.insertMappingChargesCSV();
// -----------------------------Факты оплат------------------------------------------------------------------------------//
        cspAddForm.selectPanelPanelExportMapping();
        cspAddForm.separatorCheckBoxOnPayment();
        cspAddForm.typeSeparatorPayment(";");
        cspAddForm.insertMappingPaymentsCSV();
//-----------------------------Сохранение ПКУ----------------------------------------------------------------------------//
        cspAddForm.clickSaveCSP();
//-----------------------------Поиск Созданного ПКУ----------------------------------------------------------------------//
        cspPage.typeCspNameInFilter("Селениум Филиал");

        cspPage.pause(1);
        Assert.assertTrue(cspPage.getCspTable().getValueFromCell(1, 1).equals("ООО Селениум Филиал"));
    }


    @Test
    public void test03_cspEdit() throws IOException {
        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("admin");
        loginPage.typePassword("admin0011");
        loginPage.clickLogin();

        wait.until(urlToBe(IMPORT_CHARGE_TRX));

        sideBar.administrationButtonClick();
        sideBar.cspManageButtonClick();

        cspPage.pause(2);
        cspPage.typeCspNameInFilter("Селениум");

        cspPage.pause(2);
        cspPage.getCspTable().getRows().get(0).click();

        cspPage.editButtonClick();

        cspAddForm.clickCspType("Юридическое лицо");
        cspAddForm.selectCspRegion("Алтайский край");
        cspAddForm.selectServicesSector("Детский сад");
        cspAddForm.typeFullName("ООО Вебдрайвер");
        cspAddForm.typeShortName("ООО Вебдрайвер");
        cspAddForm.typeWorkPhone("+111111111111");
        cspAddForm.typeEmail("webdriver@yandex.ru");
        cspAddForm.typeLegalAddres("г. Севастополь, ул. Советская 3");
        cspAddForm.typeInn("8901212345");
        cspAddForm.typeKpp("321");
        cspAddForm.typeOgrn("9012345123456");
        cspAddForm.typeOkved("456");
        cspAddForm.typeOkpo("789");
        cspAddForm.typeOkato("000");

        cspAddForm.selectPanelChargeProtocolMapping();
        cspAddForm.resetMappingCSV();
        cspAddForm.clickSaveCSP();
        Assert.assertTrue(cspPage.mappingAlertMessage("Присутствуют незамапленые поля в CSV"));
        cspAddForm.toastCloseClick();
        cspAddForm.deleteChargeField(6);

        cspAddForm.selectPanelPanelExportMapping();
        cspAddForm.resetPaymentsCSV();
        cspAddForm.deletePaymentField(3);

        cspAddForm.clickSaveCSP();

        Assert.assertTrue(cspPage.mappingAlertMessage("Поставщик коммерческих услуг успешно отредактирован"));

        cspPage.typeCspNameInFilter("Вебдрайвер");

        cspPage.pause(1);
        Assert.assertTrue(cspPage.getCspTable().getValueFromCell(1, 1).equals("ООО Вебдрайвер"));
    }

    @Test
    public void test04_deleteCSP() throws IOException {
        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("admin");
        loginPage.typePassword("admin0011");
        loginPage.clickLogin();

        wait.until(urlToBe(IMPORT_CHARGE_TRX));

        sideBar.administrationButtonClick();
        sideBar.cspManageButtonClick();

        cspPage.pause(2);
        cspPage.typeCspNameInFilter("Вебдрайвер");

        cspPage.pause(2);
        cspPage.getCspTable().getRows().get(0).click();

        cspPage.deleteCspButtonClick();
        cspPage.confirmDeleteButtonClick();

        Assert.assertTrue(cspPage.mappingAlertMessage("Удаление поставщика коммерческих услуг прошло успешно"));
        cspAddForm.toastCloseClick();

        cspPage.typeCspNameInFilter("Вебдрайвер");

        cspPage.pause(1);
        //Assert.assertFalse(cspPage.getCspTable().getValueFromCell(1, 1).equals("ООО Вебдрайвер"));
    }


    public static void dragAndDrop(WebElement elementFrom, WebElement elementTo) throws IOException {
        String filePath = "src/test/resources/simulateDragDrop.js";
        StringBuffer buffer = new StringBuffer();

        String line;
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {
            buffer.append(line);
            buffer.append("\n");
        }

        String javaScript = buffer.toString();

        js.executeScript(javaScript + "simulateDragDrop(arguments[0], arguments[1])", elementFrom, elementTo);
    }
}
