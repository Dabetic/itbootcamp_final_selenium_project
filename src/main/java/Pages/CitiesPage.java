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
        wait.withMessage("Actual number of elements doesn't match expected number of elements")
                .until(ExpectedConditions.numberOfElementsToBe
                        (By.cssSelector("tbody tr .text-left:nth-child(2)"),1));
    }

    public String tableDataNameFromTr () {
        List<WebElement>tableRowElements = getCitiesTrNumber();
        String cityName = null;
        for (int i = 0; i < tableRowElements.size(); i++) {
            cityName = tableRowElements.get(i).findElement(By.cssSelector(".text-left:nth-child(2)")).getText();
        }
        return cityName;
    }

    public WebElement getDeleteCityBtn () {
        return driver.findElement(By.cssSelector("#delete"));
    }

    public boolean isContainsMilosCityTxt () {
      return tableDataNameFromTr().contains("Milos Dabetic's City");
    }



}
