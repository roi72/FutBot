package Clases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cookies {
    public static void aceptarCookies(WebDriver driver, WebDriverWait wait) {
        try {
            WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fc-button.fc-cta-consent.fc-primary-button")));
            consentButton.click();
            System.out.println("Consentimiento aceptado automáticamente.");
        } catch (Exception e) {
            System.out.println("No se encontró el popup de consentimiento o ya fue aceptado.");
        }
    }
}
