package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CspAddForm extends BaseEntity {
    private WebDriver driver;

    public CspAddForm(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFullName() {
        return driver.findElement(cspFullName);
    }

    public WebElement getJgrn() {
        return driver.findElement(cspOgrn);
    }

    private By cspTypeDropDown = By.xpath("//p-dropdown[@formcontrolname='cspType']");

    private By cspServiceSector = By.xpath("//p-dropdown[@formcontrolname='servicesSector']");
    private By cspOwnerList = By.xpath("//*[@formcontrolname='owner']//button");
    private By cspRegionList = By.xpath("//*[@formcontrolname='region']//button");
    private By cspFullName = By.id("fullName"); //input[@formcontrolname='fullName']
    private By cspShortName = By.id("shortName"); //input[@formcontrolname='shortName']
    private By cspheadInfo = By.id("headInfo"); //input[@formcontrolname='headInfo']
    private By cspPostAddress = By.id("postAddress"); //input[@formcontrolname='postAddress']
    private By cspEmail = By.id("email"); //input[@formcontrolname='email']
    private By cspWorkPhone = By.id("workPhone"); //input[@formcontrolname='workPhone']
    private By cspPersonalPhone = By.id("personalPhone"); //input[@formcontrolname='personalPhone']
    private By cspOkved = By.id("okved"); //input[@formcontrolname='okved']
    private By cspInn = By.id("inn"); //input[@formcontrolname='inn']
    private By cspKpp = By.id("kpp"); //input[@formcontrolname='kpp']
    private By cspCorrBankAccount = By.id("corrBankAccount"); //input[@formcontrolname='corrBankAccount']
    private By cspBik = By.id("bik"); //input[@formcontrolname='bik']
    private By cspBankFullName = By.id("bankFullName"); //input[@formcontrolname='bankFullName']
    private By cspBankAccount = By.id("bankAccount"); //input[@formcontrolname='bankAccount']
    private By cspOkpo = By.id("okpo"); //input[@formcontrolname='okpo']
    private By cspOkato = By.id("okato"); //input[@formcontrolname='okato']

    //И.П.
    private By cspСitizenship = By.id("citizenship"); //input[@formcontrolname='citizenship']
    private By cspRegisteredAddress = By.id("registeredAddress"); //input[@formcontrolname='registeredAddress']
    private By cspIdentityDocument = By.id("identityDocument"); //input[@formcontrolname='identityDocument']
    private By cspOgrnip = By.id("ogrnip"); //input[@formcontrolname='ogrnip']

    //Ю.Л
    private By cspLegalAddress = By.id("legalAddress"); //input[@formcontrolname='legalAddress']
    private By cspOgrn = By.id("ogrn"); //input[@formcontrolname='ogrn']

    private By buttonSave = By.id("csp-submit");
    private By buttonCancel = By.xpath("//button//*[contains(text(), 'Отмена')]");

    //Маппинг протокола начислений
    private By chargeProtocolMapping = By.xpath("//span[contains(text(), 'Маппинг протокола начислений')]");
    private By addFieldCharge = By.cssSelector("p-spinner .ui-spinner-up");
    private By deleteFiledCharge = By.cssSelector("p-spinner .ui-spinner-down");
    private By addFieldPayment = By.xpath("//*[@id=\"ui-tabpanel-2\"]//p-spinner//button");
    private By resetButtonCSV = By.xpath("//button[@data-cy-csp-mapping-reset]");
    private By resetButtonPaymentsCSV = By.xpath("//#ui-tabpanel-2//button[@data-cy-csp-mapping-reset]");

//    private By innerProtocolFieldArr = By.cssSelector("//*[data-cy-csp-mapping-internal][1]");

    public void clickAddChargeField(int quantity) {
        while (quantity > 0) {
            driver.findElement(addFieldCharge).click();
            quantity--;
        }
    }


    public void clickCspType(String cspType) {
        //Юридическое лицо
        //Индивидуальный предприниматель
        //Юридическое лицо - нерезидент РФ

        String optionType = String.format("//li[@aria-label='%s']", cspType);
        driver.findElement(cspTypeDropDown).click();
        driver.findElement(By.xpath(optionType)).click();
    }

    public void selectCspOwner(String ovnerName) {
        String optionOwner = String.format("//ul[@role='listbox']/li/*[contains(text(), '%s')]", ovnerName);
        driver.findElement(cspOwnerList).click();
        driver.findElement(By.xpath(optionOwner)).click();
    }

    public void selectServicesSector(String servicesSector) {
        //Юридическое лицо
        //Индивидуальный предприниматель
        //Юридическое лицо - нерезидент РФ

        String optionServicesSector = String.format("//li[@aria-label='%s']", servicesSector);
        driver.findElement(cspServiceSector).click();
        driver.findElement(By.xpath(optionServicesSector)).click();
    }

    public void selectCspRegion(String regionName) {
        String optionOwner = String.format("//ul[@role='listbox']/li/*[contains(text(), '%s')]", regionName);
        driver.findElement(cspRegionList).click();
        driver.findElement(By.xpath(optionOwner)).click();
    }

    public void typeFullName(String fullName) {
        driver.findElement(cspFullName).clear();
        driver.findElement(cspFullName).sendKeys(fullName);
    }

    public void typeShortName(String shortName) {
        driver.findElement(cspShortName).sendKeys(shortName);
    }

    public void typeHeadInfo(String headInfo) {
        driver.findElement(cspheadInfo).sendKeys(headInfo);
    }

    public void typeLegalAddres(String legalAddress) {
        driver.findElement(cspLegalAddress).clear();
        driver.findElement(cspLegalAddress).sendKeys(legalAddress);
    }

    public void typePostlAddres(String postAddress) {
        driver.findElement(cspPostAddress).sendKeys(postAddress);
    }

    public void typeWorkPhone(String workPhone) {
        driver.findElement(cspWorkPhone).clear();
        driver.findElement(cspWorkPhone).sendKeys(workPhone);
    }

    public void typePersonalPhone(String personalPhone) {
        driver.findElement(cspPersonalPhone).sendKeys(personalPhone);
    }

    public void typeEmail(String email) {
        driver.findElement(cspEmail).clear();
        driver.findElement(cspEmail).sendKeys(email);
    }

    public void typeInn(String inn) {
        driver.findElement(cspInn).clear();
        driver.findElement(cspInn).sendKeys(inn);
    }

    public void typeKpp(String kpp) {
        driver.findElement(cspKpp).clear();
        driver.findElement(cspKpp).sendKeys(kpp);
    }

    public void typeOgrn(String ogrn) {
        driver.findElement(cspOgrn).clear();
        driver.findElement(cspOgrn).sendKeys(ogrn);
    }

    public void typeOkved(String okved) {
        driver.findElement(cspOkved).clear();
        driver.findElement(cspOkved).sendKeys(okved);
    }

    public void typeOkpo(String okpo) {
        driver.findElement(cspOkpo).clear();
        driver.findElement(cspOkpo).sendKeys(okpo);
    }

    public void typeOkato(String okato) {
        driver.findElement(cspOkato).clear();
        driver.findElement(cspOkato).sendKeys(okato);
    }

    public void typeBankAccount(String bankAccount) {
        driver.findElement(cspBankAccount).sendKeys(bankAccount);
    }

    public void typeBankFullName(String bankFullName) {
        driver.findElement(cspBankFullName).sendKeys(bankFullName);
    }

    public void typeBik(String bik) {
        driver.findElement(cspBik).sendKeys(bik);
    }

    public void typeCorrBankAccount(String corrBankAccount) {
        driver.findElement(cspCorrBankAccount).sendKeys(corrBankAccount);
    }

    public void clickSaveCSP() {
        driver.findElement(By.id("csp-submit")).click();
    }


    public void typeСitizenship(String citizenship) {
        driver.findElement(cspСitizenship).sendKeys(citizenship);
    }

    public void typeRegisteredAddress(String registeredAddress) {
        driver.findElement(cspRegisteredAddress).sendKeys(registeredAddress);
    }

    public void typeIdentityDocument(String identityDocument) {
        driver.findElement(cspIdentityDocument).sendKeys(identityDocument);
    }

    public void typeOgrnip(String ogrnip) {
        driver.findElement(cspOgrnip).sendKeys(ogrnip);
    }

    public void selectPanelChargeProtocolMapping() {
        driver.findElement(chargeProtocolMapping).click();
    }


    public WebElement getChargeField(String fieldName) {
        WebElement chargeField = driver.findElement(By.xpath("//div[@data-cy-csp-mapping-internal-inner=\"charges:CSV\" and contains(.,' " + fieldName + " ')]"));
        return chargeField;
    }

    public WebElement getfieldToMapp(int position) {
        List<WebElement> fieldToMapp = driver.findElements(By.xpath("//div[@class='field field-external']"));
        return fieldToMapp.get(position);
    }

    public void separatorCheckBoxOnCharges() {
        List<WebElement> checkBox = driver.findElements(By.tagName("p-checkbox"));
        checkBox.get(0).click();
    }


    public void typeSeparatorCharge(String separator) {
        List<WebElement> elements = driver.findElements(By.xpath("//label[text()='Разделитель:']/following-sibling::input"));
        elements.get(0).sendKeys(separator);
    }

    public void selectPanelPanelExportMapping() {
        driver.findElement(By.id("ui-tabpanel-2-label")).click();
    }

    public void clickAddPaymentField(int quantity) {
        while (quantity > 0) {
            driver.findElement(addFieldPayment).click();
            quantity--;
        }
    }

    public WebElement getPaymentField(String fieldName) {
        WebElement paymentField = driver.findElement(By.xpath("//div[@class='field field-internal' and contains(.,' " + fieldName + " ')]"));
        return paymentField;
    }

    public void separatorCheckBoxOnPayment() {
        driver.findElements(By.cssSelector("#ui-tabpanel-2 p-checkbox")).get(0).click();
    }

    public void typeSeparatorPayment(String separator) {
        driver.findElement(By.xpath("//div[@id=\"ui-tabpanel-2\"]//label[text()='Разделитель:']/following-sibling::input")).sendKeys(separator);
    }

    public void resetMappingCSV() {
        driver.findElement(resetButtonCSV).click();
    }

    public boolean mappingAlertMessage(String alertText) {
        WebElement alert = driver.findElement(By.xpath("//p-toastitem//div[text()='" + alertText + "']"));
        if (alert.isDisplayed()) return true;
        else return false;
    }

    public void toastCloseClick() {
        driver.findElement(By.xpath("//p-toast//a")).click();
    }

    public void deleteChargeField(int quantity) {
        while (quantity > 0) {
            driver.findElement(deleteFiledCharge).click();
            quantity--;
        }
    }

    public void resetPaymentsCSV() {
        driver.findElement(resetButtonPaymentsCSV).click();
    }
}
