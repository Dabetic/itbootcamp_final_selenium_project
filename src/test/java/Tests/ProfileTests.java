package Tests;

import Retry.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest{

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheProfilePage () {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();
        navPage.getMyProfileBtn().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "profile",
                "Current URL should be " + baseUrl + "profile");

        wait.withMessage("Pop up dialog should be invisible").until(ExpectedConditions.invisibilityOf(profilePage.getPleaseWaitPopUp()));
        Assert.assertEquals(profilePage.getProfileEmailInput().getAttribute("value"),
                "admin@admin.com", "not");


    }



}
