package com.example.theradiaryispw.logic.controller.graphic;

import com.example.theradiaryispw.logic.controller.application.Registration;
import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.PatientBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.PsychologistBean;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PsychologistRegistrationController extends CommonController{
    public PsychologistRegistrationController(Session session) {
        super(session);
    }

    @FXML
    TextField nome, cognome, citta, mail,  descrizione;
    @FXML
    PasswordField password;
    @FXML
    CheckBox inPresenza, online, adesionePAG;

    @FXML
    private void addPsychologist(MouseEvent event){
        String mailPs = mail.getText();
        String passwordPs = password.getText();
        Role role = Role.valueOf("PSYCHOLOGIST");
        String name = nome.getText();
        String surname = cognome.getText();
        String city = citta.getText();
        String description = descrizione.getText();
        Boolean isInPerson = inPresenza.isSelected();
        Boolean isOnline = online.isSelected();
        Boolean isPAG = adesionePAG.isSelected();

        CredentialsBean credentialsBean = new CredentialsBean(mailPs, passwordPs, role);
        PsychologistBean psychologistBean = new PsychologistBean(new LoggedUserBean(credentialsBean, name, surname, city, description, isInPerson, isOnline, isPAG));
        //creazione dell'istanza di Registration per lo psicologo essendo i metodi privati
        new Registration(psychologistBean);

        Alert alert= new Alert(Alert.AlertType.INFORMATION);//pop up alla fine della registrazione
        alert.setTitle("Registrazione");
        alert.setHeaderText(null);
        alert.setContentText("Registrato con successo");
        alert.showAndWait();
    }
}
