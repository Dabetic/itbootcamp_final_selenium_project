package Pages;

import org.openqa.selenium.By;
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


}
