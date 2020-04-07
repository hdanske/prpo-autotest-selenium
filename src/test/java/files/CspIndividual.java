package files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CspIndividual extends CspAbstract{
    private WebDriver driver;

    public CspIndividual(WebDriver driver) {
        this.driver = driver;
    }

    //И.П.
    private By cspСitizenship = By.id("citizenship"); //input[@formcontrolname='citizenship']
    private By cspRegisteredAddress = By.id("registeredAddress"); //input[@formcontrolname='registeredAddress']
    private By cspIdentityDocument = By.id("identityDocument"); //input[@formcontrolname='identityDocument']
    private By cspOgrnip = By.id("ogrnip"); //input[@formcontrolname='ogrnip']

    public void typeСitizenship(String citizenship){
        driver.findElement(cspСitizenship).sendKeys(citizenship);
    }

    public void typeRegisteredAddress(String registeredAddress){
        driver.findElement(cspRegisteredAddress).sendKeys(registeredAddress);
    }

    public void typeIdentityDocument(String identityDocument){
        driver.findElement(cspIdentityDocument).sendKeys(identityDocument);
    }

    public void typeOgrnip(String ogrnip){
        driver.findElement(cspOgrnip).sendKeys(ogrnip);
    }
}
