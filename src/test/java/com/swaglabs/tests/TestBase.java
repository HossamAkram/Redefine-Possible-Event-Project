package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.CustomSoftAssertion;
import com.swaglabs.utils.JsonUtil;
import com.swaglabs.utils.PropertiesUtil;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestBase {
    //variables
    JsonUtil testData;
    //configurations
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        DriverManager.createInstance(PropertiesUtil.getPropertyValue("browserType"),PropertiesUtil.getPropertyValue("executionType"));
    }
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        testData = new JsonUtil("test-data");
        PropertiesUtil.loadProperties();
    }


    @AfterSuite
    public void tearDown() {

        if (DriverManager.getDriver() != null) {
            BrowserActions.closeBrowser(DriverManager.getDriver());
        }
    }
    @AfterMethod
    public void afterEachTest(ITestResult result) {
        CustomSoftAssertion.customAssertAll(result);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
