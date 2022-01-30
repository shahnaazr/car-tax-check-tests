package com.tech.sra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ResultPage extends BaseClass{

    public ResultPage(WebDriver driver) {
        super(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    public String getRegistrationNumber(){
        return driver.findElement(By.xpath("//dt[text()='Registration']/following-sibling::dd")).getText();
    }

    public String getMake(){
        return driver.findElement(By.xpath("//dt[text()='Make']/following-sibling::dd")).getText();
    }

    public String getModel(){
        return driver.findElement(By.xpath("//dt[text()='Model']/following-sibling::dd")).getText();
    }

    public String getColour(){
        return driver.findElement(By.xpath("//dt[text()='Colour']/following-sibling::dd")).getText();
    }

    public String getYear(){
        return driver.findElement(By.xpath("//dt[text()='Year']/following-sibling::dd")).getText();
    }

}