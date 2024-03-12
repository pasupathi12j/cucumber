package com.qa.engine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class DriverManager extends ProjectBase {

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver2) {
        driver.set(driver2);
    }
    public void launchBrowser() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
       // WebDriverManager.edgedriver().setup();
        ChromeOptions option= new ChromeOptions();
       // EdgeOptions option=new EdgeOptions();
        option.addArguments("--start-maximized");
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("--disable-notifications");
        driver = new ChromeDriver(option);
        //driver = new EdgeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverManager.driver.set(driver);
        System.out.println("github");
        System.out.println("intellikj");
    }

}

