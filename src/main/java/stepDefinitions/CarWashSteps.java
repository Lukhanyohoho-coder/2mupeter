package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CarWashSteps {
    WebDriver driver = new ChromeDriver();

    @Given("the user is on the car wash booking page")
    public void the_user_is_on_the_car_wash_booking_page() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.get("https://grosapack.com/carwash/");
        driver.manage().window().maximize();
    }

    @And("I enter name (.*)$")
    public void i_enter_name_name(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("I enter surname (.*)$")
    public void i_enter_surname_surname(String surname) {
        driver.findElement(By.id("surname")).sendKeys(surname);
    }

    @And("I enter email (.*)$")
    public void i_enter_email_email(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("I enter phone number (.*)$")
    public void i_enter_phone_number_phone_number(String phone_number) {
        driver.findElement(By.id("phone")).sendKeys(phone_number);
    }

    @And("I select Location")
    public void i_select_location() {
        WebElement locationDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("location")));
        Select locationSelect = new Select(locationDropdown);
        locationSelect.selectByVisibleText("Capfin/PPL");

    }

    @And("I select parking type")
    public void i_select_parking_type() {
        WebElement parkingTypeDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("parkingType")));
        Select parkingTypeSelect = new Select(parkingTypeDropdown);
        parkingTypeSelect.selectByVisibleText("Street Parking");
    }

    @And("I enter Parking bay number (.*)$")
    public void i_enter_parking_bay_number_parking_bay_number(String parking_bay_number) {
        driver.findElement(By.id("locationInfo")).sendKeys(parking_bay_number);
    }

    @And("I enter vehicle make (.*)$")
    public void i_enter_vehicle_make_make(String make) {
        driver.findElement(By.id("make")).sendKeys(make);
    }

    @And("I enter number plate (.*)$")
    public void i_enter_number_plate_number_plate(String number_plate) {
        driver.findElement(By.id("plate")).sendKeys(number_plate);
    }

    @And("I enter color (.*)$")
    public void i_enter_color_color(String color) {
        driver.findElement(By.id("color")).sendKeys(color);
    }

    @And("I select a vehicle type")
    public void i_select_a_vehicle_type() {
        WebElement vehicleTypeDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("type")));
        Select dropdown = new Select(vehicleTypeDropdown);
        dropdown.selectByVisibleText("R 80.00 - Small car express wash");
    }

    @And("I select date")
    public void i_select_date() {
        WebElement dateInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("date")));
        dateInput.sendKeys("2025-02-26");
    }

    @And("I select time slot")
    public void i_select_time_slot() {
        WebElement timeSlotInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("timeSlot1a")));
        timeSlotInput.sendKeys("08:00 – 09:00");


    }

    @When("I click submit button")
    public void i_click_submit_button() {
        WebElement submitButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.name("add-booking")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", submitButton);
    }




    @Then("The booking submitted successfully title should be displayed")
    public void the_booking_submitted_successfully_title_should_be_displayed() {

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}