package javaselenium.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/drag-drop");

        System.out.println("Page Title: " + driver.getTitle());

        Actions builder = new Actions(driver);

        WebElement ball = driver.findElement(By.id("ball"));
        WebElement d1 = driver.findElement(By.id("dropzone1"));
        WebElement d2 = driver.findElement(By.id("dropzone2")); 

        builder.dragAndDrop(ball, d1).perform(); 
        if (d1.findElements(By.id("ball")).size() > 0) {
            System.out.println("Ball dropped into Dropzone 1");
        } else {
            System.out.println("Ball NOT dropped into Dropzone 1");
        }
 
        ball = driver.findElement(By.id("ball"));
        builder.dragAndDrop(ball, d2).perform();
        if (d2.findElements(By.id("ball")).size() > 0) {
            System.out.println("Ball dropped into Dropzone 2");
        } else {
            System.out.println("Ball NOT dropped into Dropzone 2");
        }

        driver.quit();
    }
}