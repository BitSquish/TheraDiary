package com.example.theradiaryispw.logic.controller.graphic.account;

import com.example.theradiaryispw.logic.controller.graphic.CommonController;
import com.example.theradiaryispw.logic.controller.graphic.HomepageLoggedPsController;
import com.example.theradiaryispw.logic.controller.graphic.HomepagePtLoggedController;
import com.example.theradiaryispw.logic.controller.graphic.ModifyController;
import com.example.theradiaryispw.logic.controller.graphic.login.LoginController;
import com.example.theradiaryispw.logic.controller.graphic.modify.ModifyPatientController;
import com.example.theradiaryispw.logic.controller.graphic.modify.ModifyPsychologistController;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class AccountController extends CommonController {

    protected AccountController(Session session) {
        super(session);
    }

    @FXML
    ImageView account;

    @FXML
    protected void goToModifyScreen(MouseEvent event) throws IOException {
        try {
            FXMLLoader loader;
            if(session.getUser()==null){
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Login.fxml"));
                loader.setControllerFactory(c -> new LoginController(session));
            }else if (session.getUser().getRole().toString().equals("PATIENT")) {
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/ModifyPatient.fxml"));
                loader.setControllerFactory(c -> new ModifyPatientController(session));
            } else  {
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/ModifyPsychologist.fxml"));
                loader.setControllerFactory(c -> new ModifyPsychologistController(session));
            }
            Parent root = loader.load();
            changeScene(root,event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void joinPag() {
        // Implementa la logica per aderire al PAG
    }

    @FXML
    protected void logout(MouseEvent event) throws IOException {
        session.setUser(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Login.fxml"));
        loader.setControllerFactory(c -> new LoginController(session));
        Parent root = loader.load();
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    protected void handleCheckBoxSave(CheckBox checkBox) {
        // Implementa la logica per salvare lo stato della CheckBox
    }

    @FXML
    protected void goBack(MouseEvent event) throws IOException {
        try {
            FXMLLoader loader;
            if(session.getUser()==null){
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Login.fxml"));
                loader.setControllerFactory(c -> new LoginController(session));
            }else if (session.getUser().getRole().toString().equals("PATIENT")) {
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/HomepageLoggedPt.fxml"));
                loader.setControllerFactory(c -> new HomepagePtLoggedController(session));
            } else {
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/HomepageLoggedPs.fxml"));
                loader.setControllerFactory(c -> new HomepageLoggedPsController(session));
            }
            Parent root = loader.load();
            changeScene(root,event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


