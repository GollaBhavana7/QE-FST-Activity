package javaselenium.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.*;
public class Activity14 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net/webelements/tables");
        System.out.println(driver.getTitle());
        List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println(rows.size());
        List<WebElement> columns=driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
        System.out.println(columns.size());
        WebElement fifthRow=driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        System.out.println(fifthRow.getText());
        WebElement priceHeader=driver.findElement(By.xpath("//table/thead/tr/th[5]"));
        priceHeader.click();
        WebElement fifthRow2=driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        System.out.println(fifthRow2.getText());
        driver.quit();
    }
}