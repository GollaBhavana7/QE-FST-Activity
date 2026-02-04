package javaselenium.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
    public static void main(String[] args) {

        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net/webelements/dynamic-controls");
        System.out.println(driver.getTitle());
        if(driver.findElement(By.id("checkbox")).isDisplayed())
        {
            System.out.println("checkbox is displayed on the page");
        }
      driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/section[1]/button")).click();
      if(driver.findElement(By.id("checkbox")).isDisplayed())
        {
            System.out.println("Checkbox is displayed on the page");
        }
        else{
            System.out.println("Check box is not displayed on the page");
        }
        driver.quit();
    }
    
}
//button[@text='Toggle Checkbox']