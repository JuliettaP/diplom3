package site.stellarburgers.model;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage extends Header {

    // локатор поля ввода имени
    @FindBy(how = How.XPATH, using = "//div[label[text()='Имя']]/input")
    private SelenideElement NAME_INPUT_FIELD;

    // локатор поля ввода email
    @FindBy(how = How.XPATH, using = "//div[label[text()='Email']]/input")
    private SelenideElement EMAIL_INPUT_FIELD;

    // локатор поля ввода пароля
    @FindBy(how = How.XPATH, using = "//input[@name='Пароль']")
    private SelenideElement PASSWORD_INPUT_FIELD;

    // локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement REGISTER_BUTTON;

    // локатор текста ошибки "Некорректный пароль"
    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private SelenideElement INCORRECT_PASSWORD_TEXT;

    // локатор ссылки "Войти"
    @FindBy(how = How.XPATH, using = "//a[@href='/account']")
    private SelenideElement SIGN_IN_LINK;


    public void setName(String name) {
        NAME_INPUT_FIELD.setValue(name);
    }

    public void setEmail(String email) {
        EMAIL_INPUT_FIELD.setValue(email);
    }

    public void setPassword(String password) {
        PASSWORD_INPUT_FIELD.setValue(password);
    }

    public void clickRegisterButton() {
        REGISTER_BUTTON.click();
    }
    @Step("Регистрация пользователя")
    public void register(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }

    public boolean checkIsIncorrectPasswordTextVisible() {
        return INCORRECT_PASSWORD_TEXT.isDisplayed();
    }

    @Step("Переход на страницу логина через ссылку 'Войти'")
    public void clickSignInLink() {
        SIGN_IN_LINK.click();
    }
}
