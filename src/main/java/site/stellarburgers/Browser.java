package site.stellarburgers;

import com.codeborne.selenide.WebDriverRunner;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Browser {

    // Выбор браузера
    public final static String BROWSER = "Chrome"; // Chrome or Firefox

    public static void browserChoice()
    {
        WebDriver driver = null;

        if (BROWSER.equals("Chrome"))
        {
            // драйвер для браузера Chrome
            ChromeOptions options = new ChromeOptions();

            //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

            options.addArguments("--remote-allow-origins=*");

            var prop = System.getProperty("driver");

            if (prop != null && !prop.isEmpty())
                options.setBinary(System.getProperty("driver"));

            driver = new ChromeDriver(options);
        }
        else if (BROWSER.equals("Firefox"))
        {
            // драйвер для браузера Firefox
            FirefoxOptions options = new FirefoxOptions();

            var prop = System.getProperty("driver");

            if (prop != null && !prop.isEmpty())
                options.setBinary(System.getProperty("driver"));

            driver = new FirefoxDriver(options);
        }

        Assert.assertTrue(driver != null);

        if (driver != null)
            WebDriverRunner.setWebDriver(driver);
    }

    public static void closeBrowser()
    {
        closeWebDriver();
    }
}
