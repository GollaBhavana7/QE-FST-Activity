package javaselenium.demos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity16 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/selects"); 
        System.out.println("Page Title: " + driver.getTitle());

        WebElement dropdownEle = driver.findElement(By.tagName("select"));

        Select dropdown = new Select(dropdownEle); 
        List<WebElement> options = dropdown.getOptions();
        System.out.println("\nDropdown options:");
        for (WebElement opt : options) {
            System.out.println(opt.getText());
        }
        dropdown.selectByIndex(2);
        dropdown.selectByValue("four");
        dropdown.selectByVisibleText("Three");

        driver.quit();
    }
}