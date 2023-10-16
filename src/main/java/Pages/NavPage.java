package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLanguageBtn () {
        return driver.findElement(By.cssSelector(".btnLocaleActivation"));
    }

    public WebElement getSelectEnglishLanguage () {
        return driver.findElement(By.cssSelector("#list-item-73"));
    }

    public WebElement getLoginBtn () {
        return driver.findElement(By.cssSelector("[href='/login'] > .v-btn__content"));
    }

    public WebElement getLogoutBtn () {
        return driver.findElement(By.cssSelector(".btnAdmin"));
    }

    public WebElement getSignUpBtn () {
        return driver.findElement(By.cssSelector("[href='/signup'].btnLogin"));
    }

}
