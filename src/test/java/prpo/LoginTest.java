package prpo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static files.ImportChargeTrxPage.IMPORT_CHARGE_TRX;
import static files.LoginPage.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class LoginTest extends InitTest {

    @Test
    public void unSuccessLogin() {

        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("a");
        loginPage.typePassword("a");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.checkMessage("Login failed").isDisplayed());
        Assert.assertTrue(loginPage.checkMessage("Неправильные логин или пароль").isDisplayed());

        loginPage.closeAlert();

        loginPage.clearField(USERNAME);
        loginPage.clearField(PASSWORD);

        Assert.assertTrue(loginPage.checkHints("Данное поле обязательно").size() == 2);
        Assert.assertFalse(isClickable(loginPage.getloginButton()));
    }

    @Test
    public void successLogin() {

        loginPage.goTo(LOGIN_URL);
        loginPage.typeUsername("admin");
        loginPage.typePassword("admin123");
        loginPage.clickLogin();

        wait.until(urlToBe(IMPORT_CHARGE_TRX));
        Assert.assertEquals(driver.getCurrentUrl(), IMPORT_CHARGE_TRX);
    }

    public static boolean isClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
