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

    CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    public URL getBrowserstackUrl() {
        try {
            return new URL(credentials.baseUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", credentials.user());
        desiredCapabilities.setCapability("browserstack.key", credentials.key());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", credentials.app());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", credentials.device());
        desiredCapabilities.setCapability("os_version", credentials.os_version());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", credentials.project());
        desiredCapabilities.setCapability("build", credentials.build());
        desiredCapabilities.setCapability("name", credentials.name());

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
