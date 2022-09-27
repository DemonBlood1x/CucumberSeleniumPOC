package amazonPOM;

import chromeConnection.BrowsersConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Amazon {
    private BrowsersConnection connection;
    WebDriverWait wait;
    By searchTxtB = By.name("field-keywords");
    By searchButton = By.id("nav-search-submit-button");
    By resultView = By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']");

    public void setSearchTxtB(String strSearch) {
        wait = new WebDriverWait(connection.DRIVER, Duration.ofSeconds(10));
        connection.DRIVER.findElement(searchTxtB).sendKeys(strSearch);
        wait.until(ExpectedConditions.elementToBeClickable(searchTxtB));
    }

    public void setSearchButton() {
        wait = new WebDriverWait(connection.DRIVER, Duration.ofSeconds(10));
        connection.DRIVER.findElement(searchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
    }

    public void setResultView() {
        wait = new WebDriverWait(connection.DRIVER, Duration.ofSeconds(10));
        connection.DRIVER.findElement(resultView);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultView));
    }

    public void sendAmazonTask(String strSearch) {
        this.setSearchTxtB(strSearch);
        this.setSearchButton();
        this.setResultView();
    }
}
