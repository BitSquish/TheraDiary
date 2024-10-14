package com.example.theradiaryispw.logic.controller.graphic.login;

import com.example.theradiaryispw.logic.controller.application.Login;
import com.example.theradiaryispw.logic.controller.application.Registration;
import com.example.theradiaryispw.logic.controller.graphic.CommonController;
import com.example.theradiaryispw.logic.model.bean.generic.PsychologistBean;
import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.exceptions.*;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public abstract class UserRegistrationController extends CommonController {
    protected UserRegistrationController(Session session) {
        super(session);
    }

    @FXML
    TextField nome, cognome, citta, mail, descrizione;
    @FXML
    PasswordField password;
    @FXML
    CheckBox inPresenza, online;

    @FXML
    protected void checkFields(TextField[] fields) throws EmptyFieldException {
        for (TextField field : fields) {
            if (field.getText().isEmpty()) {
                throw new EmptyFieldException("Compila tutti i campi");
            }
        }
    }

    protected void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore di registrazione");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    protected void registerGenericUser(MouseEvent event,CredentialsBean credentialsBean, Object bean) {
        try{
            Registration registration = new Registration(bean);
            // Pop-up che segnala successo registrazione
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registrazione");
            alert.setHeaderText(null);
            alert.setContentText("Registrato con successo");
            alert.showAndWait();

            // Se la registrazione va a buon fine, effettua automaticamente il login
            Login login = new Login();
            login.log(credentialsBean);
            session.setUser(credentialsBean);
            goToHomepage(event);
        } catch (MailAlreadyExistsException | WrongEmailOrPasswordException exception){
            showAlert(exception.getMessage());
        }

    }
}
