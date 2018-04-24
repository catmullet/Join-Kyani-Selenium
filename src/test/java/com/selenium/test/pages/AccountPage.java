package com.selenium.test.pages;

import com.selenium.test.utils.NumberUtils;
import com.selenium.test.utils.TimeUtils;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class AccountPage extends BasePage {

    private static final String PAGE_URL = "https://join-staging.kyani.net/account";

    @FindBy(className = "main-header")
    private WebElement header;

    @FindBy(className = "main-content")
    private WebElement content;

    @FindBy(className = "main-footer")
    private WebElement footer;

    @FindBy(tagName = "form")
    private WebElement form;

    @FindBy(className = "display")
    private WebElement totalBox;

    @FindBy(name = "account[firstName]")
    private WebElement firstname;

    @FindBy(name = "account[lastName]")
    private WebElement lastname;

    public AccountPage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
        SettingsPage sp = new SettingsPage();
        sp.insertFormData("Roberto Gonzalez", "2034852345", "robertogonzalez@test.com","50","");
        sp.submitForm();
        PacksPage pp = new PacksPage();
        pp.selectPackByIndex(0);
        pp.selectLanguageByIndex(0);
        pp.addRandomAddonItems(2);
        pp.submitForm();
    }

    @Override
    public boolean isPageOpened() {
        return firstname.isDisplayed();
    }

    public void insertFormData(String firstname, String lastname, String birth_day, String birth_month, String birth_year,
                               boolean isCompany, String companyName, String ssn, String replicated, String photoFilePath,
                               String password, String passwordConfirm, String email, String cell, String home,
                               String work, String shippingName, String address1, String address2, String city,
                               String state, String postal, boolean terms) {
        
    }

    public String getTotal() {
        return totalBox.findElement(By.tagName("span")).getText();
    }

    public void submitForm() {
        footer.findElements(By.tagName("a")).get(3).click();
    }

    public void goBack() {
        footer.findElements(By.tagName("a")).get(2).click();
    }

    public boolean isPageSubmittedSuccessfully() {
        return getDriver().getCurrentUrl().contains("account");
    }
}
