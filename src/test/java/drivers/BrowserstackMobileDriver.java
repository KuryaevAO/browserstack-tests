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

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    String user = credentials.user();
    String key = credentials.key();
    String app = credentials.app();
    String device = credentials.device();
    String os_version = credentials.os_version();
    String project = credentials.project();
    String build = credentials.build();
    String name = credentials.name();


    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", user);
        desiredCapabilities.setCapability("browserstack.key", key);

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", app);

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", device);
        desiredCapabilities.setCapability("os_version", os_version);

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", build);
        desiredCapabilities.setCapability("build", project);
        desiredCapabilities.setCapability("name", name);

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
