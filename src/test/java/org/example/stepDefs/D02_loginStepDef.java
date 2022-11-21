package org.example.stepDefs;

import Data.data.JsonDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.example.pages.P02_login;
import org.example.pages.P03_homePage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.example.stepDefs.Hooks.driver;

public class D02_loginStepDef {
    P02_login p02login = new P02_login(driver);
    P03_homePage homePage = new P03_homePage(driver);
    P01_register p01register = new P01_register();
    //D01_registerStepDef d01registerStepDef = new D01_registerStepDef();
    JsonDataReader jsonReader = new JsonDataReader();
    SoftAssert soft = new SoftAssert();


    @When("user go to login page")
    public void userGoToLoginPage() {
        homePage.clickOnLoginLink();
    }

    @When("user logout")
    public void userLogout() {
        p01register.doLogout();
    }

    @Then("user on home page")
    public void userOnHomePage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
    }


    @And("user login with valid email and password")
    public void userLoginWithValidEmailAndPassword() throws IOException, ParseException  {
        jsonReader.JsonReader();
        p02login.enterLoginCredentials(jsonReader.email, jsonReader.password);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        p02login.clickOnLoginBtn();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        // Assert on Current page after login
        soft.assertEquals("https://demo.nopcommerce.com/", homePage.getHomePageURL());
        // Assert on my Account tab
        soft.assertTrue(p02login.getMyAccountWebEle().isDisplayed());
        soft.assertAll();

    }

    @When("user login with invalid {string} and {string}")
    public void userLoginWithInvalidAnd(String wrongEmail, String password) {
        p02login.enterLoginCredentials(wrongEmail, password);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        // Assert on failed message
        soft.assertTrue(p02login.getFailedLoginMessageText().contains("Login was unsuccessful."));
        // Assert on message color

        soft.assertEquals(p02login.getLoginMessageColor(), "rgba(228, 67, 75, 1)");
        soft.assertAll();
    }
}
