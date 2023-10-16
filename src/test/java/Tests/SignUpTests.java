package Tests;

import Retry.RetryAnalyzer;
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
        Assert.assertEquals( signUpPage.getEmailInput().getAttribute("type"),"email",
                "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals( signUpPage.getPasswordInput().getAttribute("type"), "password",
                "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals( signUpPage.getConfirmPasswordInput().getAttribute("type"), "password",
                "Actual attribute value doesn't match expected attribute value");
    }




}
