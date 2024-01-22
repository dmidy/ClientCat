package org.example.http;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code){
        String link = "https://http.cat/" + code + ".jpg";

        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            connection.disconnect();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return String.valueOf(link);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
