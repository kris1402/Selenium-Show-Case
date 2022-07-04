package com.comarch.selenium.showcase;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class FirstTest extends AbstractTest {


    @Test
    void shouldOpenBrowser() {

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        /*driver.findElement(By.id("email_create"));*/
        String valEmail = "Test7@comarch.pl";
        driver.findElement(By.id("email_create")).sendKeys(new Faker().random().nextInt(2000000 ) +  valEmail);
        //Assertions.assertEquals();
        driver.findElement(By.id("SubmitCreate")).click();
        /*ALERT
        driver.findElement(By.id("create_account_error")); // switch to alert
        String alertMessage= driver.findElement(By.id("create_account_error")).getText(); // capture alert message
        */

        new WebDriverWait(driver, Duration.of(15, ChronoUnit.SECONDS))
                .until(
                        ExpectedConditions.textToBe(By.className("page-subheading"), "YOUR PERSONAL INFORMATION")
        );

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("John");
        //Asertion
        // tworzenie zmiennych ctr + alt v
        WebElement firstname = driver.findElement(By.id("firstname"));
        //firstname.clear();
        Assertions.assertEquals("John", firstname.getAttribute("value"));

        driver.findElement(By.id("customer_lastname")).sendKeys("Snow");
        driver.findElement(By.id("passwd")).sendKeys("test123");

        driver.findElement(By.id("days"));
        new Select(driver.findElement(By.id("days"))).selectByIndex(1);

        driver.findElement(By.id("months"));
        new Select(driver.findElement(By.id("months"))).selectByValue("3");
        driver.findElement(By.id("years"));
        new Select(driver.findElement(By.id("years"))).selectByVisibleText("1992  ");

        driver.findElement(By.id("address1")).sendKeys("addressTest 12");
        driver.findElement(By.id("city")).sendKeys("cityTest");
        new Select(driver.findElement(By.id("id_state"))).selectByIndex(1);
        driver.findElement(By.id("postcode")).sendKeys("00000");

        driver.findElement(By.id("phone_mobile")).sendKeys("123456789");
        driver.findElement(By.id("submitAccount")).click();
        
        //driver.findElement(By.id("account-creation_form")).submit();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=my-account",driver.getCurrentUrl());
        //driver.quit();
        //driver.findElement(By.)
    }

}