package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity3 {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();   
        driver.get("https://training-support.net/webelements/login-form");
    }

    @Test
    public void logintest() {
         driver.findElement(By.id("username")).sendKeys("admin");
         driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button")).click();

        String actualmsg=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h2")).getText();
        System.out.println(actualmsg);

        Assert.assertEquals(actualmsg,"Welcome Back, Admin!");
    }

    @AfterClass
    public void tearDown() 
    {
            driver.close();
        }
    
}