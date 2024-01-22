package org.example;

import org.example.http.HttpImageStatusCli;

public class Main {
    public static void main(String[] args) {
        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();

        httpImageStatusCli.askStatus();
    }
}