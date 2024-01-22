package org.example.http;

import java.net.HttpURLConnection;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus(){
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        Scanner scanner = new Scanner(System.in);

        int code = 0;

        while (true) {
            System.out.println("Enter HTTP status code:");

            if (scanner.hasNextInt()) {
                code = scanner.nextInt();
                try {
                    if (code == HttpURLConnection.HTTP_OK) {
                    httpStatusImageDownloader.downloadStatusImage(code);
                    break;
                    } else {
                        System.out.println("There is not image for HTTP status " + code);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
    }
}
