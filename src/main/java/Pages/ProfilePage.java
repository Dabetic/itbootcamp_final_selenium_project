package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getProfileEmailInput () {
        return driver.findElement(By.cssSelector("#email"));
    }

    public WebElement getPleaseWaitPopUp () {
       return driver.findElement(By.cssSelector(".v-card__text"));
    }

    public String getValueForAttributeDisabled () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return arguments[0].getAttribute('disabled');", getProfileEmailInput()).toString();
    }

    public WebElement getProfileNameInput () {
        return driver.findElement(By.cssSelector("#name"));
    }

    public WebElement getProfileCityInput () {
        return driver.findElement(By.cssSelector("#city"));
    }

    public WebElement getProfileCountryInput () {
        return driver.findElement(By.cssSelector("#country"));
    }

    public WebElement getProfileTwitterHubInput () {
        return driver.findElement(By.cssSelector("#urlTwitter"));
    }

    public WebElement getProfileGitHubInput () {
        return driver.findElement(By.cssSelector("#urlGitHub"));
    }

    public WebElement getProfilePhoneInput () {
        return driver.findElement(By.cssSelector("#phone"));
    }

    public WebElement getProfileSaveBtn () {
        return driver.findElement(By.cssSelector(".btnSave"));
    }

    public WebElement getProfileBucaramangaCity () {
        return driver.findElement(By.xpath("//*[contains(text(), 'Bucaramanga')]"));
    }

}
