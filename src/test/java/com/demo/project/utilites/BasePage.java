package com.demo.project.utilites;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class BasePage {

// declaration attribute
    protected WebDriver driver;
    public WebDriverWait wait;



// Constructor: BasePage driver & PageFactory method 'this' to put value in driver & add explicit function
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // esperar 10 segundos
        PageFactory.initElements(driver, this);
    }

// Take screenshot
    protected String takeScreenshot(String nombre) {
        String carpeta = "src/test/resources/ScreenShots/";
        try {
            Files.createDirectories(Paths.get(carpeta));
            String ruta = carpeta + nombre.replaceAll(" ", "_") + "_" + System.currentTimeMillis() + ".png";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), Paths.get(ruta));

            System.out.println("📸 Captura tomada: " + ruta);
            return ruta;

        } catch (IOException e) {
            throw new RuntimeException("Error al guardar screenshot: " + e.getMessage());
        }
    }

// ComboSelection Method By Parameter
   protected void selecionarComboPorParametro(WebElement element, String parametro){
        wait.until(ExpectedConditions.visibilityOf((element))); //espera por hasta que elemento esta visble
        Select select = new Select(element);
        select.selectByVisibleText(parametro);
    }


// ComboSelection Method By value
   protected void selecionarComboPorValue(WebElement element, String value){
        wait.until(ExpectedConditions.visibilityOf((element))); //espera por hasta que elemento esta visble
        Select select = new Select(element);
        select.selectByValue(value);
    }
// Add scroll Function
    protected void scrollarElemento(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
