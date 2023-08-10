package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:com/kuryaevao/config/realDevice.properties"})
public interface RealDeviceConfig extends Config {
    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("version")
    String version();

    @Key("baseUrl")
    String baseUrl();
}

