package com.comarch.selenium.showcase;

import com.comarch.selenium.showcase.pages.Task7Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task7Test extends AbstractTest {
    @Test
    void moveOneItemShouldCountProductsBasket() {
        Task7Page page = new Task7Page(driver).get();

        //Task7Page.addNumerOfElements();
        page.setUnit(2 , 4);
        page.moveImageToBasket(2);

        Assertions.assertEquals(4, page.getSummaryItems());

    }

    @Test
    void moveTwoItemShouldCountProductsBasket() {
        Task7Page page = new Task7Page(driver).get();

        //Task7Page.addNumerOfElements();
        page.setUnit(2 , 4);
        page.moveImageToBasket(2);

        page.setUnit(3 , 1);
        page.moveImageToBasket(3);

        Assertions.assertEquals(5, page.getSummaryItems());

    }


    @Test
    void moveItemAndAddByButtonShouldCountProductsBasket() {
        Task7Page page = new Task7Page(driver).get();

        //Task7Page.addNumerOfElements();
        page.setUnit(2 , 4);
        page.moveImageToBasket(2);

        page.setUnit(3 , 1);
        page.useAddButton(3);

        Assertions.assertEquals(5, page.getSummaryItems());

    }

    @Test
    void checkIfItemsAddedShouldCountProductsBasket() {
        Task7Page page = new Task7Page(driver).get();

        //Task7Page.addNumerOfElements();

        page.setUnit(3 , 1);
        page.useAddButton(3);

        page.setUnit(3 , 1);
        page.useAddButton(3);

        page.setUnit(4 , 1);
        page.useAddButton(4);


        Assertions.assertEquals(2, page.getSummaryOneItems());

    }
}
