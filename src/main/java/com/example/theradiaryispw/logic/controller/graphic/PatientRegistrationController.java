package com.example.theradiaryispw.logic.controller.graphic;

import com.example.theradiaryispw.logic.controller.application.Login;
import com.example.theradiaryispw.logic.controller.application.Registration;
import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.PatientBean;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientRegistrationController extends CommonController{
    public PatientRegistrationController(Session session) {
        super(session);
    }

    @FXML
    TextField nome, cognome, citta, mail,  descrizione;
    @FXML
    PasswordField password;
    @FXML
    CheckBox inPresenza, online;

    @FXML
    private void addPatient(MouseEvent event){
        String mailPt = mail.getText();
        String passwordPt = password.getText();
        Role role = Role.valueOf("PATIENT");
        String name = nome.getText();
        String surname = cognome.getText();
        String city = citta.getText();
        String description = descrizione.getText();
        Boolean isInPerson = inPresenza.isSelected();
        Boolean isOnline = online.isSelected();
        Boolean isPAG = false;

        CredentialsBean credentialsBean = new CredentialsBean(mailPt, passwordPt, role);
        PatientBean patientBean = new PatientBean(new LoggedUserBean(credentialsBean, name, surname, city, description, isInPerson, isOnline, isPAG));
        new Registration(patientBean);//creazione dell'istanza di registration per il paziente
        //Pop-up che segnala successo registrazione
        Alert alert= new Alert(AlertType.INFORMATION);//pop up alla fine della registrazione
        alert.setTitle("Registrazione");
        alert.setHeaderText(null);
        alert.setContentText("Registrato con successo. Ricorda di completare il tuo profilo nella sezione account!");
        alert.showAndWait();
        //Se la registrazione va a buon fine, effettua automaticamente il login
        Login login = new Login();
        LoggedUserBean loggedUserBean = login.log(credentialsBean);
        session.setUser(loggedUserBean);
        goToHomepage(event);




    }
}
