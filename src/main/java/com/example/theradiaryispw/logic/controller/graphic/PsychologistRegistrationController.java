package com.example.theradiaryispw.logic.controller.graphic;

import com.example.theradiaryispw.logic.controller.application.Login;
import com.example.theradiaryispw.logic.controller.application.Registration;
import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.PatientBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.PsychologistBean;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
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
        //Pop-up che segnala successo registrazione
        Alert alert= new Alert(Alert.AlertType.INFORMATION);//pop up alla fine della registrazione
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
