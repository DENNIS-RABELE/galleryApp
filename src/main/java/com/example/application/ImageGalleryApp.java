/*(package com.example.application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.util.List;

public class ImageGalleryApp {
    private GridPane galleryGrid;
    private StackPane fullImageViewPane;
    private ImageView fullImageView;
    private Button backButton;
    private final Stage primaryStage;

    private final List<String> imagePaths = List.of(
            "/images/image1.jpg",
            "/images/image7.jpg",
            "/images/image2.jpg",
            "/images/image4.jpg",
            "/images/image6.jpg",
            "/images/image3.jpg",
            "/images/image5.jpg",
            "/images/image9.jpg",
            "/images/image8.jpg"



    );

    public ImageGalleryApp(Stage stage) {
        this.primaryStage = stage;
        setupUI();
    }

    private void setupUI() {
        primaryStage.setTitle("JavaFX Image Gallery");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/image1.jpg")));

        // Setup Gallery Grid
        galleryGrid = new GridPane();
        galleryGrid.setHgap(10);
        galleryGrid.setVgap(10);
        galleryGrid.setAlignment(Pos.CENTER);
        galleryGrid.getStyleClass().add("gallery-grid");

        // Populate thumbnails
        displayThumbnails();

        // Full Image View Pane
        fullImageViewPane = new StackPane();
        fullImageViewPane.getStyleClass().add("full-image-pane");

        fullImageView = new ImageView();
        fullImageView.setPreserveRatio(true);
        fullImageView.setFitWidth(500);

        backButton = new Button("Back");
        backButton.getStyleClass().add("back-button");
        backButton.setOnAction(event -> showGallery());

        VBox fullImageContainer = new VBox(10, fullImageView, backButton);
        fullImageContainer.setAlignment(Pos.CENTER);
        fullImageViewPane.getChildren().add(fullImageContainer);
        fullImageViewPane.setVisible(false);

        // Main Layout
        StackPane root = new StackPane(galleryGrid, fullImageViewPane);
        Scene scene = new Scene(root, 1380, 700);

        // Load external CSS
        String css = getClass().getResource("/com/example/application/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
    }

    private void displayThumbnails() {
        galleryGrid.getChildren().clear();
        int row = 0, col = 0;

        for (String imagePath : imagePaths) {
            ImageView thumbnail = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
            thumbnail.setFitWidth(150);
            thumbnail.setFitHeight(150);
            thumbnail.setPreserveRatio(true);
            thumbnail.getStyleClass().add("thumbnail");

            thumbnail.setOnMouseClicked(event -> showFullImage(imagePath));

            galleryGrid.add(thumbnail, col, row);
            col++;
            if (col > 2) { // 3 images per row
                col = 0;
                row++;
            }
        }
    }

    private void showFullImage(String imagePath) {
        fullImageView.setImage(new Image(getClass().getResourceAsStream(imagePath)));
        fullImageViewPane.setVisible(true);
    }

    private void showGallery() {
        fullImageViewPane.setVisible(false);
    }

    public void show() {
        primaryStage.show();
    }
})*/

package com.example.application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.util.List;

public class ImageGalleryApp {
    private GridPane galleryGrid;
    private StackPane fullImageViewPane;
    private ImageView fullImageView;
    private Button backButton, prevButton, nextButton;
    private final Stage primaryStage;
    private int currentImageIndex = 0;

    private final List<String> imagePaths = List.of(
            "/images/image1.jpg",
            "/images/image7.jpg",
            "/images/image2.jpg",
            "/images/image4.jpg",
            "/images/image6.jpg",
            "/images/image3.jpg",
            "/images/image5.jpg",
            "/images/image9.jpg",
            "/images/image8.jpg"
    );

    public ImageGalleryApp(Stage stage) {
        this.primaryStage = stage;
        setupUI();
    }

    private void setupUI() {
        primaryStage.setTitle("JavaFX Image Gallery");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/image1.jpg")));

        // Setup Gallery Grid
        galleryGrid = new GridPane();
        galleryGrid.setHgap(10);
        galleryGrid.setVgap(10);
        galleryGrid.setAlignment(Pos.CENTER);
        galleryGrid.getStyleClass().add("gallery-grid");

        // Populate thumbnails
        displayThumbnails();

        // Full Image View Pane
        fullImageViewPane = new StackPane();
        fullImageViewPane.getStyleClass().add("full-image-pane");

        fullImageView = new ImageView();
        fullImageView.setPreserveRatio(true);
        fullImageView.setFitWidth(500);

        // Previous Button
        prevButton = new Button("Previous");
        prevButton.getStyleClass().add("nav-button");
        prevButton.setOnAction(event -> showPreviousImage());

        // Back Button
        backButton = new Button("Back");
        backButton.getStyleClass().add("back-button");
        backButton.setOnAction(event -> showGallery());

        // Next Button
        nextButton = new Button("Next");
        nextButton.getStyleClass().add("nav-button");
        nextButton.setOnAction(event -> showNextImage());

        HBox navigationBar = new HBox(20, prevButton, backButton, nextButton);
        navigationBar.setAlignment(Pos.CENTER);

        VBox fullImageContainer = new VBox(10, fullImageView, navigationBar);
        fullImageContainer.setAlignment(Pos.CENTER);
        fullImageViewPane.getChildren().add(fullImageContainer);
        fullImageViewPane.setVisible(false);

        // Main Layout
        StackPane root = new StackPane(galleryGrid, fullImageViewPane);
        Scene scene = new Scene(root, 1380, 700);

        // Load external CSS
        String css = getClass().getResource("/com/example/application/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
    }

    private void displayThumbnails() {
        galleryGrid.getChildren().clear();
        int row = 0, col = 0;

        for (int i = 0; i < imagePaths.size(); i++) {
            String imagePath = imagePaths.get(i);
            ImageView thumbnail = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
            thumbnail.setFitWidth(150);
            thumbnail.setFitHeight(150);
            thumbnail.setPreserveRatio(true);
            thumbnail.getStyleClass().add("thumbnail");

            final int index = i;
            thumbnail.setOnMouseClicked(event -> showFullImage(index));

            galleryGrid.add(thumbnail, col, row);
            col++;
            if (col > 2) { // 3 images per row
                col = 0;
                row++;
            }
        }
    }

    private void showFullImage(int index) {
        currentImageIndex = index;
        fullImageView.setImage(new Image(getClass().getResourceAsStream(imagePaths.get(index))));
        fullImageViewPane.setVisible(true);
        updateNavButtons();
    }

    private void showPreviousImage() {
        if (currentImageIndex > 0) {
            currentImageIndex--;
            fullImageView.setImage(new Image(getClass().getResourceAsStream(imagePaths.get(currentImageIndex))));
            updateNavButtons();
        }
    }

    private void showNextImage() {
        if (currentImageIndex < imagePaths.size() - 1) {
            currentImageIndex++;
            fullImageView.setImage(new Image(getClass().getResourceAsStream(imagePaths.get(currentImageIndex))));
            updateNavButtons();
        }
    }

    private void updateNavButtons() {
        prevButton.setDisable(currentImageIndex == 0);
        nextButton.setDisable(currentImageIndex == imagePaths.size() - 1);
    }

    private void showGallery() {
        fullImageViewPane.setVisible(false);
    }

    public void show() {
        primaryStage.show();
    }
}


