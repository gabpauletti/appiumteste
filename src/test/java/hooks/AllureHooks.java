package hooks;

import core.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;

public class AllureHooks {

    @Before(order = 0)
    public void setUp(Scenario scenario) throws MalformedURLException {
        Driver.inicializaDriver();
        
        // Add scenario information to Allure
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName(scenario.getName());
            testResult.setDescription("Scenario: " + scenario.getName());
        });
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (Driver.getAppiumDriver() != null) {
            // Capture screenshot for failed scenarios
            if (scenario.isFailed()) {
                byte[] screenshot = takeScreenshot();
                Allure.addAttachment("Failed Screenshot", "image/png", new ByteArrayInputStream(screenshot), "png");
                
                // Attach page source for debugging
                String pageSource = getPageSource();
                Allure.addAttachment("Page Source", "text/xml", pageSource);
            } else {
                // Also capture screenshot for passed scenarios
                byte[] screenshot = takeScreenshot();
                Allure.addAttachment("Final Screenshot", "image/png", new ByteArrayInputStream(screenshot), "png");
            }
            
            Driver.getAppiumDriver().quit();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        try {
            if (Driver.getAppiumDriver() != null) {
                return ((TakesScreenshot) Driver.getAppiumDriver()).getScreenshotAs(OutputType.BYTES);
            }
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
        return new byte[0];
    }

    @Attachment(value = "Page Source", type = "text/xml")
    public String getPageSource() {
        try {
            if (Driver.getAppiumDriver() != null) {
                return Driver.getAppiumDriver().getPageSource();
            }
        } catch (Exception e) {
            return "Failed to capture page source: " + e.getMessage();
        }
        return "";
    }
}