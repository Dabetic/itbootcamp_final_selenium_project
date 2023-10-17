package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getUserDoesnotExistPopUp () {
        return driver.findElement(By.cssSelector("[role='status']>ul>li"));
    }

    public WebElement getVerifyYourAccountPopUp () {
        return driver.findElement(By.cssSelector(".v-card>div.v-card__title"));
    }

    public WebElement getVerifyYourAccountCloseBtn () {
        return driver.findElement(By.cssSelector(".btnClose"));
    }


}
