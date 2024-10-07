package com.example.theradiaryispw.logic.controller.graphic;

import com.example.theradiaryispw.logic.controller.application.Login;
import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.LoggedUserBean;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
//Commento
public class LoginController extends CommonController{

    public LoginController(Session session) {
        super(session);
    }

    @FXML
    TextField mail;
    @FXML
    PasswordField password;

   @FXML
    private void setCredentials(MouseEvent event){
        String mailCred = mail.getText();
        String passwordCred = password.getText();
        boolean validCredentials = false;
        CredentialsBean credentialsBean = new CredentialsBean(mailCred, passwordCred, null);
        Login login = new Login();
        LoggedUserBean loggedUserBean = login.log(credentialsBean);
        session.setUser(loggedUserBean);
        goToHomepage(event);
        //passo i parametri di loggedUser alla sessione
    }

    @FXML
    private void goToPatientRegistration(MouseEvent event){
       try{
           FXMLLoader loader;
           loader = new FXMLLoader(getClass().getResource("/com/example/res/view/PatientRegistration.fxml"));
           loader.setControllerFactory(c -> new PatientRegistrationController(session));
           Parent root = loader.load();
           changeScene(root, event);
       } catch(IOException e){
           throw new RuntimeException(e);
       }
    }

    @FXML
    private void goToPsychologistRegistration(MouseEvent event){
        try{
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("/com/example/res/view/PsychologistRegistration.fxml"));
            loader.setControllerFactory(c -> new PsychologistRegistrationController(session));
            Parent root = loader.load();
            changeScene(root, event);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

}
