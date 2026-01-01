package com.opspilot.sdk;

public class OpsPilotConfig {

    private final String apiKey;
    private final String endpoint;
    private final String appName;
    private final String environment;
    private final boolean debug;

    public OpsPilotConfig(String apiKey,
                          String endpoint,
                          String appName,
                          String environment,
                          boolean debug) {

        this.apiKey = apiKey;
        this.endpoint = endpoint;
        this.appName = appName;
        this.environment = environment;
        this.debug = debug;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getAppName() {
        return appName;
    }

    public String getEnvironment() {
        return environment;
    }

    public boolean isDebug() {
        return debug;
    }

    public static OpsPilotConfig withDefaults(String apiKey) {
        return new OpsPilotConfig(
                apiKey,
                "http://localhost:8080/logs",
                "default-app",
                "development",
                false
        );
    }
}
