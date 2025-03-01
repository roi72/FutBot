package Clases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Stats {
    public static String extraerEstadisticas(WebDriver driver, WebDriverWait wait) {
        StringBuilder estadisticasConcatenadas = new StringBuilder();
        try {
            WebElement estadisticasTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@data-tabid='statistics']/a")));
            estadisticasTab.click();
            System.out.println("Pestaña de estadísticas abierta correctamente.");

            List<WebElement> estadisticasElements = driver.findElements(By.xpath("//div[contains(@class, 'Box Flex heNsMA bnpRyo')]"));

            for (WebElement estadistica : estadisticasElements) {
                try {
                    String valorEquipo1 = estadistica.findElement(By.xpath("./bdi[1]/span")).getText();
                    String nombreEstadistica = estadistica.findElement(By.xpath("./bdi[2]/div/span")).getText();
                    String valorEquipo2 = estadistica.findElement(By.xpath("./bdi[3]/span")).getText();

                    estadisticasConcatenadas.append(nombreEstadistica).append(": ").append(valorEquipo1).append("-").append(valorEquipo2).append(", ");
                } catch (Exception e) {
                    System.out.println("Error al extraer una estadística: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al extraer estadísticas: " + e.getMessage());
        }
        return estadisticasConcatenadas.toString();
    }
}
