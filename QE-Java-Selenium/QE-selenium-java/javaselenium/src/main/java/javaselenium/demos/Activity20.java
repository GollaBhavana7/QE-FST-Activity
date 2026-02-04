package javaselenium.demos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import java.time.Duration;

public class Activity20 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
        driver.get("https://training-support.net/webelements/alerts");
 
        System.out.println("Page Title: " + driver.getTitle()); 
        driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click(); 
        Alert alert = driver.switchTo().alert(); 
        System.out.println("Alert Text: " + alert.getText());
        alert.sendKeys("Awesome!");
        alert.accept();
        driver.quit();
    }
}
