package com.swaglabs.utils;

import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtil {

    public static final String ALLURE_RESULTS_PATH = "test-outputs/allure-results";

    private AllureUtil(){
        super();
    }

    public static void attachLogs(){
        try {
            File logFile = FilesUtil.getLatestFile(LogsUtil.LOGS_PATH);
            if (!logFile.exists()) {
                LogsUtil.warn("Log file does not exist: " + LogsUtil.LOGS_PATH);
                return;
            }
            Allure.addAttachment("logs.log", Files.readString(Path.of(logFile.getPath())));
            LogsUtil.info("Logs attached to the report");
        } catch (Exception e) {
            LogsUtil.error("Failed to attach logs to Allure report: " + e.getMessage());
        }
    }

    public static void attachScreenshot(String screenshotName, String screenshotPath){
        try {
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotPath)));
        }
        catch (Exception e){
            LogsUtil.error("failed to attach screenshot to allure report", e.getMessage());
        }
    }

}
