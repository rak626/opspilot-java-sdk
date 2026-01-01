package com.opspilot.sdk;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EventBuilderTest {

    @Test
    void shouldBuildEventFromException() {

        SdkState.init(OpsPilotConfig.withDefaults("pk_123"));

        Exception ex = new RuntimeException("Boom");

        ErrorEvent event = EventBuilder.fromException(ex, Map.of("userId", "42"));

        assertEquals("default-app", event.appName);
        assertEquals("development", event.environment);
        assertEquals("Boom", event.message);
        assertEquals("42", event.metadata.get("userId"));
        assertNotNull(event.timestamp);
        assertNotNull(event.stackTrace);
        assertTrue(event.stackTrace.contains("RuntimeException"));
    }

    @Test
    void shouldHandleNullMetadataGracefully() {

        SdkState.init(OpsPilotConfig.withDefaults("pk_123"));

        ErrorEvent event = EventBuilder.fromException(
                new RuntimeException("X"),
                null
        );

        assertNull(event.metadata);
    }
}
