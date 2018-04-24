package com.selenium.test.junit.tests.SettingsPage;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.pages.SettingsPage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BadEmailTest {

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @Test
    public void testBadEmailAddress() {
        SettingsPage settingsPage = new SettingsPage();
        settingsPage.insertFormData("Roberto Gonzalez", "2034852345", "robertogonzalez","50","");
        settingsPage.submitForm();
        assertTrue("Didn't catch bad data", !settingsPage.isPageSubmittedSuccessfully());
    }

    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}
