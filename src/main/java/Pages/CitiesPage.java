package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CitiesPage extends BasicPage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItem () {
        return driver.findElement(By.cssSelector(".btnNewItem"));
    }

    public WebElement getSearchCityBtn () {
        return driver.findElement(By.cssSelector("#search"));
    }

    public List<WebElement> getCitiesTrNumber () {
        return driver.findElements(By.cssSelector("tbody tr"));
    }

    public WebElement getEditCityBtn () {
        return driver.findElement(By.cssSelector("#edit"));
    }

    public void waitUntilTrSizeIsOne () {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody tr"),1));
    }

}
