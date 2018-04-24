package com.selenium.test.pages;

import com.selenium.test.utils.NumberUtils;
import com.selenium.test.utils.TimeUtils;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PacksPage extends BasePage {

    private static final String PAGE_URL = "https://join-staging.kyani.net/settings";

    @FindBy(className = "columns")
    private WebElement columns;

    @FindBy(className = "main-footer")
    private WebElement footer;

    @FindBy(className = "display")
    private WebElement totalBox;

    @FindBy(xpath = "//div[@class='columns is-multiline content']")
    private WebElement packs_component;

    @FindBy(className = "modal-card-body")
    private WebElement packsLanguage_modal;


    public PacksPage() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
        SettingsPage sp = new SettingsPage();
        sp.insertFormData("Roberto Gonzalez", "2034852345", "robertogonzalez@test.com","50","");
        sp.submitForm();
    }

    @Override
    public boolean isPageOpened() {
        List<WebElement> packs = packs_component.findElements(By.tagName("button"));
        return packs.size() > 0;
    }

    public void selectPackAtRandom() {
        List<WebElement> packs = packs_component.findElements(By.tagName("button"));
        int index = NumberUtils.getRandomNumberForList(packs);
        WebElement pack = packs.get(index);
        WebElement packSelectButton = pack.findElement(By.tagName("button"));
        packSelectButton.click();
    }

    public void selectPackByIndex(int index) {
        List<WebElement> packs = packs_component.findElements(By.tagName("button"));
        WebElement pack = packs.get(index);
        pack.click();
    }

    public void selectLanguageAtRandom() {

        WebElement language_dropdown = packsLanguage_modal.findElement(By.className("value"));
        language_dropdown.click();

        WebElement options = packsLanguage_modal.findElement(By.className("options"));

        List<WebElement> language_options = options.findElements(By.tagName("li"));

        int index = NumberUtils.getRandomNumberForList(language_options);

        WebElement language = language_options.get(index);
        language.click();

        TimeUtils.waitForSeconds(1);

        List<WebElement> languageModalButtons_button = packsLanguage_modal.findElements(By.tagName("a"));
        languageModalButtons_button.get(2).click();
    }

    public void selectLanguageByIndex(int index) {
        WebElement language_dropdown = packsLanguage_modal.findElement(By.className("value"));
        language_dropdown.click();

        WebElement options = packsLanguage_modal.findElement(By.className("options"));

        List<WebElement> language_options = options.findElements(By.tagName("li"));

        WebElement language = language_options.get(index);
        language.click();

        TimeUtils.waitForSeconds(1);

        List<WebElement> languageModalButtons_button = packsLanguage_modal.findElements(By.tagName("a"));
        languageModalButtons_button.get(2).click();
    }

    public void addAddonItem(int index, int amount) {
        WebElement addons = columns.findElement(By.xpath("//div[@class='columns is-multiline content']"));
        List<WebElement> addonItems = addons.findElements(By.className("addon"));

        for (int i = 0; i < amount; i ++) {
            addonItems.get(index).findElements(By.tagName("button")).get(1).click();
        }
    }

    public void addRandomAddonItems(int amount) {
        WebElement addons = columns.findElement(By.xpath("//div[@class='columns is-multiline content']"));
        List<WebElement> addonItems = addons.findElements(By.className("addon"));

        for (int i = 0; i < amount; i ++) {
            int index = NumberUtils.getRandomNumberForList(addonItems);
            TimeUtils.waitForSeconds(1);
            addonItems.get(index).findElements(By.tagName("button")).get(1).click();
        }
    }

    public void removeAddonItem(int index, int amount) {
        WebElement addons = columns.findElement(By.xpath("//div[@class='columns is-multiline content']"));
        List<WebElement> addonItems = addons.findElements(By.className("addon"));

        for (int i = 0; i < amount; i ++) {
            addonItems.get(index).findElements(By.tagName("button")).get(0).click();
        }
    }

    public void removeRandomAddonItems(int amount) {
        WebElement addons = columns.findElement(By.xpath("//div[@class='columns is-multiline content']"));
        List<WebElement> addonItems = addons.findElements(By.className("addon"));

        for (int i = 0; i < amount; i ++) {
            int index = NumberUtils.getRandomNumberForList(addonItems);
            addonItems.get(index).findElements(By.tagName("button")).get(0).click();
        }
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
