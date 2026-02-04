package javaselenium.demos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;
import java.time.Duration;

public class Activity19 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.get("https://training-support.net/webelements/alerts");

        System.out.println("Page Title: " + driver.getTitle());

        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click(); 
        Alert alert = driver.switchTo().alert();
 
        System.out.println("Alert Text: " + alert.getText());
 
        alert.accept();
 
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click(); 
        alert = driver.switchTo().alert();

        alert.dismiss();
 
        driver.quit();
    }
}
