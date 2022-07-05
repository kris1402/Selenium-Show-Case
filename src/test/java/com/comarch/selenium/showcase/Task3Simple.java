package com.comarch.selenium.showcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

public class Task3Simple extends AbstractTest{

    public static final By CSS_SELECTOR = By.cssSelector(".nav [data-toggle=\"dropdown\"]");

    @Test
    void editPersonalData(){
        driver.get("https://testingcup.pgs-soft.com/task_3");

        driver.findElement(CSS_SELECTOR).click();
        driver.findElement(By.partialLinkText("Formularz")).click();
        driver.findElement(By.id("start-edit")).click();

        WebElement nameInput = driver.findElement(By.id("in-name"));
        nameInput.clear();
        nameInput.sendKeys("John");

        WebElement surnameInput = driver.findElement(By.id("in-surname"));
        surnameInput.clear();
        surnameInput.sendKeys("Snow");

        WebElement inNotesElement = driver.findElement(By.id("in-notes"));
        inNotesElement.sendKeys("Notaki");


        WebElement inPhoneElement = driver.findElement(By.id("in-phone"));
        inPhoneElement.clear();
        inPhoneElement.sendKeys("555666777");


        driver.findElement(By.id("in-file")).sendKeys(new File("src/test/resources/Deamony.png").getAbsolutePath());
        driver.findElement(By.id("save-btn")).click();
    }
}
