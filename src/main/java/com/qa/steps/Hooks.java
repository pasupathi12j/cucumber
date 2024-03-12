package com.qa.steps;

import com.qa.engine.ProjectBase;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Hooks extends ProjectBase {

    public static PrintStream printStream;

    @Before
    public static void loadProperties() {
        try {
            properties = new Properties();
            properties.load(Files.newInputStream(Paths.get("D:\\project\\xfrontendautomation\\src\\main\\resources\\config\\UIConfig.properties")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Before
    public void sessionIn(Scenario scenario) {
        String scenarioName = scenario.getName().contains(" ") ? scenario.getName().replace(" ", "") : scenario.getName();
        scenarioName = scenarioName.length() > 200 ? scenarioName.substring(0, 200) : scenarioName;


        String fileName = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"))
                .replace("-", "");

        try {
            printStream = new PrintStream("target/runLogs/" + scenarioName.replace("\"", "") + "_" + fileName + ".txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        logInfo("//===============Session In=======================//\n");
        logInfo("Test Execution started at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss")));
        logInfo("Scenario '" + scenario.getName() + "' is executing..");
    }

    @After
    public void sessionOut(Scenario scenario) {
        boolean failed = scenario.isFailed();

        if (!failed)
            logInfo("^^^^Test successfully completed^^^^", scenario.getSourceTagNames().iterator().next());
        else logError("\n^^^^Test completed with failures - check report for failure^^^^\n");

        logInfo("Test Execution Completed at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss")) + "\n");
        logInfo("//===============Session Out=======================//\n\n");
        printStream.close();
    }

    @After
    public void afterScenario(final Scenario scenario) {
        String scenarioName = scenario.getName().contains(" ") ? scenario.getName().replace(" ", "") : scenario.getName();

        if (getDriver() != null) {
            try {
                if (scenario.isFailed()) {
                    byte[] screenshot =((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", scenario.getName());
                }
            } catch (Exception e) {
                logError("Error taking screenshot: "+e);
            }
        }

    }

}

