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

        wait.withMessage("Pop up dialog shouldn't be visible").
                until(ExpectedConditions.invisibilityOf(profilePage.getPleaseWaitPopUp()));
        Assert.assertEquals(profilePage.getProfileEmailInput().getAttribute("value"),
                "admin@admin.com",
                "Actual email address doesn't match expected email address");


    }

    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes () {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();
        navPage.getMyProfileBtn().click();

        wait.withMessage("Pop up dialog shouldn't be visible").
                until(ExpectedConditions.invisibilityOf(profilePage.getPleaseWaitPopUp()));

        Assert.assertEquals(profilePage.getProfileEmailInput().getAttribute("type"),
                "email",
                "Actual attribute value doesn't match expected attribute value");

        Assert.assertEquals(profilePage.getValueForAttributeDisabled(),
                "disabled",
                "Actual attribute value doesn't match expected attribute value");

        Assert.assertEquals(profilePage.getProfileNameInput().getAttribute("type"),
                "text",
                "Actual attribute value doesn't match expected attribute value");

        Assert.assertEquals(profilePage.getProfileCityInput().getAttribute("type"),
                "text",
                "Actual attribute value doesn't match expected attribute value");

        Assert.assertEquals(profilePage.getProfileCountryInput().getAttribute("type"),
                "text",
                "Actual attribute value doesn't match expected attribute value");

        Assert.assertEquals(profilePage.getProfileTwitterHubInput().getAttribute("type"),
                "url",
                "Actual attribute value doesn't match expected attribute value");

        Assert.assertEquals(profilePage.getProfileGitHubInput().getAttribute("type"),
                "url",
                "Actual attribute value doesn't match expected attribute value");

        Assert.assertEquals(profilePage.getProfilePhoneInput().getAttribute("type"),
                "tel",
                "Actual attribute value doesn't match expected attribute value");

        navPage.getLogoutBtn().click();

    }


}
