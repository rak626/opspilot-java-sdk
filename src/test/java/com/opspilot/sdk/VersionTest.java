package com.opspilot.sdk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionTest {

    @Test
    void versionShouldNotBeNull() {
        assertNotNull(Version.SDK_NAME);
        assertNotNull(Version.SDK_VERSION);
        assertFalse(Version.SDK_NAME.isBlank());
        assertFalse(Version.SDK_VERSION.isBlank());
    }
}
