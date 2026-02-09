package demos;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;             // <-- TestNG Assert
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


public class TestActivity6
 {
    private WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setup()
    {
        driver=new FirefoxDriver();
        driver.get("https://training-support.net/webelements/login-form");
    }
    @Test
    @Parameters({"username","password"})
    public void Test1(String username,String password)
    {
        WebElement username_ele=driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement password_ele=driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement submit=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button"));
        username_ele.sendKeys(username);
        password_ele.sendKeys(password);
        submit.click();
        WebElement message=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h2"));
        System.out.println(message.getText());
    }
    @AfterClass
    public void test(){
        driver.quit();
    }
}