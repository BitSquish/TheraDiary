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

public class SearchController extends CommonController{
    public SearchController(Session session) {
        super(session);
    }

    @FXML
    TextField nomeP, cognomeP, cittaP;
    @FXML
    CheckBox inPresenza, online, pag, includiCategorie;

    @FXML
    private void search(MouseEvent event){
        try{
            TextField[] fields = {nomeP, cognomeP, cittaP};
            checkFields(fields);
            PsychologistBean psychologistBean = null;
            Search searchClass = new Search();
            searchClass.search(nomeP, cognomeP, cittaP, inPresenza, online, pag, includiCategorie);

        } catch (EmptyFieldException exception){
            showAlert("Inserisci il nome dello psicologo.");
        }
    }


    @FXML
    protected void checkFields(TextField[] fields) throws EmptyFieldException {
        //Da modificare, devono essere tutti vuoti
        for(TextField field:fields){
            if (!(field.getText().isEmpty()))
                return;
        }
        throw new EmptyFieldException("Inserisci almeno un campo tra nome, cognome o città");

    }

    private void showAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
