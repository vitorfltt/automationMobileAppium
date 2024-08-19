package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.MalformedURLException;

public class ScreenCourseTest {
    private static metodCourse metodCourse;
    static AndroidDriver<MobileElement> driver;

    @BeforeClass
    public static void setup() throws MalformedURLException, InterruptedException {
        driver = Config.setupDriver();
        metodCourse = new metodCourse(driver);

        Actions.login(driver, new ElementLogin(driver));
    }

    @Test
    public void enterCourse() throws InterruptedException {
        metodCourse.openCourse();
        metodCourse.pauseClass();
        metodCourse.timerClass();
        metodCourse.speedAndQuality();
        metodCourse.nextClass();
        metodCourse.closeClass();
    }

    @Test
    public void actionsCourse() throws InterruptedException {
        metodCourse.enterCourse(0);
        metodCourse.smartTV();
        metodCourse.trailer();
        metodCourse.share();
        metodCourse.download();
        metodCourse.supportMaterial();
        metodCourse.certificate();
        metodCourse.buttonClass();
        metodCourse.about();
    }

    @Test
    public void classes() throws InterruptedException {
        metodCourse.enterCourse(1);
        metodCourse.classes();
    }
}
