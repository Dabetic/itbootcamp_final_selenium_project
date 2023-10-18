package Tests;

import Retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEs () {
        navPage.getLanguageBtn().click();
        navPage.getSelectSpanishLanguage().click();
        Assert.assertEquals(navPage.getHeaderOneElement().getText(),
                "Página de aterrizaje",
                "Actual header text doesn't match expected header text");
    }

    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEn () {
        navPage.getLanguageBtn().click();
        navPage.getSelectEnglishLanguage().click();
        Assert.assertEquals(navPage.getHeaderOneElement().getText(),
                "Landing",
                "Actual header text doesn't match expected header text");
    }

    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToCn () {
        navPage.getLanguageBtn().click();
        navPage.getSelectChineseLanguage().click();
        Assert.assertEquals(navPage.getHeaderOneElement().getText(),
                "首页",
                "Actual header text doesn't match expected header text");
    }

    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToFr () {
        navPage.getLanguageBtn().click();
        navPage.getSelectFrenchLanguage().click();
        Assert.assertEquals(navPage.getHeaderOneElement().getText(),
                "Page d'atterrissage",
                "Actual header text doesn't match expected header text");
    }


}
