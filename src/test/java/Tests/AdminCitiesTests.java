package Tests;

import Retry.RetryAnalyzer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitTheAdminCitiesPageAndListOfCities () {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();
        navPage.getAdminBtn().click();
        navPage.getCitiesBtn().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "admin/cities",
                "Actual URL doesn't match expected URL");

        navPage.getLogoutBtn().click();

    }

    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checkInputTypesForCreateEditNewCity () {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();
        navPage.getAdminBtn().click();
        navPage.getCitiesBtn().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "admin/cities",
                "Actual URL doesn't match expected URL");

        citiesPage.getNewItem().click();
        wait.withMessage("Pop up window doesn't appear").
            until(ExpectedConditions.visibilityOf(messagePopUpPage.getNewItemNameFiled()));

        Assert.assertEquals(messagePopUpPage.getNewItemNameFiled().getAttribute("type"),
            "text",
            "Actual attribute value doesn't match expected attribute value");

        messagePopUpPage.getNewItemPopUpCancelBtn().click();
        wait.withMessage("Pop up window is visible").
                until(ExpectedConditions.invisibilityOf(messagePopUpPage.getNewItemNameFiled()));

        navPage.getLogoutBtn().click();

    }

    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void createANewCity () {
        String city = "Milos Dabetic's City";
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();
        navPage.getAdminBtn().click();
        navPage.getCitiesBtn().click();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "admin/cities",
                "Actual URL doesn't match expected URL");

        citiesPage.getNewItem().click();
        wait.withMessage("Pop up window doesn't appear").
                until(ExpectedConditions.visibilityOf(messagePopUpPage.getNewItemNameFiled()));
        messagePopUpPage.getNewItemNameFiled().sendKeys(city);
        messagePopUpPage.getNewItemNameFiledSaveBtn().click();

        wait.withMessage("Pop up window doesn't appear").
                until(ExpectedConditions.visibilityOf(messagePopUpPage.getPopUpSavedSuccessfully()));

        Assert.assertEquals(messagePopUpPage.getPopUpSavedSuccessfully().getText().substring(0,18),
                "Saved successfully",
                "Actual pop up message doesn't match expected pop up message");

        navPage.getLogoutBtn().click();
    }


    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void editACity () {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();
        navPage.getAdminBtn().click();

        navPage.getCitiesBtn().click();
        citiesPage.getSearchCityBtn().sendKeys("Milos Dabetic's City");
        citiesPage.waitUntilTableRowSizeIs(1);

        citiesPage.getEditCityBtn().click();
        messagePopUpPage.getEditACityNameInputPopUp().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        messagePopUpPage.getEditACityNameInputPopUp().sendKeys("Edited Milos Dabetic's City");
        messagePopUpPage.getEditACityNamePopUpSaveBtm().click();

        wait.withMessage("Pop up window doesn't appear").
                until(ExpectedConditions.visibilityOf(messagePopUpPage.getPopUpSavedSuccessfully()));

        Assert.assertEquals(messagePopUpPage.getPopUpSavedSuccessfully().getText().substring(0,18),
                "Saved successfully",
                "Actual pop up message doesn't match expected pop up message");

        navPage.getLogoutBtn().click();
    }


    @Test (priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void searchACity () {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();
        navPage.getAdminBtn().click();
        navPage.getCitiesBtn().click();

        citiesPage.getSearchCityBtn().sendKeys("Milos Dabetic's City");

        citiesPage.waitUntilTableRowSizeIs(1);

        Assert.assertTrue(citiesPage.isContainsMilosCityTxt());

        navPage.getLogoutBtn().click();

    }


    @Test (priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void deleteACity () {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginBtn().click();
        loginPage.getEmailInput().clear();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginBtn().click();
        navPage.getAdminBtn().click();
        navPage.getCitiesBtn().click();

        citiesPage.getSearchCityBtn().sendKeys("Milos Dabetic's City");

        citiesPage.waitUntilTableRowSizeIs(1);

        Assert.assertTrue(citiesPage.isContainsMilosCityTxt());

        citiesPage.deleteAnAdminCityRow(1).click();
        wait.withMessage("Pop up window doesn't appear").
                until(ExpectedConditions.visibilityOf(messagePopUpPage.getDeletePopUp()));

        messagePopUpPage.getDeletePopUpBtn().click();
        wait.withMessage("Pop up window doesn't appear").
                until(ExpectedConditions.visibilityOf
                        (messagePopUpPage.getSuccesfullyDeletedPopUp()));

        Assert.assertEquals(messagePopUpPage.getSuccesfullyDeletedPopUp()
                        .getText().substring(0,20),
                "Deleted successfully",
                "Actual pop up message doesn't match expected pop up message");

        navPage.getLogoutBtn().click();

    }
}
