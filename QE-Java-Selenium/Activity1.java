package javaselenium.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net");

        System.out.println(driver.getTitle());

        driver.findElement(By.linkText("About Us")).click();

        Thread.sleep(1000);

        System.out.println(driver.getTitle());

        driver.quit();
    }
}