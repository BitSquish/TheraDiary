package com.example.theradiaryispw.logic.controller.graphic.login;
import com.example.theradiaryispw.logic.model.bean.generic.PatientBean;
import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;


public class PatientRegistrationController extends UserRegistrationController {
    public PatientRegistrationController(Session session) {
        super(session);
    }


    @FXML
    private void registerPatient(MouseEvent event) {
        CredentialsBean credentialsBean = new CredentialsBean(mail.getText(), password.getText(), Role.valueOf("PATIENT"));
        PatientBean patientBean = new PatientBean(credentialsBean, nome.getText(), cognome.getText(), citta.getText(), descrizione.getText(), inPresenza.isSelected(), online.isSelected(), false, null, null);
        registerGenericUser(event, credentialsBean, patientBean);
    }
}
