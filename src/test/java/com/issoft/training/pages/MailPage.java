package com.issoft.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage extends Page {

    private WebDriverWait wait;

    @FindBy(css = ".mail-NestedList-Item-Name.js-folders-item-name")
    private WebElement listWithFolder;

    @FindBy(css = ".mail-User-Name")
    private WebElement userNameButton;

    @FindBy(xpath = "//a[@class=\"b-mail-dropdown__item__content js-user-dropdown-item \"][text()='Выйти из сервисов Яндекса']")
    private WebElement logOutButton;

    private final static Integer NUMBER_OF_STANDARD_FOLDERS = 5;

    public MailPage() {
        super();
        this.wait = new WebDriverWait(driver, 15);
    }

    public YandexPage logout() {
        userNameButton.click();
        logOutButton.click();
        return new YandexPage();
    }

    public boolean isFormPresent() {
        wait.until(ExpectedConditions.visibilityOf(listWithFolder));
        int size = driver.findElements(By.cssSelector(".mail-NestedList-Item-Name.js-folders-item-name")).size();
        return size == NUMBER_OF_STANDARD_FOLDERS;
    }
}
