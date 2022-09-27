package stepDefinitions;

import chromeConnection.BrowsersConnection;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Hooks {
     ChromeOptions chromeOptions;
     FirefoxOptions firefoxOptions;
     EdgeOptions edgeOptions;
    private static BrowsersConnection connection;

    @Before(value = "@Chrome", order = 0)
    public void chromeSetUp() {
        WebDriverManager.chromedriver().setup();
        chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless");
//        chromeOptions.addArguments("disable-gpu");

        connection.DRIVER = new ChromeDriver(chromeOptions);
        maximizeWindows();
    }

    @Before(value = "Edge", order = 0)
    public void edgeSetUP() {
        WebDriverManager.edgedriver().setup();
        edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("headless");
        edgeOptions.addArguments("disable-gpu");

        connection.DRIVER = new EdgeDriver(edgeOptions);
        maximizeWindows();
    }

    @Before(value = "FireFox", order = 0)
    public void fireFoxSetUP() {
        WebDriverManager.firefoxdriver().setup();
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("headless");
        firefoxOptions.addArguments("disable-gpu");

        connection.DRIVER = new FirefoxDriver(firefoxOptions);
        maximizeWindows();
    }

    public void maximizeWindows() {
        connection.DRIVER.manage().window().maximize();
        connection.DRIVER.get(connection.BASE_URL);
    }

    @After(order = 1)
    void teardown() {
        connection.DRIVER.quit();
    }

}
