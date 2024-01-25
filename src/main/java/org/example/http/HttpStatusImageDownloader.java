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
import java.nio.file.Files;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws Exception {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();

        String currentDir = System.getProperty("user.dir");
        String saveDirPath = currentDir + "/save/";
        String destinationPath = saveDirPath + code + ".jpg";
        String imageUrl = httpStatusChecker.getStatusImage(code);

        if (imageUrl != null) {

            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(imageUrl);
            URL url = new URL(imageUrl);

            try {
                HttpResponse response = httpClient.execute(httpGet);
                int statusCode = response.getStatusLine().getStatusCode();

                if (statusCode == HttpURLConnection.HTTP_OK) {
                    Path saveDir = FileSystems.getDefault().getPath(saveDirPath);
                    if (!Files.exists(saveDir)) {
                        Files.createDirectory(saveDir);
                    }
                    BufferedImage image = ImageIO.read(url);
                    Path destination = FileSystems.getDefault().getPath(destinationPath);

                    ImageIO.write(image, "jpg", destination.toFile());
                } else {
                    throw new Exception("Image not found for HTTP status code " + code);
                }
            } catch (IOException e) {
                throw new Exception("Error downloading image for HTTP status code " + code, e);
            }
        }
    }
}
