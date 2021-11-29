package ru.freemarker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
public class YAMLConfig {
    private String name;
    private String environment;
    private boolean enabled;
    private List<String> servers = new ArrayList<>();

    public String getEnvironment() {
        return environment;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }
}
