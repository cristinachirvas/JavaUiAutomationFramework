package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentTabName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://opencart.antropy.co.uk/");
        Thread.sleep(5000);

        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerOption.click();

        System.out.println(driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));

        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));

        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));

        WebElement phoneInput = driver.findElement(By.cssSelector("#input-telephone"));

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));

        WebElement confirmPasswordInput = driver.findElement(By.cssSelector("#input-confirm"));

        WebElement privacyInput = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));

        Thread.sleep(3000);

        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(currentTabName);
        driver.get("https://tekwill.md/");
        Thread.sleep(1000);
        System.out.println(driver.getTitle());
        driver.quit();

        System.out.println("The execution is over");
        }
    }
