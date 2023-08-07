package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:com/kuryaevao/config/credentials.properties"})
public interface CredentialsConfig extends Config {
    String user();
    String key();
    String app();
    String device();
    String os_version();
    String project();
    String build();
    String name();
}

