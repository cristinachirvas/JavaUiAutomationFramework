package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static String webDriverType = "CHROME";
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The CHROME Driver is initiated");
                break;

            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The FIREFOX Driver is initiated");
                break;

            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The EDGE Driver is initiated");
                break;

            case "SAFARI":
                driver = new SafariDriver();
                System.out.println("The SAFARI Driver is initiated");
                break;

            default:
                System.out.println("The is not such browser" + webDriverType);

        }
    }
    public static DriverManager getInstance() {
        if(instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }
    public WebDriver getDriver() {
        return driver;
    }



}