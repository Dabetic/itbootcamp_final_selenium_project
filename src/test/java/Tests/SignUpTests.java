package Tests;

import Retry.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest {

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitTheSignupPage () {
        navPage.getSignUpBtn().click();
        Assert.assertEquals(baseUrl + "signup",
                "https://vue-demo.daniel-avellaneda.com/signup",
                "Actual URL doesn't match expected URL");
    }

    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checkInputTypes () {
        navPage.getSignUpBtn().click();
        Assert.assertEquals(signUpPage.getEmailInput().getAttribute("type"),
                "email",
                "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals(signUpPage.getPasswordInput().getAttribute("type"),
                "password",
                "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals(signUpPage.getConfirmPasswordInput().getAttribute("type"),
                "password",
                "Actual attribute value doesn't match expected attribute value");
    }

    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displayErrorsWhenUserAlreadyExists () {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.getSignUpBtn().click();
        Assert.assertEquals(baseUrl + "signup",
                "https://vue-demo.daniel-avellaneda.com/signup",
                "Actual URL doesn't match expected URL");
        signUpPage.getNameInput().sendKeys(name);
        signUpPage.getEmailInput().sendKeys(email);
        signUpPage.getPasswordInput().sendKeys(password);
        signUpPage.getConfirmPasswordInput().sendKeys(confirmPassword);
        signUpPage.getSignMeUpBtn().click();
        wait.withMessage("Pop up window doesn't appear").
                until(ExpectedConditions.visibilityOf(messagePopUpPage.getUserDoesnotExistPopUp()));
        Assert.assertEquals(messagePopUpPage.getUserDoesnotExistPopUp().getText(),
                "E-mail already exists",
                "Actual pop up message doesn't match expected pop up message");
        Assert.assertEquals(baseUrl + "signup",
                "https://vue-demo.daniel-avellaneda.com/signup",
                "Actual URL doesn't match expected URL");
    }

@Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void verifySignUp () {
    String name = "Milos Dabetic";
    String email = "m.dabetic@itbootcamp.rs";
    String password = "12345";
    String confirmPassword = "12345";
    navPage.getSignUpBtn().click();
    signUpPage.getNameInput().sendKeys(name);
    signUpPage.getEmailInput().sendKeys(email);
    signUpPage.getPasswordInput().sendKeys(password);
    signUpPage.getConfirmPasswordInput().sendKeys(confirmPassword);
    signUpPage.getSignMeUpBtn().click();
    wait.until(ExpectedConditions.urlContains("home"));

    wait.withMessage("Pop up window isn't visible").until(ExpectedConditions.visibilityOf(messagePopUpPage.getVerifyYourAccountPopUp()));

    Assert.assertEquals(messagePopUpPage.getVerifyYourAccountPopUp().getText(),
            "IMPORTANT: Verify your account",
            "Actual pop up message doesn't match expected pop up message");

    messagePopUpPage.getVerifyYourAccountCloseBtn();

}


}
