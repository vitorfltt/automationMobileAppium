package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.MalformedURLException;

public class HomeTest {
    private static ElementHome elementHome;
    static AndroidDriver<MobileElement> driver;

    @BeforeClass
    public static void setup() throws MalformedURLException, InterruptedException {
        driver = Config.setupDriver();
        elementHome = new ElementHome(driver);

        Actions.login(driver, new ElementLogin(driver));
    }

    @Test
    public void certificates() {
        elementHome.certificates();
    }

    @Test
    public void category() {
        elementHome.category();
    }

    @Test
    public void myAccount() {
        elementHome.myAccount();
    }

    @Test
    public void fieldSearch_NotFound(){
        elementHome.notFound();
    }

    @Test
    public void fieldSearch(){
        elementHome.searchCourse();
    }

    @Test
    public void highlights(){
        elementHome.highlightsCourse();
    }
    @Test
    public void clickCourses() throws InterruptedException {
        elementHome.homeCourses();
    }
    @Test
    public void teachersCategory() throws InterruptedException {
        elementHome.teachersCategory();
    }
}
