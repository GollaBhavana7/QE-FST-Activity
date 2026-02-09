package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity1 {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();   
        driver.get("https://training-support.net");
    }

    @Test
    public void test1() {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Training Support");

        WebElement button = driver.findElement(By.linkText("About Us"));
        button.click();

        String newTitle = driver.getTitle();
        System.out.println(newTitle); 
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}