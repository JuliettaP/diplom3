package site.stellarburgers.model;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Objects;

public class LoginPage extends Header {

    public final static String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    // локатор ссылки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//a[text()='Зарегистрироваться']")
    private SelenideElement REGISTER_LINK;

    // локатор поля ввода email
    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    private SelenideElement EMAIL_INPUT_FIELD;

    // локатор поля ввода пароля
    @FindBy(how = How.XPATH, using = "//input[@name='Пароль']")
    private SelenideElement PASSWORD_INPUT_FIELD;

    // локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement SIGN_IN_BUTTON;

    // локатор ссылки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = "//a[text()='Восстановить пароль']")
    private SelenideElement PASSWORD_RECOVERY_LINK;

    public void clickRegisterLink() {
        REGISTER_LINK.click();
    }

    public void setEmail(String email) {
        // баг с анимацией
        while (!Objects.equals(EMAIL_INPUT_FIELD.getValue(), email)) {
            EMAIL_INPUT_FIELD.shouldBe(Condition.editable).setValue(email);
        }
    }

    public void setPassword(String password) {
        PASSWORD_INPUT_FIELD.setValue(password);
    }

    public void clickSignInButton() {
        SIGN_IN_BUTTON.click();
    }

    @Step("Логин пользователя")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickSignInButton();
    }

    @Step("Переход на страницу восстановления пароля")
    public void clickPasswordRecoveryLink() {
        PASSWORD_RECOVERY_LINK.click();
    }

}
