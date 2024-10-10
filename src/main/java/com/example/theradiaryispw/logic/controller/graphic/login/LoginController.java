package com.example.theradiaryispw.logic.controller.graphic.login;

import com.example.theradiaryispw.logic.controller.graphic.*;
import com.example.theradiaryispw.logic.otherClasses.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.model.LoggedUser;
import com.example.theradiaryispw.logic.otherClasses.exceptions.EmptyFieldException;
import com.example.theradiaryispw.logic.otherClasses.exceptions.LoginDBException;
import com.example.theradiaryispw.logic.otherClasses.exceptions.WrongEmailOrPasswordException;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;
import com.example.theradiaryispw.logic.otherClasses.other.Role;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import com.example.theradiaryispw.logic.otherClasses.query.LoginQuery;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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
    private void setCredentials(MouseEvent event) throws LoginDBException,WrongEmailOrPasswordException,SQLException{
            try {
                validateFields();
                String mailCred = mail.getText();
                String passwordCred = password.getText();
                CredentialsBean credentialsBean = new CredentialsBean(mailCred, passwordCred, null);

                try (Connection conn = getConnection()) {
                    ResultSet rs = LoginQuery.logQuery(conn, credentialsBean);
                    if (rs.next()) {
                        String mail = rs.getString("mail");
                        String password = rs.getString("password");
                        Role role = Role.valueOf(rs.getString("role").toUpperCase());

                        LoggedUser logged = new LoggedUser(mail, password, role);
                        session.setUser(logged);
                        goToHomepage(event, role);
                    } else {
                        throw new LoginDBException("Email o password errate");
                    }
                }
            } catch (EmptyFieldException e) {
                showAlert("Errore di login", e.getMessage());
            } catch (LoginDBException dbe) {
                WrongEmailOrPasswordException weope = new WrongEmailOrPasswordException("Email o password errate");
                weope.showAlert();
                throw weope;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new SQLException("Per piacere ritenta");
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Errore di sistema", "Errore durante il caricamento della homepage.");
            }
        }
    private Connection getConnection() throws SQLException {
        // Abstracted database connection method
        return ConnectionFactory.getConnection();
    }
    private void validateFields() throws  EmptyFieldException {
        if (mail.getText().isEmpty() || password.getText().isEmpty()) {
            throw new EmptyFieldException("Per favore compila tutti campi.");
        }
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
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