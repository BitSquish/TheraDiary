package com.example.theradiaryispw.logic.controller.graphic.login;

import com.example.theradiaryispw.logic.controller.graphic.CommonController;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

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

    /*@FXML
    private void addPsychologist(MouseEvent event){
        boolean Errore=false;
        //controllo che i campi non siano vuoti
        if(mail.getText().isEmpty()){
            Errore=true;
        }
        if(password.getText().isEmpty()){
            Errore=true;
        }
        if(nome.getText().isEmpty()){
            Errore=true;
        }
        if(cognome.getText().isEmpty()){
            Errore=true;
        }
        if(citta.getText().isEmpty()){
            Errore=true;
        }
        if(descrizione.getText().isEmpty()){
            Errore=true;
        }
        //Se ci sono errori, mostro un pop up di errore
        if(Errore){
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore di registrazione");
            alert.setHeaderText(null);
            alert.setContentText("Per favore, compila tutti i campi.");
            alert.showAndWait();
            return; //esco dal metodo
        }
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
        Psychologist psychologistBean = new Psychologist(new LoggedUser(credentialsBean, name, surname, city, description, isInPerson, isOnline, isPAG));
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
        LoggedUser loggedUser = login.log(credentialsBean);
        session.setUser(loggedUser);
        goToHomepage(event);




    }*/
}
