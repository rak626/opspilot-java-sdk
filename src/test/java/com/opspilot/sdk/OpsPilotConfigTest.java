package com.opspilot.sdk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpsPilotConfigTest {

    @Test
    void shouldStoreValuesCorrectly() {

        OpsPilotConfig config = new OpsPilotConfig(
                "pk_123",
                "http://localhost:8080/logs",
                "billing-service",
                "production",
                true
        );

        assertEquals("pk_123", config.getApiKey());
        assertEquals("http://localhost:8080/logs", config.getEndpoint());
        assertEquals("billing-service", config.getAppName());
        assertEquals("production", config.getEnvironment());
        assertTrue(config.isDebug());
    }

    @Test
    void shouldCreateDefaults() {

        OpsPilotConfig cfg = OpsPilotConfig.withDefaults("pk_abc");

        assertEquals("pk_abc", cfg.getApiKey());
        assertEquals("http://localhost:8080/logs", cfg.getEndpoint());
        assertEquals("default-app", cfg.getAppName());
        assertEquals("development", cfg.getEnvironment());
        assertFalse(cfg.isDebug());
    }
}
