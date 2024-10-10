package com.example.theradiaryispw.logic.controller.graphic.login;

import com.example.theradiaryispw.logic.controller.application.Login;
import com.example.theradiaryispw.logic.controller.graphic.*;
import com.example.theradiaryispw.logic.model.Credentials;
import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.otherClasses.exceptions.EmptyFieldException;
import com.example.theradiaryispw.logic.otherClasses.exceptions.WrongEmailOrPasswordException;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class LoginController extends CommonController {

    public LoginController(Session session) {
        super(session);
    }

    @FXML
    TextField mail;
    @FXML
    PasswordField password;

    @FXML
    private void setCredentials(MouseEvent event) throws IOException {
        try{
            validateFields();
            CredentialsBean credentialsBean = new CredentialsBean(mail.getText(), password.getText(), null);
            Login login = new Login();
            login.log(credentialsBean);
            if(credentialsBean.getRole() != null){
                session.setUser(credentialsBean);
                goToHomepage(event, credentialsBean.getRole());
                System.out.println("mail: " + credentialsBean.getMail());
            }
            else{
                throw new WrongEmailOrPasswordException("Mail o password errati");

            }
        }catch(WrongEmailOrPasswordException exception){
            showAlert("Mail o password errati");  //Si può sfruttare exception.getMessage()?
        } catch (EmptyFieldException exception) {
            showAlert("Compila tutti i campi"); //idem
        }


    }

    private Connection getConnection() throws SQLException { //Mai usato???
        // Abstracted database connection method
        return ConnectionFactory.getConnection();
    }
    private void validateFields() throws  EmptyFieldException {
        if (mail.getText().isEmpty() || password.getText().isEmpty()) {
            throw new EmptyFieldException("Per favore compila tutti campi.");
        }
    }
    private void showAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore nel login");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    private void goToHomepage(MouseEvent event, Role role) throws IOException {
        FXMLLoader loader;
        if (role.equals(Role.PATIENT)) {
            loader = new FXMLLoader(getClass().getResource("/com/example/res/view/HomepageLoggedPt.fxml"));
            loader.setControllerFactory(c -> new HomepagePtLoggedController(session));
        } else {
            loader = new FXMLLoader(getClass().getResource("/com/example/res/view/HomepageLoggedPs.fxml"));
            loader.setControllerFactory(c -> new HomepageLoggedPsController(session));
        }
        Parent root = loader.load();
        changeScene(root, event);
    }


    @FXML
    private void goToPatientRegistration(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/res/view/PatientRegistration.fxml"));
            loader.setControllerFactory(c -> new PatientRegistrationController(session));
            Parent root = loader.load();
            changeScene(root, event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void goToPsychologistRegistration(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/res/view/PsychologistRegistration.fxml"));
            loader.setControllerFactory(c -> new PsychologistRegistrationController(session));
            Parent root = loader.load();
            changeScene(root, event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}