package Clases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Match {
    public static void seleccionarPartido(WebDriver driver, WebDriverWait wait, String partidoXPath) {
        try {
            WebElement partidoWeb = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(partidoXPath)));
            partidoWeb.click();
            System.out.println("Partido seleccionado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al seleccionar el partido: " + e.getMessage());
        }
    }
}
