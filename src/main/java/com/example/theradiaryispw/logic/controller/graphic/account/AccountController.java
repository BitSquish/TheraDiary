package com.example.theradiaryispw.logic.controller.graphic.account;

import com.example.theradiaryispw.logic.controller.graphic.CommonController;
import com.example.theradiaryispw.logic.controller.graphic.ModifyController;
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
}
   /* @FXML
    ImageView account;

    @FXML
    protected void goToModifyScreen(MouseEvent event) throws IOException {
        try {
            FXMLLoader loader;
            if (session.getUser().getRole().equals("PATIENT")) {
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/ModifyPatient.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/ModifyPsychologist.fxml"));
            }
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
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
            if (session.getUser().getRole().equals("PATIENT")) {
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/HomepageLoggedPt.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("/com/example/res/view/HomepageLoggedPs.fxml"));
            }
            Parent root = loader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}*/

