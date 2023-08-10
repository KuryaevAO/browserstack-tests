package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:com/kuryaevao/config/credentials.properties"})
public interface CredentialsConfig extends Config {
    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("app")
    String app();

    @Key("baseUrl")
    String baseUrl();
}

