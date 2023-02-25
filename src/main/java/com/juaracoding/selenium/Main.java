package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        testLogin();
        testAddtoCart();
        driver.quit();
        System.out.println("test finished");
    }

    public static void testLogin(){
        driver.get("https://shop.demoqa.com");

        WebElement dismissButton = driver.findElement(By.xpath("/html/body/p/a"));
        dismissButton.click();

        WebElement myAccountLink = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a"));
        myAccountLink.click();

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("reypau");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("formeonly123");

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

    }

    public static void testAddtoCart(){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        driver.get("https://shop.demoqa.com");

        WebElement productLink = driver.findElement(By.cssSelector(".noo-product-inner"));
        productLink.click();
        js.executeScript("window.scrollBy(0,400)");

        WebElement selectColor = driver.findElement(By.id("pa_color"));
        Select color = new Select(selectColor);
        color.selectByValue("pink");
        WebElement selectSize = driver.findElement(By.id("pa_size"));
        Select size = new Select(selectSize);
        size.selectByValue("37");

        WebElement addToCartButton = driver.findElement(By.cssSelector(".single_add_to_cart_button"));
        addToCartButton.click();

    }

}