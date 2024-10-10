package com.example.theradiaryispw.logic.controller.application;

import com.example.theradiaryispw.logic.model.Patient;
import com.example.theradiaryispw.logic.model.Psychologist;
import com.example.theradiaryispw.logic.otherClasses.dao.RegistrationDAO;

import java.sql.SQLException;

public class Registration {
    private Patient patientBean;
    private Psychologist psychologistBean;


    public Registration(Patient patientBean) {
        this.patientBean = patientBean;
        registerPatient();
    }

    public Registration(Psychologist psychologistBean) {//riferimento al bean del psicologo
        this.psychologistBean = psychologistBean;
        registerPsychologist();
    }

    private void registerPatient() {//metodo per registrare un paziente nel database
        try {
            RegistrationDAO.registerPatient(patientBean);
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void registerPsychologist() {
        try {
            RegistrationDAO.registerPsychologist(psychologistBean);
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}




