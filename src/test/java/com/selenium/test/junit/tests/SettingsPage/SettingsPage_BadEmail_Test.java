package com.selenium.test.junit.tests.SettingsPage;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.pages.SettingsPage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sidelnikov Mikhail on 19.09.14.
 * Uses JUnit test framework
 * Test demonstrates work with Page Object Pattern(https://code.google.com/p/selenium/wiki/PageObjects)
 */
public class SettingsPage_BadEmail_Test {

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @Test
    public void testBadEmailAddress() {
        SettingsPage settingsPage = new SettingsPage();
        settingsPage.insertBadEmailFormData();
        settingsPage.submitForm();
        assertTrue("Didn't catch bad data", !settingsPage.isPageSubmittedSuccessfully());
    }

    @After
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}
