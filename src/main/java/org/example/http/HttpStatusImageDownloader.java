package org.example.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws Exception {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();

        String destinationPath = "D://save/" + code + ".jpg";
        String imageUrl = httpStatusChecker.getStatusImage(code);

        if (imageUrl != null) {

            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(imageUrl);
            URL url = new URL(imageUrl);

            try {
                HttpResponse response = httpClient.execute(httpGet);
                response.getStatusLine().getStatusCode();

                if (response.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
                    BufferedImage image = ImageIO.read(url);
                    Path destination = FileSystems.getDefault().getPath(destinationPath);

                    ImageIO.write(image, "jpg", destination.toFile());
                } else {
                    throw new Exception("There is not image for HTTP status " + code);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}
