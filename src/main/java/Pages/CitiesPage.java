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

    public void waitUntilTableRowSizeIs(int numberOfRows) {
        wait.withMessage("Actual number of elements doesn't match expected number of elements")
                .until(ExpectedConditions.numberOfElementsToBe
                        (By.cssSelector("tbody .text-start"),numberOfRows));

    }

    public String tableDataNameFromTr () {
        List<WebElement>tableRowElements = getCitiesTrNumber();
        String cityName = null;
        for (int i = 0; i < tableRowElements.size(); i++) {
            cityName = tableRowElements.get(i).findElement(By.cssSelector("tbody tr td:nth-child(2)")).getText();
        }
        return cityName;
    }

    public WebElement deleteAnAdminCityRow(int numberOfRow) {
        List<WebElement>deleteTableRowButtonList = getCitiesTrNumber();
        WebElement deleteBtn = null;
        for (int i = 0; i < deleteTableRowButtonList.size(); i++) {
            deleteBtn = deleteTableRowButtonList.get(i).findElement(By.cssSelector(":nth-child(" + (numberOfRow) + ") .text-start div #delete"));
        }
        return deleteBtn;
    }


    public boolean isContainsMilosCityTxt () {
      return tableDataNameFromTr().contains("Milos Dabetic's City");
    }



}
