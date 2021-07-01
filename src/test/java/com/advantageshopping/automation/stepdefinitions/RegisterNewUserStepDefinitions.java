package com.advantageshopping.automation.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

public class RegisterNewUserStepDefinitions {

    public WebDriver driver;

    @Given("^that a web user wants to register in advantage shopping online$")
    public void thatAWebUserWantsToRegisterInAdvantageShoppingOnline() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.advantageonlineshopping.com/#/register");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @When("^he fills all the requested fields$")
    public void heFillsAllTheRequestedFields() {
        assertEquals(driver.findElement(By.xpath("//h3[text()='CREATE ACCOUNT']")).getText(),"CREATE ACCOUNT");
        driver.findElement(By.name("usernameRegisterPage")).sendKeys("pamela");
        driver.findElement(By.name("emailRegisterPage")).sendKeys("crist@gmail.com");
        driver.findElement(By.name("passwordRegisterPage")).sendKeys("Kaname1");
        driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Kaname1");
        driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Cristian");
        driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Tautiva");
        driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("3128374536");
        Select country = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
        country.selectByVisibleText("Colombia");
        driver.findElement(By.name("cityRegisterPage")).sendKeys("Cucuta");
        driver.findElement(By.name("addressRegisterPage")).sendKeys("Cucuta");
        driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("Santander");
        driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("541010");
        WebElement check = driver.findElement(By.name("i_agree"));
        check.click();
        driver.findElement(By.id("register_btnundefined")).click();


    }

    @Then("^he should see him username in the homepage$")
    public void heShouldSeeHimUsernameInTheHomepage() {
        driver.get("https://www.advantageonlineshopping.com/#/");
        String username = driver.findElement(By.xpath("//span[text()='pamela']")).getText();
        System.out.println("El nombre de usuario es: "+username);
        //driver.quit();
    }

}
