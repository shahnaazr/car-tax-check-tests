package com.tech.sra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends BaseClass{

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public LandingPage navigateTo(String url){
        driver.get(url);
        return this;
    }

    public ResultPage freeCarCheckForRegistrationNumber(String regNumber){
        WebElement input = driver.findElement(By.id("vrm-input"));
        input.sendKeys(regNumber);
        WebElement freeCarCheckButton = driver.findElement(By.xpath("//button[text()='Free Car Check']"));
        freeCarCheckButton.click();
        return new ResultPage(driver);
    }

}
