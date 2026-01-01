package com.opspilot.sdk;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class OpsPilotClientTest {

    @Test
    void shouldSendHttpRequestSuccessfully() throws Exception {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(200));
        server.start();

        String url = server.url("/logs").toString();

        OpsPilotConfig cfg = new OpsPilotConfig(
                "pk_123",
                url,
                "test-app",
                "dev",
                false
        );

        SdkState.init(cfg);

        OpsPilotClient client = new OpsPilotClient(cfg);

        ErrorEvent event = EventBuilder.fromException(
                new RuntimeException("Boom"),
                Map.of()
        );

        assertDoesNotThrow(() -> client.send(event));

        server.shutdown();
    }

    @Test
    void shouldNotCrashOnServerError() throws Exception {

        MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setResponseCode(500));
        server.start();

        OpsPilotConfig cfg = new OpsPilotConfig(
                "pk_123",
                server.url("/logs").toString(),
                "test-app",
                "dev",
                false
        );

        // FIX — initialize SDK state
        SdkState.init(cfg);

        OpsPilotClient client = new OpsPilotClient(cfg);

        ErrorEvent event = EventBuilder.fromException(
                new RuntimeException("Err"),
                Map.of()
        );

        assertDoesNotThrow(() -> client.send(event));

        server.shutdown();
    }
}
