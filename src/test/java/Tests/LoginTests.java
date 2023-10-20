package Tests;

import Retry.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitTheLoginPage () {
    navPage.getLanguageBtn().click();
    navPage.getSelectEnglishLanguage().click();
    navPage.getLoginBtn().click();
    Assert.assertEquals(driver.getCurrentUrl(),
            baseUrl + "login",
            "Actual URL doesn't match expected URL");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checkInputTypes () {
        navPage.getLoginBtn().click();
       Assert.assertEquals( loginPage.getEmailInput().getAttribute("type"),"email",
               "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals( loginPage.getPasswordInput().getAttribute("type"), "password",
                "Actual attribute value doesn't match expected attribute value");
    }

    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist () {
        String email = "non-existing-user@gmal.com";
        String password = "password123";
        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();
        wait.withMessage("Pop up message isn't visible").
                until(ExpectedConditions.visibilityOf(messagePopUpPage.getUserDoesnotExistPopUp()));
        Assert.assertEquals(messagePopUpPage.getUserDoesnotExistPopUp().getText(),
                "User does not exists",
                "Actual pop up message doesn't match expected pop up message");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Actual URL doesn't match expected URL");
    }

    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void displayErrorsWhenPasswordIsWrong () {
        String email = "admin@admin.com";
        String password = "password123";
        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();


        wait.withMessage("Pop up dialog shouldn't be visible").
                until(ExpectedConditions.invisibilityOf(profilePage.getPleaseWaitPopUp()));

        Assert.assertEquals(messagePopUpPage.getUserDoesnotExistPopUp().getText(),
                "Wrong password",
                "Actual pop up message doesn't match expected pop up message");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Actual URL doesn't match expected URL");

    }

    @Test (priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void verifyLogin () {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();

        wait.withMessage("Pop up dialog shouldn't be visible").
                until(ExpectedConditions.invisibilityOf(profilePage.getPleaseWaitPopUp()));

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "home",
                "Actual URL doesn't match expected URL");
    }

    @Test (priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void verifyLogout () {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();

        wait.withMessage("Pop up dialog shouldn't be visible").
                until(ExpectedConditions.invisibilityOf(profilePage.getPleaseWaitPopUp()));

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "home",
                "Actual URL doesn't match expected URL");
        Assert.assertTrue(navPage.getLogoutBtn().isDisplayed());
        navPage.getLogoutBtn().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Actual URL doesn't match expected URL");
    }


}
