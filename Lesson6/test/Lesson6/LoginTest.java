package Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends AbstractTest{

    @Test
    @DisplayName("Тест-кейс №1: Авторизация на сайте")
    public void testCase1() {

        getWebDriver().get("https://rybomania.ru");
        new MainPage(getWebDriver()).pressLoginBtt();
        new LoginPage(getWebDriver())
                .setLogin("mbiwonok")
                .setPassword("Yjdbrjd1811")
                .pressInBtt();
        assertTrue(new MainPage(getWebDriver()).checkUser("Мария"));
        logger.info("Тест-кейс №1 пройден");
    }

    @Test
    @DisplayName("Тест-кейс №2: Авторизация на сайте (негативный тест)")
    public void testCase2() {
        getWebDriver().get("https://rybomania.ru");
        new MainPage(getWebDriver()).pressLoginBtt();
        assertTrue(
                new LoginPage(getWebDriver())
                        .setLogin("mbiwonok")
                        .setPassword("password")
                        .pressInBtt()
                        .isError()
        );
        logger.info("Тест-кейс №2 пройден");
    }



}
