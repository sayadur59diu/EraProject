package com.devmonplugin;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

public class DevActivitySender {

    private static final String API_URL = "http://localhost:8081/api/dev-activity";

    public static void sendActivity(String project, String file, String state, LocalDateTime timestamp) {
        try {
            String json = String.format(
                    "{\"userId\":\"dev1\",\"tool\":\"IntelliJ\",\"project\":\"%s\",\"state\":\"%s\",\"startTime\":\"%s\"}",
                    project, state, timestamp
            );

            URL url = new URL(API_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                os.write(json.getBytes());
                os.flush();
            }

            int responseCode = con.getResponseCode();
            System.out.println("Sent activity, response: " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

