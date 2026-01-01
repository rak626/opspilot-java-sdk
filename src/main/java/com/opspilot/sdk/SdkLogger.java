package com.opspilot.sdk;

public class SdkLogger {

    private static boolean debugEnabled = false;

    public static void enableDebug() {
        debugEnabled = true;
        info("Debug mode enabled");
    }

    public static void disableDebug() {
        debugEnabled = false;
    }

    public static void info(String message) {
        if (debugEnabled) {
            System.out.println("[OpsPilot SDK] " + message);
        }
    }

    public static void error(String message, Throwable throwable) {
        System.err.println("[OpsPilot SDK] ERROR: " + message);
        if (debugEnabled && throwable != null) {
            throwable.printStackTrace();
        }
    }

    public static void warn(String message) {
        System.err.println("[OpsPilot SDK] WARN: " + message);
    }
}
