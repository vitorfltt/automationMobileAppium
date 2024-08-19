package tests;

import elements.ElementsCourse;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class metodCourse {
    private AndroidDriver<MobileElement> driver;
    public metodCourse(AppiumDriver<MobileElement> driver) {
        this.driver = (AndroidDriver<MobileElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static boolean isElementVisible(AppiumDriver<MobileElement> driver, String xpath) {
        try {
            return driver.findElement(By.xpath(xpath)).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.ElementNotVisibleException e) {
            return false;
        }
    }

    public void openCourse(){
        Random random = new Random();
        int i = random.nextInt(9) + 1;
        Actions.scrollHorizontal(this.driver, 884,632,33,653, i);
        ElementsCourse.assistir.click();
    }

    public void pauseClass() throws InterruptedException {
        Thread.sleep(5000);
        ElementsCourse.centroClique.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"Próxima aula\"]", "Próxima aula");
        ElementsCourse.pausa.click();
        Thread.sleep(5000);
        ElementsCourse.pausa.click();
    }

    public void timerClass(){
        if (isElementVisible(this.driver, String.valueOf(ElementsCourse.avançar))) {
            System.out.println("O elemento está visível.");
        } else {
            System.out.println("O elemento não está visível.");
            ElementsCourse.centroClique.click();
        }
        ElementsCourse.avançar.click();
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        ElementsCourse.voltar.click();
    }

    public void speedAndQuality() throws InterruptedException {
        if (isElementVisible(this.driver, String.valueOf(ElementsCourse.velocidade))) {
            System.out.println("O elemento está visível.");
        } else {
            System.out.println("O elemento não está visível.");
            ElementsCourse.centroClique.click();
        }
        ElementsCourse.velocidade.click();
        Thread.sleep(2000);
        ElementsCourse.qualidade.click();
    }

    public void nextClass() throws InterruptedException {
        Thread.sleep(5000);
        if (isElementVisible(this.driver, String.valueOf(ElementsCourse.proximaAula))) {
            System.out.println("O elemento está visível.");
            ElementsCourse.proximaAula.click();
        } else {
            System.out.println("O elemento não está visível.");
            ElementsCourse.centroClique.click();
            Thread.sleep(2000);
            ElementsCourse.proximaAula.click();
            Thread.sleep(5000);
        }
    }

    public void closeClass(){
        Actions.performTapAction(this.driver, 87, 75);
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"baixar\"]", "baixar");
    }

    public void enterCourse(int scroll){
        Random random = new Random();
        int i = random.nextInt(9) + 1;
        Actions.scrollHorizontal(this.driver, 884,632,33,653, scroll);
        ElementsCourse.saibaMais.click();
        ElementsCourse.entrarCurso.click();
    }
    public void share(){
        ElementsCourse.compartilhar.click();
        Actions.performTapAction(this.driver, 991, 145);
    }

    public void trailer(){
        try {
            ElementsCourse.trailer.click();
            driver.navigate().back();
            Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"baixar\"]", "baixar");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Se o botão "baixar" não estiver presente, imprime a mensagem e prossegue
            System.out.println("não está presente o trailer");
        }
    }

    public void download() throws InterruptedException {
        ElementsCourse.baixar.click();
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"baixando\"]", "baixando");
        ElementsCourse.baixando.click();
        wait = new WebDriverWait(this.driver, 5);
        Actions.visibleElement(this.driver, "//android.widget.Button[@resource-id=\"android:id/button2\"]", "CANCELAR DOWNLOAD");
        ElementsCourse.cancelar.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"baixar\"]", "baixar");
    }

    public void about(){
        Actions.scrollDown(this.driver, 1, 0.5);
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"Sobre\"]", "Sobre");
        ElementsCourse.sobre.click();
        Actions.scrollDown(this.driver, 1, 0.5);
        Actions.visibleElement(this.driver, "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"SAIBA MAIS\"]", "SAIBA MAIS");
    }

    public void supportMaterial() throws InterruptedException {
        try {
            ElementsCourse.material.click();
            Thread.sleep(5000);
            driver.navigate().back();
            Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"baixar\"]", "baixar");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Se o botão "baixar" não estiver presente, imprime a mensagem e prossegue
            System.out.println("não está presente o material de suporte");
        }
    }

    public void certificate() {
        try {
            ElementsCourse.certificado.click();
            Actions.visibleElement(this.driver, "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"COMPARTILHAR CERTIFICADO\"]", "COMPARTILHAR CERTIFICADO");
            Actions.visibleElement(this.driver, "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"BAIXAR CERTIFICADO\"]", "BAIXAR CERTIFICADO");
            ElementsCourse.close.click();
            Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"baixar\"]", "baixar");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Se o botão de certificado não estiver presente, imprime a mensagem e prossegue
            System.out.println("Curso não tem certificado");
        }
    }

    public void buttonClass() throws InterruptedException {
        ElementsCourse.botãoAula.click();
        Thread.sleep(2000);
        ElementsCourse.centroClique.click();
        Thread.sleep(2000);
        Actions.performTapAction(this.driver, 81, 78);
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"baixar\"]", "baixar");
    }

    public void smartTV() throws InterruptedException {
        Thread.sleep(2000);
        Actions.performTapAction(this.driver, 991, 145);
        ElementsCourse.permission.click();
        Thread.sleep(2000);
        ElementsCourse.fechar.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"baixar\"]", "baixar");
    }

    public void classes() throws InterruptedException {
        Thread.sleep(2000);
        Actions.scrollDown(this.driver, 1, 0.8);
        ElementsCourse.aula01.click();
        Thread.sleep(5000);
        if (isElementVisible(this.driver, String.valueOf(ElementsCourse.proximaAula))) {
            System.out.println("O elemento está visível.");
            ElementsCourse.proximaAula.click();
        } else {
            System.out.println("O elemento não está visível.");
            ElementsCourse.centroClique.click();
            Thread.sleep(2000);
            ElementsCourse.proximaAula.click();
            Thread.sleep(5000);
        }
        Actions.performTapAction(this.driver, 81, 78);
        Thread.sleep(2000);
        Actions.scrollDown(this.driver, 1, 0.8);
        ElementsCourse.aula03.click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        Actions.scrollDown(this.driver, 1, 0.8);
        ElementsCourse.aula04.click();
        Thread.sleep(5000);
        driver.navigate().back();
    }

}
