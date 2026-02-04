 package javaselenium.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

public class Activity17 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://training-support.net/webelements/selects");
            System.out.println("Page title: " + driver.getTitle());
 
            List<WebElement> selects = driver.findElements(By.tagName("select"));
            WebElement multiSelectElement = selects.get(1);
            Select multiSelect = new Select(multiSelectElement); 
            multiSelect.selectByVisibleText("HTML");
            System.out.println("Selected: HTML"); 
            multiSelect.selectByIndex(3);
            multiSelect.selectByIndex(4);
            multiSelect.selectByIndex(5);
            System.out.println("Selected options at indexes 3, 4, and 5"); 
            
            multiSelect.selectByValue("nodejs");
             
            multiSelect.deselectByIndex(4);
            System.out.println("Deselected the 5th option (Index 4)"); 
            System.out.println("Currently Selected Options");
            List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
            for (WebElement option : selectedOptions) {
                System.out.println("Selected: " + option.getText());
            }
        
            driver.quit();
        
}}