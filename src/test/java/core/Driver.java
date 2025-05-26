package core;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    private static AppiumDriver appiumDriver;

    public static AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }

    public static void inicializaDriver() throws MalformedURLException {
        String url = "http://127.0.0.1:4723";
        BaseOptions options = new BaseOptions();
        options.setPlatformName("Android");
        options.setAutomationName("uiautomator2");
        options.setCapability("deviceName", "testecarrefour");
        options.setCapability("appPackage","com.wdiodemoapp");
        options.setCapability("appActivity","com.wdiodemoapp.MainActivity");

        appiumDriver = new AppiumDriver(new URL(url), options);

    }

    public static void swipe(int left, int top, String direction, double percent) {
        Dimension dimension = Driver.getAppiumDriver().manage().window().getSize();

        ((JavascriptExecutor) Driver.getAppiumDriver()).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", left, "top", top, "width", dimension.getWidth()/2,
                "height", dimension.getHeight()/2, "direction", direction, "percent", percent
        ));
    }


}
