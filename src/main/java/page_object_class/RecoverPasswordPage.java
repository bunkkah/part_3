package page_object_class;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RecoverPasswordPage {

    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    private SelenideElement loginBtn;

    public LoginPage clickLoginBtn() {
        loginBtn.scrollIntoView(true);
        loginBtn.click();
        return page(LoginPage.class);
    }
}
