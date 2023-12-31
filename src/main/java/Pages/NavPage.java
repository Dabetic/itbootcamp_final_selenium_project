package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        return driver.findElement(By.cssSelector(".btnLogout .v-btn__content"));
    }

    public WebElement getSignUpBtn () {
        return driver.findElement(By.cssSelector("[href='/signup']>span"));
    }

    public WebElement getAdminBtn () {
        return driver.findElement(By.cssSelector(".btnAdmin"));
    }

    public WebElement getCitiesBtn () {
        return driver.findElement(By.cssSelector(".v-list-item__icon .mdi-city"));
    }
    public WebElement getSelectSpanishLanguage () {
        return driver.findElement(By.cssSelector("#list-item-75"));
    }

    public WebElement getSelectFrenchLanguage () {
        return driver.findElement(By.cssSelector("#list-item-77"));
    }

    public WebElement getSelectChineseLanguage () {
        return driver.findElement(By.cssSelector("#list-item-79"));
    }

    public WebElement getHeaderOneElement () {
        return driver.findElement(By.cssSelector(".flex.xs12>h1"));
    }

    public WebElement getMyProfileBtn () {
        return driver.findElement(By.cssSelector(".btnProfile"));
    }


}
