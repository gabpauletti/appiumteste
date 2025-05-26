package maps;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginMaps {

    @AndroidFindBy(accessibility = "input-email")
    public WebElement inpEmail;

    @AndroidFindBy(accessibility = "input-password")
    public WebElement inpPassword;

    @AndroidFindBy(accessibility = "button-LOGIN")
    public WebElement btnLogin;

    @AndroidFindBy(id = "android:id/message")
    public WebElement txtAndroidPopup;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Please enter a valid email address\"]")
    public WebElement txtAuthEmailError;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Please enter at least 8 characters\"]")
    public WebElement txtAuthPasswordError;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Login\"]")
    public WebElement loginbtnpage;

    @AndroidFindBy(accessibility = "input-repeat-password")
    public WebElement inpConfirmPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign up\"]")
    public WebElement btnSignUp;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup\n")
    public WebElement btnConfirmSignUp;

}
