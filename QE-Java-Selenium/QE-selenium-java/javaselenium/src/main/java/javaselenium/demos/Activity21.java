package javaselenium.demos;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net/webelements/tabs");
        System.out.println(driver.getTitle());
        WebElement tabBtn=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/button"));
        String original=driver.getWindowHandle();
        System.out.println("original:"+original);
        tabBtn.click();
        Thread.sleep(2000);
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> handles=driver.getWindowHandles();
        for(String handle:handles)
        {
            if(!handle.equals(original))
            {
                driver.switchTo().window(handle);
            }
        }
        String window2= driver.getWindowHandle();
 System.out.println("new window:"+driver.getWindowHandle());
        String newTitle=driver.getTitle();
        System.out.println("new title: "+newTitle);
        System.out.println(driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/h2/span")).getText());


        WebElement tabBtn2=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/button"));
        tabBtn2.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        Set<String> handles2=driver.getWindowHandles();
        for(String handle:handles2)
        {
            if(!handle.equals(window2))
            {
                driver.switchTo().window(handle);
            }
        }
         System.out.println("new window:"+driver.getWindowHandle());
        String newTitle2=driver.getTitle();
        System.out.println("new title: "+newTitle2);
        System.out.println(driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/h2/span")).getText());
        driver.quit();
    }
}