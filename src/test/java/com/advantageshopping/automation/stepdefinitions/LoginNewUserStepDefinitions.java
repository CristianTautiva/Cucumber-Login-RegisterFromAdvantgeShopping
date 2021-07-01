package com.advantageshopping.automation.stepdefinitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;


import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

public class LoginNewUserStepDefinitions {

    public WebDriver driver;
    String username;


    @Given("^that a web user wants to login in advantage shopping online$")
    public void thatAWebUserWantsToRegisterInAdvantageShoppingOnline() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.advantageonlineshopping.com/#/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    }

    @When("^he fills all the requested fields needed$")
    public void heFillsAllTheRequestedFieldsNeeded() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("menuUserLink")).click();
        driver.findElement(By.name("username")).sendKeys("RubielaAren");
        driver.findElement(By.name("password")).sendKeys("RUb2786");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("sign_in_btnundefined")).click();
        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id( "menuUserLink")));


    }

    @Then("^he should see him dashboard in the homepage$")
    public void heShouldSeeHimDashboardInTheHomepage() {
        username = driver.findElement(By.xpath("//*[@class='hi-user containMiniTitle ng-binding']")).getText();
        System.out.println("El usuario por consola es : "+username);
        JOptionPane.showMessageDialog(null,"El usuario que inicio sesion fue "+username);
        //driver.quit();
    }

}




