package javaselenium.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/dynamic-controls");
        System.out.println(driver.getTitle());

        Thread.sleep(2000);System.out.println("Text Input");
        System.out.println(driver.findElement(By.xpath("//input[@id='textInput']")).isEnabled());
        driver.findElement(By.xpath("//button[text()='Enable Input']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@id='textInput']")).isEnabled());
        System.out.println();

        driver.quit();
    }}
