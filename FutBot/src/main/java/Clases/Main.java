package Clases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        String nombreEstadistica, valorEquipo1, valorEquipo2;
        String nombreEquipo1 = "", nombreEquipo2 = "", partido = "";
        String elementosAFiltrar;
        int ronda;


        // Ruta de apertura del Chrome Driver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.sofascore.com/es/torneo/futbol/spain/laliga/8#id:61643");

        // Código para acceptar las cookies.
        try {
            WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button")));
            consentButton.click();
            System.out.println("Consentimiento aceptado automáticamente.");
        } catch (Exception e) {
            System.out.println("No se encontró el popup de consentimiento o ya fue aceptado.");
        }


        try {
            WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'Box laShVk')]//button[contains(@class, 'jQruaf')]")
            ));
            dropdownButton.click();

            WebElement ronda1Option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@role='option' and contains(@class, 'DropdownItem') and text()='Ronda 1']")));
            ronda1Option.click();
            ronda = 1;


            /*
               Bucle que itere los containers de los partidos para ir guardando cada uno
               Metodo que se encargue de obtener en forma de variable el nombre de los equipos del primer partido
               Pasarle la variable de match al metodo partidoWeb para que haga el resto
            */


            // deportivo-alaves-celta-vigo
            // getafe-athletic-club
            WebElement partidoWeb = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href, '/es/football/match/deportivo-alaves-celta-vigo')]")
            ));
            partidoWeb.click();
            System.out.println("Partido seleccionado correctamente.");


            // Obtener de forma dinámica los nombres de los equipos y generar nombre del partido.
            try {
                WebElement equipoIzquierdo = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//div[contains(@class, 'Box Flex ggRYVx cRYpNI')])[1]/bdi")));
                WebElement equipoDerecho = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("(//div[contains(@class, 'Box Flex ggRYVx cRYpNI')])[2]/bdi")));

                nombreEquipo1 = equipoIzquierdo.getText().trim().replaceAll("\\s+", "");
                nombreEquipo2 = equipoDerecho.getText().trim().replaceAll("\\s+", "");
                partido = nombreEquipo1 + "-" + nombreEquipo2;

                System.out.println("Equipo 1: " + nombreEquipo1);
                System.out.println("Equipo 2: " + nombreEquipo2);
                System.out.println("Partido: " + partido);

            } catch (Exception e) {
                System.out.println("Error al extraer los nombres de los equipos: " + e.getMessage());
            }


            WebElement estadisticasTab = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//h2[@data-tabid='statistics']/a")
            ));
            estadisticasTab.click();
            System.out.println("Pestaña de estadísticas abierta correctamente.");

            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[contains(@class, 'Box Flex heNsMA bnpRyo')]")
            ));

            List<WebElement> estadisticasElements = driver.findElements(By.xpath("//div[contains(@class, 'Box Flex heNsMA bnpRyo')]")
            );

            StringBuilder estadisticasConcatenadas = new StringBuilder();

            try {
                WebElement leftScoreElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//span[@data-testid='left_score']")
                ));
                WebElement rightScoreElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//span[@data-testid='right_score']")
                ));

                String leftScore = leftScoreElement.getText();
                String rightScore = rightScoreElement.getText();

                String resultadoGoles = "Resultado: " + leftScore + "-" + rightScore;
                estadisticasConcatenadas.append(resultadoGoles).append(", ");
            } catch (Exception e) {
                System.out.println("Error al extraer el marcador del partido: " + e.getMessage());
            }

            // Generar el String de información con la estructura nombreEstadística: valorEquipo1 - valorEquipo2.
            for (WebElement estadistica : estadisticasElements) {
                try {
                    valorEquipo1 = estadistica.findElement(By.xpath("./bdi[1]/span")).getText();
                    nombreEstadistica = estadistica.findElement(By.xpath("./bdi[2]/div/span")).getText();
                    valorEquipo2 = estadistica.findElement(By.xpath("./bdi[3]/span")).getText();

                    estadisticasConcatenadas.append(nombreEstadistica).append(": ")
                            .append(valorEquipo1).append("-").append(valorEquipo2).append(", ");
                } catch (Exception e) {
                    System.out.println("Error al extraer una estadística: " + e.getMessage());
                }
            }

            if (estadisticasConcatenadas.length() > 2) {
                estadisticasConcatenadas.setLength(estadisticasConcatenadas.length() - 2);
            }

            // String con TODA la información de las estadísticas.
            elementosAFiltrar = estadisticasConcatenadas.toString();
            System.out.println(elementosAFiltrar);

            // Filtrado de la información para obtener las estadísticas necesarias.
            ArrayList<Result> listaEquipos;
            listaEquipos = Filter.filtrarInfo(nombreEquipo1, nombreEquipo2, partido, elementosAFiltrar, ronda);

            // Inserción en base de datos la información.
            Hibernate.insertarHib(listaEquipos);


        } catch (Exception e) {
            System.out.println("Error al interactuar con la página: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}