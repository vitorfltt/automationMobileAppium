package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Config {
    public static AndroidDriver<MobileElement> setupDriver() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("app", "C:\\Users\\vitor\\Downloads\\APKs\\app4.50.apk");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);

        Actions.visibleElement(driver, "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]", "Allow");

        return driver;
    }
}
