package com.opspilot.sdk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class OpsPilotTest {

    @Test
    void shouldNotThrowWhenCaptureBeforeInit() {
        assertDoesNotThrow(() ->
                OpsPilot.capture(new RuntimeException("boom"))
        );
    }

    @Test
    void shouldInitializeWithApiKey() {
        assertDoesNotThrow(() ->
                OpsPilot.init("pk_123")
        );
    }

    @Test
    void shouldCaptureAfterInit() {

        OpsPilot.init("pk_123");

        assertDoesNotThrow(() ->
                OpsPilot.capture(new RuntimeException("boom"))
        );
    }
}
