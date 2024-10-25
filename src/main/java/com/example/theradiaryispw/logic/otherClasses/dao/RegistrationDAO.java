package com.example.theradiaryispw.logic.otherClasses.dao;

import com.example.theradiaryispw.logic.model.Credentials;
import com.example.theradiaryispw.logic.model.MedicalOffice;
import com.example.theradiaryispw.logic.model.Patient;
import com.example.theradiaryispw.logic.model.Psychologist;
import com.example.theradiaryispw.logic.otherClasses.exceptions.MailAlreadyExistsException;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;
import com.example.theradiaryispw.logic.otherClasses.query.LoginAndRegistrationQuery;

import java.sql.Connection;
import java.sql.SQLException;

public class RegistrationDAO {
    //controllo se l'email è presente o meno
    private static boolean emailExists(String mail) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection()){
            int rs = LoginAndRegistrationQuery.checkMail(conn, mail);
             if (rs != 0)
                    return true;
        }
        return false;
    }
    //inserisco l'utente (credenziali) nel database
    public static boolean insertUser(Credentials credentials) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            int rs = LoginAndRegistrationQuery.registerUser(conn, credentials);
            return rs != 0;
        }
    }

    //CREI IL BEAN NEL CONTROLLER GRAFICO E LO PASSI ALL'APPLICATIVO
    //CREI L'ISTANZA NELL'APPLICATIVO COPIANDOLO DAL BEAN E LO PASSI AL DAO
    //NEL DAO MODIFICHI L'ENTITA'
    public static void registerPatient(Patient patient) throws SQLException, MailAlreadyExistsException {
        if(emailExists(patient.getCredentials().getMail())) {
            throw new MailAlreadyExistsException(("Mail già registrata"));
        }//inserisco la password e l'email in user
        boolean flag = insertUser(patient.getCredentials());
        if(flag){
            try (Connection conn = ConnectionFactory.getConnection()){
                LoginAndRegistrationQuery.registerPatient(conn, patient);
            }
            catch(SQLException e){
                throw new SQLException(e.getMessage());
            }
        }
        else
            throw new SQLException(); //DA SOSTITUIRE CON ECCEZIONE SPECIFICA (O FORSE NO?)
    }


    public static void registerPsychologist(Psychologist psychologist) throws SQLException, MailAlreadyExistsException {//stessa cosa che ho fatto sopra ma per lo psicologo
        if (emailExists(psychologist.getCredentials().getMail())) {
            throw new MailAlreadyExistsException("Mail già presente");
        }
        boolean flag = insertUser(psychologist.getCredentials());
        if(flag){
            try (Connection conn = ConnectionFactory.getConnection()) {
                LoginAndRegistrationQuery.registerPsychologist(conn, psychologist);
            }
            catch(SQLException e){
                    throw new SQLException(e.getMessage()); //DA SOSTITUIRE CON ECCEZIONE SPECIFICA PER INSERIMENTO SU PSICOLOGI NON A BUON FINE (O FORSE NO?)
            }
        }
        else
            throw new SQLException(); //DA SOSTITUIRE CON ECCEZIONE SPECIFICA PER INSERIMENTO SU UTENTI NON A BUON FINE (O FORSE NO?)
    }

    public static void registerMedicalOffice(MedicalOffice medicalOffice) throws SQLException {
        try(Connection conn = ConnectionFactory.getConnection()){
            LoginAndRegistrationQuery.registerMedicalOffice(conn, medicalOffice);
        } catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
    }
}

