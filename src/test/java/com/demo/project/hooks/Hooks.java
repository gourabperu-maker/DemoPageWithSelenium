package com.demo.project.hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void openBrowser(){
        System.out.println("Opening a browser......");
      //  System.setProperty("WebDriver.Chrome.Driver","src/test/resources/driver"); // investigate this function
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit expect is global, it works in parallel with explicit
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
