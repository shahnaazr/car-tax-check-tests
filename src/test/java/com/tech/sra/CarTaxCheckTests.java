package com.tech.sra;

import com.tech.sra.pages.LandingPage;
import com.tech.sra.pages.ResultPage;
import com.tech.sra.utils.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTaxCheckTests {
    private WebDriver driver;
    private LandingPage landingPage;
    private ResultPage resultPage;

    @BeforeAll
    static void init() throws IOException{
        Util.writeToFile();
    }

    private static Stream<Arguments> regNums() {
        return Stream.of(
                Arguments.of(Util.getSortedRegistrationNumbers().get(0)),
                Arguments.of(Util.getSortedRegistrationNumbers().get(1)),
                Arguments.of(Util.getSortedRegistrationNumbers().get(2)),
                Arguments.of(Util.getSortedRegistrationNumbers().get(3))
        );
    }

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
    }
    @AfterEach
    void closeDiver(){
        driver.quit();
    }

    @ParameterizedTest(name = "{index} => expectedRegistration={0}, expectedMake={1}, expectedModel={2}, expectedColor={3}, expectedYear={4}")
    @CsvFileSource(resources = "/expected_output.txt", numLinesToSkip = 1)
    void carTest(String expectedRegistration, String expectedMake, String expectedModel, String expectedColor, String expectedYear){

        landingPage = new LandingPage(driver);
        landingPage.navigateTo("https://cartaxcheck.co.uk/");
        resultPage = landingPage.freeCarCheckForRegistrationNumber(expectedRegistration);

        assertAll("Should match the car registration details",
                () -> assertEquals(expectedRegistration, resultPage .getRegistrationNumber()),
                () -> assertEquals(expectedMake, resultPage .getMake()),
                () -> assertEquals(expectedModel, resultPage .getModel()),
                () -> assertEquals(expectedColor, resultPage .getColour()),
                () -> assertEquals(expectedYear, resultPage .getYear())
        );
    }

}
