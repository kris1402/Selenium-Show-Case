package com.comarch.selenium.showcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class AbstractTest {
/*Nowa instancja chrome driver*/
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown(TestInfo testInfo) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String name = testInfo.getTestMethod().orElseThrow(RuntimeException::new).getName();
        FileUtils.copyFile(screenshot, new File(String.format("build/test-results/snapshots/%s.png", name)));
        //driver.quit();
    }

    protected WebDriver driver;

    @BeforeAll
    /*One time run code*/
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }
}
