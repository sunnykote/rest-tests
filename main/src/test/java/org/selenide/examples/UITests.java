package org.selenide.examples;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UITests {
@Before
public void Login()  {
        System.setProperty ("selenide.baseUrl","https://www.last.fm/ru/");
        System.setProperty("selenide.browser", "Chrome");
        open("");
        $(By.linkText("Вход")).click();
        $(By.id("id_username")).setValue("sunnykote").pressEnter();
        $(By.id("id_password")).setValue("error883+");
        $(By.name("submit")).click();
        }

    @Test
    public void Search() {
        $(By.linkText("Поиск")).click();
        $(By.name("q")).setValue("FKA Twings").pressEnter();
        $(By.linkText("Исполнители"));
        $(By.linkText("Альбомы"));
        $(By.linkText("Композиции"));


    }
}
