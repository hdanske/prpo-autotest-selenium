package prpo;

import files.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InitTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static LoginPage loginPage;
    public static JavascriptExecutor js;
    public static SideBar sideBar;
    public static CspPage cspPage;
    public static CspAddForm cspAddForm;
    public static ImportChargeTrxPage importChargeTrxPage;
    public static ImportChargeForm importChargeForm;
    public static ExportPaymentsPage exportPaymentsPage;
    public static ExportPaymentForm exportPaymentForm;
    public static RegionPage regionPage;
    public static RegionForm regionForm;

    @Before
    public void start() {
        if (driver != null) {
            return;
        }
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 40);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        sideBar = new SideBar(driver);
        cspPage = new CspPage(driver);
        cspAddForm = new CspAddForm(driver);
        importChargeTrxPage = new ImportChargeTrxPage(driver);
        importChargeForm = new ImportChargeForm(driver);
        exportPaymentsPage = new ExportPaymentsPage(driver);
        exportPaymentForm = new ExportPaymentForm(driver);
        regionPage = new RegionPage(driver);
        regionForm = new RegionForm(driver);

        js = (JavascriptExecutor) driver;

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    driver.quit();
                    driver = null;
                }));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
