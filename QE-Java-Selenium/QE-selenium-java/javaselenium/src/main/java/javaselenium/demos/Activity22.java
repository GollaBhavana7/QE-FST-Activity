package javaselenium.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Activity22
{
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://training-support.net/webelements/popups");
        System.out.println(driver.getTitle());
        WebElement btn=driver.findElement(By.id("launcher"));
        btn.click();

 wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"popup\"]/div")));
WebElement username=driver.findElement(By.id("username"));
WebElement password=driver.findElement(By.id("password"));
WebElement submitBtn=driver.findElement(By.xpath("//*[@id=\"signInForm\"]/button"));
username.sendKeys("admin");
password.sendKeys("password");
submitBtn.click();
System.out.println(driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h1")).getText());
driver.quit();
    }

}