package com.example.theradiaryispw.logic.controller.graphic.login;

import com.example.theradiaryispw.logic.controller.application.Login;
import com.example.theradiaryispw.logic.controller.application.Registration;
import com.example.theradiaryispw.logic.controller.graphic.CommonController;
import com.example.theradiaryispw.logic.model.bean.generic.LoggedUserBean;
import com.example.theradiaryispw.logic.model.bean.generic.PatientBean;
import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.exceptions.EmptyFieldException;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private boolean checkFields(){
        //controllo che i campi non siano vuoti
        if(mail.getText().isEmpty() || password.getText().isEmpty() || nome.getText().isEmpty() || cognome.getText().isEmpty()
                || citta.getText().isEmpty() || descrizione.getText().isEmpty()){
            return true;
        }
        return false;
    }

    private void showAlert(String message){
        Alert alert= new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore di registrazione");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void addPatient(MouseEvent event) throws EmptyFieldException {
        try{
            if(checkFields())
                throw new EmptyFieldException("Compila tutti i campi");
            CredentialsBean credentialsBean = new CredentialsBean(mail.getText(), password.getText(), Role.convertIntToRole(2));
            PatientBean patientBean = new PatientBean(credentialsBean, nome.getText(), cognome.getText(), citta.getText(), descrizione.getText(), inPresenza.isSelected(), online.isSelected(), false, null);
            Registration registration = new Registration(patientBean);
            //Pop-up che segnala successo registrazione
            Alert alert= new Alert(Alert.AlertType.INFORMATION);//pop up alla fine della registrazione
            alert.setTitle("Registrazione");
            alert.setHeaderText(null);
            alert.setContentText("Registrato con successo");
            alert.setContentText("Registrato con successo. Ricorda di completare il tuo profilo nella sezione account!");
            alert.showAndWait();

            //Se la registrazione va a buon fine, effettua automaticamente il login
            Login login = new Login();
            login.log(credentialsBean);
            session.setUser(credentialsBean);
            goToHomepage(event);
        } catch (EmptyFieldException exception){
            showAlert("Per favore, compila tutti i campi"); //c'è un modo di farlo con exception.getMessage()?
        }
    }
}
