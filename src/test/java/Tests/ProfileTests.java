package Tests;

import Retry.RetryAnalyzer;
import org.openqa.selenium.Keys;
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

        navPage.getLogoutBtn().click();


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

    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void editAProfile () {

        String email = "admin@admin.com";
        String password = "12345";
        String name = "Milos Dabetic";
        String phone = "+38161283223";
        String country = "Spain";
        String twitter = "https://twitter.com/profile/milos1232";
        String gitHub = "https://github.polaznik.com";

        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();
        navPage.getMyProfileBtn().click();

        wait.withMessage("Pop up dialog shouldn't be visible").
                until(ExpectedConditions.invisibilityOf(profilePage.getPleaseWaitPopUp()));

        profilePage.getProfileNameInput().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        profilePage.getProfileNameInput().sendKeys(name);

        profilePage.getProfilePhoneInput().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        profilePage.getProfilePhoneInput().sendKeys(phone);

        profilePage.getProfileCityInput().click();
        profilePage.getProfileBucaramangaCity().click();

        profilePage.getProfileCountryInput().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        profilePage.getProfileCountryInput().sendKeys(country);

        profilePage.getProfileTwitterHubInput().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        profilePage.getProfileTwitterHubInput().sendKeys(twitter);

        profilePage.getProfileGitHubInput().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        profilePage.getProfileGitHubInput().sendKeys(gitHub);

        profilePage.getProfileSaveBtn().click();

        wait.withMessage("Pop up dialog should be visible").
                until(ExpectedConditions.visibilityOf(messagePopUpPage.getPopUpSavedSuccessfully()));

        Assert.assertEquals(messagePopUpPage.getProfileSavedSuccessfulyPopUp().getText().substring(0,25),
                "Profile saved successfuly",
                "Actual pop up message doesn't match expected pop up message");

        Assert.assertEquals(profilePage.getProfileNameInput().getAttribute("value"),
                "Milos Dabetic",
                "Actual filed value doesn't match expected field value");

        Assert.assertEquals(profilePage.getProfilePhoneInput().getAttribute("value"),
                "+38161283223",
                "Actual field value doesn't match expected field value");

        Assert.assertEquals(profilePage.getProfileCityInput().getAttribute("value"),
                "Bucaramanga",
                "Actual field value doesn't match expected field value");

        Assert.assertEquals(profilePage.getProfileCountryInput().getAttribute("value"),
                "Spain",
                "Actual field value doesn't match expected field value");

        Assert.assertEquals(profilePage.getProfileTwitterHubInput().getAttribute("value"),
                "https://twitter.com/profile/milos1232",
                "Actual field value doesn't match expected field value");

        Assert.assertEquals(profilePage.getProfileGitHubInput().getAttribute("value"),
                "https://github.polaznik.com",
                "Actual field value doesn't match expected field value");

        navPage.getLogoutBtn().click();

    }


}
