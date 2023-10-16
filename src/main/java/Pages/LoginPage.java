package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public WebElement getEmailInput () {
        return driver.findElement(By.cssSelector("#email"));
    }

    public WebElement getPasswordInput () {
        return driver.findElement(By.cssSelector("#password"));
    }

    public WebElement getLoginBtn () {
        return driver.findElement(By.cssSelector("[type='submit']"));
    }

    public WebElement getUserDoesnotExistPopUp () {
        return driver.findElement(By.cssSelector("[role='status']>ul>li"));
    }


}


