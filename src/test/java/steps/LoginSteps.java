package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;
import core.Driver;

import java.io.ByteArrayInputStream;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@Epic("Mobile App Testing")
@Feature("Autenticação")
public class LoginSteps {

    LoginPage loginPage;

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }

    @Dado("que esteja na página de login")
    @Step("Navegar para a página de login")
    @Description("Este passo navega o usuário para a tela de login do aplicativo móvel")
    @Severity(SeverityLevel.CRITICAL)
    public void queEstejaNaPaginaDeLogin() {
        loginPage = new LoginPage();
        captureScreenshot("Tela de Login");
    }

    @Quando("for realizado login com os seguintes dados")
    @Step("Realizar login com email e senha")
    @Description("Preenche os campos de email e senha e clica no botão de login")
    @Severity(SeverityLevel.CRITICAL)
    public void forRealizadoLoginComOsSeguintesDados(Map<String, String> map) {
        String email = map.get("email");
        String senha = map.get("senha");

        // Add parameters to Allure report
        Allure.parameter("email", email);
        Allure.parameter("senha", "********");

        loginPage.realizarLogin(email, senha);
        captureScreenshot("Após clicar em login");
    }

    @Entao("valido que exibe o popup de sucesso")
    @Step("Validar popup de sucesso no login")
    @Description("Verifica se o popup de sucesso é exibido com a mensagem correta")
    @Severity(SeverityLevel.CRITICAL)
    public void validoQueExibeOPopupDeSucesso() {
        String loggedMessage = loginPage.getTxtAndroidPopup();
        Allure.addAttachment("Mensagem do Popup", loggedMessage);
        captureScreenshot("Popup de Sucesso");
        assertEquals("You are logged in!", loggedMessage);
    }

    @Entao("valido que no campo erro email exibe a mensagem {string}")
    @Step("Validar mensagem de erro no campo email")
    @Description("Verifica se a mensagem de erro apropriada é exibida no campo de email")
    @Severity(SeverityLevel.NORMAL)
    public void valido_que_no_campo_erro_email_exibe_a_mensagem(String mensagemEsperada) {
        String mensagemAtual = loginPage.getTxtNotAuthEmail();

        // Add comparison details to report
        Allure.parameter("Mensagem Esperada", mensagemEsperada);
        Allure.parameter("Mensagem Atual", mensagemAtual);

        captureScreenshot("Erro no Campo Email");
        assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Entao("valido que no campo erro senha exibe a mensagem {string}")
    @Step("Validar mensagem de erro no campo senha")
    @Description("Verifica se a mensagem de erro apropriada é exibida no campo de senha")
    @Severity(SeverityLevel.NORMAL)
    public void validoQueNoCampoErroSenhaExibeAMensagem(String mensagemEsperada) {
        String mensagemAtual = loginPage.getTxtNotAuthPassword();

        // Add comparison details to report
        Allure.parameter("Mensagem Esperada", mensagemEsperada);
        Allure.parameter("Mensagem Atual", mensagemAtual);

        captureScreenshot("Erro no Campo Senha");
        assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Quando("clico em Sign Up")
    @Step("Navegar para tela de cadastro")
    @Description("Clica no botão de Sign Up para acessar a tela de cadastro")
    @Severity(SeverityLevel.NORMAL)
    public void clicoEmSignUp() {
        loginPage.loginbtnpage.click();
        captureScreenshot("Após clicar em Login");
        loginPage.clickToSignUp();
        captureScreenshot("Tela de Sign Up");
    }

    @Quando("preencho os dados")
    @Step("Preencher dados de cadastro")
    @Description("Preenche os campos de email e senha para criar uma nova conta")
    @Severity(SeverityLevel.NORMAL)
    public void preenchoOsDados(Map<String, String> map) {
        String email = map.get("email");
        String senha = map.get("senha");

        // Add parameters to report
        Allure.parameter("email", email);
        Allure.parameter("senha", "********");

        loginPage.realizarCadastro(email, senha);
        captureScreenshot("Formulário de Cadastro Preenchido");
    }

    @Entao("confirmo que a conta foi criada")
    @Step("Validar criação de conta")
    @Description("Confirma o cadastro e valida a mensagem de sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Cadastro de Usuário")
    public void confirmoQueAContaFoiCriada() {
        loginPage.clickToConfirmSignUp();
        captureScreenshot("Após confirmar cadastro");

        String signupmessage = loginPage.getTxtAndroidPopup();
        Allure.addAttachment("Mensagem de Cadastro", signupmessage);

        captureScreenshot("Popup de Sucesso no Cadastro");
        assertEquals("You successfully signed up!", signupmessage);
    }

    /**
     * Capture screenshot and attach to Allure report
     */
    private void captureScreenshot(String screenshotName) {
        try {
            if (Driver.getAppiumDriver() != null) {
                byte[] screenshot = ((TakesScreenshot) Driver.getAppiumDriver()).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(screenshotName, "image/png", new ByteArrayInputStream(screenshot), "png");
            }
        } catch (Exception e) {
            Allure.addAttachment("Screenshot Error", "Failed to capture screenshot: " + e.getMessage());
        }
    }
}