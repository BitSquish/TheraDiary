package com.example.theradiaryispw.logic.controller.application;

import com.example.theradiaryispw.logic.model.Credentials;
import com.example.theradiaryispw.logic.model.Patient;
import com.example.theradiaryispw.logic.model.Psychologist;
import com.example.theradiaryispw.logic.model.bean.generic.PatientBean;
import com.example.theradiaryispw.logic.model.bean.generic.PsychologistBean;
import com.example.theradiaryispw.logic.otherClasses.dao.RegistrationDAO;
import com.example.theradiaryispw.logic.otherClasses.exceptions.MailAlreadyExistsException;
import com.example.theradiaryispw.logic.otherClasses.other.Role;

import java.sql.SQLException;

public class Registration {
    private PatientBean patientBean;
    private PsychologistBean psychologistBean;

    //NOTA: Su registrazione il metodo è privato e viene chiamato dal costruttore. Su login il metodo è statico e non serve istanziare la classe.
    //VEDERE QUALE DELLE DUE SOLUZIONI È MIGLIORE

    public Registration(PatientBean patientBean) {
        this.patientBean = patientBean;
        registerPatient(patientBean);
    }

    public Registration(PsychologistBean psychologistBean) {//riferimento al bean dello psicologo
        this.psychologistBean = psychologistBean;
        registerPsychologist(psychologistBean);
    }

    private void registerPatient(PatientBean patientBean) {//metodo per registrare un paziente nel database
        Credentials credentials = new Credentials(patientBean.getCredentialsBean().getMail(), patientBean.getCredentialsBean().getPassword(), Role.PATIENT);
        Patient patient = new Patient(credentials, patientBean.getName(), patientBean.getSurname(), patientBean.getCity(), patientBean.getDescription(), patientBean.isInPerson(), patientBean.isOnline(), false, null);
        try {
            RegistrationDAO.registerPatient(patient);
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
            throw new RuntimeException(e);
        } catch (MailAlreadyExistsException e) {
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




