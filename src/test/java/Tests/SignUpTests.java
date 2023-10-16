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




}
