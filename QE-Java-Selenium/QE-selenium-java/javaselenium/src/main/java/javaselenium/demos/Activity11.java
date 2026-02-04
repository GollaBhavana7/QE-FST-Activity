package javaselenium.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/dynamic-controls");
        System.out.println(driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By toggleCheckboxBtn = By.xpath("//button[contains(.,'Toggle Checkbox')]");
        By checkbox = By.cssSelector("input[type='checkbox']");   
        wait.until(ExpectedConditions.elementToBeClickable(toggleCheckboxBtn)).click(); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
        System.out.println("Checkbox is removed (not visible).");
 
        wait.until(ExpectedConditions.elementToBeClickable(toggleCheckboxBtn)).click(); 
        WebElement cb = wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
        wait.until(ExpectedConditions.elementToBeClickable(cb));
        System.out.println("Checkbox appeared.");
 
        if (!cb.isSelected()) {
            cb.click();
        }
        System.out.println("Checkbox selected: " + cb.isSelected()); 
        driver.quit();
    }
}