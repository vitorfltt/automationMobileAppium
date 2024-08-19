package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.MalformedURLException;

public class LoginTest {
    private static ElementLogin elementLogin;
    static AndroidDriver<MobileElement> driver;

    @BeforeClass
    public static void setup() throws MalformedURLException, InterruptedException {
        driver = Config.setupDriver();
        elementLogin = new ElementLogin(driver);

        elementLogin.setPermissions();
        Actions.performTapAction(driver, 923, 178);
    }

    @Before
    public void clear() {
        elementLogin.field.clear();
    }

    @Test
    public void loginWithoutEmail() {
        elementLogin.loginWithoutEmail();
    }

    @Test
    public void invalidEmail() {
        elementLogin.invalidEmail();
    }

    @Test
    public void emailNotExist() {
        elementLogin.emailNotExist();
    }

    @Test
    public void loginWithoutPassword() {
        elementLogin.loginWithoutPassword();
    }

    @Test
    public void minimalCharacter() {
        elementLogin.minimalCharacter();
    }

    @Test
    public void errorPassword() {
        elementLogin.invalidPassword();
    }

    @Test
    public void loginSuccess() throws InterruptedException {
        elementLogin.loginSuccess();
    }
}
