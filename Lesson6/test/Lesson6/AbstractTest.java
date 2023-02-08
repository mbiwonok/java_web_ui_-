package Lesson6;
import java.util.*;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractTest {

    static WebDriver driver;
    Logger logger = LoggerFactory.getLogger("Test-Case's 1-6");

    @BeforeAll
    static void initClass() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");


        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");

        options.addArguments("--disable-gpu");


        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);


    }

    @BeforeEach
    void initTest() {
        driver.get("https://ribomaniya.ru/?logout=yes");
    }

    @AfterAll
    static void finalClass() {
        if(driver !=null) driver.quit();
    }

    public WebDriver getWebDriver(){
        return this.driver;
    }

}
