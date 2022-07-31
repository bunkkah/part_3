package page_object_class;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import models.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {
    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]")
    private SelenideElement nameInput;

    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[2]")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//input[@type='password']")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement signupSubmit;

    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default']")
    private SelenideElement passwordHasInvalidLength;

    @FindBy(how = How.XPATH, using = ".//a[@href='/login']")
    private SelenideElement loginBtn;

    public void setName(String name) {
        nameInput.setValue(name).pressEnter();
    }

    public void setEmail(String email) {
        emailInput.setValue(email).pressEnter();
    }

    public void setPassword(String password) {
        passwordInput.setValue(password).pressEnter();
    }

    public LoginPage clickSignupSubmit() {
        signupSubmit.scrollIntoView(true);
        signupSubmit.click();
        return page(LoginPage.class);
    }

    public LoginPage signup(User user) {
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        clickSignupSubmit();
        return page(LoginPage.class);
    }

    public RegistrationPage signupWithError(User user) {
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        clickSignupSubmit();
        return this;
    }

    public boolean isPasswordErrorCorrect() {
        passwordHasInvalidLength.scrollIntoView(true);
        passwordHasInvalidLength.shouldBe(Condition.visible);
        passwordHasInvalidLength.isDisplayed();
        return passwordHasInvalidLength.getText().equals("Некорректный пароль");
    }

    public LoginPage clickLoginBtn() {
        loginBtn.scrollIntoView(true);
        loginBtn.click();
        return page(LoginPage.class);
    }
}
