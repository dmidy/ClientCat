package org.example.http;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws Exception {
        String link = "https://http.cat/" + code + ".jpg";

        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            connection.disconnect();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return link;
            } else {
                throw new Exception("Image not found for HTTP status code " + code);
            }
        } catch (Exception e) {
            throw new Exception("Error connecting to the server", e);
        }
    }
}
