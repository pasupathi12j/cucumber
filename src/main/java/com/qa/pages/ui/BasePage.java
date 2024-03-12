package com.qa.pages.ui;

import com.beust.ah.A;
import com.google.common.collect.ImmutableList;
import com.qa.engine.DriverManager;
import com.qa.utils.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.qa.engine.ProjectBase.logInfo;

public abstract class BasePage {
    private final WebDriver driver;
    protected TestUtils utils = new TestUtils();
    public BasePage() {
        this.driver = DriverManager.driver.get();
        PageFactory.initElements(this.driver, this);
    }

    public WebDriver getDriver(){ return DriverManager.driver.get(); }

    public static String getAttribute(WebElement element, String attributeName) {
            return element.getAttribute(attributeName);
    }

    public String getAttribute(By webElement, String attribute) {
        return getDriver().findElement(webElement).getAttribute(attribute);
    }

    public String getText(By webElement){
        return getDriver().findElement(webElement).getText();
    }


//    public String getText(WebElement){
//        return getDriver()
//    }

    public void clearText(WebElement element) {
        element.clear();
    }

    public void waitForVisibility(WebElement webElement) {
        if (getDriver() instanceof AndroidDriver) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } else if (getDriver() instanceof IOSDriver){
            Instant timeout = Instant.now().plusSeconds(60);

            while (!webElement.isEnabled()) {
                if (webElement.isEnabled())
                    break;
                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException("Element is not present in the page");
            }
        }else {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(25));
            wait.until(ExpectedConditions.visibilityOf(webElement));
        }
    }

    public void waitForVisibility(By webElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));

    }
    public void waitForInVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    public void click(WebElement webElement) {
        waitForVisibility(webElement);
        webElement.click();
        logInfo("Element clicked " + webElement);
    }

    public void click(By webElement, String msg) {
        waitForVisibility(webElement);
        getDriver().findElement(webElement).click();
    }


    public void click(By webElement) {
        waitForVisibility(webElement);
        getDriver().findElement(webElement).click();
    }

    public void sendKeys(WebElement webElement, String value) {
        waitForVisibility(webElement);
        webElement.sendKeys(value);
        logInfo("value entered " + value);
    }

    public void clear(WebElement webElement, String message) {
        waitForVisibility(webElement);
        webElement.clear();
        logInfo(message);
    }

    public void clickAndSendKeys(WebElement webElement, String txt, String message) {
        webElement.click();
        webElement.sendKeys(txt);
        logInfo(message);
    }

    public void clickAndSendKeys(By webElement, String txt, String msg) {
        getDriver().findElement(webElement).click();
        getDriver().findElement(webElement).sendKeys(txt);
        logInfo(msg);
    }
    public String getAttribute(WebElement element) {
        String txt=element.getAttribute("value");
        return txt;
    }

    public void setAttribute(WebElement element,String value) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('value', '" + value + "');", element);

    }
    public void ScrollUpOrDown(String Condition,WebElement Element){
        JavascriptExecutor js= (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView("+Condition+");", Element);
       // js.executeScript("arguments[0].scrollIntoView("Condotion")")
    }
    public void ScrollUpOrDownBy(String Condition,By Element){
        JavascriptExecutor js= (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView("+Condition+");", getDriver().findElement(Element));
        // js.executeScript("arguments[0].scrollIntoView("Condotion")")
    }
    public void keyBoardActionEscape() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ESCAPE);
        r.keyRelease(KeyEvent.VK_ESCAPE);
    }
    public void keyBoardActionTab() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_TAB);
    }
    public void keyBoardActionUpArrow() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_PAGE_UP);
        r.keyRelease(KeyEvent.VK_PAGE_UP);
    }
    public void clickAttribute(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);

    }
    public void implicityWait(){
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void actionsMoveToElement(WebElement value){
        Actions a = new Actions(getDriver());
        a.moveToElement(value).build().perform();
        a.click().build().perform();

        //a.click(value);

    }
    public void actionsClick (){
        Actions a = new Actions(getDriver());
        a.click().build().perform();
    }






}
