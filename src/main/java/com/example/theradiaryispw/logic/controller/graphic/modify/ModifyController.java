package com.example.theradiaryispw.logic.controller.graphic.modify;

import com.example.theradiaryispw.logic.controller.graphic.CommonController;
import com.example.theradiaryispw.logic.controller.graphic.account.PatientAccountController;
import com.example.theradiaryispw.logic.controller.graphic.account.PsychologistAccountController;
import com.example.theradiaryispw.logic.controller.graphic.login.LoginController;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


import java.io.IOException;

public abstract class ModifyController extends CommonController {
    public ModifyController(Session session) {
        super(session);
    }

    @FXML
    TextField nome, cognome, citta, mail, descrizione;
    @FXML
    PasswordField password;
    @FXML
    CheckBox inPresenza, online;

    @FXML
    protected void Back(MouseEvent event) throws IOException {
        try {
            FXMLLoader loader;
            if(session.getUser()==null){
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Login.fxml"));
                loader.setControllerFactory(c -> new LoginController(session));
            }else if (session.getUser().getRole().toString().equals("PATIENT")) {
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/PatientAccount.fxml"));
                loader.setControllerFactory(c -> new PatientAccountController(session));
            } else {
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/PsychologistAccount.fxml"));
                loader.setControllerFactory(c -> new PsychologistAccountController(session));
            }
            Parent root = loader.load();
            changeScene(root,event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

