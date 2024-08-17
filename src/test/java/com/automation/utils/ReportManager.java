package com.automation.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportManager {
    static Scenario scenario;

    public static void initReporter(Scenario scenario) {
        ReportManager.scenario = scenario;
    }
    public static void attachScreenshot() {
        scenario.attach(takeScreenshot(), "image/png", "Failed Test Snap");
    }
    public static byte[] takeScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
    public static void log(String message) {
        scenario.log(message);
    }
}
