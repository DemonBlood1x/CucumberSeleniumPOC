package amazonPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Amazon {
    WebDriver driver;

    WebDriverWait wait;

    By searchTxtB = By.name("field-keywords");
    By searchButton = By.id("nav-search-submit-button");
    By resultView = By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']");

    public Amazon(WebDriver driver) {

        this.driver = driver;
    }

    public void setSearchTxtB(String strSearch) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(searchTxtB).sendKeys(strSearch);
        wait.until(ExpectedConditions.elementToBeClickable(searchTxtB));
    }

    public void setSearchButton() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(searchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
    }

    public void setResultView() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(resultView);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultView));
    }

    public void sendAmazonTask(String strSearch) {
        this.setSearchTxtB(strSearch);
        this.setSearchButton();
        this.setResultView();
    }
}
