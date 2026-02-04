package javaselenium.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity9 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/keyboard-events");
        System.out.println(driver.getTitle());
        WebElement keyboard=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/h1"));
        Thread.sleep(3000);
        System.out.println(keyboard.getText());
        driver.quit();
    }}