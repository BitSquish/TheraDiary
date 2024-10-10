package com.example.theradiaryispw.logic.otherClasses.exceptions;

import javafx.scene.control.Alert;

public class MailAlreadyExistsException extends Exception{
    public MailAlreadyExistsException(String message){super(message);}

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText("Mail già in uso");
        alert.showAndWait();
    } //SPOSTARE ALERT SU GRAFICO
}
