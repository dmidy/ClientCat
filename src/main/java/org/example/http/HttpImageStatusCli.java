package org.example.http;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        Scanner scanner = new Scanner(System.in);

        int code = 0;

        while (true) {
            System.out.println("Enter HTTP status code:");

            if (scanner.hasNextInt()) {
                code = scanner.nextInt();
                try {
                    httpStatusImageDownloader.downloadStatusImage(code);
                    System.out.println("Image downloaded successfully!");
                    break;
                } catch (Exception e) {
                    System.out.println("There is not image for HTTP status " + code);
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
        scanner.close();
    }
}
