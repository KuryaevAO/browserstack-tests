package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.RealDeviceConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RealDeviceMobileDriver implements WebDriverProvider {

    static final RealDeviceConfig readDeviceConfig =
            ConfigFactory.create(RealDeviceConfig.class, System.getProperties());

    public static URL getAppiumServerUrl() {
        try {
            return new URL(readDeviceConfig.baseUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", readDeviceConfig.platformName());
        desiredCapabilities.setCapability("deviceName", readDeviceConfig.deviceName());
        desiredCapabilities.setCapability("version", readDeviceConfig.version());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app", getAbsolutePath("src/test/resources/app-alpha-universal-release.apk"));


        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}