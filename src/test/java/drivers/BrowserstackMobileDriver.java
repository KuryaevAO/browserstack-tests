package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.CredentialsConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    final CredentialsConfig config =
            ConfigFactory.create(CredentialsConfig.class, System.getProperties());

    public URL getBrowserstackUrl() {
        try {
            return new URL(config.baseUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", config.user());
        desiredCapabilities.setCapability("browserstack.key", config.key());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", config.app());

        // Specify device and os_version for testing
        //desiredCapabilities.setCapability("device", config.device());
        desiredCapabilities.setCapability("device", "Samsung Galaxy S22");
        desiredCapabilities.setCapability("os_version", "12.0");

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
