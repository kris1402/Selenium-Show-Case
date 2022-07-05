package com.comarch.selenium.showcase.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.w3c.dom.html.HTMLDListElement;

import javax.swing.*;
import java.util.List;

public class Task7Page extends LoadableComponent<Task7Page> {

    @FindBy(css = ".thumbnail input[type='number']")
    private List<WebElement> unitValues;

    @FindBy(css = ".thumbnail .draggable")
    private List<WebElement> images;

    @FindBy(className = "summary-quantity")
    private WebElement summaryQuantity;

    @FindBy(className = "row-in-basket-quantity")
    private WebElement summaryFirstElementQuantity;
    @FindBy(css = "[data-add-to-basket]")
    private List<WebElement> addButtons;

    @FindBy(className = "thumbnail")
    private WebElement thumbnail;

    private WebDriver driver;

    public Task7Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @Override
    protected void load() {
        driver.get("https://testingcup.pgs-soft.com/task_7");
    }

    @Override
    protected void isLoaded() throws Error {
        Assertions.assertEquals("https://testingcup.pgs-soft.com/task_7", driver.getCurrentUrl());
    }


    public static void addNumerOfElements() {

    }


    public void setUnit(int no, int value) {
        WebElement unitValue = unitValues.get(no - 1);
        unitValue.clear();
        unitValue.sendKeys(String.valueOf(value));
    }

    public void moveImageToBasket(int no) {

        for (WebElement thumbnail : thumbnails){
            thumbnail.findElement(By.cssSelector(".caption h4")).getText();
            if(title.equals(productTitle))
        }



        WebElement image = images.get(no - 1);

        new Actions(driver)
                .clickAndHold(image).moveToElement(driver.findElement(By.className("panel-info")))
                .moveToElement(driver.findElement(By.className("place-to-drop")))
                .release()
                .perform();
    }
    public int getSummaryItems(){
        return Integer.parseInt(summaryQuantity.getText());
    }

    public int getSummaryOneItems(){
        return Integer.parseInt(summaryFirstElementQuantity.getText());
    }

    public void useAddButton(int i) {
        WebElement addButton = addButtons.get(i -1);
        addButton.click();
    }

    /*
        public int getPositionItem(String productTitle){
            return Integer.parseInt(
                    driver.findElement(By.cssSelector(String.format(""))));
        }
     */
}
