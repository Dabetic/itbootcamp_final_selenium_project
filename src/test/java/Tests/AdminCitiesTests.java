package Tests;

import Retry.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{

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
        Assert.assertEquals(baseUrl + "admin/cities",
                "https://vue-demo.daniel-avellaneda.com/admin/cities",
                "Actual URL doesn't match expected URL");
    }

    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checkInputTypesForCreateEditNewCity () {
    visitTheAdminCitiesPageAndListOfCities();
    citiesPage.getNewItem().click();
    wait.withMessage("Pop up window doesn't appear").
            until(ExpectedConditions.visibilityOf(messagePopUpPage.getNewItemNameFiled()));
    Assert.assertEquals(messagePopUpPage.getNewItemNameFiled().getAttribute("type"),
            "text",
            "Actual attribute value doesn't match expected attribute value");
    }


    @Test (priority = 3)
    public void createANewCity () {
        String city = "Milos Dabetic's City";
        visitTheAdminCitiesPageAndListOfCities();
        citiesPage.getNewItem().click();
        wait.withMessage("Pop up window doesn't appear").
                until(ExpectedConditions.visibilityOf(messagePopUpPage.getNewItemNameFiled()));
        messagePopUpPage.getNewItemNameFiled().sendKeys(city);
        messagePopUpPage.getNewItemNameFiledSaveBtn().click();

        wait.withMessage("Pop up window doesn't appear").
                until(ExpectedConditions.visibilityOf(messagePopUpPage.getPopUpSavedSuccessfully()));

        System.out.println(messagePopUpPage.getPopUpSavedSuccessfully().getText());
        System.out.println(messagePopUpPage.getPopUpSavedSuccessfully().getText().length());

        Assert.assertEquals(messagePopUpPage.getPopUpSavedSuccessfully().getText().substring(0,18),
                "Saved successfully",
                "Actual pop up message doesn't match expected pop up message");
    }



}
