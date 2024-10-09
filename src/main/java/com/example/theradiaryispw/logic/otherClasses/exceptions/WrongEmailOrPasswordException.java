package com.example.theradiaryispw.logic.otherClasses.exceptions;

import javafx.scene.control.Alert;

public class WrongEmailOrPasswordException extends Exception {
    public WrongEmailOrPasswordException(String message) {
        super(message);
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore di login");
        alert.setHeaderText(null);
        alert.setContentText(getMessage());
        alert.showAndWait();
    }
}
