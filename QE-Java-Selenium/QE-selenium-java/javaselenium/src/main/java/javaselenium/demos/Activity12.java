package javaselenium.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/dynamic-content");
        System.out.println("Page Title: " + driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        By clickMeBtn = By.xpath("//*[@id=\"genButton\"]");
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(clickMeBtn));
        actions.moveToElement(btn).click().perform();

        // Wait for ANY visible element that contains "Release"
        By releaseText = By.id("word");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(releaseText,"release"));

        System.out.println("Release text found: " + driver.findElement(releaseText).getText());

        driver.quit();
    }
}