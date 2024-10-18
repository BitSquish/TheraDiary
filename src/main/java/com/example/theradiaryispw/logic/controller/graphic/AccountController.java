package com.example.theradiaryispw.logic.controller.graphic;

import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AccountController extends CommonController{

    public AccountController(Session session) {
        super(session);
    }

    @FXML
    private void goToModify(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/res/view/Modify.fxml"));
            loader.setControllerFactory(c -> new ModifyController(session));
            Parent root = loader.load();
            changeScene(root, event);
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
    //da migliorare e rivedere con ema
    /*@FXML
    private void joinPag(MouseEvent event){
        LoggedUser.setPag(true);
    }
    @FXML
    private void goToPAG(MouseEvent event ){
        super.goToPAG(event);
    }*/


}

