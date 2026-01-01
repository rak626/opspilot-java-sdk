package com.opspilot.sdk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SdkStateTest {

    @Test
    void shouldInitializeStateCorrectly() {

        OpsPilotConfig config = OpsPilotConfig.withDefaults("pk_test");
        SdkState.init(config);

        assertTrue(SdkState.isInitialized());
        assertNotNull(SdkState.getClient());
        assertEquals("pk_test", SdkState.getConfig().getApiKey());
    }
}
