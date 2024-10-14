package com.example.theradiaryispw.logic.controller.graphic;

import com.example.theradiaryispw.logic.controller.application.Search;
import com.example.theradiaryispw.logic.model.bean.generic.PsychologistBean;
import com.example.theradiaryispw.logic.otherClasses.exceptions.EmptyFieldException;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchController extends CommonController{
    public SearchController(Session session) {
        super(session);
    }

    @FXML
    TextField nomeP, cognomeP, cittaP;
    @FXML
    CheckBox inPresenza, online, pag;

    @FXML
    private void search(MouseEvent event){
        try{
            TextField[] fields = {cognomeP, cittaP};
            checkFields(fields);
            List<PsychologistBean> psychologistBeans = new ArrayList<>();
            Search searchClass = new Search();
            searchClass.search(psychologistBeans,nomeP, cognomeP, cittaP, inPresenza, online, pag);
            for(PsychologistBean psychologistBean:psychologistBeans){
                System.out.println("Mail: " + psychologistBean.getCredentialsBean().getMail());
                System.out.println("Nome: " + psychologistBean.getName());
                System.out.println("Cognome: " + psychologistBean.getSurname());
                System.out.println("Città: " + psychologistBean.getCity());
                System.out.println("Descrizione: " + psychologistBean.getDescription());
                System.out.println("In presenza: " + psychologistBean.isInPerson());
                System.out.println("Online: " + psychologistBean.isOnline());
                System.out.println("Adesione PAG: " + psychologistBean.isPag());
            }
        } catch (EmptyFieldException exception){
            showAlert(exception.getMessage());
        }
    }


    @FXML
    protected void checkFields(TextField[] fields) throws EmptyFieldException {
        //Da modificare, devono essere tutti vuoti
        for(TextField field:fields){
            if (!(field.getText().isEmpty()))
                return;
        }
        throw new EmptyFieldException("Inserisci almeno almeno un campo tra cognome e città");

    }

    private void showAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
