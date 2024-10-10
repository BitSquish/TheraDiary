package com.example.theradiaryispw.logic.controller.graphic.login;

import com.example.theradiaryispw.logic.controller.application.Registration;
import com.example.theradiaryispw.logic.controller.graphic.CommonController;
import com.example.theradiaryispw.logic.model.bean.generic.PatientBean;
import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PatientRegistrationController extends CommonController {
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
        CredentialsBean credentialsBean = new CredentialsBean(mail.getText(), password.getText(), Role.convertIntToRole(2));
        PatientBean patientBean = new PatientBean(credentialsBean, nome.getText(), cognome.getText(), citta.getText(), descrizione.getText(), inPresenza.isSelected(), online.isSelected(), false, null);
        Registration registration = new Registration(patientBean);

    }

    /*@FXML
    private void addPatient(MouseEvent event){
        boolean Errore=false;
        //controllo che i campi non siano vuoti
        if(mail.getText().isEmpty() || password.getText().isEmpty() || nome.getText().isEmpty() || cognome.getText().isEmpty()
        || citta.getText().isEmpty() || descrizione.getText().isEmpty()){
            Errore=true;
        }

        //Se ci sono errori, mostro un pop up di errore
        if(Errore){
            Alert alert= new Alert(AlertType.ERROR);
            alert.setTitle("Errore di registrazione");
            alert.setHeaderText(null);
            alert.setContentText("Per favore, compila tutti i campi.");
            alert.showAndWait();
            return; //esco dal metodo
        }
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
        Patient patientBean = new Patient(new LoggedUser(credentialsBean, name, surname, city, description, isInPerson, isOnline, isPAG));
        new Registration(patientBean);//creazione dell'istanza di registration per il paziente
        //Pop-up che segnala successo registrazione
        Alert alert= new Alert(AlertType.INFORMATION);//pop up alla fine della registrazione
        alert.setTitle("Registrazione");
        alert.setHeaderText(null);
        alert.setContentText("Registrato con successo. Ricorda di completare il tuo profilo nella sezione account!");
        alert.showAndWait();
        //Se la registrazione va a buon fine, effettua automaticamente il login
        Login login = new Login();
        LoggedUser loggedUser = login.log(credentialsBean);
        session.setUser(loggedUser);
        goToHomepage(event);




    }*/
}
