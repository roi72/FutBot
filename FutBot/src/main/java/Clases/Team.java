package Clases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Team {
    public static String[] obtenerNombresEquipos(WebDriver driver, WebDriverWait wait) {
        String[] equipos = new String[2];
        try {
            WebElement equipoIzquierdo = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("(//div[contains(@class, 'Box Flex ggRYVx cRYpNI')])[1]/bdi")));
            WebElement equipoDerecho = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("(//div[contains(@class, 'Box Flex ggRYVx cRYpNI')])[2]/bdi")));

            equipos[0] = equipoIzquierdo.getText().trim().replaceAll("\\s+", "");
            equipos[1] = equipoDerecho.getText().trim().replaceAll("\\s+", "");

            System.out.println("Equipo 1: " + equipos[0]);
            System.out.println("Equipo 2: " + equipos[1]);
        } catch (Exception e) {
            System.out.println("Error al extraer los nombres de los equipos: " + e.getMessage());
        }
        return equipos;
    }
}
