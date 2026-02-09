package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class Activity5Steps extends Base{
    @Given("the user is on  home page")
    public void userOnTheHomePage()
    {
        driver.get("https://training-support.net/webelements/login-form");
    }
    @When("user enters with username {string} and  password {string}")
    public void enterFields(String username,String password)
    {
        WebElement username_ele=driver.findElement(By.id("username"));
        WebElement password_ele=driver.findElement(By.id("password"));
        username_ele.sendKeys(username);
        password_ele.sendKeys(password);
    }
    @And("clicks Submit Button")
    public void clicksSubmit()
    {
        WebElement submit_ele=driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button"));
        submit_ele.click();
    }
    @Then("get confirmation message as {string}")
    public void verifyMessage(String text)
    {
        WebElement msg_ele=driver.findElement(By.xpath("//*[@id=\"subheading\"]"));
        String message=msg_ele.getText();
        System.out.println(message);
        Assertions.assertEquals(text, message);
    }
}