package javaselenium.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 

public class Activity4 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net/webelements/target-practice");
        System.out.println(driver.getTitle()); 
        System.out.println(driver.findElement(By.xpath("//h3[@class='text-3xl font-bold text-orange-600']")).getText());
        System.out.println(driver.findElement(By.xpath("//h5[@class='text-3xl font-bold text-purple-600']")).getCssValue("Color"));
        System.out.println(driver.findElement(By.className("svelte-2hb4ib")).getAttribute("class"));
        System.out.println(driver.findElement(By.className("bg-slate-200")).getText());
        driver.quit();
    } 
}
