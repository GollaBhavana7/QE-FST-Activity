package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class Activity2Steps extends Base{
    @Given("the user is on the login page")
    public void userOnTheHomePage()
    {
        driver.get("https://training-support.net/webelements/login-form");
    }
    @When("user enters username and password")
    public void enterFields()
    {
        WebElement username_ele=driver.findElement(By.id("username"));
        WebElement password_ele=driver.findElement(By.id("password"));
        username_ele.sendKeys("admin");
        password_ele.sendKeys("password");
    }
    @And("clicks the submit Button")
    public void clicksSubmit()
    {
        WebElement submit_ele=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button"));
        submit_ele.click();
    }
    @Then("get the confirmation message and confirms it")
    public void verifyMessage()
    {
        WebElement msg_ele=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h1"));
        String message=msg_ele.getText();
        System.out.println(message);
        Assertions.assertEquals("Login Success!", message);
    }
}