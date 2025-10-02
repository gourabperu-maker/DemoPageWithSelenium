package org.example.utilites;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class utilitiesScreenshot {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor: inicializa PageFactory y espera explícita
    public utilitiesScreenshot(WebDriver driver) {
        this.driver = driver;
        //this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


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
}
