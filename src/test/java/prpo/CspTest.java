package prpo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static files.CspPage.CSP_URL;
import static files.ImportChargeTrxPage.IMPORT_CHARGE_TRX;
import static files.LoginPage.LOGIN_URL;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class CspTest extends InitTest {

    @Test
    public void cspCreate() throws IOException {
        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("admin");
        loginPage.typePassword("admin0011");
        loginPage.clickLogin();

        wait.until(urlToBe(IMPORT_CHARGE_TRX));

        sideBar.administrationButtonClick();
        sideBar.cspManageButtonClick();

        cspPage.addCspClick();
        cspAddForm.clickCspType("Индивидуальный предприниматель");
        cspAddForm.selectCspRegion("Санкт - Петербург");
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
//-----------------------------Поиск Созданного ПКУ----------------------------------------------------------------------//
        cspPage.typeCspNameInFilter("Селениум");

        cspPage.pause(1);
        Assert.assertTrue(cspPage.getCspTable().getValueFromCell(1, 1).equals("ОАО Селениум"));
    }

    @Test
    public void cspEdit() throws IOException {
        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("admin");
        loginPage.typePassword("admin0011");
        loginPage.clickLogin();

        wait.until(urlToBe(IMPORT_CHARGE_TRX));

        sideBar.administrationButtonClick();
        sideBar.cspManageButtonClick();

        cspPage.pause(1);
        cspPage.typeCspNameInFilter("Селениум");

        cspPage.pause(1);
        cspPage.getCspTable().getRows().get(0).click();

        cspPage.editButtonClick();

        cspAddForm.clickCspType("Юридическое лицо");
        cspAddForm.selectCspRegion("Республика Крым");
        cspAddForm.selectServicesSector("Детский сад");
        cspAddForm.typeFullName("ООО Вебдрайвер");
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
        //cspAddForm.deletePaymentField(3);

        cspAddForm.clickSaveCSP();

        Assert.assertTrue(cspPage.mappingAlertMessage("Редактирование поставщика коммерческих услуг ''ООО Вебдрайвер'' прошло успешно"));

        cspAddForm.pause(15);
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
