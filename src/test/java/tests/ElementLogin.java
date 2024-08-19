package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementLogin {

    private AndroidDriver<MobileElement> driver;
    public ElementLogin(AppiumDriver<MobileElement> driver) {
        this.driver = (AndroidDriver<MobileElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    //@iOSFindBy(id = "casdsa")
     MobileElement permissions;
    @AndroidFindBy(xpath = "//android.widget.EditText[@class=\'android.widget.EditText\']")
    //@iOSFindBy(id = "sxsaxsxas")
     MobileElement field;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='undefined.label' and @text='ENTRAR COM SENHA']")
    //@iOSFindBy(id = "sadxsa")
     MobileElement buttonEmail;
    @AndroidFindBy(xpath = "(//android.widget.Button[@class=\"android.widget.Button\"])[2]")
    //@iOSFindBy(id = "sadxsa")
     MobileElement buttonPassword;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"ENTENDI\"]")
    static//@iOSFindBy(id = "casdsa")
    MobileElement understand;

    public void visibleButton(AndroidDriver<MobileElement> driver, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String element = "//android.widget.TextView[@resource-id='undefined.label' and @text='ENTRAR COM SENHA']";

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));

            field.sendKeys(text);
            buttonEmail.click();

        } catch (Exception e) {
            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
            field.clear();
            field.sendKeys(text);
            buttonEmail.click();
        }
    }

    public void invalidEmail() {
        visibleButton(this.driver, "vitor");
        buttonEmail.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"email must be a valid email\" and @class=\"android.widget.TextView\"]", "email must be a valid email");

    }

    public void loginWithoutEmail() {
        visibleButton(this.driver, "");
        buttonEmail.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"email is a required field\" and @class=\"android.widget.TextView\"]", "email is a required field");

    }

    public void loginWithoutPassword() {
        visibleButton(this.driver, "vitor.filetto@casadosaber.com.br");
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"Digite sua senha para acessar.\" and @class=\"android.widget.TextView\"]", "Digite sua senha para acessar.");
        buttonPassword.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"password is a required field\" and @class=\"android.widget.TextView\"]", "password is a required field");

    }

    public void minimalCharacter() {
        visibleButton(this.driver, "vitor.filetto@casadosaber.com.br");
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"Digite sua senha para acessar.\" and @class=\"android.widget.TextView\"]", "Digite sua senha para acessar.");
        field.sendKeys("csac");
        buttonPassword.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"password must be at least 6 characters\" and @class=\"android.widget.TextView\"]", "password must be at least 6 characters");

    }

    public void invalidPassword() {
        visibleButton(this.driver, "vitor.filetto@casadosaber.com.br");
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"Digite sua senha para acessar.\" and @class=\"android.widget.TextView\"]", "Digite sua senha para acessar.");
        field.sendKeys("csacascs");
        buttonPassword.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"Senha incorreta. Verifique e tente novamente. Se tiver dificuldades,  recupere a sua senha\" and @class=\"android.widget.TextView\"]", "Senha incorreta. Verifique e tente novamente. Se tiver dificuldades,  recupere a sua senha");
    }

    public void emailNotExist () {
        visibleButton(this.driver, "vitor.filetto@teste.com");
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"Não foi encontrada uma conta com esse endereço de e-mail. Tente novamente ou  crie uma nova conta.\" and @class=\"android.widget.TextView\"]", "Não foi encontrada uma conta com esse endereço de e-mail. Tente novamente ou  crie uma nova conta.");

    }


    public void loginSuccess() throws InterruptedException {
        field.sendKeys("casa123");
        buttonPassword.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"ENTENDI\"]", "ENTENDI");
        Thread.sleep(3000);
        understand.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"CERTIFICADOS\"]", "CERTIFICADOS");
    }

    public void setPermissions(){
        permissions.click();
    }
}
