package com.opspilot.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpsPilotClient {

    private final OpsPilotConfig config;
    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule())
            .disable(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


    public OpsPilotClient(OpsPilotConfig config) {
        this.config = config;
    }

    public void send(ErrorEvent event) {

        try {
            URL url = new URL(config.getEndpoint());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("X-API-KEY", config.getApiKey());
            conn.setDoOutput(true);

            String json = mapper.writeValueAsString(event);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes());
            }

            conn.getResponseCode();

        } catch (Exception e) {
            System.err.println("[OpsPilot SDK] send failed: " + e.getMessage());
        }
    }
}
