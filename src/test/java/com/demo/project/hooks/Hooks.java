package com.demo.project.hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void openBrowser(){
        System.out.println("Opening a browser......");
        System.setProperty("WebDriver.Chrome.Driver","src/test/resources/driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void quitBrowser(){
        if (driver != null ) {
            System.out.println("Closing a Browser...!");
            driver.quit();
        }
    }
}
