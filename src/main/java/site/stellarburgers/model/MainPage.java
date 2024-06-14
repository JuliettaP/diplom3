package site.stellarburgers.model;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class MainPage extends Header {

    public final static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    // локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement SIGN_IN_BUTTON;

    // локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement CHECKOUT_BUTTON;

    @Step("Переход на страницу логина через кнопку 'Войти в аккаунт'")
    public void clickSignInButton() {
        SIGN_IN_BUTTON.click();
    }

    public boolean checkIsCheckOutButtonEnabled() {
        return CHECKOUT_BUTTON.isEnabled();
    }

    public boolean checkIsSignInButtonEnabled() {
        return SIGN_IN_BUTTON.isEnabled();
    }

}
