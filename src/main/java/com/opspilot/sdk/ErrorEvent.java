package com.opspilot.sdk;

import java.time.Instant;
import java.util.Map;

public class ErrorEvent {

    public String appName;
    public String environment;
    public String message;
    public String stackTrace;
    public Instant timestamp;
    public Map<String, Object> metadata;
    public String sdkVersion;
    public String sdkName;

    public ErrorEvent(String appName, String environment,
                      String message, String stackTrace,
                      Map<String, Object> metadata) {

        this.appName = appName;
        this.environment = environment;
        this.message = message;
        this.stackTrace = stackTrace;
        this.timestamp = Instant.now();
        this.metadata = metadata;
        this.sdkVersion = Version.SDK_VERSION;
        this.sdkName = Version.SDK_NAME;
    }
}
