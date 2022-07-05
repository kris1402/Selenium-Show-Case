package com.comarch.selenium.showcase;

import com.comarch.selenium.showcase.pages.Task3Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Task3PageObject extends AbstractTest {
    @Test
    void shouldEditPersonalDataWithoutSurname() {

        driver.get("https://testingcup.pgs-soft.com/task_3");

        Task3Page task3Page = new Task3Page(driver).get();

        task3Page.openMenu();
        //Wpisywanie imienia
        task3Page.cleanAndWriteName("John");
        task3Page.writeNotes("Notatki");
        task3Page.writePhoneNumber("555666777");
        task3Page.loadNewFile("src/test/resources/Deamony.png");
        task3Page.confirmButton();
    }

    @Test
    void shouldEditPersonalData() {

        //driver.get("https://testingcup.pgs-soft.com/task_3");

        Task3Page task3Page = new Task3Page(driver).get();

        task3Page.openMenu();
        //Wpisywanie imienia
        task3Page.cleanAndWriteName("John");
        //Wpisywanie nazwiska
        task3Page.cleanAndWriteSurname("Snow");

        //Notatki
        task3Page.writeNotes("Notatki");

        //phoneNumer
        task3Page.writePhoneNumber("555666777");

        //Load file
        task3Page.loadNewFile("src/test/resources/Deamony.png");

        //Click Confirm
        task3Page.confirmButton();
        //driver.findElement(By.id("save-btn")).click();



        Assertions.assertEquals("Twoje dane zostały poprawnie zapisane", task3Page.getMessageNotification());

    }
}
