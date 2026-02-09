package demos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity5 {
    private WebDriver driver;

    @BeforeClass (alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();   
        driver.get("https://training-support.net/webelements/target-practice");
    }

    @Test(groups={"Header Tests"})
    public void HeaderTests()
    {
        WebElement h3=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/h3[1]"));
        String text = h3.getText();
        System.out.println("header3 text is: " + text);
        Assert.assertEquals(text, "Heading #3");

        WebElement color_=driver.findElement(By.cssSelector("body > div > main > div > div > div > div > div.my-16.grid.max-h-80.gap-4.px-5.md\\:grid-cols-4.xl\\:grid-cols-4.xl\\:px-80 > h5"));
        String c = color_.getCssValue("color");
        System.out.println("header5 color is: " + c);
        Assert.assertEquals(c, "rgb(147, 51, 234)");

    }

    @Test(groups={"Button Tests"})
    public void ButtonTests()
    {
        WebElement button = driver.findElement(By.cssSelector("body > div > main > div > div > div > div > div.my-16.grid.max-h-80.gap-4.px-5.md\\:grid-cols-4.xl\\:grid-cols-4.xl\\:px-80 > button.rounded-xl.bg-emerald-200.p-2.text-3xl.font-bold.text-emerald-900.svelte-2hb4ib"));
        button.click();

        String text = button.getText();
        System.out.println("Button text is: " + text);
        Assert.assertEquals(text, "Emerald");

        WebElement button13 = driver.findElement(By.cssSelector("body > div > main > div > div > div > div > div.my-16.grid.max-h-80.gap-4.px-5.md\\:grid-cols-4.xl\\:grid-cols-4.xl\\:px-80 > button.rounded-xl.bg-purple-200.p-2.text-3xl.font-bold.text-purple-900.svelte-2hb4ib"));
        button13.click();

        String text2 = button13.getCssValue("color");
        System.out.println("Button text is: " + text2);
        Assert.assertEquals(text2, "rgb(88, 28, 135)");
    }
   
   
    @AfterClass
    public void tearDown() 
    {
            driver.close();
        }
}
