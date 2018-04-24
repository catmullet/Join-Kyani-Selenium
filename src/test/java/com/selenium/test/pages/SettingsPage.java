package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This page is a page object example.
 */
public class SettingsPage extends BasePage {

    private static final String PAGE_URL = "https://join-staging.kyani.net/settings";

    @FindBy(name = "name")
    private WebElement name_field;

    @FindBy(name = "phone")
    private WebElement phone_field;

    @FindBy(name = "email")
    private WebElement email_field;

    @FindBy(name = "country")
    private WebElement country_field;

    @FindBy(name = "sponsor")
    private WebElement sponsor_field;

    @FindBy(tagName = "button")
    private WebElement submit_button;



    public SettingsPage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return name_field.isDisplayed();
    }

    public void insertFormData() {
        name_field.sendKeys("Roberto Gonzalez");
        phone_field.sendKeys("2083882222");
        email_field.sendKeys("robertgonzalez@.rgonzalezcorp.com");
        sponsor_field.sendKeys("50");
    }

    public void insertBadEmailFormData() {
        name_field.sendKeys("Roberto Gonzalez");
        phone_field.sendKeys("2083882222");
        email_field.sendKeys("robertgonzalez");
        sponsor_field.sendKeys("50");
    }

    public void submitForm() {
        submit_button.click();
    }

    public boolean isPageSubmittedSuccessfully() {
        return getDriver().getCurrentUrl().contains("packs");
    }
}
