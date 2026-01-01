package com.opspilot.sdk;

public class SdkState {

    private static OpsPilotConfig config;
    private static OpsPilotClient client;
    private static boolean initialized = false;

    public static void init(OpsPilotConfig cfg) {
        config = cfg;
        client = new OpsPilotClient(cfg);
        initialized = true;
    }

    public static OpsPilotClient getClient() {
        return client;
    }

    public static OpsPilotConfig getConfig() {
        return config;
    }

    public static boolean isInitialized() {
        return initialized;
    }
}
