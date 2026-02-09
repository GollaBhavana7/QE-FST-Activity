package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

public class Activity3Steps extends Base{
    Alert alert;
    @Given("user is on the page")
    public void userOnTheHomePage()
    {
        driver.get("https://training-support.net/webelements/alerts");
    }
    @When("user clicks the simple alert button")
    public void simpleAlertWhen()
    {
        WebElement simpleBtn=driver.findElement(By.id("simple"));
        simpleBtn.click();
    }
    @When("user clicks the Confirm Alert button")
     public void confirmAlertWhen()
    {
        WebElement simpleBtn=driver.findElement(By.id("confirmation"));
        simpleBtn.click();
    }
    @When("user clicks the prompt alert button")
     public void promptAlertWhen()
    {
        WebElement simpleBtn=driver.findElement(By.id("prompt"));
        simpleBtn.click();
    }
    @Then("alert opens")
    public void Alert_Switch()
    {
        alert=driver.switchTo().alert();
    }
    @And("read the text from it and print it")
    public void Alert_readText()
    {
        System.out.println(alert.getText());
    }
     @And("write a custom message in it")
    public void sendText()
    {
        alert.sendKeys("hello");
    }
    @And("close the alert")
     public void acceptAlert()
    {
        alert.accept();
    }
     @And("close the alert with Cancel")
     public void dismissAlert()
    {
        alert.dismiss();
    }
    @And("read the result text")
    public void result(){
        System.out.println(driver.findElement(By.id("result")).getText());
    }
}