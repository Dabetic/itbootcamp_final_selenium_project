package Tests;

import Retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void verifyEnglishLanguageOption () {
    navPage.getLanguageBtn().click();
    navPage.getSelectEnglishLanguage().click();
    navPage.getLoginBtn().click();
    Assert.assertEquals(baseUrl + "login",
            "https://vue-demo.daniel-avellaneda.com/login",
            "Actual URL doesn't match expected URL");
    }

}
