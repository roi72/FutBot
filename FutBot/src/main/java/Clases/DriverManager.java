package Clases;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    public static WebDriver configurarDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = (WebDriver) new DriverManager();
        driver.manage().window().maximize();
        driver.get("https://www.sofascore.com/es/torneo/futbol/spain/laliga/8#id:61643");
        return driver;
    }
}
