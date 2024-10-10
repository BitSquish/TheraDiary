package com.example.theradiaryispw.logic.controller.application;

import com.example.theradiaryispw.logic.model.Patient;
import com.example.theradiaryispw.logic.model.Psychologist;
import com.example.theradiaryispw.logic.model.bean.generic.PatientBean;
import com.example.theradiaryispw.logic.model.bean.generic.PsychologistBean;
import com.example.theradiaryispw.logic.otherClasses.dao.RegistrationDAO;

import java.sql.SQLException;

public class Registration {
    private PatientBean patientBean;
    private PsychologistBean psychologistBean;


    public Registration(PatientBean patientBean) {
        this.patientBean = patientBean;
        registerPatient(patientBean);
    }

    public Registration(PsychologistBean psychologistBean) {//riferimento al bean del psicologo
        this.psychologistBean = psychologistBean;
        registerPsychologist(psychologistBean);
    }

    private void registerPatient(PatientBean patientBean) {//metodo per registrare un paziente nel database
        Patient patient = new Patient(patientBean.getCredentialsBean(), patientBean.getName(), patientBean.getSurname(), patientBean.getCity(), patientBean.getDescription(), patientBean.isInPerson(), patientBean.isOnline(), false, null);
        try {
            RegistrationDAO.registerPatient(patient);
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void registerPsychologist(PsychologistBean psychologistBean) {
        /*try {
            RegistrationDAO.registerPsychologist(psychologist);
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            throw new RuntimeException(e);
        }*/
    }
}




