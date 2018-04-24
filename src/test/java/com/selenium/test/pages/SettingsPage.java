package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(name = "placement")
    private WebElement placement_field;

    @FindBy(className = "layout__collapse-text")
    private WebElement viewmore_button;

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

    public void insertFormData(String name, String phone, String email, String sponsor, String placement) {
        name_field.sendKeys(name);
        phone_field.sendKeys(phone);
        email_field.sendKeys(email);
        sponsor_field.sendKeys(sponsor);
        viewmore_button.click();
        placement_field.sendKeys(placement);
    }

    public void submitForm() {
        submit_button.click();
    }

    public boolean isPageSubmittedSuccessfully() {
        return getDriver().getCurrentUrl().contains("packs");
    }
}
