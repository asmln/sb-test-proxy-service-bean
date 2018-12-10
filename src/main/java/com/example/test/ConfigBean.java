package com.example.test;

import org.springframework.stereotype.Component;

@Component
public class ConfigBean {
    private String configName = "TEST_CONFIG_NAME";

    public String getConfigName() {
        return configName;
    }
}
