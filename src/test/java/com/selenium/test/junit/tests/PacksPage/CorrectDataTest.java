package com.selenium.test.junit.tests.PacksPage;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.pages.PacksPage;
import com.selenium.test.pages.SettingsPage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CorrectDataTest {

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @Test
    public void testCorrectFormData() {
        PacksPage packsPage = new PacksPage();
        packsPage.selectPackByIndex(0);
        packsPage.selectLanguageByIndex(0);
        packsPage.addRandomAddonItems(2);
        packsPage.submitForm();
        assertTrue("Wasn't able to get past settings page with correct info", packsPage.isPageSubmittedSuccessfully());
    }

    /*@After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }*/
}
