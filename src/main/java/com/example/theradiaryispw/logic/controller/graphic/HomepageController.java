package com.example.theradiaryispw.logic.controller.graphic;

import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class HomepageController extends CommonController {
    public HomepageController(Session session) {
        super(session);
    }

    @FXML
    private void startButton(MouseEvent event){
        goToAccountPage(event);
    }


}
