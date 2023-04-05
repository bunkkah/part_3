import clients.UserClient;
import jdk.jfr.Description;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BrowserStarter {
    User user;
    UserClient userClient;
    String accessToken;

    @Before
    public void setUp() {
        userClient = new UserClient();
        user = User.getRandom();
        accessToken = userClient.createUser(user);
    }

    @After
    public void deleteUser() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }

    //вход по кнопке «Войти в аккаунт» на главной
    @Test
    @Description("Login via the 'Log in to account' button")
    public void successfulLoginViaLoginToAccountButton() {
        // нажать кнопку Войти в аккаунт
        // ввести почту и пароль
        // нажать кнопку входа

        final boolean isLoginCompletedViaLogInToAccount = mainPage
                .clickLogInToYourAccountBtn()
                .login(user.getEmail(), user.getPassword())
                .isUrlCorrectAfterLogin();
        assertTrue("Аутентификация через кнопку 'Войти в аккаунт' пользователя завершилась ошибкой", isLoginCompletedViaLogInToAccount);
    }

    //вход через кнопку «Личный кабинет»
    @Test
    @Description("Login via the 'Personal account' button")
    public void successfulLoginViaPersonalAccountButton() {
        // нажать кнопку Личный кабинет
        // ввести почту и пароль
        // нажать кнопку входа
        // проверить url страницы после аутентификации

        final boolean isLoginCompletedViaPersonalAccount = mainPage
                .clickPersonalAccountBtn()
                .login(user.getEmail(), user.getPassword())
                .isUrlCorrectAfterLogin();
        assertTrue("Аутентификация через личный кабинет пользователя завершилась ошибкой", isLoginCompletedViaPersonalAccount);
    }

    //вход через кнопку в форме регистрации
    @Test
    @Description("Login via the 'Sign up page' button")
    public void successfulLoginViaSignUpPageButton() {
        // нажать кнопку Личный кабинет
        // перейти на форму регистрации
        // нажать кнопку Войти
        // ввести почту и пароль
        // нажать кнопку входа
        // проверить url страницы после аутентификации

        final boolean isLoginCompletedViaSignPage = mainPage
                .clickPersonalAccountBtn()
                .clickSignupBtn()
                .clickLoginBtn()
                .login(user.getEmail(), user.getPassword())
                .isUrlCorrectAfterLogin();
        assertTrue("Аутентификация со страницы регистрации пользователя завершилась ошибкой", isLoginCompletedViaSignPage);
    }

    //вход через кнопку в форме восстановления пароля
    @Test
    @Description("Login via the 'Recover password' button")
    public void successfulLoginViaRecoverPasswordPageButton() {
        // нажать кнопку Личный кабинет
        // перейти на форму восстановления пароля
        // нажать кнопку Войти
        // ввести почту и пароль
        // нажать кнопку входа
        // проверить url страницы после аутентификации

        final boolean isLoginCompletedViaRecoverPasswordPage = mainPage
                .clickPersonalAccountBtn()
                .clickRecoverPasswordBtn()
                .clickLoginBtn()
                .login(user.getEmail(), user.getPassword())
                .isUrlCorrectAfterLogin();
        assertTrue("Аутентификация со страницы восстановления пароля завершилась ошибкой", isLoginCompletedViaRecoverPasswordPage);
    }
}
