package com.example.theradiaryispw.logic.controller.graphic;

import com.example.theradiaryispw.logic.controller.application.MedicalOfficeRegistration;
import com.example.theradiaryispw.logic.model.bean.generic.MedicalOfficeBean;
import com.example.theradiaryispw.logic.otherClasses.exceptions.EmptyFieldException;
import com.example.theradiaryispw.logic.otherClasses.other.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class MedicalOfficeController extends CommonController{
    protected MedicalOfficeController(Session session) {
        super(session);
    }

    @FXML
    TextField citta, cap, via, altreInfo;
    @FXML
    Label errorMessage;

    @FXML
    private void register(MouseEvent event){
        //VA GESTITO IL CASO DI MODIFICA DEI DATI
        errorMessage.setVisible(false);
        try{
            TextField[] fields = {citta, cap, via};
            checkFields(fields);
            MedicalOfficeBean medicalOfficeBean = new MedicalOfficeBean(session.getUser().getMail(), citta.getText(), cap.getText(), via.getText(), altreInfo.getText());
            MedicalOfficeRegistration medicalOffice = new MedicalOfficeRegistration();
            medicalOffice.register(medicalOfficeBean);
            System.out.println("Registrato con successo"); //DA IMPLEMENTARE INTERFACCIA GRAFICA
        }catch(EmptyFieldException exception){
            errorMessage.setText(exception.getMessage());
            errorMessage.setVisible(true);
        } catch (SQLException e) {
            throw new RuntimeException(e); //DA VERIFICARE ECCEZIONE
        }

    }

    @FXML
    protected void checkFields(TextField[] fields) throws EmptyFieldException {
        for(TextField field:fields){
            if (field.getText().isEmpty())
                throw new EmptyFieldException("Devi obbligatoriamente inserire città, cap e via.");
        }
    }
}
