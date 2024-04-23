package com.example.theradiaryispw.logic.view;

import com.example.theradiaryispw.logic.controller.graphic.HomepageController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import com.example.theradiaryispw.logic.otherClasses.other.Session;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Session session = new Session(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/res/view/HomepageNotLogged.fxml"));
        loader.setControllerFactory(c -> new HomepageController(session)); //Controller homepage
        Parent rootParent = loader.load();

        Scene scene = new Scene(rootParent);
        stage.setTitle("Theradiary");
        // stage.getIcons().add(new Image("/logic/view/images/utente.jpg"));
        stage.setScene(scene);
        stage.setResizable(false);

        // Add an event filter to the primary stage to handle the ESC key
        stage.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                event.consume();
                Platform.exit();
            }
        });
        stage.show();
    }
}