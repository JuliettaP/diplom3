package site.stellarburgers.model;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConstructorPage {

    // локатор таба "Булки"
    @FindBy(how = How.XPATH, using = "//div[span[text()='Булки']]")
    private SelenideElement BUN_TAB;

    // локатор таба "Соусы"
    @FindBy(how = How.XPATH, using = "//div[span[text()='Соусы']]")
    private SelenideElement SAUCE_TAB;

    // локатор таба "Начинки"
    @FindBy(how = How.XPATH, using = "//div[span[text()='Начинки']]")
    private SelenideElement FILLING_TAB;

    public void clickSauceTab() {
        SAUCE_TAB.click();
    }

    public void clickFillingTab() {
        FILLING_TAB.click();
    }

    public boolean checkIsBunTabSelected() {
        return BUN_TAB.getAttribute("class").contains("current");
    }

    public boolean checkIsSauceTabSelected() {
        return SAUCE_TAB.getAttribute("class").contains("current");
    }

    public boolean checkIsFillingTabSelected() {
        return FILLING_TAB.getAttribute("class").contains("current");
    }
}
