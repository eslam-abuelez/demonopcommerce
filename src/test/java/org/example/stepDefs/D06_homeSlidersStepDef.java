package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D06_homeSlidersStepDef {
    P03_homePage homePage = new P03_homePage(driver);





    @When("user click on nokia slider")
    public void userClickOnNokiaSlider() {
        homePage.clickOnNokiaSlider();
    }

    @Then("nokia slider is clickable")
    public void nokiaSliderIsClickable() {
        wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/nokia-lumia-1020"));
        // Verify the directed URL
        System.out.println(driver.getCurrentUrl());

        // Assert the direction to th exact product url

        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/nokia-lumia-1020");
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    @When("user click on iphone slider")
    public void userClickOnSliderOfIphone() {
        homePage.clickOniPhoneSlider();
    }

    @Then("iphone slider is clickable")
    public void iphoneSliderIsClickable() {
        wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/iphone-6"));
        // Verify the directed URL
        System.out.println(driver.getCurrentUrl());
        // Assert the direction to th exact product url
        Assert.assertEquals(driver.getCurrentUrl(), " https://demo.nopcommerce.com/iphone-6");
    }
}
