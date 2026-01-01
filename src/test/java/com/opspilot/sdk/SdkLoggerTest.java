package com.opspilot.sdk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SdkLoggerTest {

    @Test
    void shouldNotThrowOnInfo() {
        assertDoesNotThrow(() -> SdkLogger.info("hello"));
    }

    @Test
    void shouldNotThrowOnError() {
        assertDoesNotThrow(() -> SdkLogger.error("fail", new RuntimeException()));
    }

    @Test
    void shouldNotThrowOnWarn() {
        assertDoesNotThrow(() -> SdkLogger.warn("warn message"));
    }

    @Test
    void shouldEnableDebugWithoutCrash() {
        assertDoesNotThrow(SdkLogger::enableDebug);
        assertDoesNotThrow(SdkLogger::disableDebug);
    }
}
