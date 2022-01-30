package com.tech.sra.pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseClass {
    protected WebDriver driver;

    public BaseClass(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}



