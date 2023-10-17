package Tests;

import Retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage () {
        navPage.getSignUpBtn().click();
        Assert.assertEquals(baseUrl + "signup",
                "https://vue-demo.daniel-avellaneda.com/signup",
                "Actual URL doesn't match expected URL");

    }


}
