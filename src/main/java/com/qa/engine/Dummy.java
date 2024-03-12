package com.qa.engine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.Objects;

public class Dummy {
    public static void main(String[] args) {

//        WebDriverManager.edgedriver().setup();
//        WebDriver driver = new EdgeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.redbus.in/");
//        driver.findElement(By.xpath("//span[text()='Date']")).click();
//        driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][2]")).getText();
//        driver.findElement(By.xpath("//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'][2]//child::div")).getText();
//        List<WebElement> date=driver.findElements(By.xpath("//hr[@class='divider']//preceding::span[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 hVMWpe']"));
//        for(WebElement dateone:date){
//            dateone.getCssValue("color");
//        }
        String a="java";
        for (int i=0;i<a.length()-1;i++){
            char c = a.charAt(i);
            for(int j=i+1;j<a.length()-1;j++){
                char eachcharacterj=a.charAt(j);
                if(Objects.equals(c,eachcharacterj)){
                    System.out.println(c);
                }
            }
        }

           }
}
