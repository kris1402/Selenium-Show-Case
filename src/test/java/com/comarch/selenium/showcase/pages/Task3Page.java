package com.comarch.selenium.showcase.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.fail;

public class Task3Page extends LoadableComponent<Task3Page> {

    public static final By CSS_SELECTOR = By.cssSelector(".nav [data-toggle=\"dropdown\"]");

    @FindBy(id = "in-notes")
    private WebElement notes;

    @FindBy(id = "in-phone")
    private  WebElement phoneNumber;

    @FindBy(tagName = "form")
    private WebElement saveButton;

    @FindBy(css = "[data-notify-text]")
    private WebElement messageNotify;

    private WebDriver driver;

    public Task3Page(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get("https://testingcup.pgs-soft.com/task_3");
    }

    @Override
    protected void isLoaded() throws Error {
        Assertions.assertEquals("https://testingcup.pgs-soft.com/task_3", driver.getCurrentUrl());
    }

    public void openMenu() {
        driver.findElement(CSS_SELECTOR).click();
        driver.findElement(By.partialLinkText("Formularz")).click();
        driver.findElement(By.id("start-edit")).click();
    }

    public void cleanAndWriteName(String inputTestName) {
        WebElement nameInput = driver.findElement(By.id("in-name"));
        nameInput.clear();
        nameInput.sendKeys(inputTestName);
    }

    public void cleanAndWriteSurname(String inputTest) {
        WebElement surnameInput = driver.findElement(By.id("in-surname"));
        surnameInput.clear();
        surnameInput.sendKeys(inputTest);
    }

    public void loadNewFile(String filePath) {
        driver.findElement(By.id("in-file")).sendKeys(new File(filePath).getAbsolutePath());
    }

    public void writeNotes(String inputValue) {
        notes.sendKeys(inputValue);
    }


    public void writePhoneNumber(String inputValue) {
        phoneNumber.sendKeys(inputValue);
    }

    public void confirmButton() {
        saveButton.submit();
    }

    public String getMessageNotification() {
        try {
            return new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS))
                     .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-notify-text]")))
                     .getText();
        } catch (Exception e) {
            fail("Could not find notifi box");
            throw new RuntimeException(e);
        }
        //     return messageNotify.getText();
    }
}
