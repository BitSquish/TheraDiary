package com.example.theradiaryispw.logic.controller.graphic.login;

import com.example.theradiaryispw.logic.model.bean.generic.PsychologistBean;
import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.exceptions.EmptyFieldException;
import com.example.theradiaryispw.logic.otherClasses.exceptions.MailAlreadyExistsException;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PsychologistRegistrationController extends UserRegistrationController {

    public PsychologistRegistrationController(Session session) {
        super(session);
    }
    @FXML
    CheckBox pag;
    @FXML
    ImageView infoButton;
    @FXML
    Label infoPAG;
    private boolean isVisible = false;

    @FXML
    public void clickInfoButton() {
        // Event handler al clic sull'ImageView
        infoButton.setOnMouseClicked(event -> showInfoLabel());
    }

    private void showInfoLabel() {
        // Alterna la visibilità della label
        isVisible = !isVisible;
        infoPAG.setVisible(isVisible);
    }

    @FXML
    private void registerPsychologist(MouseEvent event) throws EmptyFieldException, MailAlreadyExistsException {
        try{
            TextField[] fields = {nome, cognome, citta, mail, descrizione};
            checkFields(fields);
            CredentialsBean credentialsBean = new CredentialsBean(mail.getText(), password.getText(), Role.valueOf("PATIENT"));
            PsychologistBean psychologistBean = new PsychologistBean(credentialsBean, nome.getText(), cognome.getText(), citta.getText(), descrizione.getText(), inPresenza.isSelected(), online.isSelected(), pag.isSelected(), null);
            registerGenericUser(event, credentialsBean, psychologistBean);
        } catch (EmptyFieldException exception){
            showAlert("Compila tutti i campi");
        }

    }
}