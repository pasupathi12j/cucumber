package com.qa.engine;

import com.qa.steps.Hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public abstract class ProjectBase {

    protected static Properties properties;

    public WebDriver getDriver(){
        return DriverManager.driver.get();
    }

    public static Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }

    public static void logInfo(String text) {
        log().info(text);
        Hooks.printStream.print("\n" + text);
    }

    public static void logInfo(String text, Object vars) {
        log().info(text, vars);
        Hooks.printStream.print("\n" + text);
    }

    public static void logError(String text) {
        log().error(text);
        Hooks.printStream.print("\n" + text);
    }
}
