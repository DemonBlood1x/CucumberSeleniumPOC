package chromeConnection;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowsersConnection {

    final String CHROME = "chrome";
    final String FIREFOX = "firefox";
    final String EDGE = "edge";
    final private String URL = "https://www.amazon.com/-/es/";
    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;
    EdgeOptions edgeOptions;
    WebDriver driver;

    @BeforeEach
    public WebDriver setup(String browser) {
        if (browser.equalsIgnoreCase(CHROME)) {
            WebDriverManager.chromedriver().setup();
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("headless");
            chromeOptions.addArguments("disable-gpu");

            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.get(URL);

        } else if (browser.equalsIgnoreCase(FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("headless");
            firefoxOptions.addArguments("disable-gpu");

            driver = new FirefoxDriver(firefoxOptions);
            driver.manage().window().maximize();
            driver.get(URL);

        } else if (browser.equalsIgnoreCase(EDGE)) {
            WebDriverManager.edgedriver().setup();
            edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("headless");
            edgeOptions.addArguments("disable-gpu");

            driver = new EdgeDriver(edgeOptions);
            driver.manage().window().maximize();
            driver.get(URL);

        } else {
            try {
                //If no browser is passed throw exception
                throw new Exception("Incorrect Browser");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return driver;
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

}
