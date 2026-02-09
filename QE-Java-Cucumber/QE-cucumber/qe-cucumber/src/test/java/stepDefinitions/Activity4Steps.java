package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity4Steps extends Base {

    @Given("User is on Login page")
    public void user_is_on_login_page() {
        driver.get("https://training-support.net/webelements/login-form");
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        // Locate credentials fields
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        // Click the Submit button
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }

    @Then("Read the page title and confirmation message")
    public void read_the_page_title_and_confirmation_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the success page heading to appear
        // The site displays the welcome message in an <h2> or <h1> tag on success
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));

        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.tagName("h2")).getText();

        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message: " + confirmMessage);

        // Validation logic
        if(confirmMessage.contains("Welcome Back, Admin!")) {
            System.out.println("Test Passed: Login Successful!");
        } else {
            throw new RuntimeException("Assertion Failed! Expected 'Welcome Back, admin' but found: " + confirmMessage);
        }
    }

    @And("Close the Browser")
    public void close_the_browser()
         {
            driver.quit();
        }
    }