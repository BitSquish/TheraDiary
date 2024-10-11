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

    //NOTA: Su registrazione il metodo è privato e viene chiamato dal costruttore. Su login il metodo è statico e non serve istanziare la classe.
    //VEDERE QUALE DELLE DUE SOLUZIONI È MIGLIORE

   /* public Registration(PatientBean patientBean) throws MailAlreadyExistsException {
        registerPatient(patientBean);
    }

    public Registration(PsychologistBean psychologistBean) throws MailAlreadyExistsException {//riferimento al bean dello psicologo
        registerPsychologist(psychologistBean);
    }*/
    public Registration(Object bean) throws MailAlreadyExistsException {
        if(bean instanceof PatientBean)
            registerPatient((PatientBean) bean);
        else
            registerPsychologist((PsychologistBean) bean);
    }

    private void registerPatient(PatientBean patientBean) throws MailAlreadyExistsException {//metodo per registrare un paziente nel database
        Credentials credentials = new Credentials(patientBean.getCredentialsBean().getMail(), patientBean.getCredentialsBean().getPassword(), Role.PATIENT);
        Patient patient = new Patient(credentials, patientBean.getName(), patientBean.getSurname(), patientBean.getCity(), patientBean.getDescription(), patientBean.isInPerson(), patientBean.isOnline(), false);
        try {
            RegistrationDAO.registerPatient(patient);
        } catch (SQLException exception) {
            System.out.println("Error:" + exception.getMessage()); //DA MODIFICARE
            throw new RuntimeException(exception);  //DA VERIFICARE IL TIPO DI ECCEZIONE
        } catch (MailAlreadyExistsException exception) {
            throw new MailAlreadyExistsException(exception.getMessage());
        }
    }

    private void registerPsychologist(PsychologistBean psychologistBean) throws MailAlreadyExistsException {
        Credentials credentials = new Credentials(psychologistBean.getCredentialsBean().getMail(), psychologistBean.getCredentialsBean().getPassword(), Role.PSYCHOLOGIST);
        Psychologist psychologist = new Psychologist(credentials, psychologistBean.getName(), psychologistBean.getSurname(), psychologistBean.getCity(), psychologistBean.getDescription(), psychologistBean.isInPerson(), psychologistBean.isOnline(), psychologistBean.isPag(), null);
        try {
            RegistrationDAO.registerPsychologist(psychologist);
        } catch (SQLException exception) {
            System.out.println("Error:" + exception.getMessage());
            throw new RuntimeException(exception);
        } catch (MailAlreadyExistsException exception){
            throw new MailAlreadyExistsException(exception.getMessage());
        }
    }
}




