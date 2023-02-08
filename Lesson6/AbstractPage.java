package Lesson6;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    private WebDriver driver;

    public AbstractPage(WebDriver ){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver protected(){
        return this.driver;
    }
}

