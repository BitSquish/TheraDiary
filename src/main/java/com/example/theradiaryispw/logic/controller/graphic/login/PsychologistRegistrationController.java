package com.example.theradiaryispw.logic.controller.graphic.login;

import com.example.theradiaryispw.logic.controller.application.Login;
import com.example.theradiaryispw.logic.controller.application.Registration;
import com.example.theradiaryispw.logic.controller.graphic.CommonController;

import com.example.theradiaryispw.logic.model.LoggedUser;
import com.example.theradiaryispw.logic.model.Psychologist;
import com.example.theradiaryispw.logic.model.bean.generic.PsychologistBean;
import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.exceptions.EmptyFieldException;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PsychologistRegistrationController extends CommonController {
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
    private void addPsychologist(MouseEvent event) throws EmptyFieldException{
        try{
            if(checkFields())
                throw new EmptyFieldException("Compila tutti i campi");
                CredentialsBean credentialsBean = new CredentialsBean(mail.getText(), password.getText(), Role.convertIntToRole(1));
                PsychologistBean psychologistBean = new PsychologistBean(credentialsBean, nome.getText(), cognome.getText(), citta.getText(), descrizione.getText(), inPresenza.isSelected(), online.isSelected(), adesionePAG.isSelected(), null);
                Registration registration = new Registration(psychologistBean);
          //Pop-up che segnala successo registrazione
            Alert alert= new Alert(Alert.AlertType.INFORMATION);//pop up alla fine della registrazione
            alert.setTitle("Registrazione");
            alert.setHeaderText(null);
            alert.setContentText("Registrazione avvenuta con successo");
            alert.showAndWait();
            //Login
            Login login =new Login();
            login.log(credentialsBean);
            goToHomepage(event);
        }catch(EmptyFieldException exception){
            showAlert("Per favore, compila tutti i campi");
        }

    }
}