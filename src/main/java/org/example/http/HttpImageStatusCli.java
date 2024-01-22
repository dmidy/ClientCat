package org.example.http;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus(){
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        Scanner scanner = new Scanner(System.in);

        int code = 0;

        while (true) {
            System.out.println("Enter HTTP status code:");

            if (scanner.hasNextInt()) {
                code = scanner.nextInt();
                try {
                    httpStatusImageDownloader.downloadStatusImage(code);
                    break;
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
