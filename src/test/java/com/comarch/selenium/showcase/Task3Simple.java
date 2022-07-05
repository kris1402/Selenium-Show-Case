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
        //driver.findElement(By.id("in-file")).click();
        //driver.findElement(By.id("in-file")).sendKeys("C:\\Users\\Krzysztof\\OneDrive\\Pulpit");
        driver.findElement(By.id("in-file")).sendKeys(new File("src/test/resources/Deamony.png").getAbsolutePath());
        driver.findElement(By.id("save-btn")).click();
    }
}
