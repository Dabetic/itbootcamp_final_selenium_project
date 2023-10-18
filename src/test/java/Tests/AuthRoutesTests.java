package Tests;

import Retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void forbidVisitsToHomeUrlIfNotAuthenticated () {

        driver.navigate().to(baseUrl + "home");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Current URL should be " + baseUrl + "login");
    }

    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void forbidVisitsToProfileUrlIfNotAuthenticated () {

        driver.navigate().to(baseUrl + "profile");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Current URL should be " + baseUrl + "login");
    }

    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void forbidVisitsToAdminCitiesUrlIfNotAuthenticated () {

        driver.navigate().to(baseUrl + "admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Current URL should be " + baseUrl + "login");
    }

    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void forbidVisitsToAdminUsersUrlIfNotAuthenticated () {

        driver.navigate().to(baseUrl + "admin/users");
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "login",
                "Current URL should be " + baseUrl + "login");
    }


}
