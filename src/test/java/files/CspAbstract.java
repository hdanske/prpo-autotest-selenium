package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class CspAbstract {
    private WebDriver driver;

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

    private By buttonSave = By.id("csp-submit");

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
        driver.findElement(cspFullName).sendKeys(fullName);
    }

    public void typeShortName(String shortName) {
        driver.findElement(cspShortName).sendKeys(shortName);
    }

    public void typeHeadInfo(String headInfo) {
        driver.findElement(cspheadInfo).sendKeys(headInfo);
    }

    public void typePostAddres(String postAddress) {
        driver.findElement(cspPostAddress).sendKeys(postAddress);
    }

    public void typeWorkPhone(String workPhone) {
        driver.findElement(cspWorkPhone).sendKeys(workPhone);
    }

    public void typePersonalPhone(String personalPhone) {
        driver.findElement(cspPersonalPhone).sendKeys(personalPhone);
    }

    public void typeEmail(String email) {
        driver.findElement(cspEmail).sendKeys(email);
    }

    public void typeInn(String inn) {
        driver.findElement(cspInn).sendKeys(inn);
    }

    public void typeKpp(String kpp) {
        driver.findElement(cspKpp).sendKeys(kpp);
    }

    public void typeOkved(String okved) {
        driver.findElement(cspOkved).sendKeys(okved);
    }

    public void typeOkpo(String okpo) {
        driver.findElement(cspOkpo).sendKeys(okpo);
    }

    public void typeOkato(String okato) {
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
        driver.findElement(buttonSave).click();
    }

}
