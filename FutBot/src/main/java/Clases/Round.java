package Clases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Round {
    public static int seleccionarRonda(WebDriver driver, WebDriverWait wait, int numeroRonda) {
        try {
            WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'Box laShVk')]//button[contains(@class, 'jQruaf')]")
            ));
            dropdownButton.click();

            WebElement rondaOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@role='option' and contains(@class, 'DropdownItem') and text()='Ronda " + numeroRonda + "']")));
            rondaOption.click();
            System.out.println("Ronda " + numeroRonda + " seleccionada.");
            return numeroRonda;
        } catch (Exception e) {
            System.out.println("Error al seleccionar la ronda: " + e.getMessage());
            return -1;
        }
    }
}
