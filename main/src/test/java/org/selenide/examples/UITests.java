package org.selenide.examples;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class UITests {

    @Test
    public void Login()  {
        System.setProperty ("selenide.baseUrl","https://www.last.fm/ru/");
        System.setProperty("selenide.browser", "Chrome");
        open("");
        $(By.linkText("Вход")).click();
        $(By.id("id_username")).setValue("sunnykote").pressEnter();
        $(By.id("id_password")).setValue("error883+");
        $(By.name("submit")).click();


    }
}
