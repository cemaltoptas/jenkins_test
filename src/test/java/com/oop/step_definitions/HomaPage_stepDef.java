package com.oop.step_definitions;

import com.oop.utilties.Driver;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomaPage_stepDef {
    @Given("the user is on home page")
    public void theUserIsOnHomePage() {

        //visit home page
        Driver.getDriver().get("https://google.com/");

    }
}
