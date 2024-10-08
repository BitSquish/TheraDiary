package com.example.theradiaryispw.logic.controller.application;

import com.example.theradiaryispw.logic.otherClasses.bean.login.PatientBean;
import com.example.theradiaryispw.logic.otherClasses.bean.login.PsychologistBean;
import com.example.theradiaryispw.logic.otherClasses.dao.RegistrationDAO;

import java.sql.SQLException;

public class Registration {
    private PatientBean patientBean;
    private PsychologistBean psychologistBean;


    public Registration(PatientBean patientBean) {
        this.patientBean = patientBean;
        registerPatient();
    }

    public Registration(PsychologistBean psychologistBean) {//riferimento al bean del psicologo
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

//Qui


