package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class Actions {
    public Actions(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static void performTapAction(AndroidDriver<MobileElement> driver, int x, int y) {
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.tap(PointOption.point(x, y)).perform();
    }


    public static void visibleElement(AndroidDriver<MobileElement> driver, String xpath, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By elementLocator = By.xpath(String.valueOf(xpath));

        String actualText = null;
        String expectedText = null;
        try {
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
            actualText = element.getText();
            expectedText = text;

            Assert.assertEquals("Texto não corresponde ao esperado!", expectedText, actualText);
            System.out.println(String.format("Elemento visivel -- " + actualText));
        } catch (TimeoutException e) {
            Assert.fail("O elemento não está visível" + expectedText);
        }
    }

    public static void login(AndroidDriver<MobileElement> driver, ElementLogin elementLogin) throws InterruptedException {
        elementLogin.setPermissions();
        Actions.performTapAction(driver, 923, 178);
        elementLogin.visibleButton(driver, "vitor.filetto@casadosaber.com.br");
        Actions.visibleElement(driver, "//android.widget.TextView[@text=\"Digite sua senha para acessar.\" and @class=\"android.widget.TextView\"]", "Digite sua senha para acessar.");
        elementLogin.field.sendKeys("casa123");
        elementLogin.buttonPassword.click();
        Actions.visibleElement(driver, "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"ENTENDI\"]", "ENTENDI");
        Thread.sleep(1000);
        ElementLogin.understand.click();
        Actions.visibleElement(driver, "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"CERTIFICADOS\"]", "CERTIFICADOS");
    }

    public static void scrollDown(AndroidDriver<MobileElement> driver, int numberOfScrolls, double increment) {
        double startPercentageY = 0.8;

        double scrollIncrement = increment;

        int screenHeight = driver.manage().window().getSize().height;

        int startY = (int) (screenHeight * startPercentageY);

        for (int i = 0; i < numberOfScrolls; i++) {
            int endY = (int) (startY - screenHeight * scrollIncrement);

            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(PointOption.point(1, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(1, endY))
                    .release()
                    .perform();
        }
    }

    public static void scrollTop(AndroidDriver<MobileElement> driver, int numberOfScrolls, double increment) {
        double startPercentageY = 0.8;

        int screenHeight = driver.manage().window().getSize().height;

        for (int i = 0; i < numberOfScrolls; i++) {
            int startY = (int) (screenHeight * startPercentageY);
            int endY = (int) (screenHeight * (startPercentageY + increment));

            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(PointOption.point(1, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(1, endY))
                    .release()
                    .perform();
        }
    }

    public static void scrollHorizontal(
            AppiumDriver<MobileElement> driver,
            int startX, int startY,
            int endX, int endY,
            int numberOfScrolls
    ) {
        PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        for (int i = 0; i < numberOfScrolls; i++) {
            Sequence swipe = new Sequence(FINGER, 1)
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(0),
                                PointerInput.Origin.viewport(),
                                startX,
                                startY))
                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(1000),
                                PointerInput.Origin.viewport(),
                                endX,
                                endY))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(swipe));}
    }

    public static void scrollIfElementNotFound(AndroidDriver<MobileElement> driver, String xpath, int scroll, double increment) {
        try {
            driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            System.out.println(String.format("Scroll"));
            scrollTop(driver, scroll, increment);
        }
    }

    public static void scrollClickCourses(AndroidDriver<MobileElement> driver) {
        double increment = 0.25;
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                Actions.scrollHorizontal(driver, 858, 1668, 214, 1686, 1);
                Thread.sleep(1000);
                Actions.performTapAction(driver, 169, 1733);
                if (ElementHome.voltar.isDisplayed()) {
                    ElementHome.voltar.click();
                }
//                ElementHome.voltar.click();
                Thread.sleep(1000);
                Actions.scrollDown(driver, 1, increment);
                Thread.sleep(1000);
                if (i == 0) {
                    increment += 0.10;
                }
                System.out.println(increment);
            } catch (InterruptedException e) {
                Actions.scrollDown(driver, 1, increment);
                System.out.println("Nova ação de scroll realizada após exceção");
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                // Se o elemento "ElementHome.voltar" não estiver presente, continue com outras ações
                System.out.println("Elemento 'voltar' não encontrado, continuando com outras ações.");
            }
        }
    }
}
