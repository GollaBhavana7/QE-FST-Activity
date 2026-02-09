package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestOrange {
private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();   
        driver.get("https://alchemy.hguy.co/orangehrm/");
    }
    @Test(priority=1)
    public void title() {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "OrangeHRM");
    }
    @Test(priority=2)
    public void url() { 
        driver.get("https://alchemy.hguy.co/orangehrm/");
        WebElement headerImg = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
        System.out.println("Header Image URL: " + headerImg.getAttribute("src"));
    }
     
    @Test(priority = 3)
    public void loginingtest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername"))).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click(); 
        WebElement welcomeMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
        String welcomeText = welcomeMenu.getText();
        System.out.println("Homepage reached. Welcome text: " + welcomeText);
        Assert.assertTrue(welcomeText.toLowerCase().contains("welcome"));
    }

    @Test(priority = 4, dependsOnMethods = "loginingtest")
    public void addEmployeeAndVerify() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Go to PIM
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewPimModule"))).click();

        // Click Add Employee (try menu first, fallback to Add button)
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_addEmployee"))).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewEmployeeList"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAdd"))).click();
        }

        long ts = System.currentTimeMillis();
        String firstName = "Bhavana";
        String lastName  = "Golla" + ts;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);

        String employeeId = driver.findElement(By.id("employeeId")).getAttribute("value");
        System.out.println("Generated Employee ID: " + employeeId);

        driver.findElement(By.id("btnSave")).click();

        WebElement personalEmpId = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("personal_txtEmployeeId"))
        );

        String savedId = personalEmpId.getAttribute("value");
        if (savedId != null && !savedId.trim().isEmpty()) {
            employeeId = savedId.trim();
        }

        System.out.println("Employee Created: " + firstName + " " + lastName + " | ID: " + employeeId);

        // Back to Employee List
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewPimModule"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewEmployeeList"))).click();

        WebElement searchId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empsearch_id")));
        searchId.clear();
        searchId.sendKeys(employeeId);

        driver.findElement(By.id("searchBtn")).click();

        WebElement resultTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
        WebElement firstRow = resultTable.findElement(By.xpath(".//tbody/tr[1]"));

        String rowText = firstRow.getText();
        System.out.println("Search Result: " + rowText);

        Assert.assertTrue(rowText.contains(employeeId), "Employee not found in Employee List by ID.");
        Assert.assertTrue(rowText.toLowerCase().contains(firstName.toLowerCase()), "First name not found in result.");
        Assert.assertTrue(rowText.toLowerCase().contains(lastName.toLowerCase()), "Last name not found in result.");

        System.out.println("Employee verified successfully in Employee List!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
