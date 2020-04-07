package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CspYuridical extends CspAbstract{
    private WebDriver driver;

    public CspYuridical(WebDriver driver) {
        this.driver = driver;
    }

    public CspYuridical(WebDriver driver,
                        String serviceSector,
                        String cspType,     String owner,
                        String region,      String fullName,
                        String shortName,   String headInfo,
                        String postAddress, String email,
                        String workPhone,   String personalPhone,
                        String okved,       String inn,
                        String kpp,         String korrBankAccount,
                        String bik,         String bankFullName,
                        String bankAccount, String okpo,
                        String okato,       String cspLegalAddress, String cspOgrn
    )
    {typeEmail(email);
        selectServicesSector(serviceSector);
        selectCspOwner(owner);
        selectCspRegion(region);
        typeFullName(fullName);
        typeShortName(shortName);
        typeHeadInfo(headInfo);
        typePostAddres(postAddress);

        typeWorkPhone(workPhone);
        typePersonalPhone(personalPhone);
        typeOkved(okved);
        typeInn(inn);
        typeKpp(kpp);
        typeCorrBankAccount(korrBankAccount);
        typeBik(bik);
        typeBankFullName(bankFullName);
        typeBankAccount(bankAccount);
        typeOkpo(okpo);
        typeOkato(okato);
        typeLegalAddres(cspLegalAddress);
        typeOgrn(cspOgrn);
        clickCspType(cspType);
    }

    //Ю.Л
    private By cspLegalAddress = By.id("legalAddress"); //input[@formcontrolname='legalAddress']
    private By cspOgrn = By.id("ogrn"); //input[@formcontrolname='ogrn']

    public void typeLegalAddres(String legalAddress){
        driver.findElement(cspLegalAddress).sendKeys(legalAddress);
    }

    public void typeOgrn(String ogrn){
        driver.findElement(cspOgrn).sendKeys(ogrn);
    }


}
