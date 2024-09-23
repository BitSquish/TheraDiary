package com.example.theradiaryispw.logic.controller.graphic;

import com.example.theradiaryispw.logic.controller.application.Registration;
import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.PatientBean;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PatientRegistrationController extends CommonController{
    public PatientRegistrationController(Session session) {
        super(session);
    }

    @FXML
    TextField nome, cognome, citta, mail, password, descrizione;
    @FXML
    CheckBox inPresenza, online, adesionePAG;

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
        Boolean isPAG = online.isSelected();

        CredentialsBean credentialsBean = new CredentialsBean(mailPt, passwordPt, role);
        PatientBean patientBean = new PatientBean(new LoggedUserBean(credentialsBean, name, surname, city, description, isInPerson, isOnline, isPAG));
        Registration registration = new Registration(patientBean);
        System.out.println("Registrato");
    }
}
