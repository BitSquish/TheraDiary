package com.example.theradiaryispw.logic.otherClasses.dao;

import com.example.theradiaryispw.logic.model.bean.generic.PsychologistBean;
import com.example.theradiaryispw.logic.model.bean.login.CredentialsBean;
import com.example.theradiaryispw.logic.model.Patient;
import com.example.theradiaryispw.logic.otherClasses.other.ConnectionFactory;
import com.example.theradiaryispw.logic.otherClasses.query.LoginQuery;

import java.sql.Connection;
import java.sql.SQLException;

public class RegistrationDAO {
    private RegistrationDAO(){}
    //controllo se l'email è presente o meno
    public static boolean emailExists(String mail) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection()){
            int rs = LoginQuery.checkMail(conn, mail);
             if (rs != 0)
                    return true;
        }
        return false;
    }
    //inserisco l'utente (credenziali) nel database
    public static boolean insertUser(CredentialsBean credentialsBean) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            int rs = LoginQuery.registerUser(conn, credentialsBean);
            return rs != 0;
        }
    }

    //CREI IL BEAN NEL CONTROLLER GRAFICO E LO PASSI ALL'APPLICATIVO
    //CREI L'ISTANZA NELL'APPLICATIVO COPIANDOLO DAL BEAN E LO PASSI AL DAO
    //NEL DAO MODIFICHI L'ENTITA'
    public static void registerPatient(Patient patientBean) throws SQLException{
        if(emailExists(patientBean.getCredentialsBean().getMail())) {
            throw new SQLException(("Mail già presente nel database")); //NON VA BENE SQL
        }//inserisco la password e l'email in user
        boolean flag = insertUser(patientBean.getCredentialsBean());
        if(flag){
            try (Connection conn = ConnectionFactory.getConnection()){
                int rs = LoginQuery.registerPatient(conn, patientBean);
                if(rs != 0){
                    System.out.println("Registrato con successo");
                    //QUALCOSA  PER ANDARE AL LOGIN
                }
                else
                    throw new SQLException(); //DA SOSTITUIRE CON ECCEZIONE SPECIFICA PER INSERIMENTO SU PSICOLOGI NON A BUON FINE (O FORSE NO?)
            }
        }
        else
            throw new SQLException(); //DA SOSTITUIRE CON ECCEZIONE SPECIFICA (O FORSE NO?)
    }


    /*public static void registerPsychologist(PsychologistBean psychologistBean) throws SQLException {//stessa cosa che ho fatto sopra ma per lo psicologo
        if (emailExists(psychologistBean.getCredentialsBean().getMail())) {
            throw new SQLException("Mail già presente nel database");
        }
        boolean flag = insertUser(psychologistBean.getCredentialsBean());
        if(flag){
            try (Connection conn = ConnectionFactory.getConnection()){
                int rs = LoginQuery.registerPsychologist(conn, psychologistBean);
                if(rs != 0){
                    System.out.println("Registrato con successo");
                    //QUALCOSA PER ANDARE AL LOGIN
                }
                else
                    throw new SQLException(); //DA SOSTITUIRE CON ECCEZIONE SPECIFICA PER INSERIMENTO SU PSICOLOGI NON A BUON FINE (O FORSE NO?)
            }
        }
        else
            throw new SQLException(); //DA SOSTITUIRE CON ECCEZIONE SPECIFICA PER INSERIMENTO SU UTENTI NON A BUON FINE (O FORSE NO?)
    }*/
}

