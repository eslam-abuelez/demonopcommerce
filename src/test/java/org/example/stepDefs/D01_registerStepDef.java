package org.example.stepDefs;

import io.cucumber.java.en.Given;
import org.example.pages.P01_register;
public class D01_registerStepDef {

    P01_register register = new P01_register();

    @Given(" user go to register page")
    public void goRegisterPage() {
        register.registerlink().click();
    }


}


