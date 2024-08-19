package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class ElementHome {

    private static ElementLogin elementLogin;
    private AndroidDriver<MobileElement> driver;
    public ElementHome(AppiumDriver<MobileElement> driver) {
        this.driver = (AndroidDriver<MobileElement>) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        elementLogin = new ElementLogin(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"MINHA CONTA\"]")
    //@iOSFindBy(id = "casdsa")
    MobileElement minhaConta;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"CATEGORIAS\" and @class=\"android.widget.TextView\"]")
    //@iOSFindBy(id = "casdsa")
    MobileElement categorias;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uF215\" and @class=\"android.widget.TextView\"]")
    //@iOSFindBy(id = "casdsa")
    MobileElement fechar;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"CERTIFICADOS\"]")
    //@iOSFindBy(id = "casdsa")
    MobileElement certificados;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\uF12F\" and @class=\"android.widget.TextView\"]")
    //@iOSFindBy(id = "casdsa")
    static MobileElement voltar;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Pesquisar\" and @class=\"android.widget.EditText\"]")
    //@iOSFindBy(id = "casdsa")
    MobileElement search;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Para se Comunicar Melhor\" and @class=\"android.widget.TextView\"]")
    //@iOSFindBy(id = "casdsa")
    MobileElement categoryCourses;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"ALTERAR\"])[1]")
    //@iOSFindBy(id = "casdsa")
    MobileElement dadosPessoais;
    @AndroidFindBy(xpath = "(//android.view.View[@class=\"android.view.View\"])[1]")
    //@iOSFindBy(id = "casdsa")
    static MobileElement destaques;




    public void category(){
        Actions.scrollIfElementNotFound(this.driver, String.valueOf(categorias), 5, 2);
        categorias.click();
        Actions.scrollDown(this.driver, 3, 0.5);
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"Para se Comunicar Melhor\" and @class=\"android.widget.TextView\"]", "Para se Comunicar Melhor");
        categoryCourses.click();
        Actions.scrollDown(this.driver, 2,0.5);
        voltar.click();
        fechar.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"MINHA CONTA\"]", "MINHA CONTA");
    }

    public void myAccount() {
        minhaConta.click();
        dadosPessoais.click();
        voltar.click();
        Actions.scrollDown(this.driver, 2,0.5);
        Actions.visibleElement(this.driver, "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"SAIR DA CONTA\"]", "SAIR DA CONTA");
        voltar.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"MINHA CONTA\"]", "MINHA CONTA");
    }

    public void certificates(){
        Actions.scrollIfElementNotFound(this.driver, String.valueOf(certificados), 1, 2);
        certificados.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"Aqui você pode baixar o seu certificado em formato PNG ou compartilha-lo em suas redes sociais.\" and @class=\"android.widget.TextView\"]", "Aqui você pode baixar o seu certificado em formato PNG ou compartilha-lo em suas redes sociais.");
        Actions.scrollDown(this.driver, 3,0.5);
        voltar.click();
        Actions.visibleElement(this.driver, "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"MINHA CONTA\"]", "MINHA CONTA");
    }

    public void fieldSearch() {
        Actions.performTapAction(this.driver, 516,175);
        Actions.visibleElement(this.driver, "//android.widget.EditText[@text=\"Pesquisar\" and @class=\"android.widget.EditText\"]", "Pesquisar");

    }

    public void notFound() {
        fieldSearch();
        search.sendKeys("cursoNaoEncontrado");
        Actions.visibleElement(this.driver, "(//android.widget.TextView[@class=\"android.widget.TextView\"])[5]", "Não encontramos resultados para \"cursoNaoEncontrado\".");
        voltar.click();
    }

    public void searchCourse() {
        fieldSearch();
        search.sendKeys("amor");
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"CURSOS ENCONTRADOS\" and @class=\"android.widget.TextView\"]", "CURSOS ENCONTRADOS");
        voltar.click();
    }

    public void highlightsCourse(){
        Actions.scrollIfElementNotFound(this.driver, String.valueOf(destaques), 2,2);
//        Random random = new Random();
//        int i = random.nextInt(9) + 1;
        for (int i = 0; i < 5; i++) {
            Actions.scrollHorizontal(this.driver, 884,632,33,653, 2);
            destaques.click();
            Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"baixar\" and @class=\"android.widget.TextView\"]", "baixar");
            Actions.scrollDown(this.driver, 2, 0.5);
            voltar.click();
            Actions.visibleElement(this.driver, "//android.widget.TextView[@resource-id=\"undefined.label\" and @text=\"MINHA CONTA\"]", "MINHA CONTA");
        }
    }

    public void homeCourses() throws InterruptedException {
        //Nesse cenário quando os IDs forem colocados, irá sofrer alteração.
        Actions.scrollClickCourses(this.driver);
    }

    public void teachersCategory() throws InterruptedException {
        Actions.scrollDown(driver, 5, 2);
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"Professores\" and @class=\"android.widget.TextView\"]", "Professores");
        Actions.scrollHorizontal(driver, 825, 1715, 362, 1710, 1);
        Thread.sleep(500);
        Actions.performTapAction(driver, 169, 1914);
        Thread.sleep(500);
        Actions.scrollDown(driver, 2, 0.5);
        Actions.visibleElement(this.driver, "//android.widget.TextView[@text=\"Cursos\" and @class=\"android.widget.TextView\"]", "Cursos");
        voltar.click();
    }
}
