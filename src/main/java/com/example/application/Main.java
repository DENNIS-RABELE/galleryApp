package com.example.application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        ImageGalleryApp app = new ImageGalleryApp(primaryStage);
        app.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

