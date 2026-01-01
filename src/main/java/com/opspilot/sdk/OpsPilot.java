package com.opspilot.sdk;

import java.util.Collections;
import java.util.Map;

public class OpsPilot {

    public static void init(String apiKey) {
        OpsPilotConfig config = OpsPilotConfig.withDefaults(apiKey);
        init(config);
    }

    public static void init(OpsPilotConfig config) {

        SdkState.init(config);

        if (config.isDebug()) {
            SdkLogger.enableDebug();
        }

        SdkLogger.info("OpsPilot initialized");
    }

    public static void capture(Exception ex) {
        capture(ex, Collections.emptyMap());
    }

    public static void capture(Exception ex, Map<String, Object> metadata) {

        if (!SdkState.isInitialized()) {
            SdkLogger.warn("SDK not initialized. Call OpsPilot.init() first.");
            return;
        }

        ErrorEvent event = EventBuilder.fromException(ex, metadata);

        SdkState.getClient().send(event);
    }
}
