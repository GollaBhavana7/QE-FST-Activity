package javaselenium.demos;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabDemo {
    public static void main(String[] args) {
     FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().fullscreen();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://training-support.net/webelements/tabs");

        String originalHandle = driver.getWindowHandle();
        System.out.println("Current page title is: " + driver.getTitle());
        System.out.println("Current tab handle is: " + originalHandle);
        System.out.println("Available handles: " + driver.getWindowHandles());

        WebElement launcher = driver.findElement(By.xpath("//button[text()='Open A New Tab']"));
        launcher.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        System.out.println("After clicking, available handles: " + driver.getWindowHandles());

        Set<String> handles = driver.getWindowHandles();

        for (String handle: handles) {
            if(handle != originalHandle) {
                driver.switchTo().window(handle);
            }
        }

        wait.until(ExpectedConditions.titleIs("New Tab!"));
        System.out.println("After switching, handle is: " + driver.getWindowHandle());
        System.out.println("Title of the page is: " + driver.getTitle());

        driver.quit();
   
    }
}