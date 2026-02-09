package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity2 {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/target-practice");
    }


    @Test(priority = 1)
    public void test1() {
        String title = driver.getTitle();
        System.out.println("Title is: " + title);

        // safer than exact match:
        Assert.assertTrue(title.contains("Target Practice"),
                "Expected title to contain 'Target Practice' but got: " + title);
    }

    @Test(priority = 2)
    public void test2() {
        WebElement button = driver.findElement(By.cssSelector("Black"));
        button.click();

        String text = button.getText();
        System.out.println("Button text is: " + text);

        // intentionally wrong expected value to make it fail:
        Assert.assertEquals(text, "wrong text");
    }


    @Test(enabled = false)
    public void test3() {
        System.out.println("This test is disabled");
    }

    
    @Test(priority = 4)
    public void test4() {
        throw new SkipException("Skipping this test deliberately");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
