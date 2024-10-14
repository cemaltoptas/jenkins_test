package com.oop.step_definitions;

import com.oop.utilties.Driver;
import io.cucumber.java.en.Given;
import org.junit.Assert;


public class HomaPage_stepDef {
    @Given("the user is on home page")
    public void theUserIsOnHomePage() {

        //visit home page
        Driver.getDriver().get("https://www.google.com/");
        Assert.assertEquals("https://www.google", Driver.getDriver().getCurrentUrl());

    }
}
