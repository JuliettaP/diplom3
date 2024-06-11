package site.stellarburgers.model;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountPage {

    // локатор кнопки "Выйти"
    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement SIGN_OUT_BUTTON;



    @Step("Выход из аккаунта")
    public void clickSignOutButton() {
        SIGN_OUT_BUTTON.click();
    }

}
