package site.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import junitparams.JUnitParamsRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import site.stellarburgers.model.ConstructorPage;
import site.stellarburgers.model.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static site.stellarburgers.Browser.browserChoice;
import static site.stellarburgers.Browser.closeBrowser;

@RunWith(JUnitParamsRunner.class)
@DisplayName("Вкладки конструктора")
public class SectionsTest {

    MainPage mainPage;
    ConstructorPage constructorPage;

    @BeforeClass
    public static void beforeAll() {
        browserChoice();
    }

    @Before
    public void setUp() {
        mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
        constructorPage = page(ConstructorPage.class);
    }

    @After
    public void tearDown(){
        clearBrowserLocalStorage();
    }

    @AfterClass
    public static void afterAll() {
        closeBrowser();
    }

    @Test
    public void bunTabValidWorking() {
        // поскольку сразу после прогрузки страницы владка Булки некликабельна (выделена по умолчанию),
        // то мы сначала переходим на вкладку Соусы, а с нее уже тестируем переход на вкладку Булки
        constructorPage.clickSauceTab();
        constructorPage.clickBunTab();
        Assert.assertTrue(constructorPage.checkIsBunTabSelected());
    }

    @Test
    public void sauceTabValidWorking() {
        constructorPage.clickSauceTab();
        Assert.assertTrue(constructorPage.checkIsSauceTabSelected());
    }

    @Test
    public void fillingTabValidWorking() {
        constructorPage.clickFillingTab();
        Assert.assertTrue(constructorPage.checkIsFillingTabSelected());
    }
}
