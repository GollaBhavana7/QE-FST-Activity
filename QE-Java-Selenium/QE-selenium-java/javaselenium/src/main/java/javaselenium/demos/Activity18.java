package javaselenium.demos;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity18 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://training-support.net/webelements/alerts");

        System.out.println("Page title is: " + driver.getTitle());


        driver.findElement(By.id("simple")).click();


        wait.until(ExpectedConditions.alertIsPresent());


        Alert alert = driver.switchTo().alert();


        System.out.println("Alert text is: " + alert.getText());

        alert.accept();
        driver.quit();
    }
}